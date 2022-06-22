/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package projectuas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 *
 * @author Khairiyah N Y M (222011626)
 */
public class StartPomodoro extends javax.swing.JPanel {

    private JScrollPane contentScrollPane;
    private static String task;
    
    Timer timer;
    int menit;
    int detik;
    
    /**
     * Creates new form Timer
     * @param contentScrollPane
     */
    public StartPomodoro(JScrollPane contentScrollPane) {
        initComponents();
        this.contentScrollPane = contentScrollPane;
        menit = 25;
        detik = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detikjLabel2 = new javax.swing.JLabel();
        menitjLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SelesaijButton2 = new javax.swing.JButton();
        KembalijButton3 = new javax.swing.JButton();
        MulaijButton4 = new javax.swing.JButton();
        taskjLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        detikjLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 1, 35)); // NOI18N
        detikjLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detikjLabel2.setPreferredSize(new java.awt.Dimension(50, 50));
        add(detikjLabel2);
        detikjLabel2.setBounds(260, 235, 50, 50);

        menitjLabel3.setFont(new java.awt.Font("Poppins ExtraBold", 1, 35)); // NOI18N
        menitjLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menitjLabel3.setPreferredSize(new java.awt.Dimension(50, 50));
        add(menitjLabel3);
        menitjLabel3.setBounds(188, 235, 50, 50);

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 1, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(":");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 50));
        add(jLabel4);
        jLabel4.setBounds(225, 235, 50, 50);

        SelesaijButton2.setBackground(new java.awt.Color(247, 190, 0));
        SelesaijButton2.setFont(new java.awt.Font("Poppins SemiBold", 0, 15)); // NOI18N
        SelesaijButton2.setText("Tandai Selesai");
        SelesaijButton2.setBorderPainted(false);
        SelesaijButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelesaijButton2ActionPerformed(evt);
            }
        });
        add(SelesaijButton2);
        SelesaijButton2.setBounds(180, 390, 140, 30);

        KembalijButton3.setBackground(new java.awt.Color(247, 190, 0));
        KembalijButton3.setFont(new java.awt.Font("Poppins SemiBold", 0, 15)); // NOI18N
        KembalijButton3.setText("Kembali");
        KembalijButton3.setBorderPainted(false);
        KembalijButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembalijButton3ActionPerformed(evt);
            }
        });
        add(KembalijButton3);
        KembalijButton3.setBounds(320, 440, 100, 30);

        MulaijButton4.setBackground(new java.awt.Color(247, 190, 0));
        MulaijButton4.setFont(new java.awt.Font("Poppins SemiBold", 0, 15)); // NOI18N
        MulaijButton4.setText("Mulai");
        MulaijButton4.setBorderPainted(false);
        MulaijButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MulaijButton4ActionPerformed(evt);
            }
        });
        add(MulaijButton4);
        MulaijButton4.setBounds(90, 440, 90, 30);

        taskjLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        taskjLabel.setForeground(new java.awt.Color(255, 255, 255));
        taskjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(taskjLabel);
        taskjLabel.setBounds(0, 93, 500, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\4\\PBO (P)\\Project UAS\\ProjectUAS\\pomodoro2.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void SelesaijButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelesaijButton2ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Yakin tugas telah dikerjakan?", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirm==0){
            try {
                Selesai();
                JOptionPane.showMessageDialog(this, "Kegiatan berhasil dihapus");
                contentScrollPane.setViewportView(new Pomodoro(contentScrollPane));
            } catch (SQLException ex) {
                Logger.getLogger(StartPomodoro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SelesaijButton2ActionPerformed

    private void KembalijButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembalijButton3ActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new Pomodoro(contentScrollPane));
    }//GEN-LAST:event_KembalijButton3ActionPerformed

    private void MulaijButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MulaijButton4ActionPerformed
        // TODO add your handling code here:
        hitungMundur();
    }//GEN-LAST:event_MulaijButton4ActionPerformed

    public void hitungMundur(){
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(detik<10)
                    detikjLabel2.setText("0"+detik);
                else
                    detikjLabel2.setText(""+detik);
                if(menit<10)
                    menitjLabel3.setText("0"+menit);
                else
                    menitjLabel3.setText(""+menit);
                if(detik==0){
                    menit--;
                    //jika menit <0 maka waktu habis
                    if(menit<0){
                        JOptionPane.showMessageDialog(null,
                            "Waktu habis, silahkan beristirahat");
                        timer.stop();
//                        System.exit(0);
                    }
                    detik = 60;
                }
                detik--;
            }
        });
        timer.start();
    }
    
    public static void Selesai() throws SQLException{
        Database.getInstance().hapusTaskPomodoro(taskjLabel.getText(),Login.getUsername());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KembalijButton3;
    private javax.swing.JButton MulaijButton4;
    private javax.swing.JButton SelesaijButton2;
    private javax.swing.JLabel detikjLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel menitjLabel3;
    public static javax.swing.JLabel taskjLabel;
    // End of variables declaration//GEN-END:variables
}
