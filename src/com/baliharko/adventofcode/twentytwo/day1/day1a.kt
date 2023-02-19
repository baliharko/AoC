package com.baliharko.adventofcode.twentytwo.day1

import com.baliharko.adventofcode.util.Util
import com.baliharko.adventofcode.util.Util.measure

val lines = Util.readFile("/twentytwo/day1/input.txt")

fun solvePart1() {
    val result = getElfCals(lines).values.maxOrNull()
    println(result)
}

fun solvePart2() {
    val result = getElfCals(lines).values
        .sortedDescending()
        .take(3)
        .reduce { acc, i -> acc + i }

    println(result)
}

fun getElfCals(lines: List<String>): HashMap<Int, Int> {
    val cals: HashMap<Int, Int> = HashMap()
    var elf = 0

    tailrec fun List<String>.splitAndSum() {
        val boundIndex: Int = this.indexOf("")
        if (boundIndex != -1) {
            cals[elf++] = this.subList(0, boundIndex).sumOf { it.toInt() }

            if (boundIndex == this.lastIndexOf(""))
                cals[elf] = this.subList(boundIndex + 1, this.size).sumOf { it.toInt() }

            this.subList(boundIndex + 1, this.size).splitAndSum()
        }
    }

    lines.splitAndSum()
    return cals
}

fun main() {
    measure {
        solvePart2()
    }
}