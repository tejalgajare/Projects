
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.cityRecord;
import model.countryRecord;
import service.RecordDAO;

/**
 * This servlet is used for displaying all City Records from the City Table
 * @author Tejal Gajare
 */
@WebServlet(name = "showCityRecords", urlPatterns = {"/showCityRecords"})
public class showCityRecords extends HttpServlet {
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
         List<cityRecord> records = recordDAO.findAllCities();
        // set the collection in the request scope
        request.setAttribute("records", records);
        // and forward the request to the appropriate view
        request.getRequestDispatcher("/WEB-INF/CityRecords/showAll.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
