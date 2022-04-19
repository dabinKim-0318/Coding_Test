package com.ummaaack.coding_test.dongbin

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main_3() = with(Scanner(System.`in`)) {
    //두수를 공백으로 입력받음
    val n = nextInt() //행
    val m = nextInt() //열
    var result = 0
    var mini = 0
    //이차원 배열로 저장
    val list = MutableList(n) { IntArray(m) { 0 } }
    val columnList = mutableListOf<Int>()
    val rowList = MutableList(n) { i -> i }
    for (i in 0 until n) {
        for (j in 0 until m) {
            list[i][j] = nextInt()
            columnList.add(list[i][j])
            columnList.sort()
            mini = columnList[0]
            if (list[i][j] == mini) {
                rowList.remove(i)
            }
        }
    }
    val list23 = mutableListOf<Int>()
    for (i in 0 until m) {
        list23.add(list[rowList[0]][i])
    }
    println(list23[0])
}

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt() //행
    val m = nextInt() //열
    var max = -29
    for (i in 0 until n) {
        var result = 10000  //반복문 돌릴때 반복할때마다 기본 세팅값이어야하는 것과 전역변수 max처럼 계속 비교대상이 되는 애를 주의
        for (j in 0 until m) {
            val input = nextInt()
            result = min(result, input)
        }
        max = max(max, result)
    }

    println(max)
}