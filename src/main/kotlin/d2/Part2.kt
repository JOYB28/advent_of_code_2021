package d2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var horizontal = 0
    var aim = 0
    var depth = 0
    while (true) {
        val (opt, int) = try {
            val (opt, int) = readLine().split(" ")
            Pair(opt, int)
        } catch (t: Throwable) {
            break
        }

        when (opt) {
            "forward" -> {
                horizontal += int.toInt()
                depth += aim * int.toInt()
            }
            "down" -> aim += int.toInt()
            "up" -> aim -= int.toInt()
        }
    }
    println(horizontal * depth)
    println("end!")
}
