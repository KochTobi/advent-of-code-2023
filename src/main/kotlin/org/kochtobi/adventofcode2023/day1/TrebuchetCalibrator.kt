package org.kochtobi.adventofcode2023.day1

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
class TrebuchetCalibrator {

    fun readInput(location: String): List<String> {
        val inputStream = this::class.java.getResourceAsStream(location)
        val lines = inputStream?.bufferedReader()?.readLines()
        return lines!!
    }

    enum class SpelledDigit(val index: Int, val string: String, val digit: Int) {

    }

    fun replaceLettersWithDigits(input: String): String {

        val idx1 = input.indexOf("one")
        val idx2 = input.indexOf("two")
        val idx3 = input.indexOf("three")
        val idx4 = input.indexOf("four")
        val idx5 = input.indexOf("five")
        val idx6 = input.indexOf("six")
        val idx7 = input.indexOf("seven")
        val idx8 = input.indexOf("eight")
        val idx9 = input.indexOf("nine")
        listOf(idx1,idx2,idx3,idx4,)

        return input.replace("one", "1")
            .replace("two", "2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9")
    }

    fun extractCalibration(input: String): Int {
        val isDigitPredicate = { character: Char -> character.isDigit() }
        val lastDigit = input.findLast(isDigitPredicate)
        val firstDigit = input.find(isDigitPredicate)
        return "$firstDigit$lastDigit".toInt()
    }

    fun run(part: Int = 2, location: String): List<Int> {
        return when (part) {
            1 -> {
                readInput(location).stream()
                    .map(this::extractCalibration)
                    .toList()
            }

            2 -> {
                readInput(location).stream()
                    .map(this::replaceLettersWithDigits)
                    .map(this::extractCalibration)
                    .toList()
            }

            else -> {
                listOf()
            }
        }
    }
}
