fun main() {
    val list = mutableListOf(1, 2, 3, 4)
    print(list)

    print(list[1])

    val dd = emptyList<Int>()
    //빈 리스트 만들기
    val emptyList = mutableListOf<Int>()

    //연속된 숫자로 초기화한 리스트
    val array = List(9) { i -> i }
    print(array)  //[0, 1, 2, 3, 4, 5, 6, 7, 8]

    //특정값으로 초기화한 리스트
    val zeroList = List(5) { 0 } //[0, 0, 0, 0, 0]
    val zeroList2 = List(5) { _ -> 0 } //[0, 0, 0, 0, 0]
    print(zeroList)

    val list2 = MutableList(5) { 5 }  //[5,5,5,5,5]

    //특정 값으로 초기화한 리스트는 함수로 만들땐 안됨
    //val list3 = mutableListOf(5, { i -> 3 })

    // print(list2[-1])

    //슬라이싱: 리스트에서 연속적 위치를 각ㅈ는 원소 가져오기
    print(list2.slice(0..2))  //index 0,1,2인애들만 출력됨

    //0-18까지 중 홀수만 출력
    for (item in List(18) { i -> i })
        if (item % 2 == 1) print(item)  //1357911131517
/*
    list2.addAll(listOf(1, 2, 3, 4))
    list2.removeAll(listOf(1, 2))
    list2.retainAll(listOf(4))
    list2.removeAt(3)*/

    //2차원 배열 선언
    val array1 = arrayOf(
        arrayOf("Aa", "Bb", "Cc", "Dd", "Ee"),
        arrayOf("Ff", "Gg", "Hh", "Ii", "Jj"),
        arrayOf("Kk", "Ll", "Mm", "Nn", "Oo")
    )
//출력값
    println(array1[0][1])  //Bb
    println(array1[1][1])  //Gg
    println(array1[2][1])  //Ll

//    val zeroList = List(5) { 0 } //[0, 0, 0, 0, 0]
    val array2 = List(3) { IntArray(2) { 0 } }
              //Array(행의 크기, {IntArray(열의 크기, {초기화 값})}

    //출력값
    for ((i, row) in array2.withIndex()){ //i는 배열의 행수만큼 돌아감
        for ((j,column) in row.withIndex()){ //row=열의 개수만큼 반복
            print("[$i,$j] => $column\t")
        }
        println()
    }

    for((i,row) in array2.withIndex()){
        for((j,column) in row.withIndex()){
            print("$i,$j=$column")
        }
    }

}