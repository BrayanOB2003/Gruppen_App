package com.project.gruppen.screens.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandHorizontally(
    initiallyVisible: Boolean,
    content: @Composable () -> Unit
){

    var visible by remember { mutableStateOf(initiallyVisible) }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(durationMillis = 500)) +
                expandHorizontally { 20000 },
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)) +
                shrinkHorizontally(
                    // Overwrites the default animation with tween for this shrink animation.
                animationSpec = tween(),
                    // Shrink towards the end (i.e. right edge for LTR, left edge for RTL). The default
                    // direction for the shrink is towards [Alignment.Start]
                    shrinkTowards = Alignment.End,
                ) { fullWidth ->
                    // Set the end width for the shrink animation to a quarter of the full width.
                    fullWidth / 4
                },
        content = content,
        initiallyVisible = !visible
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SliceTransition(
    initiallyState: String,
    content: @Composable () -> Unit
){
    AnimatedContent(
        targetState = initiallyState,
        transitionSpec = {
            expandHorizontally { height -> height } + fadeIn() with
                    slideOutVertically { height -> -height } + fadeOut()
        }
    ) {
        content
    }
}