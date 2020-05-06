package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) return "[]"
        if (count == 1) return "[[0]]"
        var resultString = ""
        var arrayOfTriangles = ArrayList<Triangle>()
        arrayOfTriangles.add(Triangle(null, null))
        val numOfTriangles = (count - 1) / 2
        (1 until numOfTriangles).forEach {
            val triangle = Triangle(null, null)
            arrayOfTriangles.add(triangle)
            arrayOfTriangles[it - 1].secondPlace = triangle
        }
        resultString = saveBranch(arrayOfTriangles)
        for (i in numOfTriangles - 1 downTo 1) { //2. 1
            for (it in numOfTriangles - 2 downTo 0) { //1, 0
                if (i != it) {
                    for (j in 0..numOfTriangles - 1 - i) {
                        arrayOfTriangles[it + j].firstPlace = arrayOfTriangles[j]
                        arrayOfTriangles[i - 1 + j].secondPlace = null
                        resultString += ", " + saveBranch(arrayOfTriangles)
                        if (j == numOfTriangles - 1 - i) {
                            arrayOfTriangles[i - 1 + j].secondPlace = arrayOfTriangles[j]
                            arrayOfTriangles[it + j].firstPlace = null
                        }
                    }
                }
            }
        }
        return "[${resultString.replace(",?", "").replace(",null,null]","]")}]"
    }

    private fun saveBranch(arrayOfTriangles: java.util.ArrayList<Triangle>) = arrayOfTriangles.joinToString(",", "[0,0,0,", "]") {
        when {
//            it.firstPlace == null && it.secondPlace == null -> "0,0"
            it.firstPlace != null && it.secondPlace != null -> "0,0,0,0"
            it.firstPlace != null && it.secondPlace == null-> "0,0,null,null"
            it.secondPlace != null && it.firstPlace == null -> "null,null,0,0"
            else -> "?"
        }
    }

    private class Triangle(
        var firstPlace: Triangle?,
        var secondPlace: Triangle?
    )
}
