package ru.zxtole.leetcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.zxtole.leetcode.solutions.LongestCommonPrefix
import ru.zxtole.leetcode.solutions.RomainInteger
import ru.zxtole.leetcode.solutions.ValidParentheses
import ru.zxtole.leetcode.ui.theme.LeetcodeTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant()
        setContent {
            LeetcodeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.primary,
                                ),
                                title = {
                                    Text("Small Top App Bar")
                                }
                            )
                        },
                    ) { innerPadding ->
                        Column(
                            Modifier
                                .padding(innerPadding)
                                .fillMaxWidth()
                        ) {
                            Row {
                                RomainIntegerComposable(
                                    Modifier.padding(12.dp)
                                )
                            }

                            Row {
                                LongestCommonPrefixComposable(Modifier.padding(12.dp))
                            }

                            Row {
                                ValidParnthesesComposable(Modifier.padding(12.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RomainIntegerComposable(
    modifier: Modifier = Modifier
) {
    val romainRepresentation: String = "MMCDXXV"// 1996
//        val romainRepresentation: String = "MCMXCVI"// 1996
//        val romainRepresentation: String = "MMMCDXC"// 3490
//        val romainRepresentation: String = "MMMXLV"// 3045
//        val romainRepresentation: String = "MMCDXXV"// 2425
//        val romainRepresentation: String = "MCDLXXVI"// 1476
//        val romainRepresentation: String = "MMCCCXCIX"// 2399
//        val romainRepresentation: String = "MCDLXXVI"// 1476
//        val romainRepresentation: String = "MMCCCXCIX"// 2399
//        val romainRepresentation: String = "MCDLXXVI"// 1676
//        val romainRepresentation: String = "MCMXCIV"// 1994
//        val romainRepresentation: String = "LVIII"//58
//        val romainRepresentation: String = "MCMXCVI"//1996
//        val romainRepresentation: String = "DCXXI" //621
//        val romainRepresentation: String = "MDCCCLXXXIV" //1884
//        val romainRepresentation: String = "IX" //9
    val romainIntegerSolution = RomainInteger()
    val romainRepresentationResult =
        romainIntegerSolution.romanToInt(romainRepresentation).toString()

    Text(
        text = "$romainRepresentation ->> $romainRepresentationResult",
        modifier = modifier
    )
}

@Composable
fun LongestCommonPrefixComposable(modifier: Modifier = Modifier) {
    val longestCommonPrefix = LongestCommonPrefix()
//    val wordsToProcess = arrayOf("cir","car")
//    val wordsToProcess = arrayOf("a", "a", "b")
//    val wordsToProcess = arrayOf("dog","racecar","car") //--
//    val wordsToProcess = arrayOf("c","acc","ccc")
//    val wordsToProcess = arrayOf("flower", "flow", "flight") //--
//    val wordsToProcess = arrayOf("aa","aa") //-
    val wordsToProcess = arrayOf("flower", "flower", "flower", "flower") //-+
    val commonPrefix = wordsToProcess.joinToString() + " common prefix: " +
            "\'" + longestCommonPrefix.longestCommonPrefix(wordsToProcess) + "\'"


    Column(modifier = Modifier.fillMaxWidth()) {
        Row {
            Text(
                text = commonPrefix,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ValidParnthesesComposable(modifier: Modifier = Modifier) {
    val validParntheses = ValidParentheses()
//    val parnthesesToProcess = java.lang.String("()")
//    val parnthesesToProcess = java.lang.String("()[]{}")
//    val parnthesesToProcess = java.lang.String("(]")
//    val parnthesesToProcess = java.lang.String("([)]")
    val parnthesesToProcess = java.lang.String("{[]}")

    val result = validParntheses.processParntheses(parnthesesToProcess.toCharArray())
    validParntheses.processParntheses(parnthesesToProcess.toCharArray())
    Text(
        text = "${parnthesesToProcess}: " +
                "$result",
        modifier = modifier
    )
}
