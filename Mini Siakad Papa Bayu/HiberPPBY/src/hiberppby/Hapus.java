/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberppby;

import Hibernate.Dosen;
import Hibernate.Mahasiswa;
import Hibernate.Matakuliah;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.sql.Delete;

/**
 *
 * @author Mach Rojamz
 */
public class Hapus {
    
public static void Hapus() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Pilih nomor table yang ingin di buat:");
        System.out.println("1. Dosen");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Mata Kuliah");
        System.out.println("4. Keluar");
        System.out.println("Masukan Pilihan : ");
        int c = Integer.parseInt(input.readLine());
        switch (c) {
            case 1:
                Dosen();
                break;

            case 2:
                Mahasiswa();
                break;

            case 3:
                MataKuliah();
                break;
            case 4:
                System.exit(0);
                break;
        }
        System.exit(0);
    }

    public static void Dosen() {
        //delete
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            Dosen d = new Dosen();
            System.out.println("NIP         : ");
            String n = input.readLine();
            Query z = s.createQuery("delete Dosen where nid like :nid");
            z.setParameter("nip", "%" + n + "%");
            z.executeUpdate();
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        } catch (IOException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Mahasiswa() {
        //delete
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            Mahasiswa ma = new Mahasiswa();
            System.out.println("NIM         : ");
            String n = input.readLine();
            Query z = s.createQuery("delete mahasiswa where nim like :nim");
            z.setParameter("nim", "%" + n + "%");
            z.executeUpdate();
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        } catch (IOException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void MataKuliah() {
        //delete
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            Matakuliah ma = new Matakuliah();
            System.out.println("Kode        : ");
            String n = input.readLine();
            Query z = s.createQuery("delete matakuliah where Kodemk like :Kodemk");
            z.setParameter("Kodemk", "%" + n + "%");
            z.executeUpdate();
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        } catch (IOException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
