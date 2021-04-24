package sistemaFacturacion

import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class LlamadaNacionalTest {
    val diaHabilALasSiete = LocalDate.of(2021,4,19).atTime(7,0)

    val nacionalLunesSiete = LlamadaNacional(2.5, diaHabilALasSiete,2215486459, "La Plata")

    @Test
    fun test_Constructor(){
        assertEquals(2.5, nacionalLunesSiete.duracion)
        assertEquals(LocalDate.of(2021,4,19).atTime(7,0), nacionalLunesSiete.fecha)
        assertEquals(2215486459, nacionalLunesSiete.destinatario)
        assertEquals("La Plata", nacionalLunesSiete.localidad)
    }

    @Test
    fun test_LlamadaNacionalConoceImporte(){
        assertEquals(5.0, nacionalLunesSiete.importe())
    }

}