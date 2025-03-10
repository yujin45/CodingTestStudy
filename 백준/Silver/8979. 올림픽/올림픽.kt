package org.example

import java.util.StringTokenizer

data class Country(val countryNum: Int, val gold: Int, val silver: Int, val bronze: Int, var ranking: Int) {
    fun printCountry() {
        println("|국가 | $countryNum | 금 | $gold | 은 | $silver | 동 | $bronze | 순위 | $ranking|")
        println("-------------------------------------------------------------------------")
    }
}

fun main() {
    val br = System.`in`.bufferedReader()

    val (N, K) = br.readLine().split(" ").map { it.toInt() } // 국가 수 N, 등수 알고 싶은 국가 k
    // 각 국가 1~N
    // N줄 차례대로 국가 나타내는 정수
    val countries = Array(N) {
        val st = StringTokenizer(br.readLine())
        // 국가, 금, 은, 동 숫자
        Country(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), -1)
    }
//
//    countries.forEach {
//        it.printCountry()
//    }
//
//    println("\n\n 정렬 후 ********************************************************")

    countries.sortWith(compareByDescending<Country> { it.gold }
        .thenByDescending { it.silver }
        .thenByDescending { it.bronze })

//    countries.forEach {
//        it.printCountry()
//    }
//    println("\n\n 순위 측정 ********************************************************")

    var rank = 1
    var same = 1
    countries[0].ranking = rank // 1위
    if (countries[0].countryNum == K) {
        println(rank)
    } else {
        for (i in 1 until N) {
            // 이전과 비교
            if ((countries[i - 1].gold == countries[i].gold) &&
                (countries[i - 1].silver == countries[i].silver) &&
                (countries[i - 1].bronze == countries[i].bronze)
            ) {
                // 금은동 모두 같으면 동일 순위
                countries[i].ranking = rank
                same++ // 동순위 추가
            } else {
                // 이전과 다른 순위면
                rank += same // 동순위 다음 순위 받고
                same = 1 // 동순위 초기화
                countries[i].ranking = rank
            }
            if (countries[i].countryNum == K) {
                println(rank)
                break
            }

        }
    }


//    countries.forEach {
//        it.printCountry()
//    }

    // println("입력받은 국가 K의 등수를 하나의 정수로 출력")
    br.close()
}