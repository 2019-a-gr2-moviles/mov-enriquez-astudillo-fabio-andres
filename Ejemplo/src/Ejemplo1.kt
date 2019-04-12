fun main(args: Array<String>) {
    println("Hola Mundo")

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

    if (apellido == "Eguez" || nombre=="Adrian"){
        println("Verdadero")
    }else{
        println("Falso")
    }

    val tieneNombreYApellido = if(apellido!=null && nombre!=null) "ok" else "no"
    println(tieneNombreYApellido)

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

    estaJalado(10.0)

}
