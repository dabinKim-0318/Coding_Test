package com.ummaaack.coding_test.programmers.revel1.stack

import java.lang.StringBuilder
import java.util.*

/*
1.반복문을 실행하는 기준을 생각해라=>break의 포인트 지점
2.stack이 isNotEmpty인지를 검사하고 peek()하라 ->조건문 쓸때 isNotEmpty가 앞에 와야함
3.무언가를 넣고 빼고 나서의 조건을 잘 생각->뺴고나서 변경해줘야하는 데이터인가 */

class Solution {
    fun solution2(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        moves.forEach {
            for(i in board.indices){
                if( board[i][it-1]!=0){
                    if(stack.isNotEmpty()&&stack.peek()==board[i][it-1]){
                        answer+=2
                        stack.pop()
                    }else{
                        stack.push(board[i][it-1])
                    }
                    board[i][it-1]=0
                    break  //move가 실행될때마다 탐색은 한번만 하는거기때문에 move기준으로 반복
                }
            }
        }


        return answer
    }

    fun solution(s: String, n: Int): String {
        var answer = ""
        //ABCDEFGHI  인덱스를 +민다  Z->A
        arrayOf(1,3,2).sortedDescending()
        //0123456
        var s=s.toMutableList()
        var lowerList=mutableListOf<CharRange>('a'..'z')
        var upperList=mutableListOf('A'..'Z')
        val sb=StringBuilder("")
        //각 아이템의 원래 인덱스보다 +n한 문자로 바꾸고 공백이면 그냥 운래 자신으로 매핑하고
        for(i in s){
            when(i){
                in 'a'..'z'-> {
                    var index=('a'..'z').indexOf(i)
                    if(index+n >lowerList.size-1){
                        index=index+n-lowerList.size-1
                        sb.append(s[index])
                    }    else{
                        sb.append(s[index+n])
                    }
                }
                in 'A'..'Z'->{
                    var index=('A'..'Z').indexOf(i)
                    if(index+n >upperList.size-1){
                        index=index+n-upperList.size-1
                        sb.append(s[index])
                    }    else{
                        sb.append(s[index+n])
                    }
                }
                else->{
                    sb.append(" ")
                }
            }

        }

        return sb.toString()
    }
}