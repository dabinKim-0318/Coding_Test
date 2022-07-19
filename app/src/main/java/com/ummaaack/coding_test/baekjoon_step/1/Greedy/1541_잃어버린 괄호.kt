package com.ummaaack.coding_test.baekjoon_step


import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val list = IntArray(n - m + 1) { it + m }
    for (it in list) {
        if (it == 2) {
            println(it)
            continue
        }
        if (it != 1) {
            var so=true
            for (i in (2..it - 1)) {
                if (it % i == 0) {
                    so=false
                    break
                }
            }
           if(so) println(it)
        }
    }
}