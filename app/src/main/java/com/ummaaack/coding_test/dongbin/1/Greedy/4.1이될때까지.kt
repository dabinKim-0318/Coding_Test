package com.ummaaack.coding_test.dongbin

import java.util.*

fun main22() = with(Scanner(System.`in`)) {
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

fun main() = with(Scanner(System.`in`)) {
    while (true) {
        val in_str = nextInt()
        if (in_str.toString() == "exit" || in_str.toString() == "") break
        println(num_divided3(in_str))
    }
}

fun num_divided3(num: Int): Int {
    var count = 0
    for (item in List(num + 1) { i -> i })  //0 1 2 3
    {
        println(item)
        if (item % 3 == 0 && item != 0) {
            count += 1
        }
    }
    return count
}