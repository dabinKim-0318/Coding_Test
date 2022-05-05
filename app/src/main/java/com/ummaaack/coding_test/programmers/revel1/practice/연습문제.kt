package com.ummaaack.coding_test.programmers.revel1.practice

/*어디부터 어디까지 반복문을 돌린다할때 사용하는거
int->Long도 명시적으로 toLong()해줘야하는군
처음부터 toLong여러번썼더니 런타임 에러남 answer을 long으로 만들어두고 시작
for문에서 .. 은 모두 포함, indices는 index끝으로 만들어서 넘어준다는거 복기*/
class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer=0L

        if(a>b){
            for(item in b..a){
                answer+=item
            }
        }else if(a<b){
            for(item in a..b){
                answer+=item
            }
        }else{
            answer=a.toLong()
        }
        return answer
    }
}