package org.kochtobi.adventofcode2023.day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


//@SpringBootTest
class TrebuchetCalibratorTest {


    @Test
    fun extractDigitsFromString() {
        val trebuchetCalibrator = TrebuchetCalibrator()
        Assertions.assertEquals(
            42, trebuchetCalibrator.extractCalibration(
                "42",
                trebuchetCalibrator.spelledOutDigits
            ).combined()
        )
    }

    @Test
    fun testPartOne() {
        val trebuchetCalibrator = TrebuchetCalibrator()
        val calibrationValues = trebuchetCalibrator.run(1, "/input/day1/part1-test-input.txt")
        Assertions.assertIterableEquals(
            listOf(12, 38, 15, 77),
            calibrationValues
        )
        Assertions.assertEquals(142, calibrationValues.sum())
    }

    @Test
    fun runPartOne() {
        val trebuchetCalibrator = TrebuchetCalibrator()
        val calibrationValues = trebuchetCalibrator.run(1, "/input/day1/part1.txt")
        calibrationValues.forEach { println(it) }
        println(
            "The sum of the calibration values is ${calibrationValues.sum()}"
        )
        Assertions.assertEquals(54953, calibrationValues.sum())
    }

    @Test
    fun testPartTwo() {
        val trebuchetCalibrator = TrebuchetCalibrator()
        val calibrationValues = trebuchetCalibrator.run(2, "/input/day1/part2-test-input.txt")
        Assertions.assertIterableEquals(
            listOf(29, 83, 13, 24, 42, 14, 76, 18),
            calibrationValues
        )
        Assertions.assertEquals(299, calibrationValues.sum())
    }

    @Test
    fun runPartTwo() {
        val trebuchetCalibrator = TrebuchetCalibrator()
        val calibrationValues = trebuchetCalibrator.run(2, "/input/day1/part1.txt")
        calibrationValues.forEach { println(it) }
        println(
            "The sum of the calibration values is ${calibrationValues.sum()}"
        )
    }

}
