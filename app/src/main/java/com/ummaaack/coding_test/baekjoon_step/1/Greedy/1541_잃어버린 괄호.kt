package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.system.exitProcess


var graph = arrayOf<IntArray>()
var n = 0
var m = 0
var count = 0 //청소할 개수
var loca = 0 //0-북 1-동 2-남 3-서

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (nn, mm) = readLine().split(" ").map { it.toInt() }
    n = nn
    m = mm
    graph = Array(n) { IntArray(m) { 0 } }
    val (r, c, d) = readLine().split(" ").map { it.toInt() }
    loca = d //바라보고 있는 방향
    for (i in 0 until n) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            graph[i][j] = input[j]
        }
    }
    if (dfs(r, c)) println(count)
}

fun dfs(x: Int, y: Int): Boolean {
    if (x < 0 || y < 0 || x >= n || y >= m) return false

    if (graph[x][y] == 0) {
        graph[x][y] = 1 //방문처리
        count += 1 //청소할 곳 하나 증가
        println(x.toString() + ":" + y.toString())
        println(loca)
        lotate(x, y)
        return true
    }

    //0이 아닌경우 회전시킴
    else {
        lotate(x,y)
        return false
    }
}


fun lotate(x: Int, y: Int) {
    when (loca) {
        0 -> { //북쪽을 바라보고 있다면
            loca = 3 //다음엔 서쪽을 바라봐야하고
            dfs(x, y - 1) //서쪽으로 한칸 간다
        }
        1 -> { //동쪽을 바라보고 있으면
            loca = 0 //다음엔 북쪽을 바라본다
            dfs(x - 1, y) //북쪽으로 한칸 간다
        }
        2 -> { //남쪽을 바라보고 있으면
            loca = 1 //다음엔 동쪽을 바라본다
            dfs(x, y + 1) //동쪽으로 한칸 간다
        }
        3 -> { //서쪽을 바라보고 있으면
            loca = 2 //다음엔 남쪽을 바라본다
            dfs(x + 1, y) //남쪽으로 한칸 간다
        }
    }
}