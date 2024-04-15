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

            for (firstElement in strings) {
                if (prefixBuilder.isEmpty()) {
                    for (i in 1 until smallestWordLength - 1) {
                        val secondElement = strings[i]
                        if (l < smallestWordLength) {
                            if (firstElement[l] == secondElement[l]) {
                                prefixBuilder.append(firstElement[l])
                            }
                            l++
                        }
                    }
                } else {
                    for (i in 1 until smallestWordLength - 1) {
                        val secondElement = strings[i]

                    }
                }
                result = prefixBuilder.toString()
            }
        }
        return result
    }
}