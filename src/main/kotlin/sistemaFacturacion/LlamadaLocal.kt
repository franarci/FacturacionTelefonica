package sistemaFacturacion

import java.math.RoundingMode
import java.time.LocalDateTime


class LlamadaLocal(duracion: Double, fecha: LocalDateTime?, destinatario: Long): Llamada(duracion, fecha!!, destinatario){


    override fun importe(): Double {
    if (esFinDeSemana()){
        importe = redondear(0.10*duracion)
        return importe!!
    } else{
        return costoDiaHabil()
    }
        }

    private fun costoDiaHabil(): Double {
        if(fecha.hour in 8..20){
            importe = redondear(0.20*duracion)
            return importe!!
        } else{
            importe = redondear((0.10*duracion))
            return importe!!
        }
    }

    private fun redondear(d: Double): Double? {
        return d.toBigDecimal().setScale(2,RoundingMode.HALF_EVEN).toDouble()
    }

    private fun esFinDeSemana(): Boolean {
        return fecha.dayOfWeek.value == 6 || fecha.dayOfWeek.value == 7
    }


}


