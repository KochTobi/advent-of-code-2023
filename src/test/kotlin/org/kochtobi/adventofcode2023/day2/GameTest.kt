package org.kochtobi.adventofcode2023.day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.kochtobi.adventofcode2023.day1.TrebuchetCalibrator

class GameTest {

    @Test
    fun testPartOne() {
        val result = GameChecker().run(1, "/input/day2/part1-test-input.txt")
        Assertions.assertEquals(8, result)
    }

    @Test
    fun runPartOne() {
        val result = GameChecker().run(1, "/input/day2/part1.txt")
        Assertions.assertEquals(2720, result)
    }

    @Test
    fun testPartTwo() {
        val result = GameChecker().run(2, "/input/day2/part2-test-input.txt")
        Assertions.assertEquals(2286, result)
    }

    @Test
    fun runPartTwo() {
        val result = GameChecker().run(2, "/input/day2/part1.txt")
        Assertions.assertEquals(71535, result)
    }
}
