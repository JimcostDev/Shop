/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.services;

import com.hardwareStore.data.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronaldo Jiménez
 * Create Date: 18/11/2019
 * Description: SEARCH METHODS PAYMENT
 */
public class MethodPayment {
    public List<com.hardwareStore.models.MethodPayment> SearchMethodsPayment() 
            throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call SearchMethodsPayment() }");//procedimiento de almacenado
            ResultSet rs = ps.executeQuery();
           
            
            //arrayList (arreglo dinamico)- array de objetos
            List<com.hardwareStore.models.MethodPayment> listMethodsPayment = new ArrayList<>();
            
            //cuando el ejecute el procedimiento de almacenado, lo reccoremos atraves de un while
            while(rs.next()){
                //almacenamos los valores del PROC SearchCategories en la variable categories(ENCONTRAR CATEGORIAS)
                com.hardwareStore.models.MethodPayment methodsPayment = new com.hardwareStore.models.MethodPayment();
                methodsPayment.setId(rs.getInt("Id"));
                methodsPayment.setName(rs.getString("Name"));
                methodsPayment.setActive(rs.getBoolean("Active"));
                
                //a la lista(array de objetos) le añada el objeto categorias
                listMethodsPayment.add(methodsPayment);
            }
            
            return listMethodsPayment;
            
        } catch (Exception err) {
            throw err;
        }
    }
    
    
}
