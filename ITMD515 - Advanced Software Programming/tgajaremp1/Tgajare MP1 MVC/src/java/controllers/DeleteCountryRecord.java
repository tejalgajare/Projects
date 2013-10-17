
package controllers;

import java.io.IOException;

import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Validator;
import model.countryRecord;
import service.RecordDAO;

/**
 * This servlet is used for deletion of a Country Record which gets the selected record ID from  
 * @param showCountryRecords.jsp
 * @author Tejal Gajare
 */
@WebServlet(name = "DeleteCountryRecord", urlPatterns = {"/DeleteCountryRecord"})
public class DeleteCountryRecord extends HttpServlet {

    @EJB
    RecordDAO recordDAO;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        recordDAO.deleteCountry(request.getParameter("CountryCode"));
        request.getRequestDispatcher("/WEB-INF/CountryRecords/deleteCountryRecord.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
