package sistema.supermercado;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.File;

public class ArchivoDatos {

    private static final int TAM_ID = 10;
    private static final int TAM_NOMBRES = 20;
    private static final int TAM_APELLIDOS = 20;
    private static final int TAM_TELEFONO = 10;
    private static final int TAM_CORREO = 30;
    private static final int TAM_CODIGO_EMPLEADO = 10;
    private static final int TAM_FECHADECOMPRA = 19;
    private static final int TAM_NOMBREPRODUCTO = 30;
    private static final int TAM_CODIGODEPRODUCTO = 10;
    private static final int TAM_CATEGORIA = 20;


    

 
    private static final String ARCHIVO_CLIENTES = "Clientes.dat";
    private static final int TAM_CLIENTE_REGISTRO =
        (TAM_ID + TAM_NOMBRES + TAM_APELLIDOS + TAM_TELEFONO + TAM_CORREO) * 2 + 4;   // 184, 4 de numero de puntos

    private static final String ARCHIVO_CAJEROS = "Cajeros.dat";
    private static final int TAM_CAJERO_REGISTRO =
        (TAM_ID + TAM_NOMBRES + TAM_APELLIDOS + TAM_TELEFONO + TAM_CODIGO_EMPLEADO) * 2 + 4;   // 144, 4 de numero de caja
    
    private static final String ARCHIVO_COMPRAS = "Compras.dat";
    private static final int TAM_COMPRA_REGISTRO =
        (TAM_ID + TAM_FECHADECOMPRA + TAM_CODIGO_EMPLEADO) * 2 + 4; //82, 4 de numero de compra
    
    private static final String ARCHIVO_PRODUCTOS = "Productos.dat";
    private static final int TAM_PRODUCTO_REGISTRO =
        (TAM_NOMBREPRODUCTO  + TAM_CODIGODEPRODUCTO + TAM_CATEGORIA ) * 2 + 4+4+4;   // 132, 4 de numero de PASILLO, 4 de precio y 4 de stock
    
    private static final String ARCHIVO_DETALLECOMPRA = "DetalleCompra.dat";
    private static final int TAM_DETALLECOMPRA_REGISTRO =
        (TAM_CODIGODEPRODUCTO) * 2 + 4;  // 24, 4 de numero de compra

    

    // ---------- LEER ----------

    
    public static ArrayList<Producto> verProductos(ArrayList<Inventario> listaInventarios) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        if (!new File(ARCHIVO_PRODUCTOS).exists())
        {
            return listaProductos;
        }
        
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_PRODUCTOS, "r"))
        {                
            long total = f.length() / TAM_PRODUCTO_REGISTRO;
            
            for (long i = 0; i < total; i++)
            {
                String codigo = leerTexto(f, TAM_CODIGODEPRODUCTO);
                String nombre = leerTexto(f, TAM_NOMBREPRODUCTO);
                float precio = f.readFloat();
                int stock = f.readInt();
                String categoria = leerTexto(f, TAM_CATEGORIA);
                int numeroPasillo = f.readInt();
                
                Producto datoProducto = new Producto(stock, precio, codigo, nombre, categoria);
                listaProductos.add(datoProducto);
                ubicarEnPasillo(listaInventarios, datoProducto, numeroPasillo);
            }
            
        } 
        catch (IOException e) 
        {
            System.out.println("No se pudo leer el archivo de productos.");
        }
        return listaProductos;
    }

    public static ArrayList<Cliente> verClientes() 
    {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        if (!new File(ARCHIVO_CLIENTES).exists())
        {
            return listaClientes;
        }
                
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_CLIENTES, "r")) 
        {
            long total = f.length() / TAM_CLIENTE_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                String cedula = leerTexto(f, TAM_ID);
                String nombre = leerTexto(f, TAM_NOMBRES);
                String apellido = leerTexto(f, TAM_APELLIDOS);
                String telefono = leerTexto(f, TAM_TELEFONO);
                int puntos = f.readInt();
                String correo = leerTexto(f, TAM_CORREO);

                listaClientes.add(new Cliente(cedula, nombre, apellido, telefono, puntos, correo));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de clientes.");
        }
        return listaClientes;
    }

    public static ArrayList<Cajero> verCajeros() 
    {
        
        ArrayList<Cajero> listaCajeros = new ArrayList<>();
        
        if (!new File(ARCHIVO_CAJEROS).exists())
        {
            return listaCajeros;
        }
                
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_CAJEROS, "r")) 
        {
            long total = f.length() / TAM_CAJERO_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                String cedula = leerTexto(f, TAM_ID);
                String nombre = leerTexto(f, TAM_NOMBRES);
                String apellido = leerTexto(f, TAM_APELLIDOS);
                String telefono = leerTexto(f, TAM_TELEFONO);
                int numeroCaja = f.readInt();
                String codigoEmpleado = leerTexto(f, TAM_CODIGO_EMPLEADO);

                listaCajeros.add(new Cajero(cedula, nombre, apellido, telefono, numeroCaja, codigoEmpleado));
            }
        } 
        catch (IOException e) 
        {
            System.out.println("No se pudo leer el archivo de cajeros.");
        }
        return listaCajeros;
    }

    // ---------- ESCRIBIR ----------

    public static void guardarProducto(Producto datoProducto, int numeroPasillo) {
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_PRODUCTOS, "rw")) 
        {
            f.seek(f.length()); //para no sobreescribir
            
            escribirTexto(f, datoProducto.getCodigo(), TAM_CODIGODEPRODUCTO);
            escribirTexto(f, datoProducto.getNombreProducto(), TAM_NOMBREPRODUCTO);
            f.writeFloat(datoProducto.getPrecio());
            f.writeInt(datoProducto.getStock());
            escribirTexto(f, datoProducto.getCategoria(), TAM_CATEGORIA);
            f.writeInt(numeroPasillo);
            
        } 
        catch (IOException e) 
        {
            System.out.println("No se pudo guardar el producto.");
        }
    }

    public static void guardarCliente(Cliente datoCliente) {
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_CLIENTES, "rw")) 
        {
            f.seek(f.length()); //para no sobreescribir

            escribirTexto(f, datoCliente.getCedula(), TAM_ID);
            escribirTexto(f, datoCliente.getNombre(), TAM_NOMBRES);
            escribirTexto(f, datoCliente.getApellido(), TAM_APELLIDOS);
            escribirTexto(f, datoCliente.getTelefono(), TAM_TELEFONO);
            f.writeInt(datoCliente.getPuntos());
            escribirTexto(f, datoCliente.getCorreo(), TAM_CORREO);    
        } 
        catch (IOException e) 
        {
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
    
    private static String ajustar(String texto, int tamanio)
    {
        String cadenaConEspacios = "";
        
        if (texto.length() < tamanio)
        {
            cadenaConEspacios += texto;
            for (int i = texto.length(); i< tamanio; i++)
            {
                cadenaConEspacios += " ";
            }
        }
        else if (texto.length() > tamanio)
        {
            cadenaConEspacios = texto.substring(0, tamanio);
        }
        else
        {
            cadenaConEspacios += texto;
        }
        return cadenaConEspacios;
    }
    
    private static void escribirTexto(RandomAccessFile f, String texto, int tamanio) throws IOException 
    {
        f.writeChars(ajustar(texto, tamanio));
    }
    
    private static String leerTexto(RandomAccessFile f, int tamanio) throws IOException
    {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < tamanio; i++) 
        {
            cadena.append(f.readChar());
        }
        return cadena.toString().trim();   // quita los espacios de relleno
    }
    
    private static void cargarDetalle(Compra datoCompra, ArrayList<Producto> listaProductos) throws IOException
    {
        if (!new File(ARCHIVO_DETALLECOMPRA).exists())
        {
            return;
        }
        
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_DETALLECOMPRA, "r")) 
        {
            long total = f.length() / TAM_DETALLECOMPRA_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                int numero = f.readInt();
                String codigo = leerTexto(f, TAM_CODIGODEPRODUCTO);
                
                if (numero == datoCompra.getNumeroCompra())
                {
                    Producto datoProducto = buscarProducto(listaProductos, codigo);
                    
                    if (datoProducto != null)
                    {
                        datoCompra.agregarProducto(datoProducto);
                    }
                }
            }    
        } 
        catch (IOException e) 
        {
            System.out.println("No se pudo cargar el detalle de la compra.");
        }
        
    }
    

    // ---------- COMPRAS ----------

    public static void verCompras(ArrayList<Cliente> listaClientes, ArrayList<Cajero> listaCajeros,
            ArrayList<Producto> listaProductos) 
    {
        if (!new File(ARCHIVO_COMPRAS).exists())
        {
            return;
        }
        
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_COMPRAS, "r")) 
        {
            long total = f.length() / TAM_COMPRA_REGISTRO;
            
            for (long i = 0; i < total; i++)
            {
                
                int numeroCompra = f.readInt();
                LocalDateTime fechaCompra = LocalDateTime.parse(leerTexto(f, TAM_FECHADECOMPRA));
                String cedulaCliente = leerTexto(f, TAM_ID);
                String codigoEmpleado = leerTexto(f, TAM_CODIGO_EMPLEADO);
                
                Compra datoCompra = new Compra(numeroCompra, fechaCompra);
                
                cargarDetalle(datoCompra, listaProductos);

                Cliente datoCliente = buscarCliente(listaClientes, cedulaCliente);
                if (datoCliente != null)
                {
                    datoCliente.agregarCompra(datoCompra);
                }
            }
        } 
        catch (IOException e) 
        {
            System.out.println("No se pudo leer el archivo de compras.");
        }
    }

    public static void guardarCompra(Compra datoCompra, Cliente datoCliente, Cajero datoCajero)
    {
        
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_COMPRAS, "rw")) 
        {
            f.seek(f.length()); //para no sobreescribir
            
            f.writeInt(datoCompra.getNumeroCompra());
            escribirTexto(f, datoCompra.getFechaCompra().withNano(0).toString(), TAM_FECHADECOMPRA);
            escribirTexto(f, datoCliente.getCedula(), TAM_ID);
            escribirTexto(f, datoCajero.getCodigoEmpleado(), TAM_CODIGO_EMPLEADO);
        }
        catch (IOException e) 
        {
            System.out.println("No se pudo guardar la compra.");
        }
        try (RandomAccessFile d = new RandomAccessFile(ARCHIVO_DETALLECOMPRA, "rw")) 
        {
            d.seek(d.length());
            
            for  (Producto datoProducto: datoCompra.getListaDeProductosComprados())
            {
                d.writeInt(datoCompra.getNumeroCompra());
                escribirTexto(d, datoProducto.getCodigo(), TAM_CODIGODEPRODUCTO);
            }
            
        }
        catch (IOException e) 
        {
            System.out.println("No se pudo guardar el detalle de la compra.");
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

}
