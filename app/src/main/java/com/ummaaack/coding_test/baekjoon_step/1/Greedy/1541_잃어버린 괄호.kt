package com.ummaaack.coding_test.baekjoon_step

import java.util.*
import kotlin.math.max

fun main() {

    val n = readLine()!!.toInt()
    val list = IntArray(n + 1) { 0 }
    var d = MutableList(10000) { 0 }
    for (i in 0 until n) {
        list[i] = Scanner(System.`in`).nextInt()
    }

    for (i in 1..n) { //1 2 3 4 5
        //경우의 수중 가장 큰값
        for (j in 1..i) { //1
            d[i] = max(d[i], d[i - j] + list[j])
        }
    }
    println(d[n])
}
//10 9 8 7 6


object Beak11052 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val arr = IntArray(n + 1)
        val d = IntArray(n + 1)
        for (i in 1..n) arr[i] = sc.nextInt()
        for (i in 1..n) {
            for (j in 1..i) {
                d[i] = Math.max(d[i], d[i - j] + arr[j])
            }
        }
        println(d[n])
        sc.close()
    }
}
