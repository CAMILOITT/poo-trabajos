package sistema.supermercado;
import java.util.ArrayList;

public class Cliente extends Persona {
  private int puntos;
  private String correo;
  private ArrayList<Venta> listaDeCompras;

  public Cliente(String cedula, String nombre, String apellido, String telefono, int puntos, String correo) {
    super(cedula, nombre, apellido, telefono);
    this.puntos = puntos;
    this.correo = correo;
    this.listaDeCompras = new ArrayList<>();
  }
  public int getPuntos() {
    return puntos;
  }
  public String getCorreo() {
    return correo;
  }
  public ArrayList<Venta> getListaDeCompras() {
    return listaDeCompras;
  }

  public void agregarCompra(Venta datoVenta) {
    this.listaDeCompras.add(datoVenta);
  }

  public void acumularPuntos(int total) {
    if (total < 1)
      return;
    this.puntos += total;
  }
  
  public void mostrarDatos () {
    //muestra datos
  }
}
