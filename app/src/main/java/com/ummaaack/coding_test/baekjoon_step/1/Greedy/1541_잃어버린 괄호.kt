package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var visited = booleanArrayOf()
var list = intArrayOf()
var pickedNum = mutableListOf<Int>()
var ansList = mutableListOf<MutableList<Int>>()
var target = mutableListOf<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt() //4
    target = readLine().split(" ").map { it.toInt() }.toMutableList()
    list = IntArray(n) { it + 1 }
    visited = BooleanArray(n) { false }
    if (target == list.toMutableList()) println(-1)
    else {
        if (nextPermutation(list)) list.forEach { print(it) }
    }
}

private fun nextPermutation(arr: IntArray): Boolean {
    var i = arr.size - 1
    while (i > 0 && arr[i - 1] <= arr[i]) i--
    if (i <= 0) return false

    var j = arr.size - 1

    while (arr[j] >= arr[i - 1]) j--

    swap(arr, i - 1, j)
    j = arr.size - 1
    while (i < j) {
        swap(arr, i, j)
        i++
        j--
    }
    return true
}

private fun swap(arr: IntArray, index1: Int, index2: Int) {
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}