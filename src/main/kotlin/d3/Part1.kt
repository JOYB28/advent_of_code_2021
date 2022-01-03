package d3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var inputLength: Int? = null
    var zeroCount: IntArray? = null
    var oneCount: IntArray? = null

    while (true) {
        val input = try {
            readLine()
        } catch (t: Throwable) {
            break
        }

        if (input.length == 0) {
            break
        }

        if (inputLength == null) {
            inputLength = input.length
            zeroCount = IntArray(inputLength) { 0 }
            oneCount = IntArray(inputLength) { 0 }
        }

        input.mapIndexed { i, char ->
           when (char) {
               '0' -> zeroCount!![i] += 1
               '1' -> oneCount!![i] += 1
           }
        }
    }

    var gammaRate = 0
    var epsilonRate = 0
    (0 until inputLength!!)
        .map {
            val add = Math.pow(2.0, (inputLength - it -1) * 1.0).toInt()
            if (zeroCount!![it] > oneCount!![it]) {
                epsilonRate += add
            } else {
                gammaRate += add
            }
        }

    println(inputLength.toString())
    println(oneCount.contentToString())
    println(zeroCount.contentToString())

    println("gammaRate: $gammaRate")
    println("epsilonRate: $epsilonRate")
    println("ans: ${gammaRate * epsilonRate}")
    println("end!")
}

