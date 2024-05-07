package ru.zxtole.leetcode.solutions

class ValidParentheses {

    enum class ParnthesesState {
        OPENED, CLOSED
    }

    fun isValid(parnthesesToProcessString: String): Boolean {
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

    fun isValidStrict(parnthesesToProcessString: String): Boolean {
        var parnthesesCheck  = 0
        var parnthesesCheckSquare  = 0
        var parnthesesCheckCurly  = 0

        if (parnthesesToProcessString.isNotEmpty()) {
            val strHalf = parnthesesToProcessString.length / 2

            for (i in 0..strHalf) {
                val char = parnthesesToProcessString[i]
                when (char.toString()) {
                    "(" -> {
                        parnthesesCheck++
                    }
                    "[" -> {
                        parnthesesCheckSquare++
                    }
                    "{" -> {
                        parnthesesCheckCurly++
                    }
                    ")" -> {
                        if (parnthesesCheck > 0) {
                            parnthesesCheck--
                        } else {
                            return false
                        }
                    }
                    "]" -> {
                        if (parnthesesCheckSquare > 0) {
                            parnthesesCheckSquare--
                        } else {
                            return false
                        }
                    }
                    "}" -> {
                        if (parnthesesCheckCurly > 0) {
                            parnthesesCheckCurly--
                        } else {
                            return false
                        }
                    }
                }
            }
        }

        return parnthesesCheck == 0 && parnthesesCheckSquare == 0 && parnthesesCheckCurly == 0
    }
}