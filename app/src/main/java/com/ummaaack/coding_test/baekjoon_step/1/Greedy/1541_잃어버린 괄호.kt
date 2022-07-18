package com.ummaaack.coding_test.baekjoon_step


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()
    val stack = Stack<Char>()
    var flag = true //true면 뒤집음
    val sb = StringBuilder("")
    for (i in input.indices) {
        val char = input[i]
        if (char == '<') flag = false
        if (char == '>') {
            flag = true
            sb.append(char)
            continue
        }

        if (flag) {
            if (char != ' ') stack.push(char)
        }
        if (!flag || char == ' ') {
          while(stack.isNotEmpty()) sb.append(stack.pop())
            sb.append(char)
        }
    }
    while(stack.isNotEmpty()) sb.append(stack.pop())
    println(sb.toString())
}