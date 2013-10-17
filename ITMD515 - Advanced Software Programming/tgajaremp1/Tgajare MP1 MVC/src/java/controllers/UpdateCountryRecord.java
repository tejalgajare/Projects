
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
import model.countryRecord;
import service.RecordDAO;

/**
 * This servlet is used for updating a Country Record which updates the selected record  from  
 * @param showCountryRecords.jsp
 * @author Tejal Gajare
 */
@WebServlet(name = "UpdateCountryRecord", urlPatterns = {"/UpdateCountryRecord"})
public class UpdateCountryRecord extends HttpServlet {
    
private static final Logger LOG = Logger.getLogger(UpdateCountryRecord.class.getName());
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
    private countryRecord buildFromRequest(HttpServletRequest request) {
        // Method sets values as null or populated, not as empty string...
        countryRecord c = new countryRecord();

        if (!isEmpty(request.getParameter("Code"))) {
            c.setcode(trimParam(request.getParameter("Code")));
        }

        c.setname(trimParam(request.getParameter("Name")));
        c.setcontinent(trimParam(request.getParameter("Continent")));
        c.setregion(trimParam(request.getParameter("Region")));
        c.setsurfaceArea(new Float(trimParam(request.getParameter("SurfaceArea"))));
        
        if (!isEmpty(request.getParameter("IndepYear"))) {
        c.setindepYear(new Integer(trimParam(request.getParameter("IndepYear"))));
        }
        
        c.setpopulation(new Integer(trimParam(request.getParameter("Population"))));
        
        if (!isEmpty(request.getParameter("LifeExpectancy"))) {
        c.setlifeExpectancy(new Float(trimParam(request.getParameter("LifeExpectancy"))));
        }
        
        c.setvGNP(new Float(trimParam(request.getParameter("GNP"))));
        
        if (!isEmpty(request.getParameter("GNPOld"))) {
        c.setvGNPOld(new Float(trimParam(request.getParameter("GNPOld"))));
        }
        
        c.setlocalName(trimParam(request.getParameter("LocalName")));
        c.setgovernmentForm(trimParam(request.getParameter("GovernmentForm")));
        c.setheadOfState(trimParam(request.getParameter("HeadOfState")));
        c.setcapital(new Integer(trimParam(request.getParameter("Capital"))));
        c.setcode2(trimParam(request.getParameter("Code2")));

        return c;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       countryRecord cr=recordDAO.findCountry(request.getParameter("UCountryCode").toString());
       request.setAttribute("code", request.getParameter("UCountryCode"));
       request.setAttribute("Name", cr.getname());
       request.setAttribute("Continent", cr.getcontinent());
       request.setAttribute("Region", cr.getregion());
       request.setAttribute("SurfaceArea", cr.getsurfaceArea());
       request.setAttribute("IndepYear", cr.getindepYear());
       request.setAttribute("Population", cr.getpopulation());
       request.setAttribute("LifeExpectancy", cr.getlifeExpectancy());
       request.setAttribute("GNP", cr.getvGNP());
       request.setAttribute("GNPOld", cr.getvGNPOld());
       request.setAttribute("LocalName", cr.getlocalName());
       request.setAttribute("GovernmentForm", cr.getgovernmentForm());
       request.setAttribute("HeadOfState", cr.getheadOfState());
       request.setAttribute("Capital", cr.getcapital());
       request.setAttribute("Code2", cr.getcode2());
       
       
       request.getRequestDispatcher("/WEB-INF/CountryRecords/updateCountryRecord.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         countryRecord c = buildFromRequest(request);

        // Then, we need to validate it
        Set<ConstraintViolation<countryRecord>> violations = validator.validate(c);

        LOG.info("There are " + violations.size() + " violations.");

        for (ConstraintViolation<countryRecord> violation : violations) {
            LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                    + "." + violation.getPropertyPath()
                    + " - Invalid Value = "
                    + violation.getInvalidValue()
                    + " - Error Msg = " + violation.getMessage());

        }

        // if the post is successfully validated, persist the record
        if (violations.isEmpty()) {
            if (recordDAO.updateCountry(c)) {
                request.setAttribute("successes", "The record has been updated.");
                request.getRequestDispatcher("/showCountryRecords").forward(request, response);
            } else {
                // in this condition, there was a problem with the call to create
                request.setAttribute("violations", "There was a problem creating the record.");
                request.getRequestDispatcher("/showCountryRecords").forward(request, response);
            }
        } else {
            // if the post was not successfully validated, set the violations
            // in the request scope
            request.setAttribute("violations", violations);
            // and forward the request back to the form, which will display the
            // violations as error messages for the end-user
            request.getRequestDispatcher("/WEB-INF/CountryRecords/updateCountryRecord.jsp").forward(request, response);
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
