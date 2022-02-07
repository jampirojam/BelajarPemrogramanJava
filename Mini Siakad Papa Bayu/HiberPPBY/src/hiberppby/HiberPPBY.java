/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberppby;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mach Rojamz
 */
public class HiberPPBY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Apa yang ingin Anda lakukan? ");
        System.out.println("1. Insert");
        System.out.println("2. Select");
        System.out.println("3. Delete");
        System.out.println("4. Update");
        System.out.println("5, Keluar");
        System.out.print("Masukan Pilihan : ");
        int a = input.nextInt();
        switch (a) {
            case 1 :
                Masuk.Masuk();
                break;
                
                case 2 :
                Pilih.Pilih();
                break;
                
                case 3 :
                Hapus.Hapus();
                break;
                
                case 4 :
                Ubah.Ubah();
                break;
                
                case 5 :
                System.exit(0);
                break;
        }
     /*   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Utama().setVisible(true);
            }
        });*/
    }

}
