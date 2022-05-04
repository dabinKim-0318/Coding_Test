package com.ummaaack.coding_test.study

import java.util.*
import kotlin.time.Duration.Companion.seconds

fun main() {
    val arr = mutableListOf(1, 2, 3, 0)

    /*오름차순*/

    // MutableList<T>.sort(): Unit
    arr.sort() //오름차순->Unit반환해서 이거 하고 print(arr)해야됨 //mutableList반환
    // Iterable<T>.sorted(): List<T>
    arr.sorted().toMutableList() //오름차순으로 정렬된 list반환
    // MutableList<T>.sortBy(crossinline selector: (T) -> R?): Unit
    arr.sortBy { 3 } //3을 기준으로 오름차순

    /*내림차순*/
    arr.sortDescending() //내림차순->Unit
    arr.sortedDescending().toMutableList() //내림차순으로 정렬된 list반환
    arr.sortByDescending { 3 } //3을 기준으로 내림차순

    arr.sortedWith(compareBy { 2 })//2를 기준으로 오름차순 정렬
    println(arr)

    /*뒤집기*/
    //MutableList<T>.reverse(): Unit
    arr.reverse() // 뒤집기-> Unit반환
    //Iterable<T>.reversed(): List<T>
    arr.reversed() //새로운 list반환 반환형 List임
    //MutableList<T>.asReversed(): MutableList<T> = ReversedList(this)
    arr.asReversed() //mutableList로 반환

    /*복사*/
    //1.얕은복사=원본 리스트와 복사 리스트가 공유됨
    var arr1 = mutableListOf(1, 2, 3)
    var arr2 = arr1
    arr2.add(0)
    println("arr1: $arr1 arr2: $arr2") //arr1: [1, 2, 3, 0] arr2: [1, 2, 3, 0]

    //2.깊은복사=원본 리스트와 복사 리스트가 공유안됨
    var arr3 = mutableListOf(1, 2, 3)
    var arr4 = mutableListOf<Int>()
    //addAll(elements: Collection<E>): Boolean
    arr4.addAll(arr3)  //addAll은 collection만 받음
    arr4.add(0)
    println("arr3: $arr3 arr4: $arr4") //arr3: [1, 2, 3] arr4: [1, 2, 3, 0]

    //슬라이싱: 특정 인덱스 범위~범위까지 가져오기, 깊은복사
    val arr6 = mutableListOf(1, 2, 3, 4, 5)
    // List<T>.slice(indices: IntRange): List<T>
    val arr5 = arr6.slice(0..2).toMutableList()  //arr리스트의 0,1,2인덱스 범위까지 가져오기 List로 반환
    arr5.add(0)
    println("arr5: $arr5 arr6: $arr6") //arr5: [1, 2, 3, 0] arr6: [1, 2, 3, 4, 5]

}


/*
   commands.map { command ->
    array.slice(command[0] - 1 until command[1]).sorted()[command[2] - 1]
}.toIntArray()


   intArrayOf(
        7-lottos.filter{win_nums.contains(it) || it==0 }.size,  //filter는 적용한애 타입 고대로 반환해줌
        7-lottos.filter{win_nums.contains(it)}.size
    ).map{if(it>6) 6 else it}.toIntArray()  //map은 무조건 List<T>로 반환함


    commands.map { command ->
            array.slice(command[0] - 1 until command[1]).sorted()[command[2] - 1]
        }.toIntArray()
*/
