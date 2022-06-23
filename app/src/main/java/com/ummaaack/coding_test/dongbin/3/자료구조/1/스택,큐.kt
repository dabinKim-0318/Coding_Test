package com.ummaaack.coding_test.dongbin

import java.util.*

/** stack 사용을 위한 import */


fun main() {
    val stack = Stack<Int>()
    if (stack.isNotEmpty())
        stack.peek()  //stack.isNotEmpty()
    stack.push(1)
    stack.pop()

    var queue: Queue<Int> = LinkedList<Int>()  //queue인터페이스를 구현한 객체 직접 생성 이거 = 띄어쓰기 안하니가 왜 안되지

    println(queue.add(1))  //가장 앞으 데이터  //true
    println(queue.add(2))  //true
    println(queue.add(3))  //true

    println(queue.poll()) //가장 앞 데이터 꺼내기  //1

    println(queue.peek()) //가장 앞 데이터 보기  //2

}

class DFS() {
    val visitedList = MutableList(8) { false }
    val graph = arrayOf(arrayOf(1), arrayOf(2, 3, 8), arrayOf(1, 7), arrayOf(1, 4, 5))
    fun dfs(n: Int) {
        visitedList[n] = true
        for (index in graph.indices) {
            val y = graph[n][index]
            if (!visitedList[y]) {
                dfs(y)
            }
        }
    }
}

class BFS() {
    val visitedList = MutableList(8) { false }
    val graph = arrayOf(arrayOf(1), arrayOf(2, 3, 8), arrayOf(1, 7), arrayOf(1, 4, 5))
    fun bfs(n: Int) {
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(n) //큐에 집어넣고
        while (queue.isNotEmpty()) //큐가 비워져 있지 않다면
        {
            queue.poll()  //큐에서 하나 꺼내고
            for (index in graph[n].indices) {
                val y=graph[n][index]  //인접 '노드'의 값을 구하는거임 !!!!
                if (!visitedList[y]) {
                    visitedList[y] = true //인접 노드 방문처리
                    queue.add(y)
                }
            }
        }
    }
}

















