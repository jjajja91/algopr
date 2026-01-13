package hashMap

import FastScannerUtil

/**
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
 * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
*/

fun main() {
    val fs = FastScannerUtil()
    // 자연수 N(1 ≤ N ≤ 100,000)
    val n = fs.nextInt()
    require(n in 1..100000) { "1 ≤ N ≤ 100,000" }
    val numSet = HashSet<Int>()
    val answerList = mutableListOf<Int>()
    // N개의 정수
    repeat(n) {
        val a = fs.nextInt()
        require(a in -231 until 231) { "정수의 범위는 -231 보다 크거나 같고 231보다 작다" }
        numSet.add(a)
    }
    // 자연수 M(1 ≤ M ≤ 100,000)
    val m = fs.nextInt()
    require(m in 1..100000) { "1 ≤ M ≤ 100,000" }
    // M개의 정수
    repeat(m) {
        val x= fs.nextInt()
        require(x in -231 until 231) { "정수의 범위는 -231 보다 크거나 같고 231보다 작다" }
        answerList.add(if(numSet.contains(x)) 1 else 0)
    }
    print(answerList.joinToString("\n"))
}