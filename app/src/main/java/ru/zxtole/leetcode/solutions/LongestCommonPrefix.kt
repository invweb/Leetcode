package ru.zxtole.leetcode.solutions

import android.annotation.SuppressLint
import timber.log.Timber
import java.util.Arrays
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
        val smallestWordLength: Int
        var l = 0
        if (strings.isNotEmpty()) {
            smallestWordLength = strings.asList().stream().min(
                Comparator.comparingInt(String::length)
            ).get().length - 1

            for (firstElement in strings) {
                for (i in 1 until smallestWordLength) {
                    val secondElement = strings[i]
                    if (firstElement != secondElement) {
                        if (l < smallestWordLength) {
                            if (l == 0) {
                                if (firstElement[l] == secondElement[l]) {
                                    if (canAdd) {
                                        prefixBuilder.append(firstElement[l])
                                    }
                                }
                            } else {
                                if (prefixBuilder.isNotEmpty()) {
                                    prefixBuilder.deleteCharAt(l - 1)
                                    canAdd = false
                                }
                            }
//                            }
                            l++
                            result = prefixBuilder.toString()
                        }
                    }
                }
            }
        }
        return result
    }
}