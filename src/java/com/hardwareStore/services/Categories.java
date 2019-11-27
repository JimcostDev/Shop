/**
    Author: Ronaldo Jimenez
    Create date: 2019-09-26
    Description: Search Categories
*/
package com.hardwareStore.services;
import java.sql.*;
import com.hardwareStore.data.ConnectionDB;
import java.util.ArrayList;
import java.util.List;

 
public class Categories {
    public List<com.hardwareStore.models.Categories> SearchCategories() throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call SearchCategories() }");//procedimiento de almacenado
            ResultSet rs = ps.executeQuery();
           
            
            //arrayList (arreglo dinamico)- array de objetos
            List<com.hardwareStore.models.Categories> listCategories = new ArrayList<>();
            
            //cuando el ejecute el procedimiento de almacenado, lo reccoremos atraves de un while
            while(rs.next()){
                //almacenamos los valores del PROC SearchCategories en la variable categories(ENCONTRAR CATEGORIAS)
                com.hardwareStore.models.Categories categories = new com.hardwareStore.models.Categories();
                categories.setId(rs.getInt("Id"));
                categories.setName(rs.getString("Name"));
                categories.setActive(rs.getBoolean("Active"));
                
                //a la lista(array de objetos) le añada el objeto categorias
                listCategories.add(categories);
            }
            
            return listCategories;
            
        } catch (Exception err) {
            throw err;
        }
    }
    
}
