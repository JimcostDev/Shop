/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ronaldo Jiménez
 */
@WebServlet(name = "SalesController", urlPatterns = {"/SalesController"})
public class SalesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btnShippingCost") != null) {
            SalesShippingCost(request, response);
        }
        else if (request.getParameter("btnMethodPayment") != null) {
            SalesSMethodPayment(request, response);
        }
        else if (request.getParameter("btnSale") != null){
            SalesComplete(request,response);
        }

    }
    private void SalesComplete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int methodPaymentId = Integer.parseInt(request.getParameter("ddlMethodPayment"));//atrapamos el valor desde SalesMethodPayment
            com.hardwareStore.models.Products product = new com.hardwareStore.models.Products();//aqui atrapamos el producto
            com.hardwareStore.models.Customer customer = new com.hardwareStore.models.Customer();
            
            //variable de sesión
            HttpSession session = request.getSession(true);
            product = (com.hardwareStore.models.Products) session.getAttribute("product");//atrapamos la variable de session
            request.setAttribute("product", product);//informaciòn del producto--enviarlo al jsp salesShippingCost
            customer = (com.hardwareStore.models.Customer) session.getAttribute("customer");//atrapar en session
            
            com.hardwareStore.services.Sales sales = new com.hardwareStore.services.Sales();
            int saleId = sales.SalesComplete(
                    methodPaymentId, 
                    (product.getQuantity()*product.getPrice()+product.getShippingCost()), 
                    customer.getId(), 
                    product.getId(), 
                    product.getQuantity(), 
                    product.getQuantity()* product.getPrice());
            
                    request.setAttribute("saleId", saleId);
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);

            //devolverme a la vista (response)
            request.getRequestDispatcher("SalesComplete.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("SalesComplete.jsp").forward(request, response);
        }

    }

    private void SalesSMethodPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double shippingCost = Double.parseDouble(request.getParameter("shippingCost"));//atrapamos el valor desde SalesShippingCost.jsp
            com.hardwareStore.models.Products product = new com.hardwareStore.models.Products();
            
            //variable de sesión
            HttpSession session = request.getSession(true);
            product = (com.hardwareStore.models.Products) session.getAttribute("product");//atrapamos la variable de session
            //modificamos el valor del costo del envio de la variable de session
            product.setShippingCost(shippingCost);//enviar al modelo
            //actualizar la variable de session
            session.setAttribute("product",product);

            request.setAttribute("product", product);//informaciòn del producto--enviarlo al jsp salesShippingCost
            //llamar metodo SearchMethodsPayment() (buscar metodosdepago y guardar en el array list)
            com.hardwareStore.services.MethodPayment methodPayment = new com.hardwareStore.services.MethodPayment();
            List<com.hardwareStore.models.MethodPayment> listMethodsPayment = methodPayment.SearchMethodsPayment();//lista de objetos
            request.setAttribute("listMethodsPayment", listMethodsPayment);//variable que vamos a envir al formulario SalesMethodPayment
            
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);

            //devolverme a la vista (response)
            request.getRequestDispatcher("SalesMethodPayment.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("SalesMethodPayment.jsp").forward(request, response);
        }

    }
    private void SalesShippingCost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            //llamar metodo SearchProducts (buscar productos y guardar en el array list)
            com.hardwareStore.models.Products product = new com.hardwareStore.models.Products();
            com.hardwareStore.models.Customer customer = new com.hardwareStore.models.Customer();
            //variable de sesión
            HttpSession session = request.getSession(true);
            product = (com.hardwareStore.models.Products) session.getAttribute("product");//atrapamos la variable de session
            customer = (com.hardwareStore.models.Customer) session.getAttribute("customer");

            request.setAttribute("product", product);//informaciòn del producto--enviarlo al jsp salesShippingCost
            request.setAttribute("customer", customer);//informaciòn del clientetome--enviarlo al jsp salesShippingCost
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);

            //devolverme a la vista (response)
            request.getRequestDispatcher("SalesShippingCost.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("SalesShippingCost.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
