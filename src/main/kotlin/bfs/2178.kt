package bfs

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
    // (2 ≤ N ≤ 100) 줄 수
    val n = fs.nextInt()
    require(n in 2..100) { "(2 ≤ N ≤ 100)" }
    // (2 ≤ M ≤ 100) 줄 마다 개수
    val m = fs.nextInt()
    require(m in 2..100) { "(2 ≤ M ≤ 100)" }
    val maze = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        val line = fs.next()
        for (j in 0 until m) {
            maze[i][j] = line[j] - '0'
        }
    }
    val dist = Array(n) { IntArray(m) { -1 } }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)
    val q = ArrayDeque<Pair<Int, Int>>()

    dist[0][0] = 1
    q.add(0 to 0)

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for(dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]

            if(nx !in 0 until n || ny !in 0 until m) continue
            if(maze[nx][ny] == 0) continue
            if(dist[nx][ny] != -1) continue

            dist[nx][ny] = dist[x][y] + 1
            q.add(nx to ny)
        }
    }
    print(dist[n-1][m-1])
}