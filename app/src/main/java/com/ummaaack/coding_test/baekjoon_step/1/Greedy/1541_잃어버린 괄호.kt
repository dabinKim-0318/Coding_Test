package com.ummaaack.coding_test.baekjoon_step

import java.io.*
import java.util.*
import kotlin.math.*
import kotlin.system.*

var n = 0
var m = 0
var graph = arrayOf<IntArray>()
var list = mutableListOf<Pair<Int, Int>>() //벽 후보
var pickedNum = mutableListOf<Pair<Int, Int>>() //선택된 벽 3개
var vList = mutableListOf<Pair<Int, Int>>() //선택된 벽 3개
var ans = 0
var hasB = false
var count = 0
var visited = arrayOf<BooleanArray>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (nn, mm) = readLine().split(" ").map { it.toInt() }
    n = nn
    m = mm
    graph = Array(n) { IntArray(m) { 0 } }
    visited = Array(n) { BooleanArray(m) { false } }

    for (i in 0 until n) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            graph[i][j] = input[j]
            if (input[j] == 0) {
                list.add(Pair(i, j))
            } //0이니까 빈칸 후보
            if (input[j] == 1) {
                visited[i][j] = true
                vList.add(Pair(i, j))
            }
        }
    }

    combi(0, 3, 0)
    println(ans)
    //빈칸 3개를 조합으로 구함
    //dfs로 돌려서 바이러스 전파
    //전파 후 0의 개수 => ans

}

fun combi(cnt: Int, depth: Int, beginWith: Int) {
    if (cnt == depth) {
        for (i in 0..2) {
            graph[pickedNum[i].first][pickedNum[i].second] = 1 //벽을 세움
            visited[pickedNum[i].first][pickedNum[i].second] = true
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                dfs(i, j)
                hasB = false
                count = 0
            }
        }
        var vCount=0
        visited.forEach { vCount+=it.count{it==false} }
        ans = max(ans, vCount)
        println(pickedNum)
        println(vCount)
        visited = Array(n) { BooleanArray(m) { false } }
        for (i in vList) {
            visited[i.first][i.second] = false
        }
        for (i in 0..2) {
            graph[pickedNum[i].first][pickedNum[i].second] = 0 //벽을 초기화함
            visited[pickedNum[i].first][pickedNum[i].second] = false
        }

        return
    }

    for (i in beginWith until list.size) {
        pickedNum.add(list[i])
        combi(cnt + 1, depth, i + 1)
        pickedNum.removeLast()
    }
}


fun dfs(x: Int, y: Int): Int {
    if (x < 0 || y < 0 || x >= n || y >= m) return 0

    if (graph[x][y] != 1 && !visited[x][y]) {
        when (graph[x][y]) {
            0 -> count += 1
            2 -> hasB = true
        }
        visited[x][y] = true

        dfs(x + 1, y)
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)

        return if (hasB) return count else 0
    }

    return 0
}