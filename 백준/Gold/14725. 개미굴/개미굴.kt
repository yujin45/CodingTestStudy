package org.example

import java.util.StringTokenizer

// Trie 노드 클래스, 정렬 유지
class TrieNode {
    val children = sortedMapOf<String, TrieNode>()
}

// 트라이 자료 구조
class Trie {
    //루트는 비워두기
    private val root = TrieNode()

    // 트라이로 먹이 경로 삽입
    fun insert(path: List<String>) {
        var node = root
        for (food in path) {
            node = node.children.computeIfAbsent(food) { TrieNode() }
        }
    }

    // 트라이 DFS 탐색하며 개미굴 형식으로 출력
    fun printTrie() {
        fun dfs(node: TrieNode, depth: Int) {
            for ((key, child) in node.children) {
                println("--".repeat(depth) + key)
                dfs(child, depth + 1)
            }
        }
        dfs(root, 0)
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val trie = Trie()

    repeat(N) {
        val path = br.readLine().split(" ").drop(1)//첫번째 숫자 제외
        trie.insert(path)
    }

    trie.printTrie()
    br.close()
}

