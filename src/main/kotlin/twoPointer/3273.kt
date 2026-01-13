package twoPointer

import FastScannerUtil
import java.util.Arrays

fun main() {
    val fs = FastScannerUtil()
    // 1 ≤ n ≤ 100000
    val n = fs.nextInt()
    require(n in 1..100000) { "n must be between 1..100000" }
    // n개의 서로 다른 양의 정수 (중복처리 필요없음)
    // a의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수
    val nums = IntArray(n) {
        val a = fs.nextInt()
        require(a in 1..1000000) { "a must be between 1..1000000" }
        a
    }
    // 1 ≤ x ≤ 2000000)
    val x = fs.nextInt()
    require(x in 1..2000000) { "x must be between 1..2000000" }

    Arrays.sort(nums)
    var l = 0
    var r = n - 1
    var answer = 0
    while (l < r) {
        val sum = nums[l] + nums[r]
        when {
            sum == x -> { answer++; l++; r-- }
            sum < x  -> l++
            else     -> r--
        }
    }
    print(answer)
}