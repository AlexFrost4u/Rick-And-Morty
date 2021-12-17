package com.ronasit.core.ui.utils

fun String.shortenIf(length: Int): String {
    return if (this.length >= length) {
        this.take(length - 3).plus("...")
    } else {
        this
    }
}

