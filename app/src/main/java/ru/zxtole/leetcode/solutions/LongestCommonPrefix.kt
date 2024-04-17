package ru.zxtole.leetcode.solutions

import kotlin.text.StringBuilder

class LongestCommonPrefix {
    //strings:["cir","car"]
    //strings:["flower","flow","flight"]
    //strings:["flower","flower","flower","flower"]
    //strings:["aa","aa"]
    //strings:["aaa","aa","aaa"]
    //strings:["","cbb",""]
    //strings:["c","acc","ccc"]
    //strings:["a","a","b"]
    //strings:["aa","aa"]
    //strings:["flower","flower","flower", "flower"]
    //strings:["dog","racecar","car"]
    fun longestCommonPrefix(strings: Array<String>): String {
        val prefixBuilder = StringBuilder()
        var result = ""
        val smallestWordLength: Int

        if (strings.isNotEmpty()) {
            smallestWordLength = strings.asList().stream().min(
                Comparator.comparingInt(String::length)
            ).get().length

            for ((l, firstElementElementInDaStrings) in strings.withIndex()) {
                for (secondElementInDaStrings in strings.asList().subList(1, strings.size)) {
                    for (i in 0 until smallestWordLength) {
                        if (firstElementElementInDaStrings[i] == secondElementInDaStrings[i]) {
                            if (!prefixBuilder.contains(firstElementElementInDaStrings[i])) {// That is incorrect
                                prefixBuilder.append(firstElementElementInDaStrings[i])
                            }
                        }
                        result = prefixBuilder.toString()
                    }
                }
            }
        }
        return result
    }
}