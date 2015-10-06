/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Carlos Cortes i Pol Girbal
 */
public class CuinaUB {

    
    private Session session = null;

    static private enum OpcionsMenuPrincipal {

        OPT_RECEPTA, OPT_FAMILIA, OPT_MENJAR, OPT_PLAT, OPT_XEF, OPT_INGREDIENT, SORTIR
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
                    break;
                case MENU_S1_READ:
                    System.out.println("Has triat READ");
                    break;
                case MENU_S1_UPDATE:
                    System.out.println("Has triat UPDATE");
                    break;
                case MENU_S1_DELETE:
                    System.out.println("Has triat DELETE");
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
                    break;
                case MENU_S2_READ:
                    System.out.println("Has triat READ");
                    break;
                case MENU_S2_UPDATE:
                    System.out.println("Has triat UPDATE");
                    break;
                case MENU_S2_DELETE:
                    System.out.println("Has triat DELETE");
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
                    break;
                case MENU_S3_READ:
                    System.out.println("Has triat READ");
                    break;
                case MENU_S3_UPDATE:
                    System.out.println("Has triat UPDATE");
                    break;
                case MENU_S3_DELETE:
                    System.out.println("Has triat DELETE");
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
                    break;
                case MENU_S4_READ:
                    System.out.println("Has triat READ");
                    break;
                case MENU_S4_UPDATE:
                    System.out.println("Has triat UPDATE");
                    break;
                case MENU_S4_DELETE:
                    System.out.println("Has triat DELETE");
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
                    break;
                case MENU_S5_READ:
                    System.out.println("Has triat READ");
                    break;
                case MENU_S5_UPDATE:
                    System.out.println("Has triat UPDATE");
                    break;
                case MENU_S5_DELETE:
                    System.out.println("Has triat DELETE");
                    break;
                case MENU_S5_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while (opcio != OpcionsIngredient.MENU_S5_SORTIR);
    }
}
