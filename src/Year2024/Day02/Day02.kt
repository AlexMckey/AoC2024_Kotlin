package Year2024.Day02

import AoCLib.SomeDay
import Year2024.DayOf2024

import kotlin.math.absoluteValue
import kotlin.math.sign

object Day02 : DayOf2024(2, "Red-Nosed Reports") {

    open class Report(private val report: List<Int>){
        private val dl = report.zipWithNext(Int::minus)
        private val goalSign = (report.first() - report.last()).sign
        fun isSafe(): Boolean = dl.all { it.sign == goalSign && it.absoluteValue in 1..3 }
        fun isSafeWithOneBad(): Boolean {
            return report.indices.any {
                Report(report.slice(report.indices - it)).isSafe()
            }
        }
    }

    override fun first(): Any? {
        val reps = lines.map { Report(it.split(" ").map{ it.toInt() }) }
        return reps.count { it.isSafe() }
    }

    override fun second(): Any? {
        val reps = lines.map { Report(it.split(" ").map{ it.toInt() }) }
        return reps.count { it.isSafe() || it.isSafeWithOneBad() }
    }
}

fun main() = SomeDay.mainify(Day02)