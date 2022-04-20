package com.ummaaack.coding_test.dongbin

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    var time = List(60) { i -> i }
    var result=0

    for (i in 0 until n+1) {
        for (j in time) {
            for (k in time) {
                val timeStr = i.toString() + j.toString() + k.toString()
                if (timeStr.contains('3'))
                    result+=1
            }
        }
    }
    println(result)

    // 분 초
}