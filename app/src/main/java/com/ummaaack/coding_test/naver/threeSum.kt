package com.ummaaack.coding_test.naver

import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.math.max
import kotlin.math.min

//-4 -1 -1 0 1 2

fun threeSort(arr: IntArray): List<List<Int>> {
    var arr = arr.sorted()
    var ans = mutableListOf<List<Int>>() //조건 만족하는 인덱스 값 담아서 리턴
    var length = arr.size

    for (index in 0 until length - 2) {
        if (index < 0 && arr[index] == arr[index - 1]) continue

        var left = index + 1
        var right = length - 1
        var sum = arr[index] + arr[left] + arr[right]

        while (left < right) {

            if (sum < 0) {
                left++
            } else if (sum > 0) {
                right--
            } else {
                ans.add(listOf(arr[index], arr[left], arr[right]))
                while (left < right && arr[left] == arr[left + 1]) left++
                while (left < right && arr[right] == arr[right - 1]) right--
                left++
                right--
            }
        }
    }
    return ans
}

fun maxProfit(prices: IntArray): Int {
    var minPrice = Integer.MAX_VALUE
    var profit = 0

    for (price in prices) {
        minPrice = min(minPrice, price)
        profit = max(profit, price - minPrice)
    }

    return profit
}

fun reverseString(str: String): String {
    var sb = StringBuilder("")
    for (i in str.length - 1 downTo 0) {
        sb.append(str[i])
    }
    return sb.toString()
}

fun queueTest() {
    val queue: Deque<Int> = LinkedList()
    val stack = Stack<Int>()
    queue.removeFirst()
}

class Stack<E> {
    private var stack = ArrayList<E>()

    fun push(item: E) {
        stack.add(item)
    }

    fun pop(): E? {
        if (stack.size == 0) return null
        val lastIndex = stack.size - 1
        val item = stack[lastIndex]
        stack.removeAt(lastIndex)
        return item
    }

    fun peek(): E {
        return stack[stack.size - 1]
    }

    fun size(): Int {
        return stack.size
    }
}

class Queue<E> {
    private val enQueueStack = Stack<E>()
    private val deQueueStack = Stack<E>()

    fun enqueue(item: E) {
        enQueueStack.push(item)
    }

    fun dequeue(): E? {
        if (deQueueStack.size() == 0) {
            while (enQueueStack.peek() != null) {
                deQueueStack.push(enQueueStack.pop()!!)
            }
        }
        return deQueueStack.pop()
    }
}

fun stackL(): Int {
    val enQueueStack = java.util.Stack<Int>()
    val deQueueStack = java.util.Stack<Int>()

    //1 2 3 4 5 ->1을 반환
    enQueueStack.push(1)
    enQueueStack.push(2)
    enQueueStack.push(3)
    enQueueStack.push(4)
    enQueueStack.push(5)


    while (enQueueStack.isNotEmpty()) {
        deQueueStack.add(enQueueStack.pop())
    }
    return deQueueStack.pop()
}

fun isValid(s: String): Boolean {
    val stack = java.util.Stack<Char>()
    for (i in s) {
        stack.add(i)
        if (stack.size > 1) {
            when (stack.pop()) {
                ')' -> {
                    if (stack.peek() == '(')
                        stack.pop()
                    continue
                }
                ']' -> {
                    if (stack.peek() == '[')
                        stack.pop()
                    continue
                }
                '}' -> {
                    if (stack.peek() == '{')
                        stack.pop()
                    continue
                }
            }
            println(stack)
        }
    }
    println(stack)
    return stack.isEmpty()
}

fun isVaild(s: String): Boolean {
    val bucket =
        mutableMapOf<Char, Char>() //LinkedHashMap을 반환하므로 넣은 순서대로 출력하고 HashMap처럼 멀티 스레드에선 안전하지 않음
    val stack = java.util.Stack<Char>()
    bucket['['] = ']'
    bucket['{'] = '}'
    bucket['('] = ')'
    println(bucket)

    for (item in s) {
        if (bucket.containsKey(item)) {
            stack.push(item)
        } else if (stack.isNotEmpty() && bucket[stack.peek()] == item) {
            stack.pop()
        } else return false
    }
    return stack.isEmpty()
}

fun removeDuplicateLetters(s: String): String {
    return s.toCharArray().distinct().reversed().joinToString("")
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val ans = mutableListOf<Int>()
    for (i in 0 until temperatures.size - 1) {
        var count = 0
        for (j in i + 1 until temperatures.size) {
            if (temperatures[j] - temperatures[i] > 0) {
                ans.add(j - i)
                break
            } else {
                count++
            }
        }
    }

    return ans.toIntArray()
}

/*
[1, 2, 3, 4, 5, 7]
[2, 3, 4, 5, 7, 1]
[3, 4, 5, 7, 1, 2]
[4, 5, 7, 1, 2, 3]
[5, 7, 1, 2, 3, 4]
[7, 1, 2, 3, 4, 5]
마지막으로 넣은 값 직전까지 원소들 remove, add로 다시 넣고 빼고
*/
class MyStack {
    val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.add(x)
        for (i in 0 until queue.size - 1) {
            queue.add(queue.remove())
        }
    }

    fun pop(): Int {
        return queue.pop()
    }
}

fun quickSort(arr: IntArray, left: Int = 0, right: Int = arr.size - 1) {
    if (left >= right) return

    val pivot = partition(arr, left, right)
    quickSort(arr, left, pivot - 1)
    quickSort(arr, pivot + 1, right)
}

fun partition(arr: IntArray, left: Int, right: Int): Int {
    var low = left + 1
    var high = right
    val pivot = arr[left]

    while (low <= high) {
        while (arr[low] <= pivot && low < high) low++
        while (arr[high] > pivot && low >= high) high--

        if (low < high) swap(arr, low, high)
        else break
    }
    swap(arr, left, high)
    return high
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun mergeSort(data: MutableList<Int>, start: Int = 0, end: Int = data.size - 1) {
    if (start >= end) return

    val mid = (start + end) / 2
    mergeSort(data, start, mid)
    mergeSort(data, mid + 1, end)

    merge(data, start, mid, end)
    println(data)
}

fun merge(data: MutableList<Int>, start: Int, mid: Int, end: Int) {
    val sortedList = mutableListOf<Int>()
    var indexA = start
    var indexB = mid + 1

    while (indexA <= mid && indexB <= end) {
        if (data[indexA] <= data[indexB]) {
            sortedList.add(data[indexA])
            indexA++
        } else {
            sortedList.add(data[indexB])
            indexB++
        }
    }

    val g = mutableListOf<Int>()
    val dd = arrayListOf<Int>()
    if (indexA > mid) {
        for (i in indexB..end) {
            sortedList.add(data[i])
        }
    }
    if (indexB > end) {
        for (i in indexA..mid) {
            sortedList.add(data[i])
        }
    }
    for (x in sortedList.indices) {
        data[start + x] = sortedList[x]
    }
}

class me(i: Int) {}

fun main() {

    val hashSet=HashSet<me>()
    hashSet.add(me(1))
    hashSet.add(me(1))
    hashSet.add(me(1))
    hashSet.add(me(1))
    hashSet.contains(me(1))
    println(if())
}