package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy

import java.util.*

import java.util.*
import kotlin.collections.ArrayDeque


private var N = 0
fun main() = with(Scanner(System.`in`)) {
    //사전순으로 바로 이전에 오는 순열을 구하는 프로그램

    N = nextInt()
    val list = mutableListOf<Int>()
    for (item in 0 until N) {
        list.add(nextInt())
    }

    val listInt = list.map { it.toString() }.joinToString("").toInt()
    val isVisited = BooleanArray(N + 1)
    dfs(0, isVisited, IntArray(N), listInt)
}

private fun dfs(depth: Int, isVisited: BooleanArray, nums: IntArray, listInt:Int) {
  /*  if (depth == N) {
        for(index in 0 until nums.size){
            if(nums[index]==listInt&&)
        }
    }*/
    for (i in 1..N) {
        if (!isVisited[i]) {
            isVisited[i] = true
            nums[depth] = i
            dfs(depth + 1, isVisited, nums,listInt)
            isVisited[i] = false
        }
    }
}
