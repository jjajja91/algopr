package twoPointer

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // N (10 ≤ N < 100,000)
    val n = fs.nextInt()
    require(n in 10..100000) { "n must be between 10..100000" }
    // K (0 < K ≤ 100,000,000)
    val k = fs.nextInt()
    require(k in 1..100000000) { "k must be between 1..100000000" }
    //  각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수
    val nums = IntArray(n) {
        val a = fs.nextInt()
        require(a in 1..10000) { "a must be between 1..10000" }
        a
    }
    var l = 0
    var sum = 0
    var ans = 0
    for(r in 0 until n) {
        sum += nums[r]
        while(sum > k) {
            sum -= nums[l]
            l++
        }
        ans += (r - l + 1)
    }
    print(ans)
}