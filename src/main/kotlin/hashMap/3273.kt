package hashMap

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다
 * ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다
 * 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
 * 문제의 조건을 만족하는 쌍의 개수를 출력한다.
*/

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

    // N(1 ≤ N ≤ 100000)
    val n = fs.nextInt()
    require(n in 1..100000) { "1 ≤ N ≤ 100000" }

    // n개의 서로 다른 양의 정수
    val nums = IntArray(n) {
        val a = fs.nextInt()
        require(n in 1..1000000) { "a의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수" }
        a
    }

    // X(1 ≤ X ≤ 2000000)
    val x = fs.nextInt()
    require(x in 1..2000000) { "1 ≤ X ≤ 2000000" }

    var ans = 0
    val freq = HashMap<Int, Int>()

    nums.forEach { v ->
        val need = x - v
        ans += freq.getOrDefault(need, 0)
        freq[v] = freq.getOrDefault(v, 0) + 1
    }

    print(ans)
}