package ru.zxtole.leetcode.solutions

import android.annotation.SuppressLint

class LongestCommonPrefix {
    //strings:["flower","flow","flight"]
    //strings:["cir","car"]
    //strings:["aa","aa"]
    @SuppressLint("LogNotTimber")
    fun longestCommonPrefix(strings: Array<String>): String {
        val firstWord: String = strings[0]
        val foundLetterList = ArrayList<String>()

        var countVar = 0
        for (currentLetterIndex in firstWord.indices) {
            val character: Char = firstWord[currentLetterIndex]

            for (currentWord in strings) {
                if (currentWord.contains(character)) {
                    if (!foundLetterList.contains(character.toString())) {
                        if (countVar == 0) {
                            foundLetterList.add(character.toString())
                        }
                    }
                } else {
                    foundLetterList.remove(character.toString())
                    countVar++
                }
            }
        }

        var common = foundLetterList.toString()
        common = common.replace("[", "")
            .replace("]", "")
            .replace(",", "")
            .replace(" ", "")
        return common.ifEmpty {
            ""
        }
    }
}