package minecraft;

import java.util.ArrayList;

public class Minecraft {

    private static ArrayList<String> crearLista(String... elementos) {
        ArrayList<String> lista = new ArrayList<>();
        for (String elemento : elementos) {
            lista.add(elemento);
        }
        return lista;
    }

    public static void main(String[] args) {
        // 1. Instanciación de las 4 listas globales del sistema
        ArrayList<Monstruo> bestiarioGlobal = new ArrayList<>();
        ArrayList<Zombie> listaZombies = new ArrayList<>();
        ArrayList<Esqueleto> listaEsqueletos = new ArrayList<>();
        ArrayList<Arania> listaAranias = new ArrayList<>();

        // Listas auxiliares con datos predefinidos
        ArrayList<String> opcionesZombies = crearLista("Estándar", "Ahogado", "Husk", "Zombie Aldeano");

        // 2. Instanciación de ZOMBIES (variante va PRIMERO según tu constructor)
        ArrayList<String> dropsZombie1 = crearLista("Carne podrida", "Lingote de hierro");
        ArrayList<String> variantesZombie1 = crearLista(opcionesZombies.get(1), opcionesZombies.get(2)); // Ahogado, Husk
        
        Zombie zombie1 = new Zombie(variantesZombie1, "MOB-001", "Zombie de Cueva", 20.0, 3.0, dropsZombie1);
        listaZombies.add(zombie1);
        bestiarioGlobal.add(zombie1);

        ArrayList<String> dropsZombie2 = crearLista("Carne podrida", "Zanahoria");
        ArrayList<String> variantesZombie2 = crearLista(opcionesZombies.get(3)); // Zombie Aldeano
        
        Zombie zombie2 = new Zombie(variantesZombie2, "MOB-002", "Zombie Aldeano", 20.0, 3.5, dropsZombie2);
        listaZombies.add(zombie2);
        bestiarioGlobal.add(zombie2);


        // 3. Instanciación de ESQUELETO (tipoArco va PRIMERO según tu constructor)
        ArrayList<String> dropsEsqueleto = crearLista("Hueso", "Flecha");
        
        Esqueleto esqueleto1 = new Esqueleto("Arco Encantado (Fuego I)", "MOB-003", "Esqueleto Arquero", 20.0, 4.0, dropsEsqueleto);
        listaEsqueletos.add(esqueleto1);
        bestiarioGlobal.add(esqueleto1);


        // 4. Instanciación de ARAÑA (TipoVeneno va PRIMERO según tu constructor)
        ArrayList<String> dropsArania = crearLista("Hilo", "Ojo de araña");
        
        Arania arania1 = new Arania("Veneno I", "MOB-004", "Araña de Cueva", 12.0, 2.0, dropsArania);
        listaAranias.add(arania1);
        bestiarioGlobal.add(arania1);
    }
}