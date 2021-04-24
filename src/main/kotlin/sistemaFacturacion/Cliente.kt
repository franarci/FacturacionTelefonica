package sistemaFacturacion

import java.time.LocalDateTime

class Cliente(val nombreApellido: String,val abonoMensual: Int, var acumulado: Double = 0.0) {

    fun registrarLlamadaLocal(duracion: Double, fecha: LocalDateTime, destinatario: Long) {
       val llamada = LlamadaLocal(duracion,fecha,destinatario)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    val registro = ArrayList<Llamada>()
}
