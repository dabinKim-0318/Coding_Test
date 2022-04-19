package com.ummaaack.coding_test.dongbin

import java.util.*

fun main4() = with(System.`in`.bufferedReader()) {
    // 정수 하나 읽기
    val num = readLine().toInt()  //3
    print(num)  //3

    // 공백 기준으로 읽기->""을 기준으로 자른 후 각 원소를 int로 매핑
    val nums = readLine().split(" ").map { it.toInt() }  //3 3
    print(nums)  //[3 3]

    // 문자열 을 char 배열로 받기
    val char = readLine().toCharArray()  //김다빈
    print(char)  //김다빈

    // 문자열 받기
    val string = readLine() //김다빈
    print(string)  //김다빈

}

fun main() = with(Scanner(System.`in`)) {

    // 이거는 Scanner을 열 필요가 없군
  //  val a = readLine()  //엔터구분 / 무조건 string?타입으로 입력받음 공백포함
  //  print("a를 정수로 변환 ${a!!.toInt()}")

  // val b = next() //엔터, 공백기준 / String 타입 안녕 코틀린
 //  print("b : $b") //안녕
   // val c = nextInt() //Int타입

    val d = nextLine().split(" ").map{it.toInt()} //엔터구분 / String타입 , 공백포함 !! //3 3 5
   print("d : $d") //[3, 3, 5]

    val e = nextLine()//엔터구분 / String타입 , 공백포함 !! //안녕 코틀린
   print("e : $e") //안녕 코틀린
}