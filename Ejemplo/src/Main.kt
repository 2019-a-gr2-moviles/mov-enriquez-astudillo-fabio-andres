import java.util.*

fun main(args: Array<String>) {
    println("Hola Mundo bbbbbbbb")

    //Variables

    //Mutables

    var nombre = "Adrian"
    nombre = "Vicente"

    //Inmutables

    val nombreI = "Vicente"

    //tipos de datos
    val apellido: String = "Eguez"
    val edad: Int = 29
    val sueldo: Double = 1.21
    val casado: Boolean = false
    val hijos = null


    if (apellido == "Eguez" || nombre == "Adrian") {
        println("Verdadero")
    } else {
        println("Falso")
    }

    val tieneNombreYApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreYApellido)

    estaJalado(10.0)
    hola("Hola")

    val arreglo1: Array<Int> = arrayOf(1, 2, 3, 4)
    val arreglo2: Array<Any> = arrayOf(1, "asd", 10.2, true)

    arreglo1[0] = 5
    arreglo1.set(0, 5)

    val notas = arrayListOf(1,2,3,4,5,6)

}


fun hola(mensaje:Any): Unit{
    println("Mensaje: $mensaje.")

}

fun estaJalado(nota:Double) {
    when (nota){
        7.0 -> {
            println("Pasaste con las justas")
        }

        10.0 ->{
            println("Felicidades")
        }
        else ->{
            println("Tu nota es: $nota")
        }

    }
}