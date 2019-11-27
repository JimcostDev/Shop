/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.controllers;

import com.hardwareStore.services.Products;
import com.hardwareStore.services.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hardwareStore.services.Categories;
import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Ronaldo Jimenez
 */
@WebServlet(name = "ProductsController", urlPatterns = {"/ProductsController"})
public class ProductsController extends HttpServlet {

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

        HttpSession session = request.getSession(true);
        
        //si optProductsIndex es diferente de nulo entonces llame el metodo ProductsIndex()
        if (request.getParameter("optProductsIndex") != null) {

            ProductsIndex(request, response);
        } else if (request.getParameter("btnSearch") != null) {

            ProductsSearch(request, response);
        } else if (request.getParameter("btnDetailsProduct") != null) {
            ProductDetails(request, response);

        } else if (request.getParameter("optProductsCreate") != null) {
            VwProductsCreate(request, response);
        }
        else if (request.getParameter("btnCreateProduct") != null) {
            ProductsCreate(request, response);
        }
        else if (session.getAttribute("productId") != null) {
            ProductsCreatePhoto(request, response);
        }
    }

    private void ProductDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //String email = request.getParameter("txtEmail");
            //atrapar datos de la vista
            int productId = Integer.parseInt(request.getParameter("productId"));

            //llamar metodo SearchProducts (buscar productos y guardar en el array list)
            com.hardwareStore.services.Products products = new com.hardwareStore.services.Products();
            List<com.hardwareStore.models.Products> listProducts = products.SearchProductsById(productId);
            //variable de sesión
            HttpSession session = request.getSession(true);
            session.setAttribute("product", listProducts.get(0));

            request.setAttribute("product", listProducts.get(0));
            //enviar datos desde el servlet(controlador) al jsp(vista)
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);

            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductDetails.jsp").forward(request, response);
        }

    }

    private void ProductsSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("txtEmail");
            //atrapar datos de la vista
            int categoryId = Integer.parseInt(request.getParameter("ddlCategories"));
            String productName = request.getParameter("txtProductName");
            //llamar metodo SearchProducts (buscar productos y guardar en el array list)
            com.hardwareStore.services.Products products = new com.hardwareStore.services.Products();
            List<com.hardwareStore.models.Products> listProducts = products.SearchProducts(categoryId, productName);
            request.setAttribute("listProducts", listProducts);

            //volver a cargar la lista de categorias (F5 - cuando refrescamos la pagina)
            com.hardwareStore.services.Categories categories = new com.hardwareStore.services.Categories();
            List<com.hardwareStore.models.Categories> listCategories = categories.SearchCategories();
            request.setAttribute("listCategories", listCategories);

            //enviar datos desde el servlet(controlador) al jsp(vista)
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);

            //variable de sesión
            HttpSession session = request.getSession(true);
            session.setAttribute("userName", email);
            //session.setAttribute("customerId", );
            String user = (String) session.getAttribute("userName");

            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
        }
    }

    //indice de los productos (lo que arga la vista)
    private void ProductsIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //llamar metodo SearchCategories (buscar categorias y guardar en el array list)
            com.hardwareStore.services.Categories categories = new com.hardwareStore.services.Categories();
            List<com.hardwareStore.models.Categories> listCategories = categories.SearchCategories();
            //variable de sesión
            HttpSession session = request.getSession(true);
            //session.setAttribute("customerId", );
            String user = (String) session.getAttribute("userName");
            //enviar al jsp
            request.setAttribute("userName", user);

            request.setAttribute("listCategories", listCategories);
            
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
        }
    }

    private void ProductsCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            HttpSession session = request.getSession(true);
            
            com.hardwareStore.models.Customer customer = new com.hardwareStore.models.Customer();
            customer = (com.hardwareStore.models.Customer) session.getAttribute("customer");//atrapar en session
            int customerId = customer.getId();//atrapamos el customerId
            
            String name = request.getParameter("txtName");
            double price = Double.parseDouble(request.getParameter("txtPrice"));
            double shippingCost = Double.parseDouble(request.getParameter("txtShippingCost"));
            String warranty = request.getParameter("txtWarranty");
            String description = request.getParameter("txtDescription");
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            int stateId = Integer.parseInt(request.getParameter("ddlStates"));
            int categoryId = Integer.parseInt(request.getParameter("ddlCategories"));
        
            
           

            //Crear Producto ( conectar con procedimiento de almacenado)
            Products product = new Products();
            int productId = product.ProductCreate(name, price, shippingCost, warranty, description, quantity, customerId, stateId, categoryId);
            session.setAttribute("productId", productId);//enviar id del producto al metodo ProductsCreatePhoto()
            
            //llamar metodo SearchCategories (buscar categorias y guardar en el array list)
            com.hardwareStore.services.Categories categories = new com.hardwareStore.services.Categories();
            List<com.hardwareStore.models.Categories> listCategories = categories.SearchCategories();
            request.setAttribute("listCategories", listCategories);
            
            //llamar metodo CheckState() (buscar estado y guardar en el array list)
            com.hardwareStore.services.States states = new com.hardwareStore.services.States();
            List<com.hardwareStore.models.States> listStates = states.CheckState();
            request.setAttribute("listStates", listStates);
            
            
            

            //enviar el productId para subir la foto
            session.setAttribute("productId", productId);
            

            //enviar datos desde el servlet(controlador) al jsp(vista)
            request.setAttribute("message", "Process was successful");
            request.setAttribute("status", 200);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductCreatePhoto.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductsCreate.jsp").forward(request, response);
        }
    }
    private void VwProductsCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //llamar metodo SearchCategories (buscar categorias y guardar en el array list)
            com.hardwareStore.services.Categories categories = new com.hardwareStore.services.Categories();
            List<com.hardwareStore.models.Categories> listCategories = categories.SearchCategories();
            request.setAttribute("listCategories", listCategories);
             //llamar metodo CheckState() (buscar estado y guardar en el array list)
            com.hardwareStore.services.States states = new com.hardwareStore.services.States();
            List<com.hardwareStore.models.States> listStates = states.CheckState();
            request.setAttribute("listStates", listStates);
            
            
            //variable de sesión
            HttpSession session = request.getSession(true);
            //session.setAttribute("customerId", );
            String user = (String) session.getAttribute("userName");
            //enviar al jsp
            request.setAttribute("userName", user);

            

            request.getRequestDispatcher("ProductsCreate.jsp").forward(request, response);

        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductsCreate.jsp").forward(request, response);
        }
    }
    private void ProductsCreatePhoto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            
            HttpSession session = request.getSession(true);
            String user = (String) session.getAttribute("userName");
            request.setAttribute("userName", user);
            
            //FileUpload
            String guid = "";
            String ext = "";
            String urlPath = "C:\\Users\\Ronaldo Jimenez\\Documents\\NetBeansProjects\\HardwareStore\\web\\img\\products";
            //definir la variable que me permite trabajar con los archivos en disco
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //tamaño en megas
            factory.setSizeThreshold(1024);
            //url donde vamos a almacenar
            factory.setRepository(new File(urlPath));
            //cargar archivos
            ServletFileUpload upload = new ServletFileUpload(factory);

            //generar guid de manera aleatoria
            UUID uuid = UUID.randomUUID();
            List<FileItem> fileItems = upload.parseRequest(request);
            //vamos a reccorer la lista fileItems
            for (FileItem item : fileItems) {
                //capturar la extension del archivo
                ext = FilenameUtils.getExtension(item.getName());
                //generar guid
                guid = uuid.toString();
                //crear un archivo con el guid y la extension
                File file = new File(urlPath, guid + "." + ext);
                item.write(file);
                break;

                
            }
            
            int productId =(int)session.getAttribute("productId");
            Products product = new Products();
            product.ProductCreatePhoto(productId,guid,"."+ext);
            
            
            

            request.getRequestDispatcher("ProductsCreate.jsp").forward(request, response);
        } catch (Exception err) {
            request.setAttribute("message", err.getMessage());
            request.setAttribute("status", 500);
            //devolverme a la vista (response)
            request.getRequestDispatcher("ProductsCreate.jsp").forward(request, response);
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
