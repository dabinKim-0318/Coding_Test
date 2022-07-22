package com.ummaaack.coding_test.baekjoon_step

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import kotlin.math.min
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var n=readLine().toInt()
    val d= MutableList(n+1){0L}

    d[1]=1
    d[2]=2

    for (i in 3 .. n){
        d[i]=(d[i-1]+d[i-2])%10007
    }

    println(d[n])
}