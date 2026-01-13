package binarySearch

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // 오영식 랜선 수 1 ≤ K ≤ 10000
    val k = fs.nextInt()
    // 캠프 필요 랜선 수 1 ≤ N ≤ 1,000,000
    val n = fs.nextInt()
    //  랜선의 길이 0 ≤ line ≤ 2의31승 -1
    var lineMax = 0L
    val lines = LongArray(k) {
        val line = fs.nextInt().toLong()
        if(lineMax < line) lineMax = line
        line
    }
    fun can(h: Long): Boolean {
        var count = 0L
        for (line in lines) {
            count += (line/h)
            if (count >= n) return true
        }
        return false
    }
    var l = 1L
    var r = lineMax
    var answer = 0L
    while (l <= r) {
        val mid = l + (r - l) / 2
        if(can(mid)) {
            answer = mid
            l = mid + 1
        } else {
            r = mid -1
        }
    }
    print(answer)
}