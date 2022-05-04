package com.ummaaack.coding_test.dongbin

import java.util.*

//a4입력받아서 하나씩 처리하기
//입력받고나서 int형 숫자를 바로 toInt()로 하면 안되고 toString()후 toInt()처리
//list안에 Pair객체 담기
//숫자 알파벳 범위 내에 있는지 검사
//alph in 'a' .. 'h'  ->a<= alph <=h
fun main() = with(Scanner(System.`in`)) {
    val place = nextLine()
    var (x, y) = Pair(place[0], place[1].toString().toInt()) //문자->문자열->정수
    var result = 0

    val list = listOf(Pair(-2, 1), Pair(-2, -1), Pair(2, -1), Pair(2, 1), Pair(2, -1), Pair(2, 1), Pair(-2, 1), Pair(-2, -1))
    for (item in list.indices) {
        if (item <= 3) {
            val xx = x + list[item].first
            val yy = y + list[item].second
            if (xx in 'a'..'h' && 1 <= yy && yy <= 8){
                result+=1
            }
        }else{
            val xx = x + list[item].second
            val yy = y + list[item].first
            if (xx in 'a'..'h' && 1 <= yy && yy <= 8){
                result+=1
            }
        }
    }

    println(result)

}