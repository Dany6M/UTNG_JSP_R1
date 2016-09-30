/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Store;
import utng.util.UtilDB;

/**
 *
 * @author Daniel Aguilar
 */
public class StoreDAOImp implements StoreDAO{
  private Connection connection;
  
  public StoreDAOImp(){
      connection=UtilDB.getConnection();
  }
    @Override
    public void agregarStore(Store store) {
        try {
            String query = "INSERT INTO store (name,adress,phone)" + "VALUES(?,?,?)";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, store.getName());
            co.setString(2, store.getAdress());
            co.setString(3, store.getPhone());
            co.executeUpdate();
            co.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarStore(int idStore) {
        try{
            String query = "DELETE FROM store WHERE "
                    + " idStore=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setInt(1, idStore);
            co.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarStore(Store store) {
        try{
            String query = "UPDATE store SET name= ?"
                    + ", adress=?"
                    + ", phone=?"
                    + "WHERE idStore=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, store.getName());
            co.setString(2, store.getAdress());
            co.setString(3, store.getPhone());
            co.setInt(4, store.getIdStore());
            co.executeUpdate();
            co.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Store> desplegarStores() {
        List<Store> stores = new ArrayList<Store>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM store");
            while(rs.next()){
                Store store = new Store(rs.getInt("idStore"),
                rs.getString("name"),
                rs.getString("adress"),
                rs.getString("phone"));
                stores.add(store);
            } 
            
            rs.close();
            statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return stores;
    }

    @Override
    public Store elegirStore(int idStore) {
        Store store=null;
        try{
            String query = " SELECT * FROM store WHERE idStore=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idStore);
            ResultSet rs= statement.executeQuery();
            
            if(rs.next()){
                store= new Store(
                rs.getInt("idStore"),
                rs.getString("name"),
                rs.getString("adress"),
                rs.getString("phone"));
                
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return store;
    }
    
}
