package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader


var sosuList = mutableListOf<Boolean>()
var list = mutableListOf<Int>()
var pickedNum = mutableListOf<Int>()
var ans = 0 //가능한 경우수 카운트
var n = 0
fun mai4n() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var input = readLine().toInt()
    for (i in 1..input) {
        n = readLine().toInt()
        getSosu(n)

        jo(0, 2, 0, sosuList)
        sosuList.forEachIndexed { i, it ->
            if (it && i * 2 == n) ans += 1
        }
        println(ans)
        ans = 0
        list.clear()
    }
}

fun getSosu(n: Int) {
    sosuList = MutableList(n + 1) { true }
    sosuList[0] = false
    sosuList[1] = false
    for (i in 2 until n + 1) {
        if (sosuList[i]) {
            for (j in 2 * i until n + 1 step i) {
                sosuList[j] = false
            }
        }
    }
}

fun jo(cnt: Int, depth: Int, beginWith: Int, list: List<Boolean>) {
    if (cnt == depth) {
        //  println(pickedNum)
        if (pickedNum.sum() == n) ans += 1
        return
    }

    for (i in beginWith until list.size) {
        if (list[i]) {
            pickedNum.add(i)
            jo(cnt + 1, depth, i + 1, list)
            pickedNum.removeLast()
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bol = BooleanArray(100001) { true }
    bol[0] = false
    bol[1] = false
    for (i in 2 until bol.size) {
        if (bol[i]) {
            for (j in 2 * i until bol.size step i) {
                bol[j] = false
            }
        }
    }
    val input = readLine().toInt()
    for (i in 1..input){
        val n=readLine().toInt()
        var ans=0
        for(j in 2..n/2){

        }
    }
}

