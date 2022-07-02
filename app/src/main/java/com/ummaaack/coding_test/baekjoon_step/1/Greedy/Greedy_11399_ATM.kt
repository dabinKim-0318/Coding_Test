package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy


import androidx.core.text.isDigitsOnly
import java.util.*

fun main() = with(Scanner(System.`in`)) {

    var comList = listOf<String>()
    val stack = Stack<Int>()
    //명령의 수
    val comCount = nextInt()

    //명령 수만큼 반복
    for (index in 1..comCount) {
        val command = nextLine().split(" ")
        comList = command
    }
    //명령 수만큼 반복
    for (index in comList.indices) {
        if (comList[index] == "top") { //push
            if (stack.isNotEmpty()) println(stack.peek())
            else println(-1)
        } else if (comList[index] == "pop") {
            if (stack.isNotEmpty()) println(stack.pop())
            else println(-1)
        } else if (comList[index] == "size") {
            println(stack.size)
        } else if (comList[index] == "empty") {
            if (stack.isNotEmpty()) println(0)
            else println(1)
        } else if (comList[index] == "push") {
            stack.add(comList[index + 1].toInt())
        }
    }

    //명령에 따라 스택 처리하면서 출력해야하면 하나씩 출력


}
