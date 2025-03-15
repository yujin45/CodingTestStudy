package org.example

import java.util.StringTokenizer
import kotlin.math.roundToInt


fun main() {
    val br = System.`in`.bufferedReader()
    // inorder

    // 상근이가 순서 주어졌을 때 각 레벨에 있는 빌딩 번호 구하기

    val K = br.readLine().toDouble()
    val st = StringTokenizer(br.readLine())
    val arr = IntArray((Math.pow(2.0, K).toInt() - 1))
    for (i in 0 until arr.size) {
        arr[i] = st.nextToken().toInt()
    }

    //println(arr.contentToString())
    val depthArray = Array(K.toInt()) { mutableListOf<Int>() }
    search(K.toInt(), 0, arr.size - 1, 0, depthArray, arr)
    //println(depthArray.contentDeepToString())
    val sb = StringBuilder()
    depthArray.forEach { item ->
        item.forEach { node ->
            sb.append(node).append(" ")
        }
        sb.deleteCharAt(sb.length - 1).append("\n")
    }
    print(sb)
    br.close()
}

fun search(k: Int, start: Int, end: Int, depth: Int, depthArray: Array<MutableList<Int>>, arr: IntArray) {
    if (depth == k) {
        //println("k도달--------------")
        return
    }
    val mid = (start + end) / 2
    depthArray[depth].add(arr[mid])
    //println("start $start  - end $end  /2 -> mid $mid")
    search(k, start, mid - 1, depth + 1, depthArray, arr) // 왼쪽
    search(k, mid + 1, end, depth + 1, depthArray, arr) // 오른쪽
}