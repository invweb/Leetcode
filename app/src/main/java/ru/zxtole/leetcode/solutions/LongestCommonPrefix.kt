package ru.zxtole.leetcode.solutions

import timber.log.Timber

class LongestCommonPrefix {
    //strings:["flower","flow","flight"]
    fun longestCommonPrefix(strings: MutableList<String>): String {
        val firstWord: String = strings[0]

        val foundWordBuilder: StringBuilder = StringBuilder()
        val letterList = ArrayList<String>()

        for (currentLetter in firstWord) {
            for (currentWord in strings) {
                Timber.d("LongestCommonPrefix: $currentWord")
                if(currentWord != firstWord && currentWord.contains(currentLetter)) {
                    if(!letterList.contains(currentLetter.toString())) {
                        letterList.add(currentLetter.toString())
                    }
                }
            }
        }

        if (letterList.size >= strings.size) {
            letterList.forEach {
                if(!foundWordBuilder.contains(it)) {
                    foundWordBuilder.append(it)
                }
            }
        }

        val common = foundWordBuilder.toString()
        return common.ifEmpty {
            "NA"
        }

    }
}