package com.hardwareStore.services;

import java.sql.*;
import com.hardwareStore.data.ConnectionDB;

public class Account {

    /*
    Author: Ronaldo Jimenez
    Create date: 2019-08-31
    Description: Register User
     */
    //metodo vacio (void) porque no vamos retornar nada
    public void Register(String email,
            String password) throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call RegisterUser(?,?) }");//procedimiento de almacenado

            //enviar parametros email y password a RegisterUser()
            ps.setString(1, email);
            ps.setString(2, password);
            //ejecutar consulta
            ps.execute();
        } catch (Exception err) {
            throw err;
        }
    }
    public boolean Login(String email,
            String password) throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call LoginUser(?,?) }");//procedimiento de almacenado

            //enviar parametros email y password a RegisterUser()
            ps.setString(1, email);
            ps.setString(2, password);
            
            //retonar una consulta (ResultSet, variable que me permite guardar ese resultado)
            ResultSet rs = ps.executeQuery();
            boolean exists = false;
            
            //recorrer esa consulta (registro X registro) si retorna algo, existe
            while(rs.next()){
                //encontar registro valido (UserName & Password correctas)
               exists = true; 
            }
            return exists;
        } catch (Exception err) {
            throw err;
        }
    }
}
