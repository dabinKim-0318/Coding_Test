package com.ummaaack.coding_test.dongbin

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    //입력
    var n = nextInt()
    val k = nextInt()
    var result = 0

    //나눠 떨어지는경우
    while (true) {
        if (n % k == 0) {
            n /= k //몫저장 //6
            result += 1
            if (n == 1) break
        } else {
            n -= 1 //나누어떨어질때까지 뺸다
            result += 1
        }
    }
    println(result)
}