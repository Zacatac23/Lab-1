package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun Palindroma(palabra: String): Boolean {
    val palabraLimpia = palabra.lowercase().filter { it.isLetter() }
    return palabraLimpia == palabraLimpia.reversed()
}

fun contieneDosVocalesDistintas(palabra: String): Boolean {
    val vocales = "aeiou"
    val vocalesEncontradas = mutableSetOf<Char>()

    for (letra in palabra.lowercase()) {
        if (letra in vocales) {
            vocalesEncontradas.add(letra)
        }
        if (vocalesEncontradas.size >= 2) {
            return true
        }
    }

    return false
}

fun iniciaConConsonante(palabra: String): Boolean {
    val consonantes = "bcdfghjklmnpqrstvwxyz"
    return palabra.isNotEmpty() && palabra[0].lowercaseChar() in consonantes
}

fun main() {
    do {
        println("Introduce varias palabras separadas por espacios:")
        val palabras = readLine()?.split(" ") ?: return

        var cantidadPalindromas = 0
        var cantidadConDosVocalesDistintas = 0
        var cantidadInicianConConsonante = 0
        val palabrasPalindromas = mutableListOf<String>()

        for (palabra in palabras) {
            if (Palindroma(palabra)) {
                cantidadPalindromas++
                palabrasPalindromas.add(palabra)
            }
            if (contieneDosVocalesDistintas(palabra)) {
                cantidadConDosVocalesDistintas++
            }
            if (iniciaConConsonante(palabra)) {
                cantidadInicianConConsonante++
            }
        }

        println("Cantidad de palabras palíndromas: $cantidadPalindromas")
        println("Cantidad de palabras con al menos 2 vocales distintas: $cantidadConDosVocalesDistintas")
        println("Cantidad de palabras que inician con consonante: $cantidadInicianConConsonante")
        println("Palabras palíndromas: ${palabrasPalindromas.joinToString(", ")}")

        println("¿Quieres ingresar otro texto? (s/n):")
        val respuesta = readLine()?.lowercase()
    } while (respuesta == "s")
}
