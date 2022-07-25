package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


val graph: Array<CharArray> = Array(100) { CharArray(100) { ' ' } }
val bool: Array<BooleanArray> = Array(100) { BooleanArray(100) { false } }
var n = 0
var m = 0
val xx = listOf(-1, 1, 0, 0)
val yy = listOf(0, 0, -1, 1)
var ans = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().toInt()
    n = input
    m = input

    for (i in 0 until n) {
        val str = readLine()
        for (j in 0 until m) {
            graph[i][j] = str[j]
        }
    }
    ans = max(ans, checkCanIt())
    for (i in 0 until n) {
        for (j in 0 until m) {
            swith(i, j)
        }
    }
    println(ans)
}

fun swith(x: Int, y: Int) {
    for (i in xx.indices) {
        var temp = graph[x][y]
        if (x < 0 || x >= n || y >= m || y < 0) return
        graph[x][y] = graph[x + i][y]
        graph[x + i][y] = temp
        ans = max(ans, checkCanIt())
        temp = graph[x][y]
        graph[x][y] = graph[x + i][y]
        graph[x + i][y] = temp
    }
    for (i in yy.indices) {
        var temp = graph[x][y]
        if (x < 0 || x >= n || y >= m || y < 0) return
        graph[x][y] = graph[x][y + i]
        graph[x][y + i] = temp
        ans = max(ans, checkCanIt())
        temp = graph[x][y]
        graph[x][y] = graph[x][y + i]
        graph[x][y + i] = temp
    }

}

fun checkCanIt(): Int {
    var maxCnt = 0
    for (i in 0 until n) {
        var curRowCnt = 1
        var lastChar = graph[i][0]
        for (j in 1 until n) {
            var curChar = graph[i][j]
            if (curChar == lastChar) curRowCnt++
            else {
                lastChar = curChar
                if (maxCnt < curRowCnt) maxCnt = curRowCnt
                curRowCnt = 1
            }
        }
        if (maxCnt < curRowCnt) maxCnt = curRowCnt
    }
    for (i in 0 until n) {
        var curColCnt = 1
        var lastChar = graph[0][i]
        for (j in 1 until n) {
            var curChar = graph[j][i]
            if (curChar == lastChar) curColCnt++
            else {
                lastChar = curChar
                if (maxCnt < curColCnt) maxCnt = curColCnt
                curColCnt = 1
            }
        }
        if (maxCnt < curColCnt) maxCnt = curColCnt
    }

    return maxCnt
}