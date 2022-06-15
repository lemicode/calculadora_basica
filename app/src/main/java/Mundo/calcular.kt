package Mundo

fun calcular(op: String): Double {
    var newOp = op.replace("x", "*").replace("÷", "/")
    return evaluate(newOp)
}