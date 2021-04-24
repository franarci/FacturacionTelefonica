package sistemaFacturacion

import java.math.RoundingMode
import java.time.LocalDateTime


class LlamadaLocal(duracion: Double, fecha: LocalDateTime?, destinatario: Long): Llamada(duracion, fecha!!, destinatario){



    override fun importe(): Double {
    if (esFinDeSemana()){
        return (0.10*duracion).toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toDouble()
    } else{
        return costoDiaHabil()
    }
        }

    private fun costoDiaHabil(): Double {
        if(fecha.hour in 8..20){
            return  (0.20*duracion).toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toDouble()
        } else{
            return (0.10*duracion).toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toDouble()
        }
    }

    private fun esFinDeSemana(): Boolean {
        return fecha.dayOfWeek.value == 6 || fecha.dayOfWeek.value == 7
    }

}


