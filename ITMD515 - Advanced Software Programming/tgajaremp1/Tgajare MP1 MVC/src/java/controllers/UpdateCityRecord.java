
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import model.cityRecord;

import service.RecordDAO;

/**
 * This servlet is used for updating a City Record which updates the selected record  from  
 * @param showCityRecords.jsp
 * @author Tejal Gajare
 */
@WebServlet(name = "UpdateCityRecord", urlPatterns = {"/UpdateCityRecord"})
public class UpdateCityRecord extends HttpServlet {
private static final Logger LOG = Logger.getLogger(UpdateCityRecord.class.getName());
    @Resource
    Validator validator;
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
    private boolean isEmpty(String param) {
        if (param == null || param.trim().equals("")) {
            return true;
        }
        return false;
    }

    private String trimParam(String param) {
        if (isEmpty(param)) {
            return null;
        } else {
            return param.trim();
        }
    }

    // utility method to build a record object from the http request
    private cityRecord buildFromRequest(HttpServletRequest request) {
        // Method sets values as null or populated, not as empty string...
        cityRecord c = new cityRecord();

        if (!isEmpty(request.getParameter("ID"))) {
            c.setvID(new Integer(trimParam(request.getParameter("ID"))));
        }

        c.setname(trimParam(request.getParameter("Name")));
        c.setcountryCode(trimParam(request.getParameter("CountryCode")));
        c.setdistrict(trimParam(request.getParameter("District")));
        c.setpopulation(new Integer(trimParam(request.getParameter("Population"))));
       
        return c;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       cityRecord cr=recordDAO.findCity(new Integer(request.getParameter("ID")));
       request.setAttribute("ID", cr.getvID());
       request.setAttribute("Name", cr.getname());
       request.setAttribute("CountryCode", cr.getcountryCode());
       request.setAttribute("District", cr.getdistrict());
       request.setAttribute("Population", cr.getpopulation());
       request.getRequestDispatcher("/WEB-INF/CityRecords/updateCityRecord.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         cityRecord c = buildFromRequest(request);

        // Then, we need to validate it
        Set<ConstraintViolation<cityRecord>> violations = validator.validate(c);

        LOG.info("There are " + violations.size() + " violations.");

        for (ConstraintViolation<cityRecord> violation : violations) {
            LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                    + "." + violation.getPropertyPath()
                    + " - Invalid Value = "
                    + violation.getInvalidValue()
                    + " - Error Msg = " + violation.getMessage());

        }

        // if the post is successfully validated, persist the record
        if (violations.isEmpty()) {
            if (recordDAO.updateCity(c)) {
                request.setAttribute("successes", "The record has been updated.");
                request.getRequestDispatcher("/showCityRecords").forward(request, response);
            } else {
                // in this condition, there was a problem with the call to create
                request.setAttribute("violations", "There was a problem creating the record.");
                request.getRequestDispatcher("/showCityRecords").forward(request, response);
            }
        } else {
            // if the post was not successfully validated, set the violations
            // in the request scope
            request.setAttribute("violations", violations);
            // and forward the request back to the form, which will display the
            // violations as error messages for the end-user
            request.getRequestDispatcher("/WEB-INF/CityRecords/updateCityRecord.jsp").forward(request, response);
        }
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
