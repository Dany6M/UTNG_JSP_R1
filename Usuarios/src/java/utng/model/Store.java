/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author Daniel Aguilar
 */
public class Store {
    private int idStore;
    private String name;
    private String adress;
    private String phone;
    

    public Store(int idStore, String name, String adress, String phone) {
        this.idStore = idStore;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        
    }
    
    public Store(){
        this(0,"","","");
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Store{" + "idStore=" + idStore + ", name=" 
                + name + ", adress=" + adress + ", phone=" + phone + '}';
    }

   
    
    
    
}
