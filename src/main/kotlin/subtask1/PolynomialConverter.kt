package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        return numbers.mapIndexed { i, it ->
            when {
                it == 0 -> 0
                i == numbers.size - 1 -> "$it"
                i == numbers.size - 2 -> "${when {
                    it != 1 && it != -1 -> it
                    it == -1 -> "-"
                    else -> ""
                }}x"
                it != 0 -> "${it}x^${numbers.size - i - 1}"
                else -> 0
            }
        }.filter { it != 0 }.map { it.toString() }.mapIndexed { i, it ->
            when {
                i == 0 -> it
                it.contains('-') -> " - ${it.removePrefix("-")}"
                else -> " + $it"
            }
        }.joinToString("")
    }
}
