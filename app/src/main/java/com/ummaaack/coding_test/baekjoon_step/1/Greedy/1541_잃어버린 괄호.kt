package com.ummaaack.coding_test.baekjoon_step

import kotlin.math.max

fun main() {

    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }
    var d = MutableList(10000) { 0 }
    d[0]=list[0]
    for (i in 1..n - 1) {
        //경우의 수중 가장 큰값
        for (j in 1..i-1) {
            d[i] = max(d[i],d[i-j]+list[j])
        }
    }
    println(d[n - 1])
}
