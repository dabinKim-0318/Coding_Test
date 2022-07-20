package com.ummaaack.coding_test.baekjoon_step


import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

var ans = 1L
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //2 4 8  ->차이의 최대공약수
    val (n, s) = readLine().split(" ").map { it.toLong() } //수 , 내좌표
    val list = readLine().split(" ").map { it.toLong() } //동생 좌표
    val cha = mutableListOf<Long>() //차이 리스트
    list.forEach {
        cha.add(abs(it - s))
    }
    ans = cha.first()
    for (i in cha.indices) {
        if (i == cha.size - 1) break
        ans = gcd(ans, cha[i + 1])
    }

    println(ans)
}

fun gcd(a: Long, b: Long):Long = if (b != 0L) gcd(b, a % b) else a