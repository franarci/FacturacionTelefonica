package sistemaFacturacion

import java.time.LocalDateTime

class LlamadaLocal(val duracion: Double, val fecha: LocalDateTime, val destinatario: Long){
    fun importe(): Double {
        if (esFinDeSemana()){
            return 0.10*duracion
        } else{
            return costoEstandar()
        }
    }

}


