package com.ummaaack.coding_test.dongbin.dfs

import java.util.*

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

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt()
        m = sc.nextInt()
        sc.nextLine() // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (i in 0 until n) {
            val str: String = sc.nextLine()
            for (j in 0 until m) {
                graph[i][j] = str[j] - '0'
            }
        }

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