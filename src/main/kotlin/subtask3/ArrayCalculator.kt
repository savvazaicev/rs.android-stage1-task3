package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var array = itemsFromArray.filter { it::class == Int::class } as MutableList<Int>
        var maxProduct = Int.MIN_VALUE
        with(array) {
            if (isEmpty()) return 0
            if (numberOfItems >= size) return fold(1) { acc, it -> acc * it }
            sortBy { it.absoluteValue }
            array = asReversed()
            for (i in 0..size - numberOfItems) {
                val halfProd = filterIndexed { index, _ -> index >= i && index <= i + numberOfItems - 2 }
                    .fold(1) { acc, it -> acc * it }
                for (j in i + numberOfItems - 1 until size) {
                    val prod = halfProd * get(j)
                    if (prod > maxProduct) maxProduct = prod
                }
            }
        }
        return maxProduct
    }
}
