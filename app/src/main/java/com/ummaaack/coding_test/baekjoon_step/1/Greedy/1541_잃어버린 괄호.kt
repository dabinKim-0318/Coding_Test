package com.ummaaack.coding_test.baekjoon_step

import java.io.*
import java.util.*
import kotlin.math.*
import kotlin.system.*

/*private lateinit var matrix: Array<IntArray>
private lateinit var visited: BooleanArray
private var ans = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //depth가 m인 연결요소가 존재하는가
    val (nn, mm) = readLine().split(" ").map { it.toInt() }
    matrix = Array(nn) { IntArray(nn) { 0 } }
    visited = BooleanArray(nn) { false }
    repeat(mm) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        matrix[x][y] = 1
        matrix[y][x] = 1
    }
  for(it in matrix) {
        if(it.slice(1..it.size-1).filter{i->i==1}.count()==it.size-1){
            println(0)
            exitProcess(0)
        }
    }
    for (i in visited.indices) {
        dfs(i)
        if (ans - 1 == nn - 1) {
            println(1)
            exitProcess(0)
        }
        ans = 0
        visited.fill(false)
    }
    println(0)
}

private fun dfs(n: Int) {
    ans += 1
    visited[n] = true
    for (i in 0 until matrix.size) {
        if (matrix[n][i] == 1 && !visited[i]) {
            dfs(i)
        }
    }
}*/


val queue: Queue<Char> = LinkedList<Char>()
var target = ""
var list = ""
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine()
    target = readLine()

    for (i in 0 until str.length) {
        if (target.contains(str[i])
        ) {
            list += str[i]
            println(list)
            println(i)
        } else {
            println(i)
            check()
            queue.add(str[i])
            println(queue)
        }
    }
    var sb = StringBuilder()
    queue.forEach {
        sb.append(it)
    }
    println(sb)
}

private fun check() {
    while (true) {
        if (list.isEmpty()) break
        if (list.length >= target.length) { //ca4ca4
            for (i in 0 until list.length) {
                if (i + target.length - 1 >= list.length - 1) break
                if (list.substring(i..i + target.length - 1) == target) {

                    list = (list.removeRange(i..i + target.length - 1))
                    break
                }
            }
        }
    }
    if (list.isNotEmpty()) {
        println(list)
        list.forEach {
            queue.add(it)
            println(queue)
        }
    }
}