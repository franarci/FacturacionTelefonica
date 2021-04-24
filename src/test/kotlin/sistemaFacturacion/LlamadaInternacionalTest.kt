package sistemaFacturacion

import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class LlamadaInternacionalTest {
    val diaSabado = LocalDate.of(2021,4,24).atTime(10,0)

    val internacionalSabado = LlamadaInternacional(4.0, diaSabado,2215486459, "Uruguay")

    @Test
    fun test_Constructor(){
        assertEquals(2.5, internacionalSabado.duracion)
        assertEquals(LocalDate.of(2021,4,19).atTime(7,0), internacionalSabado.fecha)
        assertEquals(2215486459, internacionalSabado.destinatario)
        assertEquals("Uruguay", internacionalSabado.pais)
    }

    @Test
    fun test_LlamadaInternacionalConoceImporte(){
        assertEquals(10.0, internacionalSabado.importe())
    }
}