package ru.zxtole.leetcode.solutions

class ValidParentheses {

    enum class ParnthesesState {
        OPENED, CLOSED
    }

    fun processParntheses(parnthesesToProcessString: CharArray): Boolean {
        var parnthesesCheck  = 0
        var parnthesesCheckSquare  = 0
        var parnthesesCheckCurly  = 0

        var parnthesesRound  = 0
        var parnthesesSquare  = 0
        var parnthesesCurly  = 0

        var parnthesesRoundState: ParnthesesState = ParnthesesState.CLOSED
        var parnthesesSquareState: ParnthesesState = ParnthesesState.CLOSED
        var parnthesesCurlyState: ParnthesesState = ParnthesesState.CLOSED

        for (item in parnthesesToProcessString) {
            when (item.toString()) {
                "(" -> {
                    parnthesesCheck++
                    parnthesesRound++
                    parnthesesRoundState = ParnthesesState.OPENED
                }
                "[" -> {
                    parnthesesCheckSquare++
                    parnthesesSquare++
                    parnthesesSquareState = ParnthesesState.OPENED
                }
                "{" -> {
                    parnthesesCheckCurly++
                    parnthesesCurly++
                    parnthesesCurlyState = ParnthesesState.OPENED
                }
                ")" -> {
                    parnthesesCheck--
                    parnthesesRoundState = ParnthesesState.CLOSED
                }
                "]" -> {
                    parnthesesCheckSquare--
                    parnthesesSquareState = ParnthesesState.CLOSED
                }
                "}" -> {
                    parnthesesCheckCurly--
                    parnthesesCurlyState = ParnthesesState.CLOSED
                }
            }
        }

        return parnthesesCurlyState == ParnthesesState.CLOSED &&
                parnthesesRoundState == ParnthesesState.CLOSED &&
                parnthesesSquareState == ParnthesesState.CLOSED &&
                parnthesesCheck == 0
    }
}