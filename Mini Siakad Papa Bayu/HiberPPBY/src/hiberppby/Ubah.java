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
public class Ubah {
    
    public static void Ubah() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));

        System.out.println("1. Dosen");
        System.out.println("2. Mahasiswa");
        System.out.println("3. Mata Kuliah");
        System.out.println("4. Keluar");
        System.out.println("Pilih Nomor Pilihan : ");
        int a = Integer.parseInt(input.readLine());
        switch (a) {
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

    public static void Dosen() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session ses = new PPBY().getSessionFactory().openSession();
        ses.getTransaction().begin();
        try {
            System.out.println("NIP             : ");
            String n = input.readLine();
            Dosen d = new Dosen();
            d = (Dosen) ses.get(Dosen.class, n);
            System.out.println("UPDATE DOSEN");
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

            ses.update(d);

            ses.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(String.valueOf(e));
        }
    }

    public static void Mahasiswa() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session ses = new PPBY().getSessionFactory().openSession();
        ses.getTransaction().begin();
        try {
            System.out.println("NIm             : ");
            String n = input.readLine();
            Mahasiswa d = new Mahasiswa();
            d = (Mahasiswa) ses.get(Mahasiswa.class, n);
            System.out.println("UPDATE MAHASISWA");
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

            ses.update(d);

            ses.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(String.valueOf(e));
        }
    }

    public static void MataKuliah() throws IOException {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        Session ses = new PPBY().getSessionFactory().openSession();
        ses.getTransaction().begin();
        try {
            System.out.println("Kode            : ");
            String n = input.readLine();
            Matakuliah mat = new Matakuliah();
            mat = (Matakuliah) ses.get(Matakuliah.class, n);
            System.out.println("UPDATE MATA KULIAH");
            mat.setKodemk(n);
            System.out.println("Nama            : ");
            String nam = input.readLine();
            mat.setNamamk(nam);

            ses.update(mat);

            ses.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(String.valueOf(e));
        }
    }
}

