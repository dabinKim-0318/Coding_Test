package com.ummaaack.coding_test.baekjoon_step

import java.io.*
import java.util.*
import kotlin.math.*
import kotlin.system.*

/*private lateinit var matrix: Array<IntArray>
private lateinit var visited: BooleanArray
private var ans = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    //depth가 m인 연결요소가 존재하는가
    val (nn, mm) = readLine().split(" ").map { it.toInt() }
    matrix = Array(nn) { IntArray(nn) { 0 } }
    visited = BooleanArray(nn) { false }
    repeat(mm) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        matrix[x][y] = 1
        matrix[y][x] = 1
    }
  for(it in matrix) {
        if(it.slice(1..it.size-1).filter{i->i==1}.count()==it.size-1){
            println(0)
            exitProcess(0)
        }
    }
    for (i in visited.indices) {
        dfs(i)
        if (ans - 1 == nn - 1) {
            println(1)
            exitProcess(0)
        }
        ans = 0
        visited.fill(false)
    }
    println(0)
}

private fun dfs(n: Int) {
    ans += 1
    visited[n] = true
    for (i in 0 until matrix.size) {
        if (matrix[n][i] == 1 && !visited[i]) {
            dfs(i)
        }
    }
}*/


private const val m = 0
private lateinit var list: Array<ArrayList<Int>>
private const val ans = 0
private lateinit var v: BooleanArray


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    Main.m = M

    //DFS를 위한 인접리스트 구현하기
    list = Array<ArrayList<Int>>(N) { ArrayList(N) { 0 } }
    v = BooleanArray(N)
    for (i in 0 until N) {
        list.get(i) = ArrayList<Int>()
    }
    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val n1 = st.nextToken().toInt()
        val n2 = st.nextToken().toInt()
        Main.list.get(n1).add(n2)
        Main.list.get(n2).add(n1)
    }

    //N-1까지의 모든 정점에서 DFS를 통해 확인
    for (i in 0 until N) {
        if (Main.ans == 0) Main.dfs(i, 1)
    }
    bw.write(Integer.toString(Main.ans))
    bw.flush()
    bw.close()
    br.close()
}

fun dfs(start: Int, depth: Int) {
    //System.out.println(start + " " + depth); //방문 정점과 깊이를 확인해보고 싶을 때 사용
    if (depth == 5) {
        Main.ans = 1
        return
    }
    Main.v.get(start) = true
    for (i in Main.list.get(start)) {
        if (!Main.v.get(i)) {
            Main.dfs(i, depth + 1)
        }
    }
    Main.v.get(start) = false
}
