package archivorandomico;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoRandomico {

    public static void main(String[] args) {
        new JFrameRegistro().setVisible(true);
    }

    public void guardarRegistro(String clave, String nombre, int edad) throws IOException {
        RandomAccessFile archivo = new RandomAccessFile("ArchivoEjercicio.dat", "rw");
        archivo.seek(archivo.length());
        archivo.writeUTF(clave);
        archivo.writeUTF(nombre);
        archivo.writeInt(edad);
        archivo.close();
    }
}