package Mundo

/**
 * La función contenida en este archivo (evaluate.kt) fue copiada de la publiación realizada en la
 * URL https://stackoverflow.com/questions/71560324/parsing-arithmetic-string-operations-in-kotlin
 * por el usuario "lukas.j" el 21 de marzo de 2022 a las 15:57 horas.
 */

fun evaluate(str: String): Double {

    data class Data(val rest: List<Char>, val value: Double)

    return object : Any() {

        fun parse(chars: List<Char>): Double {
            return getExpression(chars.filter { it != ' ' })
                .also { if (it.rest.isNotEmpty()) throw RuntimeException("Unexpected character: ${it.rest.first()}") }
                .value
        }

        private fun getExpression(chars: List<Char>): Data {
            var (rest, carry) = getTerm(chars)
            while (true) {
                when {
                    rest.firstOrNull() == '+' -> rest = getTerm(rest.drop(1)).also { carry += it.value }.rest
                    rest.firstOrNull() == '-' -> rest = getTerm(rest.drop(1)).also { carry -= it.value }.rest
                    else                      -> return Data(rest, carry)
                }
            }
        }

        fun getTerm(chars: List<Char>): Data {
            var (rest, carry) = getFactor(chars)
            while (true) {
                when {
                    rest.firstOrNull() == '*' -> rest = getTerm(rest.drop(1)).also { carry *= it.value }.rest
                    rest.firstOrNull() == '/' -> rest = getTerm(rest.drop(1)).also { carry /= it.value }.rest
                    else                      -> return Data(rest, carry)
                }
            }
        }

        fun getFactor(chars: List<Char>): Data {
            return when (val char = chars.firstOrNull()) {
                '+'              -> getFactor(chars.drop(1)).let { Data(it.rest, +it.value) }
                '-'              -> getFactor(chars.drop(1)).let { Data(it.rest, -it.value) }
                '('              -> getParenthesizedExpression(chars.drop(1))
                in '0'..'9', ',' -> getNumber(chars)
                else             -> throw RuntimeException("Unexpected character: $char")
            }
        }

        fun getParenthesizedExpression(chars: List<Char>): Data {
            return getExpression(chars)
                .also { if (it.rest.firstOrNull() != ')') throw RuntimeException("Missing closing parenthesis") }
                .let { Data(it.rest.drop(1), it.value) }
        }

        fun getNumber(chars: List<Char>): Data {
            val s = chars.takeWhile { it.isDigit() || it == '.' }.joinToString("")
            return Data(chars.drop(s.length), s.toDouble())
        }

    }.parse(str.toList())

}