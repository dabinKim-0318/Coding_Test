package com.ummaaack.coding_test.baekjoon_step

fun main(){
    val num=readLine()!!
    val list=num.toCharArray().map{
        it.toString().toInt()
    }.sortedDescending()

    val sb=StringBuilder("")
    list.forEach{
        sb.append(it)
    }

    println(sb.toString().toInt())

}