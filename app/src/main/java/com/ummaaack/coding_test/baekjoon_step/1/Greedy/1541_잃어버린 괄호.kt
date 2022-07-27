package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

var list = mutableListOf<Char>()
var pickedNum = mutableListOf<Char>()
var bolList = BooleanArray(list.size) { false }
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (l, c) = readLine().split(" ").map { it.toInt() }
    val input = StringTokenizer(readLine()) //a c i s t w
    for (i in 0..c - 1) {
        list.add(input.nextToken()[0])
    }
    list.sort()
    bolList = BooleanArray(list.size) { false }
    sun(0, l, 0)
}

fun sun(cnt: Int, depth: Int, beginWith: Int) {
    if (cnt == depth) {
        val count = pickedNum.count { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }
        val count2 = depth - count

        if (count > 0 && count2 >= 2) {
            var sb = StringBuilder("")
            pickedNum.forEach {
                sb.append(it)
            }
            print(sb.append("\n"))

        }
        return
    }
    for (i in beginWith until list.size) {
        pickedNum.add(list[i])
        sun(cnt + 1, depth, i + 1)
        pickedNum.removeLast()
    }
}


