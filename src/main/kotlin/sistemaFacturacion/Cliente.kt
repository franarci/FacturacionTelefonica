package sistemaFacturacion

import java.math.RoundingMode
import java.time.LocalDateTime


class Cliente(val nombreApellido: String,val abonoMensual: Int, var acumulado: Double = 0.0) {

    val registro = ArrayList<Llamada>()

    fun nombreApellido(): String {
        return nombreApellido
    }

    fun acumulado(): Double {
        return acumulado
    }

    fun abonoMensual(): Int {
        return abonoMensual
    }

    fun registro(): ArrayList<Llamada> {
        return registro
    }

    fun registrarLlamadaLocal(duracion: Double, fecha: LocalDateTime, destinatario: Long) {
       val llamada = LlamadaLocal(duracion,fecha,destinatario)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    fun registrarLlamadaNacional(duracion: Double, fecha: LocalDateTime,destinatario: Long, localidad: String) {
        val llamada = LlamadaNacional(duracion,fecha,destinatario,localidad)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    fun registrarLlamadaInternacional(duracion: Double, fecha: LocalDateTime, destinatario: Long, pais: String) {
        val llamada = LlamadaInternacional(duracion,fecha,destinatario,pais)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    fun facturar(): Double {
        //Retorna el monto
        val montoTotal = (abonoMensual+acumulado()).toBigDecimal().setScale(2, RoundingMode.HALF_EVEN).toDouble()
        Factura(nombreApellido(),montoTotal,registro()).imprimir()
        return montoTotal
    }
}
