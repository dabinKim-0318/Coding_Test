package com.ummaaack.coding_test.programmers.revel1


/*lottos	win_nums	result
[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]*/

/*
1.filter 안에는 Boolean 조건문만 와야한다
2.타입.filter는 타입값으로 반환해준다 즉 string.filter->string IntArray.filter->IntArray
3.intArrayOf는 값 변경 불가 임으로 그 안에서 값을 생성한다
4.map 은 List타입을 반환한다 toIntArray로 IntArray타입으로 변경해야한다*/

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {

        return intArrayOf(
            //최고등수
            7-lottos.filter{win_nums.contains(it) || it==0 }.size,  //filter는 적용한애 타입 고대로 반환해줌
            //최저등수
            7-lottos.filter{win_nums.contains(it)}.size
        ).map{if(it>6) 6 else it}.toIntArray()  //map은 무조건 List<T>로 반환함
    }
}