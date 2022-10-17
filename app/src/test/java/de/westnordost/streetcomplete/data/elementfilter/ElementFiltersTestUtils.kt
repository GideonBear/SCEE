package de.westnordost.streetcomplete.data.elementfilter

import de.westnordost.streetcomplete.data.elementfilter.filters.ElementFilter
import de.westnordost.streetcomplete.testutils.node
import de.westnordost.streetcomplete.util.ktx.toEpochMilli
import de.westnordost.streetcomplete.util.ktx.LocalDate
import de.westnordost.streetcomplete.util.ktx.LocalDateTime
import de.westnordost.streetcomplete.util.ktx.minusHours
import de.westnordost.streetcomplete.util.ktx.now
import de.westnordost.streetcomplete.util.ktx.toLocalDate

/** Returns the date x days in the past */
fun dateDaysAgo(daysAgo: Float): LocalDate =
    LocalDateTime.now().minusHours((daysAgo * 24).toLong()).toLocalDate()

fun ElementFilter.matches(tags: Map<String, String>, date: LocalDate? = null): Boolean =
    matches(node(tags = tags, timestamp = date?.toEpochMilli()))
