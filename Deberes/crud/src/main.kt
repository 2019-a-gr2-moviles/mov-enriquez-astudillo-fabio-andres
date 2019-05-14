import java.io.*
import java.util.*
import javax.swing.JOptionPane
import kotlin.collections.HashMap

fun main() {
    cargarDeArchivo()
    var opc = presentarMenu()
    when(opc){
        "1" -> {
            Medico.crearMedico()
            Medico.leerMedicos()
            escribirEnArchivo()
        }
        "2" -> Medico.leerMedicos()
        "3" -> {
            Medico.actualizarMedico()
            escribirEnArchivo()
        }
        "4" -> {
            Medico.borrarMedico()
            escribirEnArchivo()
        }
    }
}

fun cargarDeArchivo(){
    var medicos = HashMap<String,Medico>()
    File("medicos.txt").forEachLine {
        var array = it.split(";")
        var med = Medico(array.get(0),array.get(1),array.get(2).toInt())
        medicos.put(array.get(0),med)
    }
    Medico.medicos = medicos
}

fun escribirEnArchivo(){
    borrarArchivo()
    val fr = FileWriter("medicos.txt",true)
    val array = Medico.medicos
    for (med in array.keys){
        var str:String = array.get(med)!!.nombre + ";" + array.get(med)!!.esp + ";" + array.get(med)!!.ofi.toString()
        println(str)
        fr.write(str + "\n")
    }
    fr.close()
}

fun borrarArchivo(){
    val fr = FileWriter("medicos.txt")
    fr.write("")
}

fun presentarMenu(): String{
    val menu = "Modulo Medico" + "\n" +
            "\t 1) Ingresar nuevo registro" + "\n" +
            "\t 2) Consultar registros" + "\n" +
            "\t 3) Actualizar un registro" + "\n" +
            "\t 4) Eliminar un registro" + "\n" +
            "\t 5) Regresar" + "\n" +
            "Escoja una opción: "
    return JOptionPane.showInputDialog(menu);
}