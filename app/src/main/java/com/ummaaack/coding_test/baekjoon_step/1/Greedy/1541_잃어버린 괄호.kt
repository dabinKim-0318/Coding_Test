package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val stack = Stack<Int>()
    val st = StringTokenizer(readLine())
    val list = mutableListOf<Int>()
    repeat(n){
        list.add(st.nextToken().toInt())
    }
    for(i in 0 until list.size){
        while(stack.isNotEmpty()&&list[stack.peek()]<list[i]){
            list[stack.pop()]=list[i]
        }
        stack.push(i)
    }
    while(stack.isNotEmpty()){
        list[stack.pop()]=-1
    }
    var sb=StringBuilder("")
    list.forEach {sb.append("$it ")}
    println(sb.toString())
}
