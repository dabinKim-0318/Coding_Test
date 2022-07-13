package com.ummaaack.coding_test.baekjoon_step

import java.util.*
import kotlin.math.max

val graph: Array<IntArray> = Array(1000) { IntArray(1000) { 0 } }
var isVisited: Array<BooleanArray> = Array(1000) { BooleanArray(1000) { false } }
var virus: Queue<Pair<Int, Int>> = LinkedList()
var n = 0
var m = 0
val dy = arrayOf(-1, 0, 1, 0)
val dx = arrayOf(0, 1, 0, -1)
var max = 0
var answer = Integer.MIN_VALUE

fun main() {
    val nm = readLine()!!.split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    max = n * m

    for (i in 0 until n) {
        val list = readLine()!!.split(" ").map { it.toInt() }
        for (j in 0 until m) {
            graph[i][j] = list[j]
            if (graph[i][j] == 0) continue
            max--
            if (graph[i][j] == 2)
                virus.offer(Pair(i, j))
        }
    }
    permutation(0)
}

val copyList = graph.copyOf()
val isVisitedPer = Array(n){BooleanArray(m){false} }
fun permutation(dept: Int) {

    if (dept == 3) {
        var countVirusRange=0
        val q:Queue<Pair> = LinkedList

    }

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (isVisitedPer[x][y]==false&&copyList[x][y] == 0) {
                graph[x][y] = 1
                isVisitedPer[x][y]=true
                max--
                permutation(dept + 1)

                isVisited[x][y]=false
                graph[x][y]=0
                max++
            }
        }
    }
}