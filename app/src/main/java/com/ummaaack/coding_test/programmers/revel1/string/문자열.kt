package com.ummaaack.coding_test.programmers.revel1.string

class Solution {
    fun solution(new_id: String): String {

        //val 타입인 new_id를 var인 answer에 넣고 시작
        var answer: String = new_id

        //1.모든 대문자를 대응되는 소문자로 변환
        answer = answer.lowercase() //String

            //2, 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
            //string.filter니까 string타입으로 반환
            //소문자    //Char.isLowerCase(): Boolean  //Char.isDigit(): Boolean
            .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }

            //3.마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            //CharSequence.replace(regex: Regex, replacement: String)
            .replace("[.]*[.]".toRegex(), ".")

            //4.마침표(.)가 처음이나 끝에 위치한다면 제거
            //String.removePrefix(prefix: CharSequence)
            .removePrefix(".").removeSuffix(".")

            //5.빈 문자열이라면, new_id에 "a"를 대입
            .let { if (it.isEmpty()) "a" else it }

            //6. 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            .let {                       //0포함 16포함x start부터 end - 1 까지의 부분 문자열을 가져오는 함수
                if (it.length >= 16) it.substring(0, 16).removeSuffix(".") else it
            }

            //7.new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
            .let {
                if (it.length <= 2) {
                    //원래 string을 불변이라 append같은걸로 새로운 문자열 만들떄 StringBuilder로 사용
                    //단일 스레드 환경이니까 StringBuilder쓰면 됨
                    val sb = StringBuilder(it)
                    while (sb.length != 3)
                        sb.append(it.last()) //CharSequence.last(): Char
                    sb.toString()
                } else it
            }
        return answer
    }
}
/*
//알파벳
// String.lowercase(): String
var str = "AgfDvFd sSD1234"
println("문자열 대문자 변환 = ${str.uppercase()}") //string반환
println("문자열 소문자 변환 = ${str.lowercase()}") //string반환

if (str[0] in 'a'..'z' || str[0] in 'A'..'Z') {  //대소문자 다르게 인식하고 a랑 z도 포함해서 검사함
    println(true) //true
    3 >= 4
}

//공백 제거
// String.trim(): String
str.trim()

//인덱스 기준 쪼개서 가져오기
//String.substring(startIndex: Int, endIndex: Int): String
str.substring(0, 2)  //0번째 인덱스부터 2인째 인덱스까지  Ag

//문자열 뒤집기
//String.reversed(): String
str.reversed()//4321DSs dFvDfgA

val dd = "fff"
dd.removePrefix("f")

.let {
    if (it.length <= 2) {
        //원래 string을 불변이라 append같은걸로 새로운 문자열 만들떄 StringBuilder로 사용
        //단일 스레드 환경이니까 StringBuilder쓰면 됨
        val sb = StringBuilder(it)
        while (sb.length != 3)
            sb.append(it.last()) //CharSequence.last(): Char
        sb.toString()
    } else it
}
*/


