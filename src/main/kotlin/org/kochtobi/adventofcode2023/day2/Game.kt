package org.kochtobi.adventofcode2023.day2

import kotlin.math.max

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
class Game(val gameNumber : Int) {

    val rounds: List<Round> = mutableListOf()


    data class Round(val red: Int, val green: Int, val blue: Int) {
        companion object Parser {
            fun parse(input: String): Round {
                val stoneDraws = input.split(",")
                    .map { it.trim() }
                    .map {
                        val split = it.split(" ")
                        val numberOfStones = split[0].toInt()
                        val color = split[1]
                        StoneDraw(numberOfStones, color)
                    }
                    .toList()
                val totalCountOfRed = stoneDraws.filter { it.color == "red" }
                    .map { it.count }
                    .sum()
                val totalCountOfGreen = stoneDraws.filter { it.color == "green" }
                    .map { it.count }
                    .sum()
                val totalCountOfBlue = stoneDraws.filter { it.color == "blue" }
                    .map { it.count }
                    .sum()

                return Round(totalCountOfRed, totalCountOfGreen, totalCountOfBlue)
            }
        }
    }

    data class StoneDraw(val count: Int, val color: String)

    fun addRound(round: Round) {
        rounds.addLast(round)
    }

    fun isPossibleWithStones (redCount: Int, greenCount: Int, blueCount: Int): Boolean {
        return !rounds.any { it.red > redCount || it.green > greenCount || it.blue > blueCount }
    }

    fun getFewestPossibleStones(): Round {
        return rounds.reduce { round1, round2 ->
            Round(
                max(round1.red, round2.red),
                max(round1.green, round2.green),
                max(round1.blue, round2.blue)
            )
        }
    }

    fun power(): Int {
        val fewestPossibleStones = getFewestPossibleStones()
        return fewestPossibleStones.red * fewestPossibleStones.green * fewestPossibleStones.blue
    }

    companion object Parser {
        fun parse(line: String): Game {
            val stringWithoutGamePrefix = line.replaceFirst("Game ", "")
            val split = stringWithoutGamePrefix.split(":")

            val gameNumber = split.first().trim().toInt()
            val game = Game(gameNumber)

            val rounds = split[1].trim().split(";")
            rounds.map { Round.parse(it) }.forEach { game.addRound(it) }
            return game
        }
    }
}
