package sistemaFacturacion

import com.google.gson.Gson


data class Factura(val nombre: String, val montoTotal: Double, val registro: List<Llamada>) {
    fun imprimir(){

       println(Gson().toJson(this))
    }
}