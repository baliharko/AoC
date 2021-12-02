package com.baliharko.adventofcode.twentyone.day2

import com.baliharko.adventofcode.twentyone.util.Util

data class Instruction(val dir: String, val vel: Int)

object Count {
    var horizontal: Int = 0
    var depth: Int = 0
    var aim: Int = 0;

    fun reset() {
        this.depth = 0
        this.horizontal = 0
    }
}

val input: List<Instruction> = Util.readFile("/day2/input.txt")
    .map { line ->
        Instruction(
            line.substring(0, line.length - 2),
            Integer.parseInt(line.substring(line.length - 1))
        )
    }

val day1a: Int
    get() {
        input.forEach { (dir, vel) ->
            when (dir) {
                "up" -> Count.depth -= vel
                "down" -> Count.depth += vel
                "forward" -> Count.horizontal += vel;
            }
        }

        return Count.depth * Count.horizontal
    }

val day1b: Int
    get() {
        input.forEach { (dir, vel) ->
            when (dir) {
                "up" -> Count.aim -= vel
                "down" -> Count.aim += vel
                "forward" -> {
                    Count.depth += vel * Count.aim
                    Count.horizontal += vel
                }
            }
        }

        return Count.depth * Count.horizontal
    }

fun main() {
//    println(day1a);

    Count.reset()
    println(day1b)
}