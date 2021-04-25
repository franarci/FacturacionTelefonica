package sistemaFacturacion

import java.time.LocalDateTime

class LlamadaNacional(duracion: Double, fecha: LocalDateTime, destinatario: Long,val localidad: String): Llamada(duracion, fecha,destinatario) {

    override fun importe(): Double {
        //Se asume que para realizar el calculo se utilizara la variable localidad
        importe = 5.0
        return importe!!
    }

}
