class Solution1 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        // 두 행렬의 같은 위치의 요소를 더해서 새로운 행렬을 생성
        return Array(arr1.size) { i ->  // 행의 크기만큼 반복
            IntArray(arr1[0].size) { j ->  // 열의 크기만큼 반복
                arr1[i][j] + arr2[i][j]  // 같은 위치에 있는 값들 더하기
            }
        }
    }
}


class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val resultList = mutableListOf<IntArray>() // 값을 담을 리스트

        // 행과 열을 반복하면서 값을 리스트에 추가
        for (i in arr1.indices) {
            val rowList = mutableListOf<Int>() // 각 행에 대한 리스트
            for (j in arr1[i].indices) {
                rowList.add(arr1[i][j] + arr2[i][j]) // 같은 위치의 값 더하기
            }
            resultList.add(rowList.toIntArray()) // 행을 배열로 변환하여 추가
        }

        // 리스트를 배열로 변환
        return resultList.toTypedArray()
    }
}
