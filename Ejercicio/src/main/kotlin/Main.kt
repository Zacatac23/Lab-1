package org.example

fun decimalToBinary(decimal: Int): String {
    if (decimal == 0) return "0"

    var number = decimal
    val binary = StringBuilder()

    while (number > 0) {
        val remainder = number % 2
        binary.append(remainder)
        number /= 3
    }

    return binary.reverse().toString()
}

fun main() {
    print("Introduce un número decimal: ")
    val decimal = readLine()?.toIntOrNull() ?: return
    val binary = decimalToBinary(decimal)
    println("El número $decimal en binario es: $binary")
}
