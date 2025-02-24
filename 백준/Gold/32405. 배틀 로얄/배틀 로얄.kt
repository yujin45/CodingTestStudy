package org.example

import java.util.StringTokenizer

data class Player(val id: Int, val atk: Int, val hp: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val stD = StringTokenizer(br.readLine())
    val stH = StringTokenizer(br.readLine())

    var players = mutableListOf<Player>()

    for (i in 1..N) {
        players.add(Player(i, stD.nextToken().toInt(), stH.nextToken().toInt()))
    }
    //
    var atkSum = 0
    var loop = 0

    while (players.size > 1) {
        players = players.filter { player ->
            if (player.hp > atkSum - player.atk * loop) {
                atkSum += player.atk
                true
            } else false
        }.toMutableList()
        loop++
    }

    println(players[0].id)
    br.close()
}


