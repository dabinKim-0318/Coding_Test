package com.ummaaack.coding_test.baekjoon_step

import java.util.*
import kotlin.math.max

val graph:Array<IntArray> = Array(250){IntArray(250){0}}
var n=0
var m=0
var answer=0

fun main(){
    val nm=readLine()!!.split(" ").map{it.toInt()}
    n=nm[0]
    m=nm[1]

    for(i in 0 until n){
        val list=readLine()!!.split(" ").map{it.toInt()}
        for(j in 0 until m){
            graph[i][j]=list[j]
        }
    }

    for(i in 0 until n){
        for(j in 0 until m){
            if(dfs(i,j)) answer++
        }
    }

    println(answer)
}

fun dfs(x:Int,y:Int):Boolean{
    if(x<0||x>=n||y<0||y>=m) return false

    if(graph[x][y]==1){
        graph[x][y]=0

        dfs(x+1,y)
        dfs(x-1,y)
        dfs(x,y+1)
        dfs(x,y-1)

        dfs(x-1,y+1)
        dfs(x+1,y+1)
        dfs(x-1,y-1)
        dfs(x+1,y-1)

        return true
    }

    return false

}