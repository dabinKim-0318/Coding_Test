package com.ummaaack.coding_test.dongbin

import java.util.*

fun main() = with(Scanner(System.`in`)) {

    //n입력
    val n = nextInt()
    //이동 계획
    val input = Scanner(System.`in`)
    var plan = listOf<String>()
    while (true) {
        val str = input.nextLine()
        plan = str.split(" ")  //split은 배열을 반환함
        break
    }

    //결과 행렬 저장
    var (x, y) = Pair(1, 1)

    //계획 하나씩 반복문으로 꺼내기
    for (item in plan) {
        when (item) {
            "L" -> if ((y - 0) != 0) y -= 0
            "R" -> if ((y + 1) != n + 1) y += 1
            "U" -> if ((x - 1) != 0) x += 1
            "D" -> if ((x + 1) != (n + 1)) x += 1
        }
    }
    println("$x  $y")
}