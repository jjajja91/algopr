package twoPointer

class Solution {
    fun solution(t: String, p: String): Int {
        val len = p.length
        require(len in 1..18) { "p length must be between 1 and 18" }
        require(t.length in len..10000) { "t length must be between p.length and 10,000" }
        require(t.all { it.isDigit() }) { "t all digits must be digits" }
        require(p.all { it.isDigit() }) { "p all digits must be digits" }
        var answer: Int = 0
        loop@ for (i in 0 until (t.length - len + 1)) {
            // 길이가 같으므로 앞자리부터 비교
            val c0 = t[i]
            when {
                c0 < p[0] -> { answer++; continue@loop }  // 길이 같으니 첫 글자만으로 결정
                c0 > p[0] -> continue@loop
                else -> {
                    // 첫 글자가 같으면 나머지 글자 비교
                    for (j in 1 until len) {
                        val a = t[i + j]
                        val b = p[j]
                        if (a < b) { answer++; continue@loop }
                        if (a > b) continue@loop
                    }
                    // 전부 같으면 <= 이므로 카운트
                    answer++
                }
            }
        }
        return answer
    }
}

fun main() {
    println(Solution().solution("10203", "15"))
}