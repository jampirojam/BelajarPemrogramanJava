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
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Mach Rojamz
 */
public class Masuk {
    
    public static void Masuk() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Pilih nomor table yang ingin di buat :");
        System.out.println("1. Dosen");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Mata Kuliah");
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
        }
        System.exit(0);
    }

    public static void Dosen() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session s = new PPBY().getSessionFactory().openSession();
        s.getTransaction().begin();
        try {
            Dosen d = new Dosen();
            System.out.println("NIP             : ");
            String n = input.readLine();
            d.setNid(n);
            System.out.println("Nama            : ");
            String nm = input.readLine();
            d.setNamados(nm);
            System.out.println("Jenis Kelamin   : ");
            String jk = input.readLine();
            d.setJkdos(jk);
            System.out.println("No. Telp.       : ");
            String np = input.readLine();
            d.setNpdos(np);
            System.out.println("Alamat          : ");
            String alm = input.readLine();
            d.setAlamatdos(alm);
            s.save(d);
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
            Mahasiswa d = new Mahasiswa();
            System.out.println("NIM             : ");
            String n = input.readLine();
            d.setNim(n);
            System.out.println("Nama            : ");
            String nm = input.readLine();
            d.setNamamhs(nm);
            System.out.println("Jenis Kelamin   : ");
            String jk = input.readLine();
            d.setJkmhs(jk);
            System.out.println("No. Telp.       : ");
            String np = input.readLine();
            d.setNpmhs(np);
            System.out.println("Alamat          : ");
            String alm = input.readLine();
            d.setAlamatmhs(alm);
            s.save(d);
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
            Matakuliah mat = new Matakuliah();
            System.out.println("Kode            : ");
            String n = input.readLine();
            mat.setKodemk(n);
            System.out.println("Nama            : ");
            String nm = input.readLine();
            mat.setNamamk(nm);
            s.save(mat);
            s.getTransaction().commit();
            s.close();
        } catch (HibernateException x) {
            System.out.println(String.valueOf(x));
        }
    }
}

