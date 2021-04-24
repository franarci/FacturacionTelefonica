package sistemaFacturacion

import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals


class ClienteTest {

    val jorge = Cliente("Jorge Perez", 500)
    val pedro = Cliente("Pedro Perez", 400)
    val maria =  Cliente("Maria Perez", 400)
    val laura = Cliente("Laura Perez", 400)

    val diaHabilALasDiez = LocalDate.of(2021,4,20).atTime(10,0)
    val domingoALasOcho = LocalDate.of(2021,4,25).atTime(8,0)

  @Before
  fun setUp() {
      pedro.registrarLlamadaLocal(15.3,diaHabilALasDiez,5471358989)
      maria.registrarLlamadaNacional(7.14, domingoALasOcho, 2218842082, "La Plata")
      laura.registrarLlamadaInternacional(5.35, domingoALasOcho, 515544848743, "Peru")
  }


    @Test
    fun test_Constructor(){
        assertEquals("Jorge Perez", jorge.nombreApellido)
        assertEquals(500, jorge.abonoMensual)
        assertEquals(0.0, jorge.acumulado)
        assertEquals(500, jorge.abonoMensual)
    }

    @Test
    fun test_UnClienteRegistraUnaLlamadaLocal(){
        assertEquals(LlamadaLocal::class.java.name, pedro.registro[0]::class.java.name)
    }

    @Test
    fun test_UnClienteRegistraUnaLlamadaNacional(){
        assertEquals(LlamadaNacional::class.java.name, maria.registro[0]::class.java.name)
    }

    @Test
    fun test_UnClienteRegistraUnaLlamadaInternacional(){
        assertEquals(LlamadaInternacional::class.java.name, laura.registro[0]::class.java.name)
    }

    @Test
    fun test_UnClienteRegistraUnaLlamadaYSeAcumulaElImporte(){
        assertEquals(3.06, pedro.acumulado)
    }
}