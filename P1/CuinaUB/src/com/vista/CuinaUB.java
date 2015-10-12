/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.model.Ingredient;
import com.model.Menjar;
import com.model.Plat;
import com.model.Recepta;
import com.model.Xef;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Carlos Cortes i Pol Girbal
 */
public class CuinaUB {

    
    private Session session = null;

    static private enum OpcionsMenuPrincipal {

        OPT_RECEPTA, OPT_MENJAR, OPT_PLAT, OPT_XEF, OPT_INGREDIENT, SORTIR
    };

    static private enum OpcionsRecepta {

        MENU_S1_CREATE, MENU_S1_READ, MENU_S1_UPDATE, MENU_S1_DELETE, MENU_S1_SORTIR
    };

    static private enum OpcionsMenjar {

        MENU_S2_CREATE, MENU_S2_READ, MENU_S2_UPDATE, MENU_S2_DELETE, MENU_S2_SORTIR
    };

    static private enum OpcionsPlat {

        MENU_S3_CREATE, MENU_S3_READ, MENU_S3_UPDATE, MENU_S3_DELETE, MENU_S3_SORTIR
    };

    static private enum OpcionsXef {

        MENU_S4_CREATE, MENU_S4_READ, MENU_S4_UPDATE, MENU_S4_DELETE, MENU_S4_SORTIR
    };

    static private enum OpcionsIngredient {

        MENU_S5_CREATE, MENU_S5_READ, MENU_S5_UPDATE, MENU_S5_DELETE, MENU_S5_SORTIR
    };
    
    static private String[] descMenuPrincipal = {"CRUD Recepta", "CRUD Menjar",
        "CRUD Plat", "CRUD Xef", "CRUD Ingredient", "Sortir"};
    static private String[] descSubMenu1 = {"Create", "Read",
        "Update", "Delete", "Tornar al menú anterior"};
    static private String[] descSubMenu2 = {"Create", "Read",
        "Update", "Delete", "Tornar al menú anterior"};
    static private String[] descSubMenu3 = {"Create", "Read",
        "Update", "Delete", "Tornar al menú anterior"};
    static private String[] descSubMenu4 = {"Create", "Read",
        "Update", "Delete", "Tornar al menú anterior"};
    static private String[] descSubMenu5 = {"Create", "Read",
        "Update", "Delete", "Tornar al menú anterior"};

    private static final String user = "admin";
    private static final String pass = "admin";
    
    public CuinaUB() {

        try {

            session = ConnectHB.getSession();

        } catch (HibernateException e) {

            e.printStackTrace();
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (gestioLogin(sc)) {
            CuinaUB cuina = new CuinaUB();

            cuina.gestioMenuPrincipal(sc);
        } else {
            System.out.println("Torna-ho a intentar!");
        }

    }
    
    /**
     * Mètode per gestionar el login de l'aplicació
     * @param sc
     * @return 
     */
    private static boolean gestioLogin(Scanner sc) {

        boolean validate = false;

        String u, p;

        System.out.println("LOGIN");
        System.out.println("-----");
        System.out.print("User: ");
        u = sc.next();
        System.out.print("Pass: ");
        p = sc.next();

        if (u.equalsIgnoreCase(user) && p.equalsIgnoreCase(pass)) {
            validate = true;
        }

        return validate;
    }
    
    
    
    private void gestioMenuPrincipal(Scanner sc) {

        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());

        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio = null;
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {

                case OPT_RECEPTA:
                    gestioRecepta_CRUD(sc);
                    break;
                case OPT_MENJAR:
                    gestioMenjar_CRUD(sc);
                    break;
                case OPT_PLAT:
                    gestioPlat_CRUD(sc);
                    break;
                case OPT_XEF:
                    gestioXef_CRUD(sc);
                    break;
                case OPT_INGREDIENT:
                    gestioIngredient_CRUD(sc);
                    break;
                case SORTIR:
                    System.out.println("");
                    session.close();
                    break;
            }

        } while (opcio != OpcionsMenuPrincipal.SORTIR);
    }
    
    
    private void gestioRecepta_CRUD(Scanner sc) {

        Menu<OpcionsRecepta> menu = new Menu<OpcionsRecepta>("Operacions CRUD per Recepta", OpcionsRecepta.values());

        menu.setDescripcions(descSubMenu1);

        OpcionsRecepta opcio = null;
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S1_CREATE:
                    System.out.println("Has triat CREATE");
                    createRecepta(sc);
                    break;
                case MENU_S1_READ:
                    System.out.println("Has triat READ");
                    readRecepta(sc);
                    break;
                case MENU_S1_UPDATE:
                    System.out.println("Has triat UPDATE");
                    updateRecepta(sc);
                    break;
                case MENU_S1_DELETE:
                    System.out.println("Has triat DELETE");
                    deleteRecepta(sc);
                    break;
                case MENU_S1_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsRecepta.MENU_S1_SORTIR);
    }
    
    private void gestioMenjar_CRUD(Scanner sc) {

        Menu<OpcionsMenjar> menu = new Menu<OpcionsMenjar>("Operacions CRUD per tipus de menjar", OpcionsMenjar.values());

        menu.setDescripcions(descSubMenu1);

        OpcionsMenjar opcio = null;
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S2_CREATE:
                    System.out.println("Has triat CREATE");
                    createMenjar(sc);
                    break;
                case MENU_S2_READ:
                    System.out.println("Has triat READ");
                    readMenjar(sc);
                    break;
                case MENU_S2_UPDATE:
                    System.out.println("Has triat UPDATE");
                    updateMenjar(sc);
                    break;
                case MENU_S2_DELETE:
                    System.out.println("Has triat DELETE");
                    deleteMenjar(sc);
                    break;
                case MENU_S2_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsMenjar.MENU_S2_SORTIR);
    }
    
    private void gestioPlat_CRUD(Scanner sc) {

        Menu<OpcionsPlat> menu = new Menu<OpcionsPlat>("Operacions CRUD per tipus de plat", OpcionsPlat.values());

        menu.setDescripcions(descSubMenu1);

        OpcionsPlat opcio = null;
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S3_CREATE:
                    System.out.println("Has triat CREATE");
                    createPlat(sc);
                    break;
                case MENU_S3_READ:
                    System.out.println("Has triat READ");
                    readPlat(sc);
                    break;
                case MENU_S3_UPDATE:
                    System.out.println("Has triat UPDATE");
                    updatePlat(sc);
                    break;
                case MENU_S3_DELETE:
                    System.out.println("Has triat DELETE");
                    deletePlat(sc);
                    break;
                case MENU_S3_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsPlat.MENU_S3_SORTIR);
    }
    
    
    private void gestioXef_CRUD(Scanner sc) {

        Menu<OpcionsXef> menu = new Menu<OpcionsXef>("Operacions CRUD per Xef", OpcionsXef.values());

        menu.setDescripcions(descSubMenu1);

        OpcionsXef opcio = null;
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S4_CREATE:
                    System.out.println("Has triat CREATE");
                    createXef(sc);
                    break;
                case MENU_S4_READ:
                    System.out.println("Has triat READ");
                    readXef(sc);
                    break;
                case MENU_S4_UPDATE:
                    System.out.println("Has triat UPDATE");
                    updateXef(sc);
                    break;
                case MENU_S4_DELETE:
                    System.out.println("Has triat DELETE");
                    deleteXef(sc);
                    break;
                case MENU_S4_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsXef.MENU_S4_SORTIR);
    }
    
    private void gestioIngredient_CRUD(Scanner sc) {

        Menu<OpcionsIngredient> menu = new Menu<OpcionsIngredient>("Operacions CRUD per Ingredient", OpcionsIngredient.values());

        menu.setDescripcions(descSubMenu1);

        OpcionsIngredient opcio = null;
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case MENU_S5_CREATE:
                    System.out.println("Has triat CREATE");
                    createIngredient(sc);
                    break;
                case MENU_S5_READ:
                    System.out.println("Has triat READ");
                    readIngredient(sc);
                    break;
                case MENU_S5_UPDATE:
                    System.out.println("Has triat UPDATE");
                    updateIngredient(sc);
                    break;
                case MENU_S5_DELETE:
                    System.out.println("Has triat DELETE");
                    deleteIngredient(sc);
                    break;
                case MENU_S5_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsIngredient.MENU_S5_SORTIR);
    }
    
    
    private void createRecepta(Scanner sc) {
        
        Transaction tx = session.beginTransaction();
        System.out.println("\n-Nom de la recepta?");
        String nom = sc.nextLine();
        System.out.println("\n-Elaboracio?");
        String elaboracio = sc.nextLine();
        System.out.println("\n-Temps?");
        int temps = sc.nextInt();
        System.out.println("\n-Dificultat?");
        int dificultat = sc.nextInt();
        Recepta r = new Recepta();
        r.setNom(nom);
        r.setElaboracio(elaboracio);
        r.setTemps(temps);
        r.setDificultat(dificultat);
        session.save(r);
        tx.commit();

    }
    
    private void readRecepta(Scanner sc) {
        Transaction tx = session.beginTransaction();

        System.out.println("\n-Registres de receptes: ");

        List<Recepta> listado = new ArrayList<Recepta>();
        Query q = session.createQuery("from Recepta");
        listado = q.list();

        System.out.println("id_recepta\t nom_recepta\t elaboracio\t temps\t dificultat");
        System.out.println("-----------------");
        for (Recepta r : listado) {
            System.out.println(r.getIdRecepta() + "\t\t" + r.getNom() + "\t\t" + r.getElaboracio() + "\t\t" + r.getTemps() + "\t\t" + r.getDificultat());
        }
        tx.commit();

    }
    
    private void updateRecepta(Scanner sc) {
        readRecepta(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuina recepta vols actualitzar? (inserta id)");
        int id = sc.nextInt();

        Recepta r = (Recepta) session.get(Recepta.class, id);

        System.out.println("\nIntrodueix nou nom per aquesta recepta:");
        String nom = sc.next();
        r.setNom(nom);
        sc.nextLine();
        System.out.println("\nIntrodueix nova elaboracio per aquesta recepta:");
        String elaboracio = sc.nextLine();
        r.setElaboracio(elaboracio);
        session.update(r);
        tx.commit();
            
    }
    
    private void deleteRecepta(Scanner sc) {
        readRecepta(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuina recepta vols eliminar? (inserta id)");
        int id = sc.nextInt();

        Recepta r = (Recepta) session.get(Recepta.class, id);
        session.delete(r);
        tx.commit();

    }
    
    private void createMenjar(Scanner sc) {
        
        Transaction tx = session.beginTransaction();
        System.out.println("\n-Nom del menjar?");
        String nom = sc.nextLine();
        System.out.println("\n-Descripcio?");
        String descripcio = sc.nextLine();
        Menjar m = new Menjar();
        m.setNom(nom);
        m.setDescripcio(descripcio);
        session.save(m);
        tx.commit();
        
    }
    
    private void readMenjar(Scanner sc) {
        Transaction tx = session.beginTransaction();

        System.out.println("\n-Registres de menjars: ");

        List<Menjar> listado = new ArrayList<Menjar>();
        Query q = session.createQuery("from Menjar");
        listado = q.list();

        System.out.println("id_menjar\t nom_menjar\t descripcio");
        System.out.println("-----------------");
        for (Menjar m : listado) {
            System.out.println(m.getIdMenjar() + "\t\t" + m.getNom() + "\t\t" + m.getDescripcio());
        }
        tx.commit();
    }
    
    private void updateMenjar(Scanner sc) {
        
        readMenjar(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin menjar vols actualitzar? (inserta id)");
        int id = sc.nextInt();

        Menjar m = (Menjar) session.get(Menjar.class, id);

        System.out.println("\nIntrodueix nou nom per aquest menjar:");
        String nom = sc.next();
        m.setNom(nom);
        sc.nextLine();
        System.out.println("\nIntrodueix nova descripcio per aquest menjar:");
        String descripcio = sc.nextLine();
        m.setDescripcio(descripcio);
        session.update(m);
        tx.commit();
        
    }
    
    private void deleteMenjar(Scanner sc) {
        readMenjar(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin menjar vols eliminar? (inserta id)");
        int id = sc.nextInt();

        Menjar m = (Menjar) session.get(Menjar.class, id);
        session.delete(m);
        tx.commit();
    }
    
    private void createPlat(Scanner sc) {
        Transaction tx = session.beginTransaction();
        System.out.println("\n-Nom del plat?");
        String nom = sc.nextLine();
        System.out.println("\n-Descripcio?");
        String descripcio = sc.nextLine();
        Plat p = new Plat();
        p.setNom(nom);
        p.setDescripcio(descripcio);
        session.save(p);
        tx.commit();
    }
    
    private void readPlat(Scanner sc) {
        Transaction tx = session.beginTransaction();

        System.out.println("\n-Registres de plats: ");

        List<Plat> listado = new ArrayList<Plat>();
        Query q = session.createQuery("from Plat");
        listado = q.list();

        System.out.println("id_plat\t nom_plat\t descripcio");
        System.out.println("-----------------");
        for (Plat p : listado) {
            System.out.println(p.getIdPlat() + "\t\t" + p.getNom()+ "\t\t" + p.getDescripcio());
        }
        tx.commit();
    }
    
    private void updatePlat(Scanner sc) {
        readPlat(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin plat vols actualitzar? (inserta id)");
        int id = sc.nextInt();

        Plat p = (Plat) session.get(Plat.class, id);
        
        System.out.println("\nIntrodueix nou nom per aquest plat:");
        String nom = sc.nextLine();
        p.setNom(nom);
        sc.nextLine();
        System.out.println("\nIntrodueix nova descripcio per aquest plat:");
        String descripcio = sc.nextLine();
        p.setDescripcio(descripcio);
        session.update(p);
        tx.commit();
    }
    
    private void deletePlat(Scanner sc) {
        readPlat(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin plat vols eliminar? (inserta id)");
        int id = sc.nextInt();

        Plat p = (Plat) session.get(Plat.class, id);
        session.delete(p);
        tx.commit();
    }
    
    private void createXef(Scanner sc) {
        
        Transaction tx = session.beginTransaction();
        System.out.println("\n-Nom del xef?");
        String nom = sc.nextLine();
        System.out.println("\n-Estrelles?");
        int estrelles = sc.nextInt();
        Xef x = new Xef();
        x.setNom(nom);
        x.setEstrelles(estrelles);
        session.save(x);
        tx.commit();
        
    }
    
    private void readXef(Scanner sc) {
        Transaction tx = session.beginTransaction();

        System.out.println("\n-Registres de xefs: ");

        List<Xef> listado = new ArrayList<Xef>();
        Query q = session.createQuery("from Xef");
        listado = q.list();

        System.out.println("id_xef\t nom_xef\t estrelles");
        System.out.println("-----------------");
        for (Xef x : listado) {
            System.out.println(x.getIdXef() + "\t\t" + x.getNom() + "\t\t" + x.getEstrelles());
        }
        tx.commit();
    }
    
    private void updateXef(Scanner sc) {
        readXef(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin xef vols actualitzar? (inserta id)");
        int id = sc.nextInt();

        Xef x = (Xef) session.get(Xef.class, id);

        System.out.println("\nIntrodueix nou nom per aquest xef:");
        String nom = sc.nextLine();
        x.setNom(nom);
        sc.nextLine();
        System.out.println("\nIntrodueix les noves estrelles per aquest xef:");
        int estrelles = sc.nextInt();
        x.setEstrelles(estrelles);
        session.update(x);
        tx.commit();
    }
    
    private void deleteXef(Scanner sc) {
        readXef(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin xef vols eliminar? (inserta id)");
        int id = sc.nextInt();

        Xef x = (Xef) session.get(Xef.class, id);
        session.delete(x);
        tx.commit();
    }
    
    private void createIngredient(Scanner sc) {
        Transaction tx = session.beginTransaction();
        System.out.println("\n-Nom de l'ingredient?");
        String nom = sc.nextLine();
        System.out.println("\n-Refrigeracio? (SI o NO)");
        String r = sc.next();
        Ingredient i = new Ingredient();
        if (r.equals("SI")) {
            i.setRefrigeracio(true);
        }
        else {
            i.setRefrigeracio(false);
        }
        
        i.setNom(nom);
        session.save(i);
        tx.commit();
    }
    
    private void readIngredient(Scanner sc) {
        Transaction tx = session.beginTransaction();

        System.out.println("\n-Registres de ingredients: ");

        List<Ingredient> listado = new ArrayList<Ingredient>();
        Query q = session.createQuery("from Ingredient");
        listado = q.list();

        System.out.println("id_ingredient\t nom_ingredient");
        System.out.println("-----------------");
        for (Ingredient i : listado) {
            System.out.println(i.getIdIngredient() + "\t\t" + i.getNom());
        }
        tx.commit();
    }
    
    private void updateIngredient(Scanner sc) {
        
    }
    
    private void deleteIngredient(Scanner sc) {
        readIngredient(sc);

        Transaction tx = session.beginTransaction();

        System.out.println("\nQuin ingredient vols eliminar? (inserta id)");
        int id = sc.nextInt();

        Ingredient i = (Ingredient) session.get(Ingredient.class, id);
        session.delete(i);
        tx.commit();
    }
}
