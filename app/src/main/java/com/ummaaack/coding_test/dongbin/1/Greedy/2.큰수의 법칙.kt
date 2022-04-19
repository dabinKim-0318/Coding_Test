package com.ummaaack.coding_test.dongbin

import java.util.*

fun main_2() = with(Scanner(System.`in`)) {
    //조건 입력받기
    val numThree = nextLine().split(" ").map { it.toInt() }
    val n = numThree[0] //채울 수 있는 수 개수
    val m = numThree[1] // 채울 자리수
    val k = numThree[2] //연속자리수

    val num = mutableListOf<Int>()
    for (item in 0 until n) {
        num.add(nextInt()) //공백 기준으로 반복해서 정수 입력받기
    }

    num.sort()  //입력받은 정수들 정렬

    val first = num[num.size - 1]  //제일큰수
    val second = num[num.size - 2] //그다음 큰수

    var sum = 0
    //m%k==0인경우
    if (m % k == 0) {
        if (first == second) {
            sum += first * m
        } else {
            sum += ((first * (m / k)) + (second * (m % k)))
        }
    } else {
        sum += (first * (m / k) * k + second * (m % k))

    }
    print(sum)
}

fun main() = with(Scanner(System.`in`)) {
    var n = nextInt() //채울 수 있는 수들
    var m = nextInt() // 채울 자리수
    var k = nextInt() //최대 자리수
    var result = 0
    var count = 0

    val arr = mutableListOf<Int>()
    for (item in 0 until n) {
        arr.add(nextInt())
    }

    arr.sort()

    val first = arr[arr.size - 1]
    val second = arr[arr.size - 2]

    //가장 큰수가 더해지는 획수
    count = (m / (k + 1)) * k

    //가장 큰수의 합들
    result += count * first

    //두번쨰로 큰수가 더해지는 횟수의 합
    result += (m - count) * second

    println(result)
}