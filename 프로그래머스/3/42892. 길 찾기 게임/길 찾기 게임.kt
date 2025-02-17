class Solution {
    data class Node(
        val index: Int, val x:Int, val y:Int,
        var left: Node?=null, var right:Node?=null)
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        // 노드 리스트 (index + 좌표 저장)
        val nodes = nodeinfo.mapIndexed{index, (x, y) -> Node(index+1, x, y)}
            .sortedWith(compareByDescending<Node>{it.y}.thenBy{it.x})
        // 루트 노드 생성
        val root = nodes[0]

        // 이진 트리 생성
        for(i in 1 until nodes.size){
            insertNode(root, nodes[i])
        }

        // 순회 결과 저장
        val preorderList = mutableListOf<Int>()
        val postorderList = mutableListOf<Int>()

        preorder(root, preorderList)
        postorder(root, postorderList)

        return arrayOf(preorderList.toIntArray(), postorderList.toIntArray())

    }

    // 이진 트리에 노드 삽입
    fun insertNode(parent:Node, child:Node){
        if(child.x < parent.x){
            // 왼쪽
            if(parent.left == null){
                parent.left = child
            }else{
                insertNode(parent.left!!, child)
            }
        }else{
            if(parent.right == null) parent.right = child
            else insertNode(parent.right!!, child)
        }
    }

    // 전위 순회
    fun preorder(node: Node?, result : MutableList<Int>){
        if(node ==null) return // 노드 더 없으면 리턴
        result.add(node.index)
        preorder(node.left, result) // 왼쪽 먼저 탐색
        preorder(node.right, result) // 이후 오른쪽
    }
    // 후위 순회
    fun postorder(node:Node?, result :MutableList<Int>){
        if(node == null) return
        postorder(node.left, result)
        postorder(node.right, result) 
        result.add(node.index)
    }

}

