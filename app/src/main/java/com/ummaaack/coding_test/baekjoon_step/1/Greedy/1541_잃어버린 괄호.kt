package com.ummaaack.coding_test.baekjoon_step
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()
    var list=mutableListOf<Pair<Int,Int>>()
    var answer= MutableList(n){1}
    for(item in 0 until n){
        val speck=readLine()!!.split(" ").map{it.toInt()}
        list.add(Pair(speck[0],speck[1]))
    }
    for(i in list.indices){
        for(j in list.indices){
            if(list[j].first>list[i].first && list[j].second>list[i].second){
                answer[i]+=1
            }
        }
    }
    var sb=StringBuilder("")
    for(item in answer){
        sb.append(item.toString()+" ")
    }
    println(sb.toString())
}