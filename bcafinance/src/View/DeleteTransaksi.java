/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.ConfigSession;
import Hibernate.Transaksi;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author GEMBUL
 */
public class DeleteTransaksi extends javax.swing.JDialog {

    /**
     * Creates new form DeleteTransaksi
     */
    Transaksi b = new Transaksi();

    public DeleteTransaksi(java.awt.Frame parent, boolean modal, String id) {
        super(parent, modal);
        try {
            Session session = ConfigSession.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Transaksi where id = :id");
            query.setParameter("id", id);
            List ls = query.list();
            Iterator it = ls.iterator();
            while (it.hasNext()) {
                b = (Transaksi) it.next();
            }
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        initComponents();
        SettingTanggal();

        jidTrans.setText(b.getId());
        jnomTrans.setText(String.valueOf(b.getNominal()));
        jtransTran.setSelectedItem(String.valueOf(b.getJenis()));
        jidnaTrans.setText(b.getId_saldo());
    }

    public void SettingTanggal() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime sekarang = LocalDateTime.now();
        insertTanggal.setText(dtf.format(sekarang));
        System.out.println(dtf.format(sekarang));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertTanggal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jidTrans = new javax.swing.JTextField();
        jidnaTrans = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jnomTrans = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtransTran = new javax.swing.JComboBox<>();
        bersihTrans = new javax.swing.JButton();
        deleteTrans = new javax.swing.JButton();
        balikTrans = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        insertTanggal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        insertTanggal.setText("TANGGAL");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("INSERT TRANSAKSI");

        jLabel2.setText("KODE TRANSAKSI");

        jLabel3.setText("ID NASABAH");

        jLabel4.setText("NOMINAL");

        jLabel6.setText("JENIS TRANSAKSI");

        jtransTran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kredit", "Debet" }));

        bersihTrans.setText("CLEAR");
        bersihTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bersihTransActionPerformed(evt);
            }
        });

        deleteTrans.setText("DELETE");
        deleteTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTransActionPerformed(evt);
            }
        });

        balikTrans.setText("BACK");
        balikTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balikTransActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtransTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jidTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(jidnaTrans)
                                    .addComponent(jnomTrans))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(insertTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(balikTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(bersihTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTrans)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(insertTanggal)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jidTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jidnaTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnomTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtransTran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteTrans)
                    .addComponent(bersihTrans)
                    .addComponent(balikTrans))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bersihTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersihTransActionPerformed
        jidTrans.setText(null);
        jidnaTrans.setText(null);
        jnomTrans.setText(null);
        jtransTran.setSelectedItem(null);       // TODO add your handling code here:
    }//GEN-LAST:event_bersihTransActionPerformed

    private void balikTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balikTransActionPerformed
        new MainMenu().setVisible(true);
        this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_balikTransActionPerformed

    private void deleteTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTransActionPerformed
        try {
            Session session = ConfigSession.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(b);
            session.getTransaction().commit();
            JOptionPane.showMessageDialog(this, "Hapus Berhasil");
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(this, "Hapus Gagal");
            he.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteTransActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeleteTransaksi dialog = new DeleteTransaksi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton balikTrans;
    private javax.swing.JButton bersihTrans;
    private javax.swing.JButton deleteTrans;
    private javax.swing.JLabel insertTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jidTrans;
    private javax.swing.JTextField jidnaTrans;
    private javax.swing.JTextField jnomTrans;
    private javax.swing.JComboBox<String> jtransTran;
    // End of variables declaration//GEN-END:variables
}