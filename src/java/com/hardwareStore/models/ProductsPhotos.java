/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.models;

/**
 *
 * @author Ronaldo Jimenez
 */
public class ProductsPhotos {
    public int Id;
    public int ProductId;//fk
    public String Guid;

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public void setGuid(String Guid) {
        this.Guid = Guid;
    }

    public void setProducts(Products Products) {
        this.Products = Products;
    }
            
    public Products Products;//relacion
}
