/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hardwareStore.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


/**
 *
 * @author Ronaldo Jiménez
 */
@WebServlet(name = "FileUploadController", urlPatterns = {"/FileUploadController"})
public class FileUploadController extends HttpServlet {

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
        //CONFIGURACIÓN - SETUP
        String urlPath = "C:\\Users\\Ronaldo Jimenez\\Documents\\NetBeansProjects\\HardwareStore\\web\\img\\products";
        //definir la variable que me permite trabajar con los archivos en disco
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //tamaño en megas
        factory.setSizeThreshold(1024);
        //url donde vamos a almacenar
        factory.setRepository(new File(urlPath));
        //cargar archivos
        ServletFileUpload upload = new ServletFileUpload(factory);

        //generar guid de manera akeatoria
        UUID uuid = UUID.randomUUID();
        try {
            //hace el parseo y lo deja en una lista de archivos
            List<FileItem> fileItems = upload.parseRequest(request);
            //vamos a reccorer la lista fileItems
            for (FileItem item: fileItems){
                //capturar la extension del archivo
                String extension = FilenameUtils.getExtension(item.getName());
                //generar guid
                String guid = uuid.toString();
                //crear un archivo con el guid y la extension
                File file = new File(urlPath, guid + "." + extension);
                item.write(file);
                
                request.getRequestDispatcher("FileUpload.jsp").forward(request, response);

            }
            
        } catch (Exception err) {
            String exception = err.getMessage();
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
