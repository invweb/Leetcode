package ru.zxtole.leetcode.solutions

class ValidParentheses {


    fun processParntheses(parnthesesToProcessString: CharArray): Boolean {
        var parnthesesCheck  = 0
        var parnthesesCheckSquare  = 0
        var parnthesesCheckCurly  = 0

        var parnthesesRound  = 0
        var parnthesesSquare  = 0
        var parnthesesCurly  = 0

        var parnthesesRoundState: ParnthesesState
        var parnthesesSquareState: ParnthesesState
        var parnthesesCurlyState: ParnthesesState

        for (item in parnthesesToProcessString) {
            when (item.toString()) {
                "(" -> {
                    if(parnthesesCheck != 0 || parnthesesCheckSquare != 0
                        || parnthesesCheckCurly != 0) {
                        return false
                    }
                    parnthesesCheck++
                    parnthesesRound++
                    parnthesesRoundState = ParnthesesState.OPENED
                }
                "[" -> {
                    if(parnthesesCheck != 0 || parnthesesCheckSquare != 0
                        || parnthesesCheckCurly != 0) {
                        return false
                    }
                    parnthesesCheckSquare++
                    parnthesesSquare++
                    parnthesesSquareState = ParnthesesState.OPENED
                }
                "{" -> {
                    if(parnthesesCheck != 0 || parnthesesCheckSquare != 0
                        || parnthesesCheckCurly != 0) {
                        return false
                    }
                    parnthesesCheckCurly++
                    parnthesesCurly++
                    parnthesesCurlyState = ParnthesesState.OPENED
                }
                ")" -> {
                    parnthesesCheck--
                    parnthesesRoundState = ParnthesesState.CLOSED
                    if(parnthesesCheck != 0) {
                        return false
                    }
                }
                "]" -> {
                    parnthesesCheckSquare--
                    parnthesesSquareState = ParnthesesState.CLOSED
                    if(parnthesesCheckSquare != 0) {
                        return false
                    }
                }
                "}" -> {
                    parnthesesCheckCurly--
                    parnthesesCurlyState = ParnthesesState.CLOSED
                    if(parnthesesCheckCurly != 0) {
                        return false
                    }
                }
            }
        }

        return parnthesesCheck == 0
    }
}