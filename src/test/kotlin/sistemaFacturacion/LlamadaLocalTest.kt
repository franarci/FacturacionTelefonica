package sistemaFacturacion


import org.junit.Test
import java.lang.Math.round
import java.time.LocalDate
import java.util.*
import kotlin.test.assertEquals

class LlamadaLocalTest {
    val diaHabilALasSiete = LocalDate.of(2021,4,19).atTime(7,0)
    val diaHabilALasDiez = LocalDate.of(2021,4,20).atTime(10,0)
    val diaHabilOncePM = LocalDate.of(2021,4,21).atTime(23,0)
    val diaSabado = LocalDate.of(2021,4,24).atTime(10,0)


    val localLunesSiete = LlamadaLocal(2.5, diaHabilALasSiete,2215486459)
    val localMartesDiez =LlamadaLocal(5.0, diaHabilALasDiez,2215486459)
    val localMiercolesVeinte = LlamadaLocal(7.0, diaHabilOncePM,2215486459)
    val localSabado = LlamadaLocal(4.0, diaSabado,2215486459)

    @Test
    fun test_Constructor(){
        assertEquals(2.5, localLunesSiete.duracion)
        assertEquals(LocalDate.of(2021,4,19).atTime(7,0), localLunesSiete.fecha)
        assertEquals(2215486459, localLunesSiete.destinatario)
    }

    @Test
    fun test_LlamadaLocalConocePrecioFinDeSemana(){
        assertEquals(0.4, localSabado.importe())
    }

    @Test
    fun test_LlamadaLocalConocePrecioDiaHabilEnHoraPico(){
        assertEquals(1.00, localMartesDiez.importe())
    }

    @Test
    fun test_LlamadaLocalConocePrecioDiaHabilAntesDeLasOcho(){
        assertEquals(0.25, localLunesSiete.importe())
    }

    @Test
    fun test_LlamadaLocalConocePrecioDiaHabilDespuesDeLasVeinte(){
        assertEquals((0.70), localMiercolesVeinte.importe())
    }
}