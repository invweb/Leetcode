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
        var canAdd = true
        var result = ""
        val smallestWordLength: Int
        var l = 0
        if (strings.isNotEmpty()) {
            smallestWordLength = strings.asList().stream().min(
                Comparator.comparingInt(String::length)
            ).get().length - 1

            for (firstElementElementInDaStrings in strings) {
                for (secondElementInDaStrings in strings) {
                    for (i in 1 until smallestWordLength + 1) {
                        if (l <= smallestWordLength) {
                            if (firstElementElementInDaStrings[l] == secondElementInDaStrings[l] && canAdd) {
                                prefixBuilder.append(firstElementElementInDaStrings[l])
                            } else {
                                canAdd = false
                            }
                            l++
                        }
                    }
                    result = prefixBuilder.toString()
                }
            }
        }
        return result
    }
}