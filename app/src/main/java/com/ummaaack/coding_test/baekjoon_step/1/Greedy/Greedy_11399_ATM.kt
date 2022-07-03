package com.ummaaack.coding_test.baekjoon_step.`1`.Greedy
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    //2명의 여학생과 1명의 남학생
//여학생의 수 N, 남학생의 수 M, 인턴쉽에 참여해야하는 인원 K가 주어질 때 만들 수 있는 최대의 팀
    var N=nextInt()
    var M=nextInt()
    val K=nextInt()
    var answer=0
    while(N>1&& M>0 && N+M>=3+K){
        N-=2
        M-=1
        answer++
    }
    println(answer)
}

