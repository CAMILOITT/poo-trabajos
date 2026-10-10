/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.administrativo;
import java.util.ArrayList;

/**
 *
 * @author mnobo
 */
public class SistemaAdministrativo {
    
    static int numeroDeDocentesConMaestriaODoctorado(String nivelDeFormacion, ArrayList<Docente> listaDocentes)
    {
        int contador=0;
        
        for (int i= 0; i < listaDocentes.size(); i++)
        {
            if (listaDocentes.get(i).getNivelDeFormacion().equals(nivelDeFormacion))
            {
                contador++;
            }
        }
        
        return contador;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList listaDocentes = new ArrayList();
        ArrayList<String> listaMaterias = new ArrayList();
        ArrayList<String> listaDeCargos = new ArrayList();
        
        JFrame_SistemaAdministrativo menu = new JFrame_SistemaAdministrativo(listaDocentes, listaMaterias, listaDeCargos);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
    
}
