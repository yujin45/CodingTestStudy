package org.example


// Next Permutation 알고리즘으로 모든 순열 구하지 않고, 바로 다음 순열 구하기
fun main() {
    val br = System.`in`.bufferedReader()
    val X = br.readLine().toCharArray()
    if (!nextPermutation(X)) {
        println(0) // 다음 순열 없으면 0 출력
    } else {
        println(X.joinToString("").toInt()) // 변환 후 출력하기
    }
    br.close()
}

fun nextPermutation(arr: CharArray): Boolean {
    val n = arr.size
    var i = n - 2 // [n-2] 마지막 전 , [n-1] 마지막 비교해서 감소 찾기 위함

    // 1. 뒤에서부터 처음으로 감소하는 위치 i 찾기
    while (i >= 0 && arr[i] >= arr[i + 1]) {
        i--
    }

    if (i < 0) return false // 감소 위치 없어서 이미 가장 큰 순열이면 false 반환

    // 2. i보다 크면서 가장 작은 숫자 j 찾기
    var j = n - 1
    while (arr[i] >= arr[j]) {
        j-- // 뒤에서부터 확인
    }

    // 3. swap
    arr[i] = arr[j].also { arr[j] = arr[i] }

    // 4. i 이후의 숫자들을 역순 정렬
    arr.reverse(i + 1, n)
    return true
}