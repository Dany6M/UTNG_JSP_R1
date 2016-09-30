/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Store;



/**
 *
 * @author Daniel Aguilar
 */
public interface StoreDAO {
    void agregarStore(Store store);
    void borrarStore(int idStore);
    void cambiarStore(Store store);
    List<Store> desplegarStores();
    Store elegirStore(int idStore);
}
