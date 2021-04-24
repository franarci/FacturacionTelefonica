package sistemaFacturacion

import java.time.LocalDateTime

class LlamadaInternacional(duracion: Double, fecha: LocalDateTime, destinatario: Long,val pais: String): Llamada(duracion,fecha,destinatario){
    override fun importe(): Double {
        //Se asume que para realizar el calculo se utilizara la variable pais
        return 10.0
    }

}
