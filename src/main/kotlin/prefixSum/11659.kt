package prefixSum

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // 1 ≤ N ≤ 100,000
    val n = fs.nextInt()
    require(n in 1..100000) { "n must be between 1..100000" }
    // 1 ≤ M ≤ 100,000
    val m = fs.nextInt()
    require(m in 1..100000) { "m must be between 1..100000" }
    //  각각의 A[x]는 30,000을 넘지 않는 자연수이다
    val nums = IntArray(n) {
        val a = fs.nextInt()
        require(a in 1..30000) { "a must be between 1..30000" }
        a
    }
    val prefix = IntArray(n)
    prefix[0] = nums[0]
    for(r in 1 until n) {
        prefix[r] = prefix[r - 1] + nums[r]
    }
    val sb = StringBuilder()
    repeat(m) {
        val i = fs.nextInt()
        require(i in 1..n) { "f must be between 1..n" }
        val j = fs.nextInt()
        require(j in i..n) { "l must be between i..n" }
        val sum = if(i == 1) prefix[j - 1] else prefix[j - 1] - prefix[i - 2]
        sb.append(sum).append('\n')
    }
    print(sb)
}