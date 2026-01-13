package binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
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
    // 도현이의 집 N개 2 ≤ N ≤ 200,000
    val n = fs.nextInt()
    require(n in 2..200000) { "n must be between 2..200000" }
    // 공유기의 개수 C (2 ≤ C ≤ N)
    val c = fs.nextInt()
    require(c in 2..n) { "c must be between 2..n" }
    //  집의 좌표 0 ≤ x ≤  1,000,000,000
    var furthest = 0L
    val houses = LongArray(n) {
        val x = fs.nextInt().toLong()
        require(x in 0..1000000000) { "x must be between 0..1000000000" }
        if(furthest < x) furthest = x
        x
    }
    Arrays.sort(houses)
    fun can(d: Long): Boolean {
        var count = 1
        var last = houses[0]
        for(i in 1 until n) {
            if((houses[i] - last) >= d) {
                count++
                last = houses[i]
                if(count >= c) return true
            }
        }
        return false
    }
    var l = 1L
    var r = houses[n - 1] - houses[0]
    var answer = 0L
    while (l <= r) {
        val mid = l + (r - l) / 2
        if(can(mid)) {
            answer = mid
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    print(answer)
}