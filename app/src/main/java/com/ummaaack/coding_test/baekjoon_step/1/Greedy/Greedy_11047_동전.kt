package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    //  val count = nextInt()
    //  var totalMoney = nextInt()
    var (count, totalMoney) = nextLine().split(" ").map { it.toInt() }

    val countList = MutableList(count) { nextInt() } //제한개수만큼 int배열로 받기
    var result = 0

    for (item in countList.reversed()) {  //reversed는 list를 반환함 mutableList랑 같이!!
        // if (totalMoney >= item) {
        result += totalMoney / item
        totalMoney %= item
        //    }
    }
    println(result)
}