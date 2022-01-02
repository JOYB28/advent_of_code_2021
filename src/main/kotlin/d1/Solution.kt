package d1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var ans = 0
    var prev: Int? = null
    while (true) {
        val cur = try {
            readLine().toInt()
        } catch (t: Throwable) {
            break
        }
        if (prev != null && prev < cur) {
            ans += 1
        }
        prev = cur
        println(ans)
    }
    println("end!")
}
