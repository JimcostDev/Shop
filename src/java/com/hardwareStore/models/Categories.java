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
public class Categories {
    public int Id;
    public String Name;
    //metodos gettter (obtener el valor) y setter (asignar el valor)
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    public boolean Active;
    
}
