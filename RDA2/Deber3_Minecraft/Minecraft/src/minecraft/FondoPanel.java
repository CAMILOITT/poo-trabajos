package minecraft;

/**
 * Panel con imagen de fondo escalada (src/Incons/image.png).
 * Clase publica para que el editor de NetBeans pueda instanciarla
 * en el disenador (arrastrar / ver vista previa).
 */
public class FondoPanel extends javax.swing.JPanel {

    private java.awt.Image imagenFondo;

    public FondoPanel() {
        try {
            java.net.URL url = getClass().getResource("/Incons/image.png");
            if (url != null) {
                imagenFondo = new javax.swing.ImageIcon(url).getImage();
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FondoPanel.class.getName())
                    .warning("No se pudo cargar imagen de fondo: " + ex.getMessage());
        }
        setLayout(new java.awt.BorderLayout());
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
