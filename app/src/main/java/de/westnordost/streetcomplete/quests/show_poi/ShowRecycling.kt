package de.westnordost.streetcomplete.quests.show_poi

import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.data.osm.osmquests.OsmFilterQuestType
import de.westnordost.streetcomplete.data.osm.osmquests.Tags

class ShowRecycling : OsmFilterQuestType<Boolean>() {
    override val elementFilter = """
        nodes, ways, relations with
          amenity ~ recycling|waste_basket|waste_disposal|waste_transfer_station|sanitary_dump_station
    """
    override val changesetComment = "Change recycling"
    override val wikiLink = "Key:amenity"
    override val icon = R.drawable.ic_quest_poi_recycling
    override val dotColor = "green"
    override val defaultDisabledMessage = R.string.default_disabled_msg_poi_recycling

    override fun getTitle(tags: Map<String, String>) =
        R.string.quest_poi_recycling_title

    override fun getTitleArgs(tags: Map<String, String>): Array<String>
        = arrayOf(if (!tags["recycling_type"].isNullOrBlank()) tags.entries.toString() else "")

    override fun createForm() = ShowRecyclingAnswerForm()

    override fun applyAnswerTo(answer: Boolean, tags: Tags, timestampEdited: Long) {
        if (answer) {
            tags["amenity"] = "vending_machine"
            tags["vending"] = "excrement_bags"
            tags["bin"] = "yes"
        }
    }
}