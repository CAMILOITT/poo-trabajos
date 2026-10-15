/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemacalculadora;
import javax.swing.JTextField;
/**
 *
 * @author DET PC
 */
public class JFrame_Calculadora extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrame_Calculadora.class.getName());

   
    public JFrame_Calculadora() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        ACbutton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        divButton = new javax.swing.JButton();
        number7 = new javax.swing.JButton();
        number8 = new javax.swing.JButton();
        number9 = new javax.swing.JButton();
        multiButton = new javax.swing.JButton();
        number4 = new javax.swing.JButton();
        number5 = new javax.swing.JButton();
        number6 = new javax.swing.JButton();
        minorButtom = new javax.swing.JButton();
        number1 = new javax.swing.JButton();
        number2 = new javax.swing.JButton();
        number3 = new javax.swing.JButton();
        sumButton = new javax.swing.JButton();
        number0 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        equalButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA CALCULADORA");
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(5, 4));

        ACbutton.setBackground(new java.awt.Color(255, 153, 51));
        ACbutton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        ACbutton.setText("A/C");
        ACbutton.addActionListener(this::ACbuttonActionPerformed);
        jPanel2.add(ACbutton);

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton3.setText("^");
        jPanel2.add(jButton3);

        jButton19.setBackground(new java.awt.Color(102, 102, 102));
        jButton19.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton19.setText("%");
        jPanel2.add(jButton19);

        divButton.setBackground(new java.awt.Color(102, 102, 102));
        divButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        divButton.setText("/");
        jPanel2.add(divButton);

        number7.setBackground(new java.awt.Color(153, 153, 153));
        number7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number7.setText("7");
        number7.addActionListener(this::number7ActionPerformed);
        jPanel2.add(number7);

        number8.setBackground(new java.awt.Color(153, 153, 153));
        number8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number8.setText("8");
        number8.addActionListener(this::number8ActionPerformed);
        jPanel2.add(number8);

        number9.setBackground(new java.awt.Color(153, 153, 153));
        number9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number9.setText("9");
        number9.addActionListener(this::number9ActionPerformed);
        jPanel2.add(number9);

        multiButton.setBackground(new java.awt.Color(102, 102, 102));
        multiButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        multiButton.setText("*");
        multiButton.addActionListener(this::multiButtonActionPerformed);
        jPanel2.add(multiButton);

        number4.setBackground(new java.awt.Color(153, 153, 153));
        number4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number4.setText("4");
        number4.addActionListener(this::number4ActionPerformed);
        jPanel2.add(number4);

        number5.setBackground(new java.awt.Color(153, 153, 153));
        number5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number5.setText("5");
        number5.addActionListener(this::number5ActionPerformed);
        jPanel2.add(number5);

        number6.setBackground(new java.awt.Color(153, 153, 153));
        number6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number6.setText("6");
        number6.addActionListener(this::number6ActionPerformed);
        jPanel2.add(number6);

        minorButtom.setBackground(new java.awt.Color(102, 102, 102));
        minorButtom.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        minorButtom.setText("-");
        minorButtom.setBorderPainted(false);
        jPanel2.add(minorButtom);

        number1.setBackground(new java.awt.Color(153, 153, 153));
        number1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number1.setText("1");
        number1.addActionListener(this::number1ActionPerformed);
        jPanel2.add(number1);

        number2.setBackground(new java.awt.Color(153, 153, 153));
        number2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number2.setText("2");
        number2.addActionListener(this::number2ActionPerformed);
        jPanel2.add(number2);

        number3.setBackground(new java.awt.Color(153, 153, 153));
        number3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number3.setText("3");
        number3.addActionListener(this::number3ActionPerformed);
        jPanel2.add(number3);

        sumButton.setBackground(new java.awt.Color(102, 102, 102));
        sumButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        sumButton.setText("+");
        sumButton.addActionListener(this::sumButtonActionPerformed);
        jPanel2.add(sumButton);

        number0.setBackground(new java.awt.Color(153, 153, 153));
        number0.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        number0.setText("0");
        number0.addActionListener(this::number0ActionPerformed);
        jPanel2.add(number0);

        jButton18.setBackground(new java.awt.Color(102, 102, 102));
        jButton18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton18.setText(",");
        jPanel2.add(jButton18);

        backButton.setBackground(new java.awt.Color(102, 102, 102));
        backButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        backButton.setText("<-");
        backButton.addActionListener(this::backButtonActionPerformed);
        jPanel2.add(backButton);

        equalButton.setBackground(new java.awt.Color(255, 153, 0));
        equalButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        equalButton.setText("=");
        equalButton.setBorder(null);
        jPanel2.add(equalButton);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jTextField2.setEditable(false);
        jTextField2.addActionListener(this::jTextField2ActionPerformed);
        jPanel3.add(jTextField2);

        jTextField1.setBorder(null);
        jTextField1.addActionListener(this::jTextField1ActionPerformed);
        jPanel3.add(jTextField1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void ACbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ACbuttonActionPerformed

    private void number3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number3ActionPerformed
        // TODO add your handling code here:
        
        String textoIngresado=jTextField2.getText()+"3";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number3ActionPerformed

    private void number7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number7ActionPerformed
        //se declara una variable local
        String textoIngresado=jTextField2.getText()+"7";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number7ActionPerformed

    private void sumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sumButtonActionPerformed

    private void number8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number8ActionPerformed
        // TODO add your handling code here:
        String textoIngresado=jTextField2.getText()+"8";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number8ActionPerformed

    private void number9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number9ActionPerformed
        // TODO add your handling code here:
        String textoIngresado=jTextField2.getText()+"9";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number9ActionPerformed

    private void number4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number4ActionPerformed
        // TODO add your handling code here:
        String textoIngresado=jTextField2.getText()+"4";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number4ActionPerformed

    private void number5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number5ActionPerformed
        // TODO add your handling code here:
        String textoIngresado=jTextField2.getText()+"5";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number5ActionPerformed

    private void number6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number6ActionPerformed
        // TODO add your handling code here:
        String textoIngresado=jTextField2.getText()+"6";
        jTextField2.setText(textoIngresado);
        
    }//GEN-LAST:event_number6ActionPerformed

    private void number1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number1ActionPerformed
        // TODO add your handling code here:
        
        String textoIngresado=jTextField2.getText()+"1";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number1ActionPerformed

    private void number2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number2ActionPerformed
        // TODO add your handling code here:
        String textoIngresado=jTextField2.getText()+"2";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number2ActionPerformed

    private void number0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_number0ActionPerformed
        // TODO add your handling code here:
        
        String textoIngresado=jTextField2.getText()+"0";
        jTextField2.setText(textoIngresado);
    }//GEN-LAST:event_number0ActionPerformed

    private void multiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_multiButtonActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrame_Calculadora().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACbutton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton divButton;
    private javax.swing.JButton equalButton;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton minorButtom;
    private javax.swing.JButton multiButton;
    private javax.swing.JButton number0;
    private javax.swing.JButton number1;
    private javax.swing.JButton number2;
    private javax.swing.JButton number3;
    private javax.swing.JButton number4;
    private javax.swing.JButton number5;
    private javax.swing.JButton number6;
    private javax.swing.JButton number7;
    private javax.swing.JButton number8;
    private javax.swing.JButton number9;
    private javax.swing.JButton sumButton;
    // End of variables declaration//GEN-END:variables
}
