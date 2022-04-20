package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val people = nextInt()
    val time = MutableList(people) { nextInt() }
    var totalTime = 0

    time.sort()

    for (i in time.size downTo 1) {

        totalTime += time[time.size - i] * i
    }
    println(totalTime)
}