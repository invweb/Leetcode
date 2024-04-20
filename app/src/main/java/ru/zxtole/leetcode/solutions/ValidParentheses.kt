package ru.zxtole.leetcode.solutions

class ValidParentheses {
    fun processParntheses(parnthesesToProcessString: CharArray): Boolean {
        var parnthesesCheck  = 0
        var parnthesesCheckSquare  = 0
        var parnthesesCheckCurly  = 0

        var parnthesesRound  = 0
        var parnthesesSquare  = 0
        var parnthesesCurly  = 0

        for (item in parnthesesToProcessString) {
            when (item.toString()) {
                "(" -> {
                    if(parnthesesCheck != 0 || parnthesesCheckSquare != 0
                        || parnthesesCheckCurly != 0) {
                        return false
                    }
                    parnthesesCheck++
                    parnthesesRound++
                }
                "[" -> {
                    if(parnthesesCheck != 0 || parnthesesCheckSquare != 0
                        || parnthesesCheckCurly != 0) {
                        return false
                    }
                    parnthesesCheckSquare++
                    parnthesesSquare++
                }
                "{" -> {
                    if(parnthesesCheck != 0 || parnthesesCheckSquare != 0
                        || parnthesesCheckCurly != 0) {
                        return false
                    }
                    parnthesesCheckCurly++
                    parnthesesCurly++
                }
                ")" -> {
                    parnthesesCheck--
                    if(parnthesesCheck != 0) {
                        return false
                    }
                }
                "]" -> {
                    parnthesesCheckSquare--
                    if(parnthesesCheckSquare != 0) {
                        return false
                    }
                }
                "}" -> {
                    parnthesesCheckCurly--
                    if(parnthesesCheckCurly != 0) {
                        return false
                    }
                }
            }
        }

        return parnthesesCheck == 0
    }
}