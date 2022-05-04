package com.ummaaack.coding_test.programmers.revel1.collection

//map은 항상 List<타입>으로 반환하기 때문에 return 타입이 IntArray를 요구할 경우 toIntArray를 해주어야함
//map은 반복문을 돌면서 해당 반복문의 각 아이템들을 어떤 값으로 변형하고 다시 return해줄때 유용함
class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>) {
 /*       public inline fun <T, R> Array<out T>.map(transform: (T) -> R): List<R> {
            return mapTo(ArrayList<R>(size), transform)
        }*/
       val dd= commands.map { command ->
            array.slice(command[0] - 1 until command[1]).sorted()[command[2] - 1]
           //List<Int>
        }.toIntArray()  //IntArray
        println(dd)
       // println(dd)  //5 6 3
    }
}
