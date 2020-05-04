package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var numOfColors = 1
        var result = -1L
        while (result != array[0].toLong()) {
            if (numOfColors > array[1]) return null
            if (array[1] != numOfColors) {
                result = fact(array[1]) / fact(array[1] - numOfColors) / fact(numOfColors)
            }
            numOfColors++
        }
        return numOfColors - 1
    }

    fun fact(num: Int) = (1L..num.toLong()).fold(1L) { acc, it -> acc * it }
}
