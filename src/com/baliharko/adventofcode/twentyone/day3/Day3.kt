package com.baliharko.adventofcode.twentyone.day3

import com.baliharko.adventofcode.util.Util
import com.baliharko.adventofcode.util.Util.measure

val input: List<String> = Util.readFile("/twentyone/day3/input.txt")

fun getGammaBit(index: Int): Char =
    if (input.count { it[index] == '0' } > input.count { it[index] == '1' }) '0' else '1'

fun getEpsilonBit(index: Int): Char =
    if (input.count { it[index] == '0' } > input.count { it[index] == '1' }) '1' else '0'

fun getRate(gamma: Boolean): String {
    var rate: String = ""
    for (i in 0 until input[0].length) {
        rate += if (gamma) getGammaBit(i) else getEpsilonBit(i)
    }
    return rate
}

val String.toDecimal: Int
    get() { return toInt(2) }

fun solvePart1() {
    val gamma = getRate(true).toDecimal
    val epsilon = getRate(false).toDecimal
    println(gamma * epsilon)
}

fun main() {
    measure {
        solvePart1();
    }
}