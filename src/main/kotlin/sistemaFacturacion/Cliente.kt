package sistemaFacturacion

import java.math.RoundingMode
import java.time.LocalDate
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
        //precondicion: la fecha que se recibe corresponde al mes actual por facturar
       val llamada = LlamadaLocal(duracion,fecha,destinatario)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    fun registrarLlamadaNacional(duracion: Double, fecha: LocalDateTime,destinatario: Long, localidad: String) {
        //precondicion: la fecha que se recibe corresponde al mes actual por facturar
        val llamada = LlamadaNacional(duracion,fecha,destinatario,localidad)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    fun registrarLlamadaInternacional(duracion: Double, fecha: LocalDateTime, destinatario: Long, pais: String) {
        //precondicion: la fecha que se recibe corresponde al mes actual por facturar
        val llamada = LlamadaInternacional(duracion,fecha,destinatario,pais)
        registro.add(llamada)
        acumulado+=llamada.importe()
    }

    fun facturar(): Double {
        //Retorna el montoTotal(abonoMensual+acumulado) para testear que se calcula bien
        val mes = LocalDate.now().month
        val anio = LocalDate.now().year
        val montoTotal = (abonoMensual+acumulado()).toBigDecimal().setScale(2, RoundingMode.HALF_EVEN).toDouble()
        Factura(mes,anio,nombreApellido(),abonoMensual(), montoTotal,registro()).imprimir()
        acumulado = 0.0
        registro.clear()
        return montoTotal
    }
}
