package org.example

import java.util.StringTokenizer
import kotlin.math.abs

data class Node(
    val value: Char,
    var left: Node? = null,
    var right: Node? = null,
)

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    val tree = hashMapOf<Char, Node>() // value별로 node 만들어둔 것
    repeat(N) {
        val st = StringTokenizer(br.readLine())
        val parent = st.nextToken()[0]
        val left = st.nextToken()[0]
        val right = st.nextToken()[0]

        val parentNode = tree.getOrPut(parent) { Node(parent) }
        if (left != '.') {
            parentNode.left = tree.getOrPut(left) { Node(left) }
        }
        if (right != '.') {
            parentNode.right = tree.getOrPut(right) { Node(right) }
        }
    }

    val root = tree['A']!! // 문제 조건
    val sb = StringBuilder()
    preorder(root, sb)
    sb.append("\n")
    inorder(root, sb)
    sb.append("\n")
    postorder(root, sb)
    sb.append("\n")
    print(sb)
    br.close()
}

fun preorder(node: Node?, sb: StringBuilder) {
    if (node == null) return
    sb.append(node.value)
    preorder(node.left, sb)
    preorder(node.right, sb)
}

fun inorder(node: Node?, sb: StringBuilder) {
    if (node == null) return
    inorder(node.left, sb)
    sb.append(node.value)
    inorder(node.right, sb)
}

fun postorder(node: Node?, sb: StringBuilder) {
    if (node == null) return
    postorder(node.left, sb)
    postorder(node.right, sb)
    sb.append(node.value)
}
