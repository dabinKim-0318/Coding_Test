package com.ummaaack.coding_test.dongbin

import kotlin.math.max


private fun bubbleSort(list: IntArray) {
    val dd = mutableListOf(2, 4)
    dd.removeLast()
    repeat(list.size) {
        for (index in 0 until list.size - 1) {
            if (list[index] > list[index + 1]) {
                swap(index, index + 1, list)
            }
        }
    }
}

fun InsertSort() {
    var array = arrayOf(5, 8, 12, 32, 1, 9, 2, 4) //9개

    for (i in 1 until array.size) {
        var index = i //1 2 3 4 5 6 7 8
        var temp = array[i] //array[1]->8 , array[2]->5
        while (index > 0 && array[index - 1] > temp) { //내 바로 이전에 있는 원소가 나보다 크면
            array[index] = array[index - 1] //내 자리에 그 값을 넣고 8 32 32 12 1
            index-- //인덱스 하나 줄임
        }
        array[index] = temp //하나줄인 인덱스에 저장해두었던 내 값을 넣는다 ->자리를 바꿔야하니까
    }

    for (i in array.indices) {
        println(array[i])
    }
}

private fun insertSort() {
    val arr = intArrayOf(4, 2, 3, 5, 2, 4, 35)

    for (i in 1 until arr.size) {
        var index = i
        val temp = arr[i]
        while (index < 0 && arr[index - 1] > temp) {
            arr[index] = arr[index - 1]
            index--
        }
        arr[index] = temp
    }
}

private fun binarySearch(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.size - 1
    while (start <= end) {
        val mid = (start + end) / 2
        if (arr[mid] == target) {
            return mid
        } else if (arr[mid] > target) end = mid - 1
        else start = mid + 1
    }
    return -1
}

private fun swap(index: Int, minIndex: Int, list: IntArray) {
    val tempItem = list[index]
    list[index] = list[minIndex]
    list[minIndex] = tempItem
    var str = "fdfd".split(" ")
    val dd = listOf(2, 3, 4)

}

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    //모두 소문자로 바꾼다
    var lowerStr = paragraph.toLowerCase()
    var lowerStrList = listOf<String>()
    var distinctStr = listOf<String>()
    var countList = mutableListOf<Int>()

    //구두점을 replace로 제거하고 공백기준으로 자른다
    lowerStr = lowerStr.replace(".", "").replace(",", "")
    if (banned.isNotEmpty()) {
        lowerStr = lowerStr.replace(banned[0] + " ", "")
    }
    lowerStrList = lowerStr.split(" ") //List<String>

    //distinct로 유니크 배열을 만든다
    distinctStr = lowerStrList.distinct()
    //중복 값 저장
    distinctStr.forEach { it ->
        countList.add(lowerStrList.count { i -> i == it })
    }
    //가장 큰 원소의 인덱스값을 찾는다
    var index = 0
    var max = 0
    for (i in 0 until countList.size) {
        if (countList[i] > max) {
            max = countList[i]
            index = i
        }
    }

    //유니크 배열에서 인덱스에 해당하는 값을 리턴한다
    return lowerStrList[index]
}

// intArrayOf(3 7 8 1 5 9 6 10 2 4 ) 0 8
fun quickSort(arr: IntArray, left: Int = 0, right: Int = arr.size - 1) {
    if (left >= right) return //0>=8 이 false이므로 진행

    val pivot = partition(arr, left, right)

    quickSort(arr, left, pivot - 1)
    quickSort(arr, pivot + 1, right)
}

//배열, 0, 8
fun partition(arr: IntArray, left: Int, right: Int): Int {
    var low = left + 1 //1
    var high = right //8 ->배열 사이즈-1
    val pivot = arr[left] //arr[0]이므로 5가 피벗

    //1<=8  =>인덱스를 하나씩 늘리고 줄이면서 탐색
    while (low <= high) {
        while (arr[low] <= pivot && low < high) low++ //엇갈리지 않았고 피벗보다 작은 값을 찾았다
        while (arr[high] > pivot && low <= high) high-- //엇갈리지 않았고 피벗보다 큰 값을 찾았다

        if (low < high) //조건에 만족하는 원소 2개 찾았으니
            swap(arr, low, high) //스왑한다
        else //조건에 만족하지 않으면 반복문 탈출
            break
    }

    swap(arr, left, high) //조건에 만족하지 않는다=엇갈린다=피벗과 high값(작은값 찾는 인덱스)을 교환해야한다

    return high //자리를 바꾼후 hi
}

fun swap(arr: IntArray, i: Int, j: Int) {
    var temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun mergeSort(data: MutableList<Int>, start: Int, end: Int) {
    if (start >= end) return

    val mid = (start + end) / 2  // 반으로 쪼갬
    mergeSort(data, start, mid)
    mergeSort(data, mid + 1, end)

    merge(data, start, mid, end)  // 분할된 두 리스트을 하나로 정렬하며 합침
}

fun merge(data: MutableList<Int>, start: Int, mid: Int, end: Int) {
    val sortedList = mutableListOf<Int>()  // 정렬된 새로운 리스트
    var indexA = start  // 왼쪽 배열 인덱스
    var indexB = mid + 1  // 오른쪽 배열 인덱스

    while (indexA <= mid && indexB <= end) {  // 두 리스트 중 하나라도 모두 소진되면 종료
        // 둘 중 최솟값을 새로운 리스트에 담아주는 작업
        if (data[indexA] <= data[indexB]) {
            sortedList.add(data[indexA])
            indexA++
        } else {
            sortedList.add(data[indexB])
            indexB++
        }
    }

    if (indexA > mid) {  // 오른쪽 배열 원소가 아직 남았다면
        for (i in indexB..end) {
            sortedList.add(data[i])
        }
    }

    if (indexB > end) {  // 왼쪽 배열 원소가 아직 남았다면
        for (i in indexA..mid) {
            sortedList.add(data[i])
        }
    }

    for (x in sortedList.indices) {  // 정렬된 부분 대입
        data[start + x] = sortedList[x]
    }
}

private var pickedNum = mutableListOf<Int>()
private var flag = false

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        //조합 실행
        combination(nums, target, 0, 2, 0)

        //pickedNum IntArray타입으로 출력
        return pickedNum.map { nums.indexOf(it) }.toIntArray()
    }
}

private fun combination(nums: IntArray, target: Int, cnt: Int, depth: Int, beginWith: Int) {

    //pickedNum의 합이 target이 되면 flag변경
    if (cnt == depth) {
        if (pickedNum.sum() == target) {
            flag = true
            return
        }
        return
    }

    for (index in beginWith until nums.size) {
        pickedNum.add(nums[index])
        combination(nums, target, cnt + 1, depth, index + 1)
        if (flag) return
        pickedNum.removeLast()
    }
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    // 초기화
    val numMap: HashMap<Int, Int> = HashMap() //
    for (idx in nums.indices) {
        numMap[nums[idx]] = idx
    }
    val answer = IntArray(2)
    for (idx in nums.indices) {
        val remain = target - nums[idx]
        if (numMap.containsKey(remain) && numMap[remain] !== idx) {
            answer[0] = idx
            answer[1] = numMap[remain]!!
            break
        }
    }
    return answer
}


fun threeSum(nums: IntArray): List<List<Int>> {
    val length = nums.size
    val nums = nums.sorted()
    val answer: MutableList<List<Int>> = ArrayList()
    for (idx in 0 until length - 2) {

        // 중복 제거 = 같으면 반복문 안돌고 컨티뉴
        if (0 < idx && nums[idx - 1] == nums[idx]) continue

        var left = idx + 1
        var right = length - 1

        while (left < right) {
            val sum = nums[idx] + nums[left] + nums[right]
            if (sum > 0) {
                right--
            } else if (sum < 0) {
                left++
            } else {
                answer.add(java.util.List.of(nums[idx], nums[left], nums[right]))
                // 중복 제거
                while (left < right && nums[left] == nums[left + 1]) left++
                while (left < right && nums[right] == nums[right - 1]) right--
                right--
                left++
            }
        }
    }
    return answer
}

fun productExceptSelf(nums: IntArray): IntArray? {
    val length = nums.size
    val answer = IntArray(length)

    // 왼쪽부터
    var temp = 1
    for (idx in 0 until length) {
        answer[idx] = temp
        temp *= nums[idx]
    }
    temp = 1
    for (idx in length - 1 downTo 0) {
        answer[idx] *= temp
        temp *= nums[idx]
    }
    return answer
}

fun maxProfiㅇt(prices: IntArray): Int {
    var maxPrice = 0
    for (i in 0 until prices.size - 1) {
        for (j in i until prices.size) {
            val item = prices[j] - prices[i]
            maxPrice = max(item, maxPrice)
        }
    }
    return maxPrice
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0  //7 5 3 4 1
    var minPrice = Int.MAX_VALUE
    //반복문을 한번 돌때 최소값 갱신하기 더불어 지금 price랑 갱신한 최소값
    for (price in prices) {
        minPrice = Math.min(price, minPrice) //제일 작은 값으로 항상 갱신
        profit = Math.max(price - minPrice, profit)  //지금=price에서 제일 작은 값 빼면 제일 큰가? 기존 이익보다 큰가? 확인
    }
    return profit
}

fun main() {
    println(maxProfit(intArrayOf(7, 5, 3, 4, 10)))
}