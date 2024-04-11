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
    fun longestCommonPrefix(strings: Array<String>): String {
        Timber.d("LongestCommonPrefix", LongestCommonPrefix::class.toString())
        val prefixBuilder = StringBuilder()
        var canAdd = true
        lateinit var result: String

        if (strings.isNotEmpty()) {
            for (i in 0..<strings.size - 1) {
                var firstWord: String = strings[i]

                for (ll in 1..<strings.size) {
                    if(prefixBuilder.isNotEmpty()) {
                        firstWord = prefixBuilder.toString()
                        prefixBuilder.clear()
                    }
                    val secondWord: String = strings[ll]
                    val smallestWordLength: Int = if (firstWord.length > secondWord.length) {
                        secondWord.length
                    } else {
                        firstWord.length
                    }


                    for (l in 0..< smallestWordLength) {
                        if (canAdd) {
                            if (firstWord[l] == secondWord[l]) {
                                prefixBuilder.append(firstWord[l])
                            } else {
                                canAdd = false
                            }
                        }
                    }
                }
                result = firstWord
            }
        }
        return result
    }
}