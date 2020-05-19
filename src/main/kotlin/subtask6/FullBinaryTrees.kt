package subtask6

import kotlin.collections.ArrayList

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) return "[]"
        if (count == 1) return "[[0]]"
        val tail = ",null,null]"
        val strArray = ArrayList<String>()
        createFBT("[0,0,0", count - 3, strArray)
        return strArray.map { it.replace(tail, "]").replace(tail, "]") }.distinct().toString()
    }

    private fun createFBT(start: String, numOfFreeNodes: Int, strArray: ArrayList<String>) {
        if (numOfFreeNodes >= 2) {
            createFBT("$start,0,0,null,null", numOfFreeNodes - 2, strArray)
            createFBT("$start,null,null,0,0", numOfFreeNodes - 2, strArray)
            if (numOfFreeNodes >= 4) {
                createFBT("$start,0,0,0,0,null,null,null,null", numOfFreeNodes - 4, strArray)
                createFBT("$start,0,0,0,0", numOfFreeNodes - 4, strArray)
            }
        } else strArray.add("$start]")
    }
}
