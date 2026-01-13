package binarySearch

import FastScannerUtil

fun main() {
    val fs = FastScannerUtil()
    // 나무의 수 1 ≤ N ≤ 1,000,000
    val n = fs.nextInt()
    require(n in 1..1000000) { "n must be between 1..1000000" }
    // 가져가려고 하는 나무의 길이 1 ≤ M ≤ 2,000,000,000
    val m = fs.nextInt()
    require(m in 1..2000000000) { "m must be between 1..2000000000" }
    //  나무의 높이 0 ≤ tree ≤  1,000,000,000
    var treesSum = 0L
    var treeMax = 0
    val trees = IntArray(n) {
        val tree = fs.nextInt()
        require(tree in 0..1000000000) { "tree must be between 0..1000000000" }
        treesSum += tree
        if(treeMax < tree) treeMax = tree
        tree
    }
    require(treesSum >= m) { "trees must be bigger than m($m)" }
    fun can(h: Int): Boolean {
        var sum = 0L
        for (tree in trees) {
            if (tree > h) sum += (tree - h)
        }
        return sum >= m
    }
    var l = 0
    var r = treeMax
    var answer = 0
    while (l <= r) {
        val mid = l + (r - l) / 2
        if(can(mid)) {
            answer = mid
            l = mid + 1
        } else {
            r = mid -1
        }
    }
    print(answer)
}