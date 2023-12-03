package org.kochtobi.adventofcode2023.day2

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
class GameChecker {
    public fun run(part: Int, location: String): Int {
        val expectedRed = 12
        val expectedGreen = 13
        val expectedBlue = 14
        val games = readInput(location)
            .map { Game.parse(it) }.toList()
        if (part == 1) {
            val indexSum = games
                .filter { it.isPossibleWithStones(expectedRed, expectedGreen, expectedBlue) }
                .map { it.gameNumber }
                .sum()
            println("The sum of indices for possible games is $indexSum")
            return indexSum;
        } else {

            val powerSum = games.map { it.power() }.sum()
            println("The summed power is $powerSum ")
            return powerSum
        }
    }

    private fun readInput(location: String): List<String> {
        val inputStream = this::class.java.getResourceAsStream(location)
        return inputStream?.bufferedReader()?.readLines() ?: listOf()
    }
}
