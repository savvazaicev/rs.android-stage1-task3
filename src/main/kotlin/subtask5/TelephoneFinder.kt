package subtask5

import kotlin.reflect.KClass
import java.lang.StringBuilder

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.first() == '-') return null
        val array = ArrayList<String>()
        var str = StringBuilder(number)
        number.forEachIndexed { i, it ->
            when (it) {
                '0' -> array.add(str.replace(i, i + 1, "8").toString())
                '1' -> {
                    array.add(str.replace(i, i + 1, "2").toString())
                    array.add(str.replace(i, i + 1, "4").toString())
                }
                '2' -> {
                    array.add(str.replace(i, i + 1, "1").toString())
                    array.add(str.replace(i, i + 1, "3").toString())
                    array.add(str.replace(i, i + 1, "5").toString())
                }
                '3' -> {
                    array.add(str.replace(i, i + 1, "2").toString())
                    array.add(str.replace(i, i + 1, "6").toString())
                }
                '4' -> {
                    array.add(str.replace(i, i + 1, "1").toString())
                    array.add(str.replace(i, i + 1, "5").toString())
                    array.add(str.replace(i, i + 1, "7").toString())
                }
                '5' -> {
                    array.add(str.replace(i, i + 1, "2").toString())
                    array.add(str.replace(i, i + 1, "4").toString())
                    array.add(str.replace(i, i + 1, "6").toString())
                    array.add(str.replace(i, i + 1, "8").toString())
                }
                '6' -> {
                    array.add(str.replace(i, i + 1, "3").toString())
                    array.add(str.replace(i, i + 1, "5").toString())
                    array.add(str.replace(i, i + 1, "9").toString())
                }
                '7' -> {
                    array.add(str.replace(i, i + 1, "4").toString())
                    array.add(str.replace(i, i + 1, "8").toString())
                }
                '8' -> {
                    array.add(str.replace(i, i + 1, "0").toString())
                    array.add(str.replace(i, i + 1, "5").toString())
                    array.add(str.replace(i, i + 1, "7").toString())
                    array.add(str.replace(i, i + 1, "9").toString())
                }
                '9' -> {
                    array.add(str.replace(i, i + 1, "6").toString())
                    array.add(str.replace(i, i + 1, "8").toString())
                }
            }
            str = StringBuilder(number)
        }
        return array.toTypedArray()
    }
}
