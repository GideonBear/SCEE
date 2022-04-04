package de.westnordost.streetcomplete.quests.contact

import android.content.Context
import android.content.SharedPreferences
import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.data.osm.mapdata.Element
import de.westnordost.streetcomplete.data.osm.mapdata.MapDataWithGeometry
import de.westnordost.streetcomplete.data.osm.mapdata.filter
import de.westnordost.streetcomplete.data.osm.osmquests.OsmFilterQuestType
import de.westnordost.streetcomplete.data.osm.osmquests.Tags
import de.westnordost.streetcomplete.osm.IS_SHOP_OR_DISUSED_SHOP_EXPRESSION
import de.westnordost.streetcomplete.quests.fullElementSelectionDialog

class AddContactPhone(private val prefs: SharedPreferences) : OsmFilterQuestType<String>() {

    override val elementFilter = """
        nodes, ways, relations with
        (
         tourism = information and information = office
         or """.trimIndent() +
         prefs.getString(PREF_PHONE_ELEMENTS, PLACES_FOR_CONTACT_QUESTS) +
        "\n) and !phone and !contact:phone and !contact:mobile and !brand and name"

    override val changesetComment = "Add phone number"
    override val wikiLink = "Key:phone"
    override val icon = R.drawable.ic_quest_phone

    override fun getTitle(tags: Map<String, String>) = R.string.quest_contact_phone

    override fun getHighlightedElements(element: Element, getMapData: () -> MapDataWithGeometry) =
        getMapData().filter(IS_SHOP_OR_DISUSED_SHOP_EXPRESSION)

    override fun createForm() = AddContactPhoneForm()

    override fun applyAnswerTo(answer: String, tags: Tags, timestampEdited: Long) {
        tags["phone"] = answer
    }

    override val hasQuestSettings = true

    override fun getQuestSettingsDialog(context: Context) =
        fullElementSelectionDialog(context, prefs, PREF_PHONE_ELEMENTS, R.string.quest_settings_contact)

}

val PLACES_FOR_CONTACT_QUESTS = mapOf(
    "amenity" to arrayOf(
        "restaurant", "cafe", "internet_cafe",
        "cinema", "townhall", "embassy", "community_centre", "youth_centre", "library",
        "dentist", "doctors", "clinic", "veterinary", "animal_shelter",
        "arts_centre", "ferry_terminal"
    ),
    "tourism" to arrayOf("zoo", "aquarium", "gallery", "museum", ),
    "shop" to arrayOf(
        "beauty", "massage", "hairdresser","wool","tattoo","electrical","glaziery",
        "computer","electronics","hifi","bicycle","outdoor","sports","art","craft","model",
        "musical_instrument","camera","books","travel_agency","cheese","chocolate","coffee","health_food"
    ),
    "leisure" to arrayOf("fitness_centre", "bowling_alley", "sports_centre"),
    "office" to arrayOf(
        "insurance", "government", "travel_agent", "tax_advisor", "religion", "employment_agency",
        "lawyer", "estate_agent", "therapist", "notary"
    ),
    "craft" to arrayOf(
        "carpenter", "shoemaker", "tailor", "photographer", "dressmaker",
        "electronics_repair", "stonemason", "winery"
    ),
    "healthcare" to arrayOf("psychotherapist", "physiotherapist", "laboratory")
).map { it.key + " ~ " + it.value.joinToString("|") }.joinToString("\n or ")

private const val PREF_PHONE_ELEMENTS = "pref_phone_elements"