package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


var graph = arrayOf<IntArray>()
var bolList = arrayOf<BooleanArray>()
var n = 0
val xx = listOf(-2, -2, -1, -1, 2, 2, 1, 1)
val yy = listOf(1, -1, 2, -2, -1, 1, -2, 2)
var want = Pair(0, 0)
var flag = true
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val count = readLine().toInt() //test case count
    for (i in 1..count) {
        flag = true
        n = readLine().toInt() //  가로 세로 사이즈
        val current = readLine().split(" ").map { it.toInt() } //  현재 있는 칸
        val (a, b) = readLine().split(" ").map { it.toInt() }

        if (current[0] == a && current[1] == b) {
            println(0)
            continue
        }
        bolList = Array(n) { BooleanArray(n) { false } }
        graph = Array(n) { IntArray(n) { 0 } }
        want = Pair(a, b)
        bfs(Pair(current[0], current[1]))
    }
}

fun bfs(pair: Pair<Int, Int>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(pair) //0 0
    bolList[pair.first][pair.second] = true
    while (queue.isNotEmpty()) {
        val node = queue.poll() //0 0
        for (i in xx.indices) {
            val a = node.first + xx[i]
            val b = node.second + yy[i]
            if (a < 0 || a >= n || b < 0 || b >= n) continue
            if (bolList[a][b]) continue

            graph[a][b] = graph[node.first][node.second] + 1
            if (flag && a == want.first && b == want.second) {
                flag = false
                println(graph[a][b])
                break
            } else {
                bolList[a][b] = true
                queue.add(Pair(a, b))
            }
        }
    }
}
