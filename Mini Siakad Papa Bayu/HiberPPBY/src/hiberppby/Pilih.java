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
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mach Rojamz
 */
public class Pilih {
    
    public static void Pilih() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Pilih nomor table yang ingin di create :");
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
            case 4 :
                System.exit(0);
                break;
             
        }
        System.exit(0);
    }

    public static void Dosen() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            System.out.println("NIP             : ");
            String nip = input.readLine();
            System.out.println();
            Query z = s.createQuery("from Dosen where nid like :nid");
            z.setParameter("nip", "%" + nip + "%");
            List l = z.list();
            Iterator i = l.iterator();
            while (i.hasNext()) {
                Dosen d = (Dosen) i.next();
                System.out.print("NIP           : ");
                System.out.println(d.getNid());
                System.out.print("Nama          : ");
                System.out.println(d.getNamados());
                System.out.print("Jenis Kelamin : ");
                System.out.println(d.getJkdos());
                System.out.print("No. Telp.     : ");
                System.out.println(d.getNpdos());
                System.out.print("Alamat        : ");
                System.out.println(d.getAlamatdos());
            }
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        }
    }

    public static void Mahasiswa() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            System.out.print("NIM           : ");
            String nim = input.readLine();
            System.out.println();
            Query m = s.createQuery("from Mahasiswa where nim like :nim");
            m.setParameter("nim", "%" + nim + "%");
            List l = m.list();
            Iterator i = l.iterator();
            while (i.hasNext()) {
                Mahasiswa d = (Mahasiswa) i.next();
                System.out.print("NIM           : ");
                System.out.println(d.getNim());
                System.out.print("Nama          : ");
                System.out.println(d.getNamamhs());
                System.out.print("Jenis Kelamin : ");
                System.out.println(d.getJkmhs());
                System.out.print("No. Telp.     : ");
                System.out.println(d.getNpmhs());
                System.out.print("Alamat        : ");
                System.out.println(d.getAlamatmhs());
            }
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        }
    }

    public static void MataKuliah() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            System.out.println("Kode            : ");
            String Kodemk = input.readLine();
            System.out.println();
            Query m = s.createQuery("from Matakuliah where Kodemk like :Kodemk");
            m.setParameter("Kodemk", "%" + Kodemk + "%");
            List l = m.list();
            Iterator i = l.iterator();
            while (i.hasNext()) {
                Matakuliah mat = (Matakuliah) i.next();
                System.out.print("Kode          : ");
                System.out.println(mat.getKodemk());
                System.out.print("Nama          : ");
                System.out.println(mat.getNamamk());
            }
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        }
    }
}

