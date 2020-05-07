package subtask6

import java.util.*
import kotlin.collections.ArrayList

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) return "[]"
        if (count == 1) return "[[0]]"
        var resultArray = ArrayList<String>()
        var arrayOfTriangles = ArrayList<Triangle>()
        arrayOfTriangles.add(Triangle(null, null))
        var numOfTriangles = (count - 1) / 2
        if (count == 9) numOfTriangles = 3
        (1 until numOfTriangles).forEach {
            val triangle = Triangle(null, null)
            arrayOfTriangles.add(triangle)
            arrayOfTriangles[it - 1].secondPlace = triangle
        }
        resultArray.add(saveBranch(arrayOfTriangles))
        for (i in numOfTriangles - 1 downTo 1) { //3, 2. 1
            for (it in numOfTriangles - 2 downTo 0) { //2, 1, 0
                if (i != it) {
                    for (j in 0..numOfTriangles - 1 - i) {
                        if (it + j != 4) {
                            arrayOfTriangles[it + j].firstPlace = arrayOfTriangles[j]
                            arrayOfTriangles[i - 1 + j].secondPlace = null
                            resultArray.add(saveBranch(arrayOfTriangles))
                            if (j == numOfTriangles - 1 - i) {
                                arrayOfTriangles[i - 1 + j].secondPlace = arrayOfTriangles[j]
                                arrayOfTriangles[it + j].firstPlace = null
                            }
                        }
                    }
                }
            }
        }
        if ((count - 1) / 2 == 4) {
            var newResultArray = ArrayList<String>()
            newResultArray.addAll(resultArray.map { "${it.take(count - 2)}null,null,0,0,${it.drop(count - 2)}" })
            newResultArray.addAll(resultArray.map { "${it.take(count - 2)}0,0,null,null,${it.drop(count - 2)}" })
            var centerBranch = ArrayList<Int>(Collections.nCopies(count, 0)).joinToString(",", "[", "]")
            newResultArray.add(centerBranch)
            var index = count * 2 - numOfTriangles
            repeat(numOfTriangles){
                centerBranch = "${centerBranch.take(index)}null,null,${centerBranch.drop(index)}"
                newResultArray.add(centerBranch)
            }
            resultArray = newResultArray
        }
        return resultArray.map {
            it.replace(",?", "")
                .replace(",null,null]", "]")
        }.toString()
    }

    private fun saveBranch(arrayOfTriangles: java.util.ArrayList<Triangle>) = arrayOfTriangles.joinToString(",", "[0,0,0,", "]") {
        when {
//            it.firstPlace == null && it.secondPlace == null -> "0,0"
            it.firstPlace != null && it.secondPlace != null -> "0,0,0,0"
            it.firstPlace != null && it.secondPlace == null -> "0,0,null,null"
            it.secondPlace != null && it.firstPlace == null -> "null,null,0,0"
            else -> "?"
        }
    }

    private class Triangle(
        var firstPlace: Triangle?,
        var secondPlace: Triangle?
    )
}
