class Usuario(val cedula:String){
    public var nombre:String = ""
    public var apellido:String = "";

    constructor(cedulaM:String, apellido:String):this(cedulaM){
        this.apellido = apellido
    }

}

class UsuarioKT(var nombre:String, var apellido: String, protected var id:Int){
    fun hola(){



    }

    companion object {
        val gravedad = 10.5
        fun correr(){
            println("Estoy corriendo en $gravedad");
        }
    }
}

class numero(val numero:Int){

    init{
        print("INIT")
    }
}

fun a (){
    var adrian = UsuarioKT("a","b")
    adrian.nombre = "asdsf"
    UsuarioKT.gravedad;

}

class Numero(val numero:Int){
    constructor(numeroString:String):this(numeroString.toInt()){

    }

}

open class Numeros(var numero: Int){


}

fun presley(){

}