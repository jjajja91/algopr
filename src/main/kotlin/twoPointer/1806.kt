package twoPointer

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // N (10 ≤ N < 100,000)
    val n = fs.nextInt()
    require(n in 10..100000) { "n must be between 10..100000" }
    // S (0 < S ≤ 100,000,000)
    val s = fs.nextInt()
    require(s in 1..100000000) { "s must be between 1..100000000" }
    //  각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수
    val nums = IntArray(n) {
        val a = fs.nextInt()
        require(a in 1..10000) { "a must be between 1..10000" }
        a
    }
    var l = 0
    var sum = 0
    var answer = Int.MAX_VALUE
    for (r in 0 until n) {
        sum += nums[r]
        while(sum >= s) {
            val len = r - l + 1
            if(len < answer) answer = len
            sum -= nums[l]
            l++
        }
    }
    print(if(answer == Int.MAX_VALUE) 0 else answer)
}