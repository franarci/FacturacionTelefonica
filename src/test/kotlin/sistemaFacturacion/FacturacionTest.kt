package sistemaFacturacion

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class FacturacionTest {
    val jorge = Cliente("Jorge Perez", 500)

    val diaHabilALasDiez = LocalDate.of(2021,4,20).atTime(10,0)
    val domingoALasOcho = LocalDate.of(2021,4,25).atTime(8,0)
    val diaHabilOncePM = LocalDate.of(2021,4,21).atTime(23,0)
    val diaSabado = LocalDate.of(2021,4,24).atTime(10,0)
    val diaHabilALasSiete = LocalDate.of(2021,4,19).atTime(7,0)

    @Before
    fun setUp() {
        jorge.registrarLlamadaLocal(15.3,diaHabilALasDiez,5471358989)
        jorge.registrarLlamadaNacional(7.14, domingoALasOcho, 2218842082, "La Plata")
        jorge.registrarLlamadaInternacional(5.35, diaHabilOncePM, 515544848743, "Peru")
        jorge.registrarLlamadaLocal(3.15,diaSabado,5471358989)
        jorge.registrarLlamadaLocal(8.0,diaHabilALasSiete,5471358989)
    }

    @Test
    fun test_SeFacturElImporteAcumulado(){
        assertEquals(519.18, jorge.facturar())
    }
}