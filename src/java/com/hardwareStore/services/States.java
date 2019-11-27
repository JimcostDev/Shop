/**
    Author: Ronaldo Jimenez
    Create date: 2019-09-26
    Description: Check state
*/
package com.hardwareStore.services;
import java.sql.*;
import com.hardwareStore.data.ConnectionDB;
import java.util.ArrayList;
import java.util.List;

public class States {
     public List<com.hardwareStore.models.States> CheckState() throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call CheckState() }");//procedimiento de almacenado
            ResultSet rs = ps.executeQuery();
           
            
            //arrayList (arreglo dinamico)- array de objetos
            List<com.hardwareStore.models.States> listStates = new ArrayList<>();
            
            //cuando el ejecute el procedimiento de almacenado, lo reccoremos atraves de un while
            while(rs.next()){
                //almacenamos los valores del PROC CheckState en la variable states(verificar estado)
                com.hardwareStore.models.States states = new com.hardwareStore.models.States();
                states.setId(rs.getInt("Id"));
                states.setName(rs.getString("Name"));
                states.setActive(rs.getBoolean("Active"));
                
                //a la lista(array de objetos) le añada el objeto estados
                listStates.add(states);
            }
            
            return listStates;
            
        } catch (Exception err) {
            throw err;
        }
    }
    
}
