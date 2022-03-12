package com.connexion;
//connection is an object of type connection that is for the java class

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

    private static Connection conex;
    private String url = "jdbc:postgresql://localhost:5432/ccms"; //path/link
    private String user = "postgres";
    private String pwd = "admin";

    private Connexion() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("error of driver : " + e.getMessage());
        }
        try {
            conex = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("error of connexion : " + e.getMessage());
        }
    }

    //we now create a constructor (Connection)
    public static Connection seconnecter() {
        if (conex == null) {
            Connexion connexion = new Connexion();
        }
        return conex;
    }
}
