package sistema.supermercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArchivoDatos {

    private static final String RUTA_PRODUCTOS = "datos/productos.txt";
    private static final String RUTA_CLIENTES = "datos/clientes.txt";
    private static final String RUTA_CAJEROS = "datos/cajeros.txt";
    private static final String RUTA_COMPRAS = "datos/compras.txt";

    // ---------- LEER ----------

    public static ArrayList<Producto> cargarProductos(ArrayList<Inventario> listaInventarios) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_PRODUCTOS))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                String codigo = partes[0];
                String nombre = partes[1];
                float precio = Float.parseFloat(partes[2]);
                int stock = Integer.parseInt(partes[3]);
                String categoria = partes[4];
                int numeroPasillo = Integer.parseInt(partes[5]);

                Producto datoProducto = new Producto(stock, precio, codigo, nombre, categoria);
                listaProductos.add(datoProducto);
                ubicarEnPasillo(listaInventarios, datoProducto, numeroPasillo);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de productos.");
        }
        return listaProductos;
    }

    public static ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_CLIENTES))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                String cedula = partes[0];
                String nombre = partes[1];
                String apellido = partes[2];
                String telefono = partes[3];
                int puntos = Integer.parseInt(partes[4]);
                String correo = partes[5];

                listaClientes.add(new Cliente(cedula, nombre, apellido, telefono, puntos, correo));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de clientes.");
        }
        return listaClientes;
    }

    public static ArrayList<Cajero> cargarCajeros() {
        ArrayList<Cajero> listaCajeros = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_CAJEROS))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                String cedula = partes[0];
                String nombre = partes[1];
                String apellido = partes[2];
                String telefono = partes[3];
                int numeroCaja = Integer.parseInt(partes[4]);
                String codigoEmpleado = partes[5];

                listaCajeros.add(new Cajero(cedula, nombre, apellido, telefono, numeroCaja, codigoEmpleado));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de cajeros.");
        }
        return listaCajeros;
    }

    // ---------- ESCRIBIR ----------

    public static void guardarProducto(Producto datoProducto, int numeroPasillo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_PRODUCTOS, true))) {
            escritor.write(datoProducto.getCodigo() + ";"
                    + datoProducto.getNombreProducto() + ";"
                    + datoProducto.getPrecio() + ";"
                    + datoProducto.getStock() + ";"
                    + datoProducto.getCategoria() + ";"
                    + numeroPasillo);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el producto.");
        }
    }

    public static void guardarCliente(Cliente datoCliente) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_CLIENTES, true))) {
            escritor.write(datoCliente.getCedula() + ";"
                    + datoCliente.getNombre() + ";"
                    + datoCliente.getApellido() + ";"
                    + datoCliente.getTelefono() + ";"
                    + datoCliente.getPuntos() + ";"
                    + datoCliente.getCorreo());
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el cliente.");
        }
    }

    // ---------- AYUDA ----------

    private static void ubicarEnPasillo(ArrayList<Inventario> listaInventarios, Producto datoProducto, int numeroPasillo) {
        for (Inventario pasillo : listaInventarios) {
            if (pasillo.getNumeroPasillo() == numeroPasillo) {
                pasillo.insertarProducto(datoProducto);
                return;
            }
        }
        Inventario pasilloNuevo = new Inventario(numeroPasillo);
        pasilloNuevo.insertarProducto(datoProducto);
        listaInventarios.add(pasilloNuevo);
    }

    // ---------- COMPRAS ----------

    public static void cargarCompras(ArrayList<Cliente> listaClientes, ArrayList<Cajero> listaCajeros,
            ArrayList<Producto> listaProductos) {
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_COMPRAS))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                int numeroCompra = Integer.parseInt(partes[0]);
                LocalDateTime fechaCompra = LocalDateTime.parse(partes[1]);
                String cedulaCliente = partes[2];
                String codigoCajero = partes[3];

                Compra datoCompra = new Compra(numeroCompra, fechaCompra);
                for (int i = 4; i < partes.length; i++) {
                    Producto datoProducto = buscarProducto(listaProductos, partes[i]);
                    if (datoProducto != null) {
                        datoCompra.agregarProducto(datoProducto);
                    }
                }

                Cliente datoCliente = buscarCliente(listaClientes, cedulaCliente);
                if (datoCliente != null) {
                    datoCliente.agregarCompra(datoCompra);
                }
                Cajero datoCajero = buscarCajero(listaCajeros, codigoCajero);
                if (datoCajero != null) {
                    datoCajero.registrarVenta(datoCompra);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de compras.");
        }
    }

    public static void guardarCompra(Compra datoCompra, Cliente datoCliente, Cajero datoCajero) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_COMPRAS, true))) {
            String linea = datoCompra.getNumeroCompra() + ";"
                    + datoCompra.getFechaCompra().withNano(0) + ";"
                    + datoCliente.getCedula() + ";"
                    + datoCajero.getCodigoEmpleado();
            for (Producto datoProducto : datoCompra.getListaDeProductosComprados()) {
                linea = linea + ";" + datoProducto.getCodigo();
            }
            escritor.write(linea);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar la compra.");
        }
    }

    private static Producto buscarProducto(ArrayList<Producto> listaProductos, String codigo) {
        for (Producto datoProducto : listaProductos) {
            if (datoProducto.getCodigo().equals(codigo)) {
                return datoProducto;
            }
        }
        return null;
    }

    private static Cliente buscarCliente(ArrayList<Cliente> listaClientes, String cedula) {
        for (Cliente datoCliente : listaClientes) {
            if (datoCliente.getCedula().equals(cedula)) {
                return datoCliente;
            }
        }
        return null;
    }

    private static Cajero buscarCajero(ArrayList<Cajero> listaCajeros, String codigoEmpleado) {
        for (Cajero datoCajero : listaCajeros) {
            if (datoCajero.getCodigoEmpleado().equals(codigoEmpleado)) {
                return datoCajero;
            }
        }
        return null;
    }
}
