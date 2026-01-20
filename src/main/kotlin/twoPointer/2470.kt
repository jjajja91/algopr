package twoPointer

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private class FastScanner {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private var st: StringTokenizer? = null
    fun next(): String {
        while (st == null || !st!!.hasMoreElements()) {
            st = StringTokenizer(br.readLine())
        }
        return st!!.nextToken()
    }
    fun nextInt(): Int = next().toInt()
}

fun main() {
    val fs = FastScanner()
    // N은 2 이상 100,000 이하이다.
    val n = fs.nextInt()
    require(n in 2..100000) { "n must be between 2..100000" }
    //  수들은 모두 -1,000,000,000 이상 1,000,000,000 이하
    val nums = IntArray(n) { fs.nextInt() }
    nums.sort()

    var l = 0
    var r = n - 1
    var bestAbs = Int.MAX_VALUE
    var bestL = 0
    var bestR = n - 1

    while (l < r) {
        val temp = nums[l] + nums[r]
        val a = kotlin.math.abs(temp)
        if (a < bestAbs) {
            bestAbs = a
            bestL = l
            bestR = r
            if (bestAbs == 0) break
        }
        if (temp > 0) r-- else l++
    }
    print("${nums[bestL]} ${nums[bestR]}")
}