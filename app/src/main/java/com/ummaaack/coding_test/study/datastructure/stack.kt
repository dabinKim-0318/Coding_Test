package com.ummaaack.coding_test.study.datastructure

import java.util.*

fun main() {
    val stack = Stack<Int>() //빈 스택 생성시 타입 적어줘야함

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack)  //[1,2,3]

    stack.pop()  //가장 마지막에 push한 3 제거

    println(stack)   //[1,2]

    println(stack.peek())  //pop되지 않고 2 볼 수 있음
    stack.clear()  //모두 제거
    stack.size //스택 사이즈
}