package com.baliharko.adventofcode.twentyone.day3.part2

import com.baliharko.adventofcode.util.Util
import com.baliharko.adventofcode.util.Util.measure

val input: List<String> = Util.readFile("/twentyone/day3/input.txt")

val String.toDecimal: Int
    get() {
        return toInt(2)
    }

val List<String>.asString: String
    get() {
        var out = ""
        forEach { out += it }
        return out
    }

fun getCount(index: Int, list: List<String>): Array<Int> {
    val arr = Array(2) { 0 }
    arr[0] = list.count { it[index] == '0' }
    arr[1] = list.count { it[index] == '1' }

    return arr
}

fun getOxygenBit(index: Int, input: List<String>): Char {
    val count = getCount(index, input)
    val ones = count[1]
    val zeroes = count[0]
    return if (ones == zeroes) '1'
    else
        if (ones > zeroes) '1' else '0'
}

fun getC02Bit(index: Int, input: List<String>): Char {
    val count = getCount(index, input)
    val ones = count[1]
    val zeroes = count[0]
    return if (ones == zeroes) '0'
    else
        if (ones < zeroes) '1' else '0'
}

fun solve() {
    var oxygenGenRating = input.toMutableList()
    var c02ScrubRating = input.toMutableList()

    for (i in 0 until input[0].length) {
        val tempOxy = oxygenGenRating.toMutableList()
        val tempC02 = c02ScrubRating.toMutableList()

        oxygenGenRating.forEach {
            if (oxygenGenRating.size > 1)
                if (it[i] != getOxygenBit(i, oxygenGenRating)) tempOxy.remove(it)
        }

        c02ScrubRating.forEach {
            if (c02ScrubRating.size > 1)
                if (it[i] != getC02Bit(i, c02ScrubRating)) tempC02.remove(it)
        }

        oxygenGenRating = tempOxy.toMutableList()
        c02ScrubRating = tempC02.toMutableList()
    }

    println(oxygenGenRating.asString.toDecimal * c02ScrubRating.asString.toDecimal)
}

fun main() {
    measure {
        solve()
    }
}