package com.ummaaack.coding_test.study

fun main() {

/*    filter : 컬렌션에서 원치않는 원소를 제거할 수있지만 변형불가
    Iterable<T>.filter(predicate: (T) -> Boolean): List<T>
    filter 안에는 Boolean 조건문만 와야한다
    타입.filter는 타입값으로 반환해준다 즉 string.filter->string IntArray.filter->IntArray*/

    val list = mutableListOf(1, 2, 3, 4)
    list.filter { it % 2 == 0 }
    list.filterNot { it == 3 }
    list.filterIndexed { index, _ -> index == 0 }

/*    map : 반환되는 원소의 개수는 같지만 새로운 컬렉션을 만들어서 리턴해줌
    Iterable<T>.map(transform: (T) -> R): List<R>
    map 은 List타입을 반환한다 toIntArray로 IntArray타입으로 변경해야한다*/

    val mapList = listOf(1, 2, 3, 4)
    mapList.map { it * it }

    //람다의 멤버참조
    val people = listOf(Person("다빈", 22), Person("수정", 33), Person("지태", 55))
    people.map(Person::name)

    //30살 이상인 사람의 이름을 출력
    people.filter { it.age >= 30 }.map(Person::name)

    //제일많은나이 이름
    val maxAge = people.maxByOrNull(Person::age)?.age
    people.filter { it.age == maxAge }

    //개수내놔, 이 조건 만족하는 T찾아서 내놔: count(), find() -> Int, T타입
    people.count { it.age < 40 }  //int
    list.count() //size랑 똑같누
    people.find { it.name == "다빈" }  //T타입
    people.findLast { it.name == "다빈" }

    //조건만족하는 첫, 마지막 객체 내놔: first(), firstOrNull(), last(), lastOrNull() -> T타입
    list.first { it == 4 } //T타입 조건에 맞는 첫번째 데이터
    list.last { it == 4 } //마지막 데이터터
    list.first()
    list.last()

    //최대최소: maxOrNull(), minOrNull() -> T타입
    list.maxOrNull()
    list.minOrNull()

    //앞, 뒤에서 몇만큼 리스트로 내놔: takeLast(), takeWhile() -> List<T>
    list.takeLast(4)  // 0부터 4까지 반환(인덱스 x)
    list.takeLast(4)  //뒤에서부터 앞으로 4까지 반환
    list.takeWhile { it == 4 }  //조건에 맞지 않을때까지 데이터 추출출

    //이 조건 만족하는 객체 있냐없냐: any, all, none -> Boolean
    people.all { it.age < 40 } // ?: return  이런식으로 함수안에서 쓸떄 찾는값이 없으면 리턴시킴
    people.any { it.age < 30 }
    people.none { it.age < 30 && it.name == "다빈" }
    people.groupBy { it.age }
/*    { 25=[Person(name=안드로이드, age=25)],
        30=[Person(name=코틀린, age=30), Person(name=자바, age=30)] }*/

    // 해당 인덱스 객체 내놔
    list[1]

    // 해당 객체 삭제해:remove -> Boolean
    list.remove(2) //2삭제해

    //해당 인덱스 객체 삭제해:removeAt -> Boolean
    list.removeAt(0) // index 0인거 삭제해

    // 해당 객체의 index 내놔:indexOf ->Int
    list.indexOf(0) //0이라는 객체의 index 값 내놔

    //컬렉션 하나로 묶어: flatMap -> List<R>
    val strings = listOf("abc", "def")
    strings.flatMap { it.toList() }
/*    it.toList()를 이용하여 해당 원소로 이루어진 리스트가 만들어진다. => list("abc"), list("def")
    flatMap이 list의 원소를 flat 하게 모든 원소로 이루어진 단일 리스트를 반환한다. => list("a", "b", "c", "d", "e", "f")
    [a, b, c, d, e, f]
    */
    val numbers = listOf(listOf(1, 2, 3), listOf(5, 6, 7), listOf(8, 9, 0))
    val result = numbers.flatten()
    println(result)  //[1, 2, 3, 5, 6, 7, 8, 9, 0]

    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
    val clothesBag = listOf("shirts","pants","jeans")           // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
// [[apple, orange, banana, grapes], [shirts, pants, jeans]]
    val mapBag = cart.map { it }                                // 4
// [apple, orange, banana, grapes, shirts, pants, jeans]
    val flatMapBag = cart.flatMap { it }

}

class Person(val name: String, val age: Int) {}