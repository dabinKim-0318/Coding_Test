package com.ummaaack.coding_test.baekjoon_step

var answerList = mutableListOf<Int>() //쌍의 개수 저장 ->answer
var aList = mutableListOf<Int>()
var bList = mutableListOf<Int>()

fun main() {
    val count = readLine()!!.toInt() //몇번반복
    var sum = 0
    var how=0

    while(count!=how) {
        how++
        val howList = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        aList = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        bList = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

        val sortedB=bList.sorted() //아래 forEach 구문안에서 binary에 파라미터로 bList.sorted()를 넣으니까
        //forEach 돌때마다 sorted() 매번 실행해서 시간초과 떴음 !!

        aList.forEach { target ->
            sum += binary(sortedB, target) //target별 쌍 개수 리턴
        }
        answerList.add(sum)
        sum = 0
    }
    answerList.forEach{println(it)}
}

fun binary(bList: List<Int>, target: Int): Int {
    var start = 0
    var end = bList.size - 1

    while (start <= end) {
        val mid = (start + end) / 2
        if (bList[mid] < target) {
            start = mid + 1
        } else if (bList[mid] >= target) {
            end = mid - 1
        }
    }
    return end + 1  //end index가 갈 수 있는 최대 index이자 가장 큰 갯수가 될 수 있음 +1 하는거 잊지말고
}