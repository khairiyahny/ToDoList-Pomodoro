/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package projectuas;

import javax.swing.JScrollPane;

/**
 *
 * @author Khairiyah N Y M (222011626)
 */
public class SelamatDatang extends javax.swing.JPanel {
    
    private JScrollPane contentScrollPane;

    /**
     * Creates new form SelamatDatang
     * @param contentScrollPane
     */
    public SelamatDatang(JScrollPane contentScrollPane) {
        initComponents();
        this.contentScrollPane = contentScrollPane;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(null);

        jButton1.setFont(new java.awt.Font("Poppins SemiBold", 0, 16)); // NOI18N
        jButton1.setText("Selanjutnya...");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(140, 400, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\4\\PBO (P)\\Project UAS\\ProjectUAS\\welcome.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new Login(contentScrollPane));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
