package com.ummaaack.coding_test.dongbin

import kotlin.contracts.contract


private fun main() {
    val list = intArrayOf(1, 10, 5, 8, 7, 6, 4, 3, 2, 9)
    bubbleSort(list)
    list.forEach { print("$it ") }
}


private fun bubbleSort(list: IntArray) {

    repeat(list.size) {
        for (index in 0 until list.size - 1) {
            if (list[index] > list[index + 1]) {
                swap(index, index + 1, list)
            }
        }
    }
}

private fun swap(index: Int, minIndex: Int, list: IntArray) {
    val tempItem = list[index]
    list[index] = list[minIndex]
    list[minIndex] = tempItem
}
