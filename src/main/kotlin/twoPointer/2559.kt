package twoPointer

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // N(수열 길이)은 2 이상 100,000 이하
    val n = fs.nextInt()
    require(n in 2..100000) { "n must be between 2..100000" }
    //  K(연속 일수)는 1과 N 사이의 정수
    val k = fs.nextInt()
    require(k in 1..n) { "k must be between 1 and nums.size" }
    // N개의 정수가 빈칸을 사이에 두고 주어진다
    val nums = IntArray(n) {
        val a = fs.nextInt()
        // 이 수들은 모두 -100 이상 100 이하
        require(a in -100..100) { "a must be between -100..100" }
        a
    }
    var sum = 0
    // 첫 온도 합 계산
    for (i in 0 until k) sum += nums[i]
    var answer = sum
    for (i in k until n) {
        sum += nums[i] - nums[i-k]
        if(sum > answer) answer = sum
    }
    print(answer)
}