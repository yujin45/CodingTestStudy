package org.example

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val t = br.readLine().toInt()
    val inputNums = IntArray(t)
    for (i in inputNums.indices) {
        inputNums[i] = br.readLine().toInt()
    }

    var n = 1
    var ret = 0
    val nums = ArrayList<Int>()

    while (true) {
        ret = n * (n + 1) / 2
        if (ret > 1000) {
            break
        }
        nums.add(ret)
        n++
    }

    for (input in inputNums) {
        sb.append("${check(input, nums)}\n")
    }

    print(sb)
    br.close()
}

fun check(k: Int, nums: ArrayList<Int>): Int {

    for (i in nums) {
        for (j in nums) {
            for (h in nums) {
                if ((i + j + h) == k) {
                    return 1
                }
            }
        }
    }

    return 0
}
