package com.baliharko.adventofcode.twenty.day12

import com.baliharko.adventofcode.util.Util
import kotlin.math.abs

class Day12b {
    val instructions: List<Instruction> = input.map { it.toInstruction }

    val String.toInstruction: Instruction
        get() {
            val dir: Char = first()
            return Instruction(dir, substring(1).toInt())
        }

    data class Instruction(val dir: Char, val vel: Int);

    object Ship {
        var x: Int = 0
        var y: Int = 0
        var wx: Int = 10
        var wy: Int = 1

        fun moveForward(vel: Int) {
            x += wx * vel
            y += wy * vel
        }

        fun moveWaypoint(dir: Char, vel: Int) {
            when (dir) {
                'N' -> wy += vel
                'E' -> wx += vel
                'S' -> wy -= vel
                'W' -> wy -= vel
            }
        }

        fun rotateWaypoint(vel: Int, clockwise: Boolean) {
            if (vel == 0) return
            else {
                if (clockwise) {
                    val temp = wy
                    wy = -wx;
                    wx = temp;
                } else {
                    val temp = wy
                    wy = wx;
                    wx = -temp;
                }
                rotateWaypoint(vel - 90, clockwise)
            }
        }
    }
}

fun solve() {
    instructions.forEach {
        when (it.dir) {
            'F' -> Day12b.Ship.moveForward(it.vel)
            'L', 'R' -> Day12b.Ship.rotateWaypoint(it.vel, it.dir == 'R')
            else -> Day12b.Ship.moveWaypoint(it.dir, it.vel)
        }
    }

    val manhattan = abs(Day12b.Ship.x) + abs(Day12b.Ship.y)
    println(manhattan)
}

fun main() {
    Util.measure {
        solve()
    }
}