package twoPointer

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // N(1 ≤ N ≤ 10,000)
    val n = fs.nextInt()
    require(n in 1..10000) { "n must be between 1..10000" }
    // M(1 ≤ M ≤ 300,000,000)
    val m = fs.nextInt()
    require(m in 1..300000000) { "m must be between 1..300000000" }
    //  각각의 A[x]는 30,000을 넘지 않는 자연수이다
    val nums = IntArray(n) {
        val a = fs.nextInt()
        require(a in 1..30000) { "a must be between 1..30000" }
        a
    }
    var l = 0
    var sum = 0
    var answer = 0
    for (r in 0 until n) {
        sum += nums[r]
        while (sum >= m) {
            if(sum == m)  {
                answer++
                sum -= nums[l]
                l++
            } else {
                sum -= nums[l]
                l++
            }
        }
    }
    print(answer)
}