package com.baliharko.adventofcode.twenty.day12

import com.baliharko.adventofcode.util.Util
import java.util.concurrent.TimeUnit
import kotlin.math.abs
import kotlin.system.measureNanoTime

val input: List<String> = Util.readFile("/twenty/day12/input.txt")
internal val instructions: List<Instruction> = input.map { it.toInstruction }

internal data class Instruction(val dir: Char, val vel: Int);

internal object Ship {
    var forward: Char = 'E'
    var x = 0
    var y = 0

    fun move(dir: Char, vel: Int) {
        when (dir) {
            'N' -> y += vel
            'E' -> x += vel
            'S' -> y -= vel
            'W' -> x -= vel
        }
    }

    fun rotate(vel: Int, clockwise: Boolean) {
        val directions: List<Char> =
            if (clockwise) arrayListOf('N', 'E', 'S', 'W')
            else arrayListOf('N', 'W', 'S', 'E')

        val currentDirIndex = directions.indexOf(forward)
        val newForwardIndex = (currentDirIndex + vel / 90) % directions.size
        forward = directions[newForwardIndex]
    }
}

internal val String.toInstruction: Instruction
    get() {
        val dir: Char = first()
        return Instruction(dir, substring(1).toInt())
    }

fun day12a() {
    instructions.forEach { (dir, vel) ->
        when (dir) {
            'R', 'L' -> {
                Ship.rotate(vel, dir == 'R')
            }
            'F' -> Ship.move(Ship.forward, vel)
            else -> Ship.move(dir, vel)
        }
    }
    val manhattan = abs(Ship.x) + abs(Ship.y)
    print("$manhattan ")
}


fun main() {
    Util.measure {
        day12a()
    }
}
