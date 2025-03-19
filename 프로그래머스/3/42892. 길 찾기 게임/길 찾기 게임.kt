class Solution {
    data class Node(
    val index:Int, val x:Int, val y:Int,
    var left:Node? =null, var right:Node? = null)
    
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val nodes = nodeinfo.mapIndexed{index, (x, y)-> Node(index+1, x, y)}.sortedWith(compareByDescending<Node>{it.y}.thenBy{it.x})
        
        val root = nodes[0]
        val nodeMap = mutableMapOf(root.x to root)
        
        // 이진트리 생성(빠른 탐색을 위해 map활용)
        for(i in 1 until nodes.size){
            insertNode(root, nodes[i], nodeMap)
        }
         val preorderList = mutableListOf<Int>()
        val postorderList = mutableListOf<Int>()

        preorder(root, preorderList)
        postorder(root, postorderList)

        return arrayOf(preorderList.toIntArray(), postorderList.toIntArray())
    }
    
    
    fun insertNode(parent:Node, child:Node, nodeMap:MutableMap<Int, Node>){
        var current:Node? = parent
        
        while(current != null){
            if(child.x < current.x){
                if(current.left ==null){
                    current.left = child
                    break
                }
                current = current.left
            }else{
                if(current.right==null){
                    current.right = child
                    break
                }
                current = current.right
            }
        }
        nodeMap[child.x] = child
    }
    
    fun preorder(node: Node?, result: MutableList<Int>) {
        if (node == null) return
        result.add(node.index)
        preorder(node.left, result)
        preorder(node.right, result)
    }

    fun postorder(node: Node?, result: MutableList<Int>) {
        if (node == null) return
        postorder(node.left, result)
        postorder(node.right, result)
        result.add(node.index)
    }
}