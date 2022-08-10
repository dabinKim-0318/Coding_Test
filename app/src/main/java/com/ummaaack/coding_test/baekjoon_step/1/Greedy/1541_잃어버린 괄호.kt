package com.ummaaack.coding_test.baekjoon_step

import java.io.*
import java.lang.StringBuilder
import java.util.*
import kotlin.math.*
import kotlin.system.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stack = Stack<Int>()
    stack.add(1) //stack은 add가 됨
    stack.add(2)
    stack.add(3)
    stack.push(4) //queue는 push 안됨
    stack.add(5)
    println(stack) //1 2 3 4 5
    while (stack.isNotEmpty()) {
        print(stack.pop()) //5 4 3 2 1
    }
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5) //1 2 3 4 5
    println(queue)
    while (queue.isNotEmpty()) {
        print(queue.poll()) //1 2 3 4 5
    }
}

