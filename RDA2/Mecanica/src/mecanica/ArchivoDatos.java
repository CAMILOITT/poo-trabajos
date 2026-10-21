/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grupo1
 */
public class ArchivoDatos {

    private static final String RUTA_CLIENTES = "datos/clientes.txt";
    private static final String RUTA_MECANICOS = "datos/mecanicos.txt";
    private static final String RUTA_REPUESTOS = "datos/repuestos.txt";
    private static final String RUTA_ORDENES = "datos/ordenes.txt";
    private static final String RUTA_FACTURAS = "datos/facturas.txt";

    // ---------- LEER ----------
    public static ArrayList<Cliente> mostrarClientes() {
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
                String celular = partes[3];
                String correo = partes[4];

                listaClientes.add(new Cliente(new ArrayList<>(), nombre, apellido, cedula, celular, correo));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de clientes.");
        }
        return listaClientes;
    }

    public static ArrayList<Mecanico> mostrarMecanicos() {
        ArrayList<Mecanico> listaMecanicos = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_MECANICOS))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                String cedula = partes[0];
                String nombre = partes[1];
                String apellido = partes[2];
                String celular = partes[3];
                String correo = partes[4];
                String especialidad = partes[5];

                listaMecanicos.add(new Mecanico(especialidad, new ArrayList<>(), nombre, apellido, cedula, celular, correo));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de mecánicos.");
        }
        return listaMecanicos;
    }

    public static ArrayList<Repuesto> mostrarRepuestos() {
        ArrayList<Repuesto> listaRepuestos = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_REPUESTOS))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                String codigo = partes[0];
                String nombre = partes[1];
                float precio = Float.parseFloat(partes[2]);
                int cantidad = Integer.parseInt(partes[3]);

                listaRepuestos.add(new Repuesto(codigo, nombre, precio, cantidad));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de repuestos.");
        }
        return listaRepuestos;
    }

    public static void mostrarOrdenes(ArrayList<Cliente> listaClientes,
            ArrayList<Mecanico> listaMecanicos,
            ArrayList<Repuesto> listaRepuestos) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ORDENES))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                String numeroOrden = partes[0];
                Date fecha = formatoFecha.parse(partes[1]);
                String cedulaCliente = partes[2];
                String cedulaMecanico = partes[3];
                String[] codigosRepuestos = partes[4].split(",");

                OrdenTrabajo orden = new OrdenTrabajo(numeroOrden, fecha);

                for (String codigo : codigosRepuestos) {
                    Repuesto datoRepuesto = buscarRepuesto(listaRepuestos, codigo);
                    if (datoRepuesto != null) {
                        orden.agregarRepuesto(datoRepuesto);
                    }
                }

                Cliente datoCliente = buscarCliente(listaClientes, cedulaCliente);
                if (datoCliente != null) {
                    datoCliente.solicitarOrden(orden);
                }

                Mecanico datoMecanico = buscarMecanico(listaMecanicos, cedulaMecanico);
                if (datoMecanico != null) {
                    datoMecanico.registrarOrdenes(orden);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("No se pudo leer el archivo de órdenes.");
        }
    }

    public static ArrayList<Factura> mostrarFacturas(ArrayList<Cliente> listaClientes) {
        ArrayList<Factura> listaFacturas = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_FACTURAS))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(";");
                int numeroFactura = Integer.parseInt(partes[0]);
                Date fecha = formatoFecha.parse(partes[1]);
                String[] numerosOrdenes = partes[2].split(",");

                ArrayList<OrdenTrabajo> ordenesFactura = new ArrayList<>();
                for (String numeroOrden : numerosOrdenes) {
                    OrdenTrabajo datoOrden = buscarOrden(listaClientes, numeroOrden);
                    if (datoOrden != null) {
                        ordenesFactura.add(datoOrden);
                    }
                }

                listaFacturas.add(new Factura(numeroFactura, fecha, ordenesFactura));
            }
        } catch (IOException | ParseException e) {
            System.out.println("No se pudo leer el archivo de facturas.");
        }
        return listaFacturas;
    }

    // ---------- ESCRIBIR ----------
    public static void guardarCliente(Cliente datoCliente) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_CLIENTES, true))) {
            escritor.write(datoCliente.getCedula() + ";"
                    + datoCliente.getNombre() + ";"
                    + datoCliente.getApellido() + ";"
                    + datoCliente.getCelular() + ";"
                    + datoCliente.getCorreo());
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el cliente.");
        }
    }

    public static void guardarMecanico(Mecanico datoMecanico) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_MECANICOS, true))) {
            escritor.write(datoMecanico.getCedula() + ";"
                    + datoMecanico.getNombre() + ";"
                    + datoMecanico.getApellido() + ";"
                    + datoMecanico.getCelular() + ";"
                    + datoMecanico.getCorreo() + ";"
                    + datoMecanico.getEspecialidad());
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el mecánico.");
        }
    }

    public static void guardarRepuestos(ArrayList<Repuesto> listaRepuestos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_REPUESTOS, false))) {
            for (Repuesto datoRepuesto : listaRepuestos) {
                escritor.write(datoRepuesto.getCodigo() + ";"
                        + datoRepuesto.getNombre() + ";"
                        + datoRepuesto.getPrecio() + ";"
                        + datoRepuesto.getCantidad());
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de repuestos.");
        }
    }

    public static void guardarOrden(OrdenTrabajo datoOrden, Cliente datoCliente, Mecanico datoMecanico) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String codigos = "";
        for (Repuesto datoRepuesto : datoOrden.getRepuestoUsado()) {
            if (!codigos.isEmpty()) {
                codigos += ",";
            }
            codigos += datoRepuesto.getCodigo();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ORDENES, true))) {
            escritor.write(datoOrden.getNumeroOrden() + ";"
                    + formatoFecha.format(datoOrden.getFecha()) + ";"
                    + datoCliente.getCedula() + ";"
                    + datoMecanico.getCedula() + ";"
                    + codigos);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar la orden.");
        }
    }

    public static void guardarFactura(Factura datoFactura) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String numerosOrdenes = "";
        for (OrdenTrabajo datoOrden : datoFactura.getListaDeOrdenes()) {
            if (!numerosOrdenes.isEmpty()) {
                numerosOrdenes += ",";
            }
            numerosOrdenes += datoOrden.getNumeroOrden();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_FACTURAS, true))) {
            escritor.write(datoFactura.getNumeroFactura() + ";"
                    + formatoFecha.format(datoFactura.getFehca()) + ";"
                    + numerosOrdenes);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar la factura.");
        }
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
