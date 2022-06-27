package com.ummaaack.coding_test.baekjoon_step

import java.math.BigInteger
import java.util.*

fun main3() = with(Scanner(System.`in`)) {

    val n = nextInt()
    println(temp(n))
}

fun temp(n: Int): Int {
    if (n <= 1) return 1
    else return n * temp((n - 1))
}


fun solution(arr: IntArray): IntArray {
    val answer = mutableListOf<Int>()
    var count = 0 //2이상이면 반복되는 수임
    for (i in arr.distinct()) {
        for (j in arr) {
            if (i == j) ++count
        }
        if (count >= 2) answer.add(count)
        count = 0
    }

    return if (answer.isEmpty()) intArrayOf(-1) else answer.toIntArray()
}

//중복되는 개수를 리턴 item이랑 같은 수의 엘리먼트의 ㅏㅋ운트를 리턴함
fun getCount(arr: IntArray, item: Int): Int {
    return arr.count { it == item }
}

fun solution2(arr: IntArray): IntArray {
//유니크 배열
    val distinctArr = hashSetOf<Int>()
    val answer = mutableListOf<Int>()
    for (item in arr) {
        if (distinctArr.contains(item)) continue

        if (getCount(arr, item) > 1) answer.add(getCount(arr, item))
        distinctArr.add(item)
    }

    return if (answer.isEmpty()) intArrayOf(-1) else answer.toIntArray()
}

fun mai96n() {
    solution2(intArrayOf(3, 5, 7, 9, 1)).forEach { println(it) }
}

//어떤 N진수를 10진수로 바꾼다
fun main9(args: Array<String>) {
    val scan = Scanner(System.`in`)
    var ans = 0
    val s = scan.next()
    val b = scan.nextInt()
    for (i in 0 until s.length) {
        ans = if ('0' <= s[i] && '9' >= s[i]) ans * b + (s[i] - '0') else ans * b + (s[i] - 'A' + 10)
    }
    println(ans)
}

//10진법 -> N진법
//10부터는 A B C D E F G .. Z
fun mai3n() {
    val scan = Scanner(System.`in`)
    var n = scan.nextInt()
    val b = scan.nextInt()
    val list: MutableList<Char> = ArrayList()
    while (n > 0) {
        if (n % b < 10) list.add((n % b + '0'.code).toChar())
        else list.add((n % b - 10 + 'A'.code).toChar())
        n /= b
    }
    print(list)
    for (i in list.indices.reversed()) print(list[i].toString())  //char형의 아스키코드로 저장해두면 프린트찍을떄 무조건 그 수가 됨?
}

/* 인접 리스트 이용 */
internal class Graph(private val V: Int) {
    private val adj: Array<LinkedList<Int>?> = arrayOfNulls(V)
    fun addEdge(v: Int, w: Int) {
        adj[v]!!.add(w)
    }

    /* DFS */
    fun DFS(v: Int) {
        val visited = BooleanArray(V)

        // v를 시작 노드로 DFSUtil 재귀 호출
        DFSUtil(v, visited)
    }

    /* DFS에 의해 사용되는 함수 */
    fun DFSUtil(v: Int, visited: BooleanArray) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true
        print("$v ")

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        val it: Iterator<Int> = adj[v]!!.listIterator()
        while (it.hasNext()) {
            val n = it.next()
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n]) DFSUtil(n, visited)
        }
    }

    init {
        var li = "hi".filter { it == ' ' }
        var e = "hi".map { it }
        // 인접 리스트 초기화
        for (i in 0 until V) adj[i] = LinkedList()
    }
}

object Main {
    var n = 0
    var m = 0
    var graph = Array(1000) { IntArray(1000) }

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    fun dfs(x: Int, y: Int): Boolean {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
            return true
        }
        return false
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
val list= mutableListOf(1,2,3)+ mutableListOf(3)
        list.toMutableList().add(3)
        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt()
        m = sc.nextInt()
        sc.nextLine() // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (i in 0 until n) {
            val str = sc.nextLine()
            for (j in 0 until m) {
                graph[i][j] = str[j] - '0'
            }
        }
        var d3=minOf(3,3)
        var dd=BigInteger.ONE
        // 모든 노드(위치)에 대하여 음료수 채우기
        var result = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1
                }
            }
        }
        println(result) // 정답 출력
    }
}

fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(el, fin + it, sub - it) }
}

fun main(args: Array<String>) {
    val list = mutableListOf('a', 'b', 'c', 'd')
    val list2 = permutation(list)
    list2.forEach { print("$it ") }
    println()
}

