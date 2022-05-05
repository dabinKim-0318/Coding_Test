package com.ummaaack.coding_test.programmers.revel1.greedy

/*1. set, list의 차이
2. 증가시키는게 아니라 최대에서 감소시킬 수 있는가를 생각해라
3. 문제를 제발 잘읽자
4. sort(), sorted()한테 제대로 당함 ㅋㅋ
->문제에서 리스트의 정렬순서에 따라 값에 영향을 주는가 생각해라: 테스트케이스에서 걸린다
5. 변경될 수 있는 리스트인가 아닌가를 먼저 생각하고 변경되는애면 toMutableList()시켜야겠구나 생각
6. 항상 반환타입을 생각해라 Unit인경우 런타임 에러남 !
7. when(조건)없이 바로 코드로 조건 작성 가능
8. when에서 조건범위 in 유용
9. 컬렉션-컬렉션 가능 ****************************************   val ll = mlist1 - mlist2 =>컬렉션끼리 - 하는 순서와 뱉어내는 타입은 List라는거
10. n에서 하나씩 제거한거는 잘함!!
11.반복문은 사이즈가 0이어도 돌아가서 따로 !=0 체크해줄 필요 없군 */

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n
        var lostSet = (lost.toSet() - reserve.toSet()).sorted()
        var reserveSet = (reserve.toSet() - lost.toSet()).sorted().toMutableList()

        for (i in lostSet.indices) {
            when {
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                else -> answer--
            }
        }
        return answer
    }
}

fun main() {
    val li= mutableListOf<Int>()
    for(item in li.indices){
        println(item)
    }
    val mlist1 = mutableListOf(1, 2, 3, 4)
    val mlist2 = mutableListOf(1, 2, 3)
    val ll = mlist1 - mlist2  //미친 이게되네 -> 컬렉션끼리 - 하는 순서와 뱉어내는 타입은 List라는거

    println(ll)
    val mlist3 = mutableSetOf(1, 2, 3, 4)
    val mlist4 = mutableSetOf(1, 2, 3,5)
    val ll2 = mlist3 - mlist4  //미친 이게되네

    println(ll2)
}