import java.io.*
import java.util.*
import javax.swing.JOptionPane
import kotlin.collections.HashMap

class Medico (nombre: String, especialidad: String, oficina: Int) {

    var nombre = nombre
    var esp = especialidad
    var ofi = oficina

    companion object{
        var medicos = HashMap<String,Medico>();

        fun crearMedico(){
            val n = JOptionPane.showInputDialog("Ingrese el nombre")
            val e = JOptionPane.showInputDialog("Ingrese especialidad")
            val o = JOptionPane.showInputDialog("Ingrese oficina")
            medicos.put(n,Medico(n,e,o.toInt()))
        }

        fun leerMedicos(){
            var text: String = ""
            for (med in medicos.keys){
                text = text + medicos.get(med)!!.nombre + " " + medicos.get(med)!!.esp + " " + medicos.get(med)!!.ofi + "\n"
            }
            JOptionPane.showMessageDialog(null,text)
        }

        fun actualizarMedico(){
            var nom = JOptionPane.showInputDialog("Ingrese nombre del medico que desea actualizar")
            if (medicos.contains(nom)){
                medicos.remove(nom)
                crearMedico()
            } else {
                JOptionPane.showMessageDialog(null, "no existe registro")
            }
        }

        fun borrarMedico(){
            var nom = JOptionPane.showInputDialog("Ingrese nombre del medico que desea eliminar")
            if(medicos.contains(nom)){
                medicos.remove(nom)
            }else{
                JOptionPane.showMessageDialog(null, "no existe registro")
            }
        }
    }

}