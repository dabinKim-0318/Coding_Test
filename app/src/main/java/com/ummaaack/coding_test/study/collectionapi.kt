package com.ummaaack.coding_test.study

fun main() {

    //filter : 컬렌션에서 원치않는 원소를 제거할 수있지만 변형불가
    val filterList = listOf(1, 2, 3, 4)
    filterList.filter { it % 2 == 0 }
    filterList.filterNot { it == 3 }
    filterList.filterIndexed { index, _ -> index == 0 }

    //map : 반환되는 원소의 개수는 같지만 새로운 컬렉션을 만들어서 리턴해줌
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



    people.all { it.age < 40 } // ?: return  이런식으로 함수안에서 쓸떄 찾는값이 없으면 리턴시킴
    people.any { it.age < 30 }
    people.count { it.age < 40 }
    people.find { it.name == "다빈" }
    people.groupBy { it.age }
/*    { 25=[Person(name=안드로이드, age=25)],
        30=[Person(name=코틀린, age=30), Person(name=자바, age=30)] }*/




    val strings = listOf("abc", "def")
    strings.flatMap { it.toList() }
/*    it.toList()를 이용하여 해당 원소로 이루어진 리스트가 만들어진다. => list("abc"), list("def")
    flatMap이 list의 원소를 flat 하게 모든 원소로 이루어진 단일 리스트를 반환한다. => list("a", "b", "c", "d", "e", "f")
    [a, b, c, d, e, f]
    */
    val numbers = listOf(listOf(1, 2, 3), listOf(5, 6, 7), listOf(8, 9, 0))
    val result = numbers.flatten()
    println(result)  //[1, 2, 3, 5, 6, 7, 8, 9, 0]
}

class Person(val name: String, val age: Int) {}