package ru.zxtole.leetcode.solutions

import android.annotation.SuppressLint
import timber.log.Timber
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
        Timber.d("LongestCommonPrefix", LongestCommonPrefix::class.toString())
        val prefixBuilder = StringBuilder()
        var canAdd = true
        var result = ""
        var smallestWordLength: Int = 0
        var l = 0
        if (strings.isNotEmpty()) {
            for (firstElement in strings) {
//                for (secondElement in strings) {
                for (i in 1 until strings.size) {
                    val secondElement = strings[i]

                    if (l < firstElement.length && l < secondElement.length) {
                        if (firstElement[l] == secondElement[l]) {
                            if (canAdd) {
                                prefixBuilder.append(firstElement[l])
                            }
                        } else {
                            canAdd = false
                        }
                    }
                    l++
                    result = prefixBuilder.toString()
                }
            }

        }
        return result
    }
}