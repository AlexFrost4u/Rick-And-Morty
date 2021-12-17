package com.ronasit.core.ui.utils

import java.net.URI
import java.nio.file.Paths

fun String.toFullEpisode(): String {
    val season = this
        .substringAfter('S')
        .substringBefore('E')
        .replaceFirst("0", "")

    val episode = this
        .substringAfter('E')
        .replaceFirst("0", "")

    return ("Episode: $episode, Season: $season")
}

fun String.shortenIf(length: Int): String {
    return if (this.length >= length) {
        this.take(length - 3).plus("...")
    } else {
        this
    }
}

