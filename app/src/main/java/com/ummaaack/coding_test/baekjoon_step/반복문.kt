package com.ummaaack.coding_test.dongbin

import java.util.*
import kotlin.math.sign

//기찍기
fun main1() = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val array = Array(num) { i -> i }
    for (item in array[num - 1] downTo array[0]) {
        print("${item + 1}\n")
    }
}

//출력
fun main2() = with(System.`in`.bufferedReader()) {

    val case = readLine().toInt()

    val array = mutableListOf<Int>()
    for (item in 0 until case) {
        val twoNum = readLine().split(" ").map { it.toInt() }
        array.add(twoNum[0] + twoNum[1])
    }
    for (item in 0 until case) {
        print("Case #${item + 1}: ${array[item]}\n")
    }
}

//아름답게 출력
fun main3() = with(Scanner(System.`in`)) { //Scanner쓰려면 반드시 import해야함
    for (i in 1..nextInt()) {
        val a = nextInt() //Int값 하나를 받으니까, 엔터구분
        val b = nextInt() //Int값 하나를 받고 엔터구분
        println("Case #$i: $a + $b = ${a + b}")
    }
}

//별찍기
fun main5() = with(Scanner(System.`in`)) {
    val num = nextInt()
    for (i in 1..num) {
        for (j in 0 until i) {
            print("*")
        }
        print("\n")
    }
}

//별찍기 2*******************************************
fun main6() = with(Scanner(System.`in`)) {
    val num = nextInt()
    for (i in 1..num) {
        for (j in 0 until i) {
            for (k in 1..num - i) {
                if (j != 0) break
                print(" ")
            }
            print("*")
        }
        print("\n")
    }
}

fun main7() = with(Scanner(System.`in`)) {
    val twoNum = nextLine().split(" ").map { it.toInt() }
    val array = mutableListOf<Int>()
    val array2 = mutableListOf<Int>()
    for (item in 0 until twoNum[0]) {
        val num = nextInt()
        array.add(num)
    }
    for (i in 0 until twoNum[0]) {
        if (array[i] < twoNum[1]) print("${array[i]} ")
    }
}

//A+B-4*******************************************
fun main8() {
    val input = Scanner(System.`in`)
    while (true) {
        val rr = input.nextLine() ?: break
        val aa = rr.split(" ").map { it.toInt() }
        print("${aa[0] + aa[1]}")
    }
}

fun main9() = with(Scanner(System.`in`)) {
    while (hasNextInt()) {
        println(nextInt() + nextInt())
    }
}

fun main() = with(Scanner(System.`in`)) {
    var result = 0
    val input = nextLine()
    val init = input.toInt()
    var f = 0
    var s = 0
    var new = ""
    while (true) {
        if (init == new.toInt()) break
   println(result)
        if (result == 0) {
            f = input[0].toString().toInt()
            s = input[1].toString().toInt()
            println(f)
            println(s)
        } else {
            f = new.toString()[0].toString().toInt()
            s = new.toString()[1].toString().toInt()
        }

        if (f + s < 10) {
            if(s!=0) new = (s.toString() + (f + s).toString())
            else new=f.toString()
        } else if(f+s>=10){
            val two = (f + s).toString()
            println(f)
            println(s)
            println(two)
            new = (s.toString() + two[1])
            println("mmmmmmmmmmmmmmmmmmmm$new")
        }
        result += 1
    }
println(result)
}
















