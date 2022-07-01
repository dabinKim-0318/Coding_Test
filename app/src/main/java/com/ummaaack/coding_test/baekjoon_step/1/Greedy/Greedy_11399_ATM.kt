package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var num = nextInt()
    //6,9를 필터링한 리스트
    var uniqueList = num.toString().toCharArray().filter { it != '6' && it != '9' }.toMutableList()
    //uniqueList를 distinct한 리스트
    var distinctList = uniqueList.distinct()
    //중복 수 카운트 리스트
    var countList = mutableListOf<Int>()
    distinctList.forEach { i ->
        countList.add(uniqueList.count { it == i })
    }
    //카운트 리스트 중 가장 큰 수

    var max = countList.maxOrNull() ?: 0

    var sixNineNum = num.toString().toCharArray().count { it == '6' || it == '9' }
    if(sixNineNum%2==0) sixNineNum/=2
    else sixNineNum=sixNineNum/2 +1

    if (max > sixNineNum) {
        println(max)
    } else if(sixNineNum==0){
        println(1)
    }else{
        println(sixNineNum)
    }
}