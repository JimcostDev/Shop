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
 * create date: 15/11/2019
 * description: SEARCH CUSTOMER
 */
public class Customers {

    public List<com.hardwareStore.models.Customer> SearchCustomer(String userName
    ) throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call SearchCustomer(?) }");//procedimiento de almacenado

            // //enviar parametros  a SearchProducts() 
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            //arrayList (arreglo dinamico)- array de objetos
            List<com.hardwareStore.models.Customer> listCustomer = new ArrayList<>();

            //cuando el ejecute el procedimiento de almacenado, lo reccoremos atraves de un while
            while (rs.next()) {
                
                com.hardwareStore.models.Customer customer = new com.hardwareStore.models.Customer();
                customer.setId(rs.getInt("Id"));
                customer.setDocumentTypeId(rs.getInt("DocumentTypeId"));//FK

                //creamos el objeto documentTypes (asignamos la llave foranea - FK)
                com.hardwareStore.models.DocumentTypes documentTypes = new com.hardwareStore.models.DocumentTypes();
                documentTypes.setId(rs.getInt("DocumentTypeId"));
                documentTypes.setName(rs.getString("DocumentTypeName"));
                //el objeto documentTypes esta inmerso en customer, por eso le enviamos dicho objeto 
                customer.setDocumentTypes(documentTypes);// FK
                
                customer.setDocumentNumber(rs.getString("DocumentNumber"));
                customer.setFirstName(rs.getString("FirstName"));
                customer.setSecondName(rs.getString("SecondName"));
                customer.setSurname(rs.getString("Surname"));
                customer.setSecondSurname(rs.getString("SecondSurname"));
                customer.setTelephone(rs.getString("Telephone"));
                customer.setAddress(rs.getString("Address"));
                customer.setCityId(rs.getInt("CityId"));//FK
                
                //creamos cities (asignamos la llave foranea - FK)
                com.hardwareStore.models.Cities cities = new com.hardwareStore.models.Cities();
                cities.setId(rs.getInt("CityId"));
                cities.setName(rs.getString("CityName"));
                //el objeto cities esta inmerso en customer, por eso le enviamos dicho objeto 
                customer.setCities(cities);// FK
                
                customer.setUserId(rs.getInt("UserId"));//fk--solo traemos el id
           
                //a la lista(array de objetos) le añada el objeto customer
                listCustomer.add(customer);
            }

            return listCustomer;

        } catch (Exception err) {
            throw err;
        }
    }
}
