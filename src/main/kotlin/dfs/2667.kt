package dfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

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
    // 5≤N≤25 줄 수 (정사각형)
    val n = fs.nextInt()
    require(n in 5..25) { "(5 ≤ N ≤ 25)" }
    val grid = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val line = fs.next()
        for (j in 0 until n) {
            grid[i][j] = line[j] - '0'
        }
    }
    val visited = Array(n) { BooleanArray(n) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    fun dfsIter(sx: Int, sy: Int): Int {
        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(sx to sy)
        visited[sx][sy] = true
        var cnt = 0
        while (stack.isNotEmpty()) {
            val (x, y) = stack.removeLast()
            cnt++
            for (dir in 0 until 4) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]
                if (nx !in 0 until n || ny !in 0 until n) continue
                if (grid[nx][ny] == 0) continue
                if (visited[nx][ny]) continue
                visited[nx][ny] = true
                stack.addLast(nx to ny)
            }
        }
        return cnt
    }
    val sizes = mutableListOf<Int>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                sizes.add(dfsIter(i, j))
            }
        }
    }
    sizes.sort()
    val sb = StringBuilder()
    sb.append(sizes.size).append('\n')
    for (s in sizes) sb.append(s).append('\n')
    print(sb)
}