/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grupo1
 */
public class ArchivoDatos {

    private static final int TAM_ID = 10;
    private static final int TAM_NOMBRES = 20;
    private static final int TAM_APELLIDOS = 20;
    private static final int TAM_CELULAR = 10;
    private static final int TAM_CORREO = 30;
    private static final int TAM_ESPECIALIDAD = 20;
    private static final int TAM_NUMEROORDEN = 10;
    private static final int TAM_CODIGOREPUESTO = 10;
    private static final int TAM_NOMBREREPUESTO = 30;
    private static final int TAM_FECHA = 10;   // dd/MM/yyyy

    private static final String ARCHIVO_CLIENTES = "Clientes.dat";
    private static final int TAM_CLIENTE_REGISTRO =
        (TAM_ID + TAM_NOMBRES + TAM_APELLIDOS + TAM_CELULAR + TAM_CORREO) * 2;   // 180

    private static final String ARCHIVO_MECANICOS = "Mecanicos.dat";
    private static final int TAM_MECANICO_REGISTRO =
        (TAM_ID + TAM_NOMBRES + TAM_APELLIDOS + TAM_CELULAR + TAM_CORREO + TAM_ESPECIALIDAD) * 2;   // 220

    private static final String ARCHIVO_REPUESTOS = "Repuestos.dat";
    private static final int TAM_REPUESTO_REGISTRO =
        (TAM_CODIGOREPUESTO + TAM_NOMBREREPUESTO) * 2 + 4 + 4;   // 88, 4 del precio como flotante, 4 de la cantidad

    private static final String ARCHIVO_ORDENES = "Ordenes.dat";
    private static final int TAM_ORDEN_REGISTRO =
        (TAM_NUMEROORDEN + TAM_FECHA + TAM_ID + TAM_ID) * 2;   // 80, un ID del cliente y un ID del mecanico

    private static final String ARCHIVO_DETALLEORDEN = "DetalleOrden.dat";
    private static final int TAM_DETALLEORDEN_REGISTRO =
        (TAM_NUMEROORDEN + TAM_CODIGOREPUESTO) * 2;   // 40

    private static final String ARCHIVO_FACTURAS = "Facturas.dat";
    private static final int TAM_FACTURA_REGISTRO =
        TAM_FECHA * 2 + 4;   // 24, 4 de numero de factura

    private static final String ARCHIVO_DETALLEFACTURA = "DetalleFactura.dat";
    private static final int TAM_DETALLEFACTURA_REGISTRO =
        TAM_NUMEROORDEN * 2 + 4;   // 24, 4 de numero de factura

    // ---------- LEER ----------
    public static ArrayList<Cliente> mostrarClientes()
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
                String celular = leerTexto(f, TAM_CELULAR);
                String correo = leerTexto(f, TAM_CORREO);

                listaClientes.add(new Cliente(new ArrayList<>(), nombre, apellido, cedula, celular, correo));
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo leer el archivo de clientes.");
        }
        return listaClientes;
    }

    public static ArrayList<Mecanico> mostrarMecanicos()
    {
        ArrayList<Mecanico> listaMecanicos = new ArrayList<>();

        if (!new File(ARCHIVO_MECANICOS).exists())
        {
            return listaMecanicos;
        }

        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_MECANICOS, "r"))
        {
            long total = f.length() / TAM_MECANICO_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                String cedula = leerTexto(f, TAM_ID);
                String nombre = leerTexto(f, TAM_NOMBRES);
                String apellido = leerTexto(f, TAM_APELLIDOS);
                String celular = leerTexto(f, TAM_CELULAR);
                String correo = leerTexto(f, TAM_CORREO);
                String especialidad = leerTexto(f, TAM_ESPECIALIDAD);

                listaMecanicos.add(new Mecanico(especialidad, new ArrayList<>(), nombre, apellido, cedula, celular, correo));
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo leer el archivo de mecánicos.");
        }
        return listaMecanicos;
    }

    public static ArrayList<Repuesto> mostrarRepuestos()
    {
        ArrayList<Repuesto> listaRepuestos = new ArrayList<>();

        if (!new File(ARCHIVO_REPUESTOS).exists())
        {
            return listaRepuestos;
        }

        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_REPUESTOS, "r"))
        {
            long total = f.length() / TAM_REPUESTO_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                String codigo = leerTexto(f, TAM_CODIGOREPUESTO);
                String nombre = leerTexto(f, TAM_NOMBREREPUESTO);
                float precio = f.readFloat();
                int cantidad = f.readInt();

                listaRepuestos.add(new Repuesto(codigo, nombre, precio, cantidad));
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo leer el archivo de repuestos.");
        }
        return listaRepuestos;
    }

    public static void mostrarOrdenes(ArrayList<Cliente> listaClientes,
            ArrayList<Mecanico> listaMecanicos,
            ArrayList<Repuesto> listaRepuestos)
    {
        if (!new File(ARCHIVO_ORDENES).exists())
        {
            return;
        }

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_ORDENES, "r"))
        {
            long total = f.length() / TAM_ORDEN_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                String numeroOrden = leerTexto(f, TAM_NUMEROORDEN);
                Date fecha = formatoFecha.parse(leerTexto(f, TAM_FECHA));
                String cedulaCliente = leerTexto(f, TAM_ID);
                String cedulaMecanico = leerTexto(f, TAM_ID);

                OrdenTrabajo orden = new OrdenTrabajo(numeroOrden, fecha);

                cargarDetalleOrden(orden, listaRepuestos);

                Cliente datoCliente = buscarCliente(listaClientes, cedulaCliente);
                if (datoCliente != null)
                {
                    datoCliente.solicitarOrden(orden);
                }

                Mecanico datoMecanico = buscarMecanico(listaMecanicos, cedulaMecanico);
                if (datoMecanico != null)
                {
                    datoMecanico.registrarOrdenes(orden);
                }
            }
        }
        catch (IOException | ParseException e)
        {
            System.out.println("No se pudo leer el archivo de órdenes.");
        }
    }

    public static ArrayList<Factura> mostrarFacturas(ArrayList<Cliente> listaClientes)
    {
        ArrayList<Factura> listaFacturas = new ArrayList<>();

        if (!new File(ARCHIVO_FACTURAS).exists())
        {
            return listaFacturas;
        }

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_FACTURAS, "r"))
        {
            long total = f.length() / TAM_FACTURA_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                int numeroFactura = f.readInt();
                Date fecha = formatoFecha.parse(leerTexto(f, TAM_FECHA));

                ArrayList<OrdenTrabajo> ordenesFactura = cargarDetalleFactura(numeroFactura, listaClientes);

                listaFacturas.add(new Factura(numeroFactura, fecha, ordenesFactura));
            }
        }
        catch (IOException | ParseException e)
        {
            System.out.println("No se pudo leer el archivo de facturas.");
        }
        return listaFacturas;
    }

    // ---------- ESCRIBIR ----------
    public static void guardarCliente(Cliente datoCliente)
    {
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_CLIENTES, "rw"))
        {
            f.seek(f.length()); //para no sobreescribir

            escribirTexto(f, datoCliente.getCedula(), TAM_ID);
            escribirTexto(f, datoCliente.getNombre(), TAM_NOMBRES);
            escribirTexto(f, datoCliente.getApellido(), TAM_APELLIDOS);
            escribirTexto(f, datoCliente.getCelular(), TAM_CELULAR);
            escribirTexto(f, datoCliente.getCorreo(), TAM_CORREO);
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar el cliente.");
        }
    }

    public static void guardarMecanico(Mecanico datoMecanico)
    {
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_MECANICOS, "rw"))
        {
            f.seek(f.length()); //para no sobreescribir

            escribirTexto(f, datoMecanico.getCedula(), TAM_ID);
            escribirTexto(f, datoMecanico.getNombre(), TAM_NOMBRES);
            escribirTexto(f, datoMecanico.getApellido(), TAM_APELLIDOS);
            escribirTexto(f, datoMecanico.getCelular(), TAM_CELULAR);
            escribirTexto(f, datoMecanico.getCorreo(), TAM_CORREO);
            escribirTexto(f, datoMecanico.getEspecialidad(), TAM_ESPECIALIDAD);
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar el mecánico.");
        }
    }

    public static void guardarRepuesto(Repuesto datoRepuesto)
    {
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_REPUESTOS, "rw"))
        {
            f.seek(f.length()); //para no sobreescribir

            escribirTexto(f, datoRepuesto.getCodigo(), TAM_CODIGOREPUESTO);
            escribirTexto(f, datoRepuesto.getNombre(), TAM_NOMBREREPUESTO);
            f.writeFloat(datoRepuesto.getPrecio());
            f.writeInt(datoRepuesto.getCantidad());
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar el repuesto.");
        }
    }

    // Edita un repuesto ya guardado: se ubica en su registro y escribe encima
    public static void actualizarRepuesto(Repuesto datoRepuesto)
    {
        int posicion = buscarPosicionRepuesto(datoRepuesto.getCodigo());
        if (posicion == -1)
        {
            return;
        }

        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_REPUESTOS, "rw"))
        {
            f.seek((long) posicion * TAM_REPUESTO_REGISTRO + TAM_CODIGOREPUESTO * 2);   // salta el codigo, que no cambia

            escribirTexto(f, datoRepuesto.getNombre(), TAM_NOMBREREPUESTO);
            f.writeFloat(datoRepuesto.getPrecio());
            f.writeInt(datoRepuesto.getCantidad());
        }
        catch (IOException e)
        {
            System.out.println("No se pudo actualizar el repuesto.");
        }
    }

    public static void guardarOrden(OrdenTrabajo datoOrden, Cliente datoCliente, Mecanico datoMecanico)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_ORDENES, "rw"))
        {
            f.seek(f.length()); //para no sobreescribir

            escribirTexto(f, datoOrden.getNumeroOrden(), TAM_NUMEROORDEN);
            escribirTexto(f, formatoFecha.format(datoOrden.getFecha()), TAM_FECHA);
            escribirTexto(f, datoCliente.getCedula(), TAM_ID);
            escribirTexto(f, datoMecanico.getCedula(), TAM_ID);
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar la orden.");
        }
        try (RandomAccessFile d = new RandomAccessFile(ARCHIVO_DETALLEORDEN, "rw"))
        {
            d.seek(d.length()); //para no sobreescribir

            for (Repuesto datoRepuesto : datoOrden.getRepuestoUsado())
            {
                escribirTexto(d, datoOrden.getNumeroOrden(), TAM_NUMEROORDEN);
                escribirTexto(d, datoRepuesto.getCodigo(), TAM_CODIGOREPUESTO);
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar el detalle de la orden.");
        }
    }

    public static void guardarFactura(Factura datoFactura)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_FACTURAS, "rw"))
        {
            f.seek(f.length()); //para no sobreescribir

            f.writeInt(datoFactura.getNumeroFactura());
            escribirTexto(f, formatoFecha.format(datoFactura.getFehca()), TAM_FECHA);
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar la factura.");
        }
        try (RandomAccessFile d = new RandomAccessFile(ARCHIVO_DETALLEFACTURA, "rw"))
        {
            d.seek(d.length()); //para no sobreescribir

            for (OrdenTrabajo datoOrden : datoFactura.getListaDeOrdenes())
            {
                d.writeInt(datoFactura.getNumeroFactura());
                escribirTexto(d, datoOrden.getNumeroOrden(), TAM_NUMEROORDEN);
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo guardar el detalle de la factura.");
        }
    }

    // ---------- AYUDA ----------
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

    // Agrega a la orden los repuestos guardados en el detalle con su mismo numero
    private static void cargarDetalleOrden(OrdenTrabajo datoOrden, ArrayList<Repuesto> listaRepuestos)
    {
        if (!new File(ARCHIVO_DETALLEORDEN).exists())
        {
            return;
        }

        try (RandomAccessFile d = new RandomAccessFile(ARCHIVO_DETALLEORDEN, "r"))
        {
            long total = d.length() / TAM_DETALLEORDEN_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                String numeroOrden = leerTexto(d, TAM_NUMEROORDEN);
                String codigo = leerTexto(d, TAM_CODIGOREPUESTO);

                if (numeroOrden.equals(datoOrden.getNumeroOrden()))
                {
                    Repuesto datoRepuesto = buscarRepuesto(listaRepuestos, codigo);

                    if (datoRepuesto != null)
                    {
                        datoOrden.agregarRepuesto(datoRepuesto);
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo cargar el detalle de la orden.");
        }
    }

    // Devuelve las ordenes guardadas en el detalle de esa factura
    private static ArrayList<OrdenTrabajo> cargarDetalleFactura(int numeroFactura, ArrayList<Cliente> listaClientes)
    {
        ArrayList<OrdenTrabajo> ordenesFactura = new ArrayList<>();

        if (!new File(ARCHIVO_DETALLEFACTURA).exists())
        {
            return ordenesFactura;
        }

        try (RandomAccessFile d = new RandomAccessFile(ARCHIVO_DETALLEFACTURA, "r"))
        {
            long total = d.length() / TAM_DETALLEFACTURA_REGISTRO;

            for (long i = 0; i < total; i++)
            {
                int numero = d.readInt();
                String numeroOrden = leerTexto(d, TAM_NUMEROORDEN);

                if (numero == numeroFactura)
                {
                    OrdenTrabajo datoOrden = buscarOrden(listaClientes, numeroOrden);

                    if (datoOrden != null)
                    {
                        ordenesFactura.add(datoOrden);
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo cargar el detalle de la factura.");
        }
        return ordenesFactura;
    }

    // Devuelve el numero de registro de ese codigo, o -1 si no existe
    private static int buscarPosicionRepuesto(String codigo)
    {
        if (!new File(ARCHIVO_REPUESTOS).exists())
        {
            return -1;
        }
        try (RandomAccessFile f = new RandomAccessFile(ARCHIVO_REPUESTOS, "r"))
        {
            long total = f.length() / TAM_REPUESTO_REGISTRO;
            for (int i = 0; i < total; i++)
            {
                f.seek((long) i * TAM_REPUESTO_REGISTRO);   // inicio del registro i
                if (leerTexto(f, TAM_CODIGOREPUESTO).equals(codigo))   // compara solo el primer campo
                {
                    return i;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("No se pudo leer el archivo de repuestos.");
        }
        return -1;
    }

    // ---------- BUSCAR ----------
    private static Cliente buscarCliente(ArrayList<Cliente> listaClientes, String cedula) {
        for (Cliente datoCliente : listaClientes) {
            if (datoCliente.getCedula().equals(cedula)) {
                return datoCliente;
            }
        }
        return null;
    }

    private static Mecanico buscarMecanico(ArrayList<Mecanico> listaMecanicos, String cedula) {
        for (Mecanico datoMecanico : listaMecanicos) {
            if (datoMecanico.getCedula().equals(cedula)) {
                return datoMecanico;
            }
        }
        return null;
    }

    private static Repuesto buscarRepuesto(ArrayList<Repuesto> listaRepuestos, String codigo) {
        for (Repuesto datoRepuesto : listaRepuestos) {
            if (datoRepuesto.getCodigo().equals(codigo)) {
                return datoRepuesto;
            }
        }
        return null;
    }

    private static OrdenTrabajo buscarOrden(ArrayList<Cliente> listaClientes, String numeroOrden) {
        for (Cliente datoCliente : listaClientes) {
            for (OrdenTrabajo datoOrden : datoCliente.getOrdenesRealizadas()) {
                if (datoOrden.getNumeroOrden().equals(numeroOrden)) {
                    return datoOrden;
                }
            }
        }
        return null;
    }
}
