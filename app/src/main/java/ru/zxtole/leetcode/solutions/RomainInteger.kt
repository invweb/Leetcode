package ru.zxtole.leetcode.solutions

const val X_Int: Int = 10
const val XC_Int: Int = 90
const val XX_Int: Int = 20
const val XL_Int: Int = 40

const val D_Int: Int = 500
const val M_Int: Int = 1000

const val L_Int: Int = 50
const val LV_Int: Int = 55
const val LX_Int: Int = 60

const val VI_Int: Int = 6
const val VII_Int: Int = 7
const val VIII_Int: Int = 8
const val V_Int: Int = 5

const val IV_Int: Int = 4
const val III_Int: Int = 3
const val II_Int: Int = 2
const val I_Int: Int = 1
const val IX_Int: Int = 9

const val C_Int: Int = 100
const val CD_Int: Int = 400
const val CM_Int: Int = 900

const val V_Char: Char = 'V'
const val L_Char: Char = 'L'
const val C_Char: Char = 'C'
const val D_Char: Char = 'D'
const val I_Char: Char = 'I'
const val M_Char: Char = 'M'
const val X_Char: String = "X"

const val IV_String: String = "IV"
const val V_String: String = "V"
const val VI_String: String = "VI"
const val VII_String: String = "VII"
const val VIII_String: String = "VIII"
const val IX_String: String = "IX"
const val LV_String: String = "LV"
const val LX_String: String = "LX"
const val XL_String: String = "XL"
const val XC_String: String = "XC"
const val XX_String: String = "XX"

const val CD_String: String = "CD"
const val CM_String: String = "CM"

const val II_String: String = "II"
const val III_String: String = "III"

class RomainInteger {
    fun romanToInt(romainString :String): Int {
        var localRomainString :String = romainString
        var i = 0

        val array : CharArray = localRomainString.toCharArray()
        for(char in array) {
            while (localRomainString.contains(M_Char)) {
                if (localRomainString.contains(CM_String)) {
                    i += CM_Int
                    localRomainString = localRomainString.replaceFirst(CM_String, "")
                } else {
                    i += M_Int
                    localRomainString = localRomainString.replaceFirst(M_Char.toString(), "")
                }
            }

//            if (localRomainString.contains(C_Char)) {
            while (localRomainString.contains(C_Char)) {
                if (localRomainString.contains(XC_String)) {
                    i += XC_Int
                    localRomainString = localRomainString.replaceFirst(XC_String, "")
                } else if (localRomainString.contains(CD_String)) {
                    i += CD_Int
                    localRomainString = localRomainString.replaceFirst(CD_String, "")
                } else if (localRomainString.contains(CM_String)) {
                    i += CM_Int
                    localRomainString = localRomainString.replaceFirst(CM_String, "")
                } else {
                    i += C_Int
                    localRomainString = localRomainString.replaceFirst(C_Char.toString(), "")
                }
            }

            while (localRomainString.contains(X_Char)) {
                if (localRomainString.contains(IX_String)) {
                    i += IX_Int
                    localRomainString = localRomainString.replaceFirst(IX_String, "")
                } else if (localRomainString.contains(XX_String)) {
                    i += XX_Int
                    localRomainString = localRomainString.replaceFirst(XX_String, "")
                } else if (localRomainString.contains(XL_String)) {
                    i += XL_Int
                    localRomainString = localRomainString.replaceFirst(XL_String, "")
                } else {
                    i += X_Int
                    localRomainString = localRomainString.replaceFirst(X_Char, "")
                }
            }

            while (localRomainString.contains(V_Char)) {
                while (localRomainString.contains(LV_String)) {
                    i += LV_Int
                    localRomainString = localRomainString.replaceFirst(LV_String, "")
                }

                while (localRomainString.contains(IV_String)) {
                    i += IV_Int
                    localRomainString = localRomainString.replaceFirst(IV_String, "")
                }

                while (localRomainString.contains(VI_String)) {
                    i += VI_Int
                    localRomainString = localRomainString.replaceFirst(VI_String, "")
                }

                while (localRomainString.contains(V_String)) {
                    i += V_Int
                    localRomainString = localRomainString.replaceFirst(V_String, "")
                }
            }

            while (localRomainString.contains(LX_String)) {
                i += LX_Int
                localRomainString = localRomainString.replaceFirst(LX_String, "")
            }

            while (localRomainString.contains(L_Char)) {
                i += L_Int
                localRomainString = localRomainString.replaceFirst(L_Char.toString(), "")
            }

            while (localRomainString.contains(IV_String)) {
                i += IV_Int
                localRomainString = localRomainString.replaceFirst(IV_String, "")
            }

            while (localRomainString.contains(VI_String)) {
                i += VI_Int
                localRomainString = localRomainString.replaceFirst(VI_String, "")
            }

            while (localRomainString.contains(VII_String)) {
                i += VII_Int
                localRomainString = localRomainString.replaceFirst(VII_String, "")
            }

            while (localRomainString.contains(V_Char)) {
                i += V_Int
                localRomainString = localRomainString.replaceFirst(V_Char.toString(), "")
            }

            while (localRomainString.contains(VIII_String)) {
                i += VIII_Int
                localRomainString = localRomainString.replaceFirst(VIII_String, "")
            }

            while (localRomainString.contains(I_Char)) {
                i += I_Int
                localRomainString = localRomainString.replaceFirst(I_Char.toString(), "")
            }

            while (localRomainString.contains(II_String)) {
                i += II_Int
                localRomainString = localRomainString.replaceFirst(II_String, "")
            }

            val iiiLocal = localRomainString.contains(III_String)
            if (iiiLocal) {
                i += III_Int
                localRomainString = localRomainString.replaceFirst(III_String, "")
            } else {
                localRomainString = localRomainString.replaceFirst(I_Char.toString(), "")
                val iLocalI = localRomainString.contains(I_Char)
                if (iLocalI) {
                    i += I_Int
                }
            }

            while (localRomainString.contains(D_Char)) {
                i += D_Int
                localRomainString = localRomainString.replaceFirst(D_Char.toString(), "")
            }

//            while (localRomainString.contains(C_Char)) {
//                i += C_Int
//                localRomainString = localRomainString.replaceFirst(C_Char.toString(), "")
//            }
        }

        return i
    }
}