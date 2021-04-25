# FacturacionTelefonica

## Aclaraciones

- Asumo que todas las llamadas reciben la duracion en minutos.
- Harcodeo el método importe() tanto en LlamadasNacionales como en LlamadasInternacionales ya que no se especifica. 
  cómo calcular el mismo en ambos casos. Sin embargo se asume que se tendrán en cuenta las variables localidad y pais respectivamente.
- Al momento de facturar se genera un json(se imprime en pantalla) que eventualmente una interfaz de usuario podría usar.
- Se asume que la funcion facturar() en Cliente se invoca una vez al mes, por lo que una vez invocada se reinician el registro de llamadas
  y el monto acumulado.
