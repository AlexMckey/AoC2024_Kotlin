package Year2024.Day03

import AoCLib.SomeDay
import Year2024.DayOf2024
import AoCLib.MatchResults.int

object Day03 : DayOf2024(3, "Mull It Over") {

    private val r = "mul\\((?<x>\\d{1,3}),(?<y>\\d{1,3})\\)|do(?:n't)?\\(\\)".toRegex()

    private fun readInput(): Sequence<MatchResult> = r.findAll(data)

    private fun calSumMuls(ms: Sequence<MatchResult>): Int {
        return ms
            .fold(0 to true)
            { (acc, mulOn), lst ->
                when {
                    lst.value == "do()" -> acc to true
                    lst.value == "don't()" -> acc to false
                    mulOn -> acc + lst.int("x") * lst.int("y") to mulOn
                    else -> acc to mulOn
                }
            }.first
    }

    override fun first(): Any? = calSumMuls(readInput().filter { it.value.startsWith("mul") })

    override fun second(): Any?  = calSumMuls(readInput())
}

fun main() = SomeDay.mainify(Day03)

//Year 2024, Day 3 : Mull It Over
//First: 170778545
//Time: 200ms
//Second: 82868252
//Time: 7ms