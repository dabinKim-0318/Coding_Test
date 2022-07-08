package com.ummaaack.coding_test.baekjoon_step

import java.util.*
import kotlin.math.max

//캠퍼스에서 도연이가 만날 수 있는 사람의 수
//상하좌우

var graph: Array<IntArray> = Array(200) { IntArray(200) { 0 } }
var n = 0
var m = 0

//이동할 4방향 정의
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
fun main() {
    val nm = readLine()!!.split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]

    for (i in 0 until n) {
        val list = readLine()!!.map { it.toString().toInt() }
        for (j in 0 until m) {
            graph[i][j] = list[j]
        }
    }

    println(bfs(0, 0))
}

fun bfs(x: Int, y: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(x, y))
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        val xx = node.first
        val yy = node.second

        for(i in 0 until 4){

            val nextX=xx+dx[i]
            val nextY=yy+dy[i]

            if(nextX<0||nextX>=n||nextY<0||nextY>=m) continue
            if(graph[nextX][nextY]==0) continue

            if(graph[nextX][nextY]==1){
                graph[nextX][nextY]= graph[xx][yy] +1
                queue.add(Pair(nextX,nextY))
            }
        }
    }

    return graph[n-1][m-1]
}