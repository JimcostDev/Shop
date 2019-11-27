package com.hardwareStore.services;

import java.sql.*;
import com.hardwareStore.data.ConnectionDB;
import java.util.ArrayList;
import java.util.List;

;


public class Products {
    
    public int ProductCreate(String name,
            double price,
            double ShippingCost,
            String warranty,
            String description,
            int quantity,
            int customerId,
            int stateId,
            int categoryId
           ) throws SQLException, ClassNotFoundException  {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call ProductCreate(?,?,?,?,?,?,?,?,?) }");//procedimiento de almacenado

            //enviar parametros a ProductCreate()
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setDouble(3, ShippingCost);
            ps.setString(4, warranty);
            ps.setString(5, description);
            ps.setInt(6, quantity);
            ps.setInt(7, customerId);
            ps.setInt(8, stateId);
            ps.setInt(9, categoryId);
            int productId = 0;
            
                    

            //ejecutar consulta
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                productId=rs.getInt("productId");
            }
            return productId;

        } catch (Exception err) {
            throw err;
        }

    }
    public void ProductCreatePhoto(int productId,
            String guid,
            String ext
           ) throws SQLException, ClassNotFoundException  {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call ProductCreatePhoto(?,?,?) }");//procedimiento de almacenado

            //enviar parametros a ProductCreate()
            ps.setInt(1, productId);
            ps.setString(2, guid);
            ps.setString(3, ext);
            ps.executeQuery();
           

        } catch (Exception err) {
            throw err;
        }

    }

    public List<com.hardwareStore.models.Products> SearchProducts(int categoryId,
            String productName) throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call SearchProducts(?,?) }");//procedimiento de almacenado

            // //enviar parametros  a SearchProducts() 
            ps.setInt(1, categoryId);
            ps.setString(2, productName);

            ResultSet rs = ps.executeQuery();

            //arrayList (arreglo dinamico)- array de objetos
            List<com.hardwareStore.models.Products> listProducts = new ArrayList<>();

            //cuando el ejecute el procedimiento de almacenado, lo reccoremos atraves de un while
            while (rs.next()) {
                //almacenamos los valores del PROC SearchProducts() en la variable products(ENCONTRAR PRODUCTOS)
                com.hardwareStore.models.Products products = new com.hardwareStore.models.Products();
                products.setId(rs.getInt("Id"));
                products.setCategoryId(rs.getInt("CategoryId"));//FK

                //creamos el objeto categories (asignamos la llave foranea - FK)
                com.hardwareStore.models.Categories categories = new com.hardwareStore.models.Categories();
                categories.setId(rs.getInt("CategoryId"));
                categories.setName(rs.getString("CategoryName"));
                //el objeto categories esta inmerso en products, por eso le enviamos dicho objeto 
                products.setCategories(categories);// FK

                products.setName(rs.getString("Name"));
                products.setPrice(rs.getDouble("Price"));
                products.setShippingCost(rs.getDouble("ShippingCost"));
                products.setWarranty(rs.getString("Warranty"));
                products.setDescription(rs.getString("Description"));
                products.setQuantity(rs.getInt("Quantity"));
                products.setStateId(rs.getInt("StateId"));
                products.setStateId(rs.getInt("StateId"));//FK

                //creamos el objeto states (asignamos la llave foranea - FK)
                com.hardwareStore.models.States states = new com.hardwareStore.models.States();
                states.setId(rs.getInt("StateId"));
                states.setName(rs.getString("StateName"));
                //el objeto states esta inmerso en products, por eso le enviamos dicho objeto 
                products.setStates(states);// FK
                products.setGuid(rs.getString("Guid"));

                //parte del cliente...
                products.setCustomerId(rs.getInt("CustomerId"));

                //a la lista(array de objetos) le añada el objeto products
                listProducts.add(products);
            }

            return listProducts;

        } catch (Exception err) {
            throw err;
        }
    }

    
    public List<com.hardwareStore.models.Products> SearchProductsById(int productId)
            throws SQLException, ClassNotFoundException {
        try {
            //establecer conexion || conexión creada
            Connection cnx = ConnectionDB.GetConnection();
            //ejecutar un comando en la bd, prepara una instancia
            PreparedStatement ps = cnx.prepareStatement("{ call SearchProductsById(?) }");//procedimiento de almacenado

            // //enviar parametros  a SearchProducts() 
            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            //arrayList (arreglo dinamico)- array de objetos
            List<com.hardwareStore.models.Products> listProducts = new ArrayList<>();

            //cuando el ejecute el procedimiento de almacenado, lo reccoremos atraves de un while
            while (rs.next()) {
                //almacenamos los valores del PROC SearchProducts() en la variable products(ENCONTRAR PRODUCTOS)
                com.hardwareStore.models.Products products = new com.hardwareStore.models.Products();
                products.setId(rs.getInt("Id"));
                products.setCategoryId(rs.getInt("CategoryId"));//FK

                //creamos el objeto categories (asignamos la llave foranea - FK)
                com.hardwareStore.models.Categories categories = new com.hardwareStore.models.Categories();
                categories.setId(rs.getInt("CategoryId"));
                categories.setName(rs.getString("CategoryName"));
                //el objeto categories esta inmerso en products, por eso le enviamos dicho objeto 
                products.setCategories(categories);// FK

                products.setName(rs.getString("Name"));
                products.setPrice(rs.getDouble("Price"));
                products.setShippingCost(rs.getDouble("ShippingCost"));
                products.setWarranty(rs.getString("Warranty"));
                products.setDescription(rs.getString("Description"));
                products.setQuantity(rs.getInt("Quantity"));
                products.setStateId(rs.getInt("StateId"));
                products.setStateId(rs.getInt("StateId"));//FK

                //creamos el objeto states (asignamos la llave foranea - FK)
                com.hardwareStore.models.States states = new com.hardwareStore.models.States();
                states.setId(rs.getInt("StateId"));
                states.setName(rs.getString("StateName"));
                //el objeto states esta inmerso en products, por eso le enviamos dicho objeto 
                products.setStates(states);// FK
                products.setGuid(rs.getString("Guid"));

                //parte del cliente...
                products.setCustomerId(rs.getInt("CustomerId"));

                //a la lista(array de objetos) le añada el objeto products
                listProducts.add(products);
            }

            return listProducts;

        } catch (Exception err) {
            throw err;
        }
    }

   
    
}
