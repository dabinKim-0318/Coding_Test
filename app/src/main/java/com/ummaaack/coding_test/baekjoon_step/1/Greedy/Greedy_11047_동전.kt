package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var str = nextLine()
    //문자열 배열->전부 대문자로 만들기
    val newStr = str.toUpperCase().toCharArray().map { it.toString() }.toMutableList()
    //distinct배열->전무 대문자
    val distinctList = newStr.distinct()
    val countList = mutableListOf<Int>()
    //카운트 배열->max인 element의 index로 distinct배열에서 element찾기 대문자로 출력
    distinctList.forEach { i ->
        countList.add(newStr.count { i == it })
    }
    val max = countList.maxOrNull()!!

    if (countList.count { it == max } > 1) println("?")
    else {
        println(distinctList[countList.indexOf(max)])
    }
}