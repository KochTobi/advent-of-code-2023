package org.kochtobi.adventofcode2023.day1

class TrebuchetCalibrator {
    val onlyDigits = "\\d".toRegex()
    val spelledOutDigits = "one|two|three|four|five|six|seven|eight|nine|\\d".toRegex()
    val spelledOutDigitsReversed = "eno|owt|eerht|ruof|evif|xis|neves|thgie|enin|\\d".toRegex()

    enum class SpelledOutDigits(val spelling: String, val digit: Int) {
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9);

        companion object {
            fun toDigit(spelling: String): Int? {
                return entries.find { it.spelling == spelling }?.digit
            }
        }
    }

    private fun readInput(location: String): List<String> {
        val inputStream = this::class.java.getResourceAsStream(location)
        return inputStream?.bufferedReader()?.readLines() ?: listOf()
    }

    fun extractCalibration(
        input: String,
        regex: Regex = onlyDigits,
        reversedRegex: Regex = onlyDigits
    ): DigitPair {
        val firstMatch = regex.find(input)?.value!!
        val lastMatch = reversedRegex.find(input.reversed())?.value?.reversed()!!
        return DigitPair.create(firstMatch, lastMatch)
    }

    data class DigitPair(val first: Int, val second: Int) {
        fun combined(): Int {
            return "$first$second".toInt()
        }

        companion object {
            fun create(first: Int, second: Int): DigitPair {
                return DigitPair(first = first, second = second)
            }

            fun create(first: String, second: String): DigitPair {
                val parsedFirst = first.toIntOrNull() ?: SpelledOutDigits.toDigit(first)!!
                val parsedLast = second.toIntOrNull() ?: SpelledOutDigits.toDigit(second)!!
                return DigitPair(first = parsedFirst, second = parsedLast)
            }
        }
    }


    fun run(part: Int, location: String): List<Int> {
        val regex = if (part == 1) onlyDigits else spelledOutDigits
        val reversedRegex = if(part == 1) onlyDigits else spelledOutDigitsReversed
        return readInput(location).stream()
            .map { this.extractCalibration(it, regex, reversedRegex) }
            .map(DigitPair::combined)
            .toList()
    }
}
