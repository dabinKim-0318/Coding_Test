package com.ummaaack.coding_test.programmers.revel1.stack

import java.util.*

/*
1.반복문을 실행하는 기준을 생각해라=>break의 포인트 지점
2.stack이 isNotEmpty인지를 검사하고 peek()하라 ->조건문 쓸때 isNotEmpty가 앞에 와야함
3.무언가를 넣고 빼고 나서의 조건을 잘 생각->뺴고나서 변경해줘야하는 데이터인가 */

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
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
}