package sistemaFacturacion

import java.time.LocalDateTime

abstract class Llamada(val duracion: Double, val fecha: LocalDateTime, val destinatario: Long, val importe: Double? = null){
    abstract fun importe(): Double
}
