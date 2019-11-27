/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hardwareStore.services.Account;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ronaldo Jimenez
 */
@WebServlet(name = "accountController", urlPatterns = {"/accountController"})
public class accountController extends HttpServlet {

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
        //si el boton que presionaron es btnRegister entonces llame el metodo RegisterUser()
        if (request.getParameter("btnRegister") != null) {
            RegisterUser(request, response);
        } //si el boton que presionaron es btnLogin entonces llame el metodo LoginUser()
        else if (request.getParameter("btnLogin") != null) {
            LoginUser(request, response);
        }

    }

    private void LoginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            //validar que los campos no esten vacios
            String message = "";
            if (email.trim().length() == 0) {
                message = "Email is required,";
            }
            if (password.trim().length() == 0) {
                message = "password is required,";
            }
            if (message.length() != 0) {
                throw new Exception(message.substring(0, message.length() - 1));//-1 para que no devuelva la ,
            }

            Account account = new Account();
            //llamar metodo Login
            boolean exists = account.Login(email, password);

            //si exists es 1 redireccionar a index
            if (exists) {

                //variable de sesión
                HttpSession session = request.getSession(true);
                

                com.hardwareStore.services.Customers customer = new com.hardwareStore.services.Customers();
                //lista de clientes
                List<com.hardwareStore.models.Customer> listCustomer = customer.SearchCustomer(email);//lo guardamos en una lista en la clase de modelos customer
                //guardamos el cliente en sesiòn
                
                session.setAttribute("customer", listCustomer.get(0));
                request.setAttribute("userName",email.split("@")[0]);//enviar nombre de usuario al Home
                request.getRequestDispatcher("Home.jsp").forward(request, response);
            }
            //sino
            throw new Exception("Invalid credencials");

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    private void RegisterUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //peticion al controlador (request)
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            String confirmPassword = request.getParameter("txtConfirmPassword");
            //si es diferente mostrar error
            if (!password.equals(confirmPassword)) {
                throw new Exception("Password not matched");
            }

            //Registrar Usuario ( conectar con procedimiento de almacenado)
            Account account = new Account();
            account.Register(email, password);

            //enviar datos desde el servlet(controlador) al jsp(vista)
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);
            //devolverme a la vista (response)
            request.getRequestDispatcher("Register.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("Register.jsp").forward(request, response);
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
