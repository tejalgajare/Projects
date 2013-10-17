

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.RecordDAO;

/**
 * This servlet is used for deletion of a City Record which gets the selected record ID from  
 * @param showCityRecords.jsp
 * @author Tejal Gajare
 */
@WebServlet(name = "DeleteCityRecord", urlPatterns = {"/DeleteCityRecord"})
public class DeleteCityRecord extends HttpServlet {
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

        recordDAO.deleteCity(new Integer(request.getParameter("ID")));
        request.getRequestDispatcher("/WEB-INF/CityRecords/deleteCityRecord.jsp").forward(request, response);
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