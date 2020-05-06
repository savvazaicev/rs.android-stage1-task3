package subtask4

import kotlin.math.absoluteValue
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 4) return null
        var array = ArrayList<Int>() as MutableList<Int>
        for (it in number - 1 downTo 1) {
            array.add(it)
            var diff = number * number - it * it
            var i = 1
            while (nearestQuad(diff) < array.last()) {
                array.add(nearestQuad(diff))
                diff -= array[i] * array[i]
                i++
            }

            if (diff == 0) {
                array.removeAt(array.lastIndex)
                return array.reversed().toTypedArray()
            } else {
                var j = findItemToChange(array)
                while (j != 0) {
                    array[j] -= 1
                    diff = number * number - array.take(j + 1).map { it2 -> it2 * it2 }.sum()
                    array = array.filterIndexed { index, it2 -> index <= j } as MutableList<Int>
                    if (diff < array.last() * array.last()) {
                        var arrayOfCoeffs = findCoeffs(diff)
                        array.addAll(arrayOfCoeffs)
                        if (array.last() == 0) {
                            array.remove(array.last())
                            return array.reversed().toTypedArray()
                        } else {
                            array.remove(array.last())
                        }
                    }
                    j = findItemToChange(array)
                }
            }
        }
        return array.reversed().toTypedArray()
    }

    private fun findItemToChange(array: MutableList<Int>) = array.indexOfLast { it > 2 }

    private fun findCoeffs(diff: Int): Collection<Int> {
        var resultDiff = diff
        val array = ArrayList<Int>()
        array.add(nearestQuad(resultDiff))
        resultDiff -= nearestQuad(resultDiff) * nearestQuad(resultDiff)
        while (!(2..3).contains(resultDiff) && resultDiff != 0 && nearestQuad(resultDiff) < array.last()) {
            array.add(nearestQuad(resultDiff))
            resultDiff -= nearestQuad(resultDiff) * nearestQuad(resultDiff)
        }
        array.add(resultDiff)
        return array
    }

    private fun nearestQuad(n: Int) = sqrt(n.toDouble()).absoluteValue.toInt()
}
