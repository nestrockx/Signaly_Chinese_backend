package com.wegielek.signalychinese.utils

class Utils {

    companion object {
        fun containsChinese(input: String): Boolean {
            return input.matches(".*[\\u4e00-\\u9fff]+.*".toRegex())
        }
    }
}