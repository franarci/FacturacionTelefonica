package sistemaFacturacion

import com.google.gson.Gson
import java.time.Month


data class Factura(val mes: Month,val anio: Int, val nombre: String, val abonoMensual: Int, val montoTotal: Double, val registro: List<Llamada>) {
    fun imprimir(){
       println(Gson().toJson(this))
    }
}