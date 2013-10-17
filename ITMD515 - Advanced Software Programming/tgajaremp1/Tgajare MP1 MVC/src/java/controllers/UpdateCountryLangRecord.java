
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
import model.countryLanguageRecord;
import service.RecordDAO;

/**
 * This servlet is used for updating a CountryLanguage Record which updates the selected record  from  
 * @param showCountryLanguageRecords.jsp
 * @author Tejal Gajare
 */
@WebServlet(name = "UpdateCountryLangRecord", urlPatterns = {"/UpdateCountryLangRecord"})
public class UpdateCountryLangRecord extends HttpServlet {
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
    private countryLanguageRecord buildFromRequest(HttpServletRequest request) {
        // Method sets values as null or populated, not as empty string...
        countryLanguageRecord c = new countryLanguageRecord();

        if (!isEmpty(request.getParameter("CountryCode"))) {
            c.setcountryCode(trimParam(request.getParameter("CountryCode")));
        }

        c.setlanguage(trimParam(request.getParameter("Language")));
        c.setisOfficial(trimParam(request.getParameter("IsOfficial")));
        c.setpercentage(new Float(trimParam(request.getParameter("Percentage"))));
       
        return c;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       countryLanguageRecord cr=recordDAO.findCountryLang(request.getParameter("c_code"),request.getParameter("lang"));
       request.setAttribute("CountryCode", cr.getcountryCode());
       request.setAttribute("Language", cr.getlanguage());
       request.setAttribute("IsOfficial", cr.getisOfficial());
       request.setAttribute("Percentage", cr.getpercentage());
       
       request.getRequestDispatcher("/WEB-INF/CountryLanguageRecords/updateCountryLangRecord.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         countryLanguageRecord c = buildFromRequest(request);

        // Then, we need to validate it
        Set<ConstraintViolation<countryLanguageRecord>> violations = validator.validate(c);

        LOG.info("There are " + violations.size() + " violations.");

        for (ConstraintViolation<countryLanguageRecord> violation : violations) {
            LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                    + "." + violation.getPropertyPath()
                    + " - Invalid Value = "
                    + violation.getInvalidValue()
                    + " - Error Msg = " + violation.getMessage());

        }

        // if the post is successfully validated, persist the record
        if (violations.isEmpty()) {
            if (recordDAO.updateCountryLang(c)) {
                request.setAttribute("successes", "The record has been updated.");
                request.getRequestDispatcher("/showCountryLanguageRecords").forward(request, response);
            } else {
                // in this condition, there was a problem with the call to create
                request.setAttribute("violations", "There was a problem creating the record.");
                request.getRequestDispatcher("/showCountryLanguageRecords").forward(request, response);
            }
        } else {
            // if the post was not successfully validated, set the violations
            // in the request scope
            request.setAttribute("violations", violations);
            // and forward the request back to the form, which will display the
            // violations as error messages for the end-user
            request.getRequestDispatcher("/WEB-INF/CountryLanguageRecords/updateCountryLangRecord.jsp").forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
