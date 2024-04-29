package de.westnordost.streetcomplete.screens.user.achievements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.data.user.achievements.Achievement
import de.westnordost.streetcomplete.data.user.achievements.achievements
import de.westnordost.streetcomplete.screens.user.CenteredLargeTitleHint

/** Shows the icons for all achieved achievements and opens a dialog to show the details on click. */
@Composable
fun AchievementsScreen(viewModel: AchievementsViewModel) {
    val isSynchronizingStatistics by viewModel.isSynchronizingStatistics.collectAsState()
    val achievements by viewModel.achievements.collectAsState()

    val showAchievement = remember { mutableStateOf<Pair<Achievement, Int>?>(null) }

    val allAchievements = achievements
    if (allAchievements != null) {
        if (allAchievements.isNotEmpty()) {
            LazyAchievementsGrid(
                achievements = allAchievements,
                onClickAchievement = { achievement, level ->
                    showAchievement.value = achievement to level
                },
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            )
        } else {
            CenteredLargeTitleHint(stringResource(
                if (isSynchronizingStatistics) R.string.stats_are_syncing
                else R.string.achievements_empty
            ))
        }
    }

    showAchievement.value?.let { (achievement, level) ->
        AchievementDetailsDialog(
            achievement, level,
            onDismissRequest = {
                showAchievement.value = null
            }
        )
    }
}

@Composable
fun LazyAchievementsGrid(
    achievements: List<Pair<Achievement, Int>>,
    onClickAchievement: (achievement: Achievement, level: Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 144.dp),
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(achievements) { (achievement, level) ->
            Box {
                AchievementIcon(icon = achievement.icon, level = level)
                // clickable area as separate box because the ripple should be on top of all of it
                // while the icon should not be clipped within the achievement frame
                Box(
                    Modifier
                        .matchParentSize()
                        .clip(AchievementFrameShape)
                        .clickable { onClickAchievement(achievement, level) }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLazyAchievementsGrid() {
    LazyAchievementsGrid(
        achievements = achievements.map { it to (1..20).random() },
        onClickAchievement = { achievement, level ->  }
    )
}
