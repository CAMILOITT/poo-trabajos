package minecraft;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Estilo creeper centralizado:
 * - Aceptar/Guardar/Crear: verde + creeper.jpg
 * - Error/Cancelar/Regresar: rojo + creeper_rojo.png
 */
public final class CreeperStyle {

    public static final Color VERDE = new Color(62, 172, 62);
    public static final Color ROJO = new Color(200, 40, 40);

    private CreeperStyle() {}

    private static ImageIcon icono(String ruta) {
        try {
            Image img = new ImageIcon(CreeperStyle.class.getResource(ruta)).getImage()
                    .getScaledInstance(24, 24, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            return null;
        }
    }

    public static void aceptar(JButton b) {
        b.setBackground(VERDE);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        ImageIcon icon = icono("/Incons/creeper.jpg");
        if (icon != null) b.setIcon(icon);
    }

    public static void error(JButton b) {
        b.setBackground(ROJO);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        ImageIcon icon = icono("/Incons/creeper_rojo.png");
        if (icon != null) b.setIcon(icon);
    }
}
