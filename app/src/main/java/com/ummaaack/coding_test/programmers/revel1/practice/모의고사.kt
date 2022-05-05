/*각 컬렉션 함수의 반환타입을 줄줄꾀고 있어야한다*/
class Solution {
    fun solution(answers: IntArray): IntArray {

        //answers의 size만큼 1,2,3 수포자 정답 배열 생성
        var one = arrayOf(1, 2, 3, 4, 5)
        var newOne = mutableListOf<MutableList<Int>>()
        var realOne= mutableListOf<Int>()
        var oneCount = 0

        var two = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        var newTwo = mutableListOf<MutableList<Int>>()
        var realTwo= mutableListOf<Int>()
        var twoCount = 0

        var three = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        var newThree = mutableListOf<MutableList<Int>>()
        var realThree= mutableListOf<Int>()
        var threeCount = 0

        var countList = mutableListOf<Int>()

        while (true) {  //1 2 3 4
            newOne.addAll((listOf(one.toMutableList())))
            //addAll의 반환타입은 boolean이면서 list초기화 시키고 collection만 받음
            realOne = newOne.map { it.toTypedArray() }.toTypedArray().flatten().toMutableList()
            //it.toTypedArray()로 map해서 newOne안의 item들을 array로 바꾼 후 newOne을 다시 array로 바꾼 후 flatten사용한 후 다시 toMutableList
            // Collection<T>.toTypedArray(): Array<T>

            if (realOne.size >= answers.size) break
            //배열 다 만들었으면 빠져나오고
        }
        realOne = realOne.slice(0..answers.size - 1).toMutableList()
        //진짜 answer사이즈 만큼의 정답list만듦

        for (i in realOne.indices) {
            if (realOne[i] == answers[i]) oneCount++
        }
        countList.add(oneCount)
        //정답 맞춘 카운팅 집어넣음

        while (true) {  //1 2 3 4
            newTwo.addAll((listOf(two.toMutableList())))
            realTwo = newTwo.map { it.toTypedArray() }.toTypedArray().flatten().toMutableList()
            if (realTwo.size >= answers.size) break
        }
        realTwo = realTwo.slice(0..answers.size - 1).toMutableList()
        for (i in realTwo.indices) {
            if (realTwo[i] == answers[i]) twoCount++
        }
        countList.add(twoCount)

        while (true) {  //1 2 3 4
            newThree.addAll((listOf(three.toMutableList())))
            realThree = newThree.map { it.toTypedArray() }.toTypedArray().flatten().toMutableList()
            if (realThree.size >= answers.size) break
        }
        realThree = realThree.slice(0..answers.size - 1).toMutableList()
        for (i in realThree.indices) {
            if (realThree[i] == answers[i]) threeCount++
        }
        countList.add(threeCount)
        val max = countList.maxOrNull()
        // Iterable<T>.maxOrNull(): T?
        //가장 큰 item T타입으로 반환
        val answer= mutableListOf<Int>()
        for(item in countList.indices){ //indices는 collection의 index를 예쁘게 꺼내줌
            if(countList[item]==max){
                answer.add(item+1) //index+1이 수포자의 이름
            }
        }
        return answer.toIntArray()
    }
}