/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utng.dao.StoreDAO;


import utng.dao.StoreDAOImp;
import utng.model.Store;

/**
 *
 * @author Daniel Aguilar
 */
public class StoreController extends HttpServlet{
    private static final String LISTA_STORE = "/listarStore.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/store.jsp";
    private StoreDAO dao;
    
    public StoreController() {
        dao = new StoreDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_STORE;
            int idStore = Integer.parseInt(request.getParameter("idStore"));
            dao.borrarStore(idStore);
            request.setAttribute("stores", dao.desplegarStores());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idStore = Integer.parseInt(request.getParameter("idStore"));
            Store store = dao.elegirStore(idStore);
            request.setAttribute("store", store);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_STORE;
            request.setAttribute("stores", dao.desplegarStores());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Store store = new Store();
        String idStore = request.getParameter("idStore");
       store.setName(request.getParameter("name"));
        store.setAdress(request.getParameter("adress"));
        store.setPhone(request.getParameter("phone"));
        if (idStore == null || idStore.isEmpty()) {
            dao.agregarStore(store);
        } else {
            store.setIdStore(Integer.parseInt(idStore));
            dao.cambiarStore(store);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_STORE);
        request.setAttribute("stores", dao.desplegarStores());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
