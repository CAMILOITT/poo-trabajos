package sistema.supermercado;
import java.util.ArrayList;

public class Cliente extends Persona {
  private int puntos;
  private String correo;
  private ArrayList<Compra> listaDeCompras;

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
  public ArrayList<Compra> getListaDeCompras() {
    return listaDeCompras;
  }

  public void agregarCompra(Compra datoVenta) {
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
