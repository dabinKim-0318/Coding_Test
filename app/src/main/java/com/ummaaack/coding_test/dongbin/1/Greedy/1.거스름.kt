package com.ummaaack.coding_test.dongbin

/*Greedy:
- 현재 상황에서 지금 당장 좋은 것만 고르는 방법
- 매 순간 가장 좋아보이는 것을 선택함
- 기준에 따라 좋은 것을 선택하는 알고리즘이므로 문제에서 '가장 큰 순서대로', '가장 작은 순서대로'같은
- 기준을 알게 모르게 제시해줌
- '기준'을 제시해주기 때문에 그리디 알고리즘 문제는 정렬 알고리즘과 짝을 이뤄 출제됨*/

/*거스름돈으로 500, 100, 50, 10원짜리 동전이 무한히 존재한다고 한다.
거슬러 줘야 할 돈이 N원일 때, 거슬러 줘야 할 동전의 최소 개수를 구하라. 단, N은 항상 10의 배수이다.
-> 가장 큰 화폐 단위부터 돈을 거슬러 주는 방식으로 해결*/
fun main_1() {
    var money = 1260
    var count = 0

    val coin = listOf(500, 100, 50, 10)
    for (item in coin.indices) {
        count += money / coin[item]
        money -= (coin[item] * (money / coin[item])) //money %= coin[item]

    }
    print(count)
}

fun main(args: Array<String>) {
    var n = 1260
    var cnt = 0
    val coinTypes = intArrayOf(500, 100, 50, 10)
    for (i in 0..3) {
        val coin = coinTypes[i]
        cnt += n / coin
        n %= coin  //잔돈 걍 나누면 되는데 왜케 어렵게 생각했지
    }
    println(cnt)
}
