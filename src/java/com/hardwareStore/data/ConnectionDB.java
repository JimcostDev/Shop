package com.hardwareStore.data;
//importar librerias para conectar a la bd

import java.sql.*;

public class ConnectionDB {

    //constructor privado para evitar la instancia
    private ConnectionDB() {
    }

    private static Connection cnx = null;

    /* el metodo estatico me permite invocarlo de cualquier parte de nuestro codigo 
    sin necesidad de realizar una instancia de esta clase*/
    public static Connection GetConnection() throws SQLException,
            ClassNotFoundException {
        //solamente la primera vez sera nula, por lo cual se establece la conexiòn
        if (cnx == null) {
            try {

                String server, dataBase, user, password = "";

                server = "localhost";
                dataBase = "shop";
                user = "UserShop";
                password = "1234567";

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                cnx = DriverManager.getConnection("jdbc:sqlserver://" + server + ":1433; databaseName=" + dataBase,
                        user,
                        password);
            } catch (Exception ex) {
                throw ex;
            }
        }

        return cnx;
    }

    public static void CloseConnection() throws SQLException {
        try {
            if (cnx != null) {
                cnx.close();
            }
        } catch (Exception ex) {
            throw ex;
        }

    }
}
