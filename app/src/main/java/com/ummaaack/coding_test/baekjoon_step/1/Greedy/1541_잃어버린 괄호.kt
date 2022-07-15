package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    val st = Stack<Int>()
    val answerSt = Stack<Int>()
    val charSt = mutableListOf<Char>()
    for (i in 0 until n) {
        list.add(readLine()!!.toInt())
    }
    var index = 0
    for (i in 1..n) {
        st.push(i)
        charSt.add('+')
        while (st.isNotEmpty() && st.peek() == list[index]) {
            answerSt.push(st.pop())
            charSt.add('-')
            index++
        }
    }

}