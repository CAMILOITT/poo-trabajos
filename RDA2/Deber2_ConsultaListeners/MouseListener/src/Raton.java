
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Raton implements java.awt.event.MouseListener {

    private JLabel mensaje;

    public Raton(JLabel mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mensaje.setText("Clic en x=" + e.getX() + " y=" + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        mensaje.setText("El mouse entró al botón");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mensaje.setText("El mouse salió del botón");
    }
}

