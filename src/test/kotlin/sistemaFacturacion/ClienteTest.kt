package sistemaFacturacion

import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals


class ClienteTest {

    val jorge = Cliente("Jorge Perez", 500)
    val pedro = Cliente("Pedro Perez", 400)

    val diaHabilALasDiez = LocalDate.of(2021,4,20).atTime(10,0)
    val localMartesDiez =LlamadaLocal(5.0, diaHabilALasDiez,2215486459)


  @Before
  fun setUp() {
      pedro.registrarLlamadaLocal(15.3,diaHabilALasDiez,5471358989)

  }


    @Test
    fun test_Constructor(){
        assertEquals("Jorge Perez", jorge.nombreApellido)
        assertEquals(500, jorge.abonoMensual)
        assertEquals(0.0, jorge.acumulado)
        assertEquals(500, jorge.abonoMensual)
    }

    @Test
    fun test_UnClienteRegistraUnaLlamada(){
        assertEquals(1, pedro.registro.size)
    }

    @Test
    fun test_UnClienteRegistraUnaLlamadaYSeAcumulaElImporte(){
        assertEquals(3.06, pedro.acumulado)
    }
}