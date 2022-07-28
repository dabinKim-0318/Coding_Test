package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

val list = MutableList(10) { it } //0..9
var bolList = BooleanArray(list.size) { false }
var pickedNum = mutableListOf<Int>()
var buList = mutableListOf<String>()
var ans = mutableListOf<Long>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //부등호 개수 k
    //넣을 수 있는 수 리스트: 0부터 9
    //순서열 ->k+1개의 사이즈 ->순열
    //만족하는 순열 add하고 최대 최소따로 출력
    val k = readLine().toInt() //9개의 부등호
    val st = StringTokenizer(readLine())
    for (i in 1..k) {
        buList.add(st.nextToken())
    }
    sun(0, k + 1)
    ans.sort()
    println(ans.last())
    if (ans.first().toString().length == k) println("0"+ans.first())
    else println(ans.first())
}

fun sun(cnt: Int, depth: Int) {
    if (cnt == depth) {
        if (check(pickedNum)) {
            var sb = StringBuilder("")
            pickedNum.forEach {
                sb.append(it.toString())
            }
            ans.add(sb.toString().toLong())
        }
        return
    }

    for (i in 0 until list.size) {
        if (!bolList[i]) {
            bolList[i] = true
            pickedNum.add(list[i])
            sun(cnt + 1, depth)
            bolList[i] = false
            pickedNum.removeLast()
        }
    }
}

//5 6 8 9 0 2 3 4 5 1 ->10개
fun check(list: MutableList<Int>): Boolean {
    var flag = true
    for (i in 0 until buList.size) { //0..9
        if (buList[i] == "<") {
            if (list[i] > list[i + 1]) {
                flag = false
                break
            }
        } else {
            if (list[i] < list[i + 1]) {
                flag = false
                break
            }
        }
    }
    return flag
}