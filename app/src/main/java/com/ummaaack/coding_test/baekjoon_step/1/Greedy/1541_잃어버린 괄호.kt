package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


val list = mutableListOf<Move>()
val ans = mutableListOf<Int>()
var kk = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    print(bfs().toString() + " ")

    var target = kk
    while (target != -1) {
        for (it in list) {
        //    println(list)
            if (it.now == target) {
                println(it.now)
                ans.add(target)
                target = it.before
            }
        }
    }

    ans.reversed().forEach {
        print("${it}")
    }
}

private fun bfs(): Int {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    kk = k
    val queue: Queue<Move> = LinkedList()
    val visited = BooleanArray(100_001) { false }

    queue.add(Move(n, 0, -1))
    visited[n] = true
    list.add(Move(n, 0, -1)) //Move(5,0,-1)
    while (queue.isNotEmpty()) {
        val current = queue.poll() //Move
        if (current.now == k) return current.time

        if (checkRange(current.now - 1) && !visited[current.now - 1]) {
            queue.add(Move(current.now - 1, current.time + 1, current.now))
            list.add(Move(current.now - 1, current.time + 1, current.now))
            visited[current.now - 1] = true
        }
        if (checkRange(current.now + 1) && !visited[current.now + 1]) {
            queue.add(Move(current.now + 1, current.time + 1, current.now))
            list.add(Move(current.now - 1, current.time + 1, current.now))
            visited[current.now + 1] = true
        }
        if (checkRange(current.now * 2) && !visited[current.now * 2]) {
            queue.add(Move(current.now * 2, current.time + 1, current.now))
            list.add(Move(current.now * 2, current.time + 1, current.now))
            visited[current.now * 2] = true
        }
    }
    return -1
}

fun checkRange(x: Int) = x in 0..100_000

data class Move(
    val now: Int,
    val time: Int,
    val before: Int
)
