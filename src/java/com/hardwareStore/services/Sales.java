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

/*
    Author: Ronaldo Jimenez
    Create date: 19/11/2019
    Description: Sales Complete
 */
public class Sales {

    //metodo vacio (void) porque no vamos retornar nada
    public int SalesComplete(int methodPaymentId,
            double totalValue,
            int customerId,
            int productId,
            int quantity,
            double subtotalValue) throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call Sale(?,?,?,?,?,?) }");//procedimiento de almacenado

            //enviar parametros email y password a RegisterUser()
            ps.setInt(1, methodPaymentId);
            ps.setDouble(2, totalValue);
            ps.setInt(3, customerId);
            ps.setInt(4, productId);
            ps.setInt(5, quantity);
            ps.setDouble(6, subtotalValue);

            //ejecutar consulta
            ResultSet rs = ps.executeQuery();
            int saleId = 0;
            while (rs.next()) {
                saleId = rs.getInt("SaleId");
            }
            return saleId;
        } catch (Exception err) {
            throw err;
        }
    }
}
