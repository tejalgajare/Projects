/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Brand;
import domain.Customer;
import domain.Designer;
import domain.Product;
import domain.PurchaseOrder;
import ejb.CustomerBean;
import ejb.DesignerBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is used for mapping the roles and the username of the users and displaying the
 * relevant database data for each user
 * @author Tejal
 */
@WebServlet(name = "MP3Servlet", urlPatterns = {"/MP3Servlet"})
public class MP3Servlet extends HttpServlet {

    @EJB
    private DesignerBean designerBean;
    @EJB
    private CustomerBean customerBean;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Designer designer = null;
        Customer customer = null;

        if (request.isUserInRole("CUSTOMER")) {
            customer = customerBean.findByUserName(request.getRemoteUser());
        }

        if (request.isUserInRole("DESIGNER")) {
            designer = designerBean.findByUserName(request.getRemoteUser());
        }


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("<style>body{background-color: thistle;}table{width: auto;"
                  
                    + "	font-family: 'Calibri', sans-serif;\n"
                    + "	font-size:15px;\n"
                    + "	padding: 8px;\n"
                    + "	text-align:center;\n"
                    + " border-top: 1px solid purple;border-bottom: 1px solid purple;"
                    + "border-right:1px solid white;border-left:1px solid white;}"
                    + "h2{text-align: center;}p{font-weight:bold}</style>");
            //out.println("<link href='"+ request.getContextPath()+"'/MP3_css.css' rel=\"stylesheet\">");
            // out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/MP3_css.css' />"); 
            out.println("</head>");
            out.println("<body>");

            if (request.isUserInRole("CUSTOMER")) {
                out.println("<h5>Welcome, you are a Customer: " + customer.getUser().getUserName() + "</h5>");
                // out.println("<h3>Customer functionality goes here</h3>");
                out.println("<h3>Hi, " + customer.getFirstName() + " " + customer.getLastName() + "</h3>");

                if (customer.getProducts().size() > 0) {
                    out.println("<p>You have purchased following Products:</p>");
                    out.println("<table>");
                    out.println("<tr><td>ID</td><td>Name</td><td>Desc</td><td>"
                            + "Price</td><td>Designer</td></tr>");

                    for (Product p : customer.getProducts()) {
                        out.println("<tr><td>" + p.getId() + "</td><td>" + p.getName()
                                + "</td><td>" + p.getDescription()
                                + "</td><td>" + p.getPrice()
                                + "</td><td>" + p.getDesigner().getFirstName() + " " + p.getDesigner().getLastName() + "</td></tr>"+"\n");


                    }
                    out.println("</table>");
                    if (customer.getOrder().size() > 0) {
                        out.println("<p>You have placed following orders:</p>");

                        List<PurchaseOrder> orders = customer.getOrder();
                        for (PurchaseOrder order : orders) {
                            out.println("<table>");
                            out.println("<tr><td>ID</td><td>Date</td><td>Time</td><td>"
                                    + "Shipping Address</td></tr>");

                            out.println("<tr><td>" + order.getId() + "</td>"
                                    + "<td>"
                                    + order.getOrderDate() + "</td>"
                                    + "<td>"
                                    + order.getOrderTime() + "</td>"
                                    + "<td>"
                                    + order.getShippingAddress().getLine1() + " "
                                    + order.getShippingAddress().getLine2() + " "
                                    + order.getShippingAddress().getCity() + " "
                                    + order.getShippingAddress().getState() + " "
                                    + order.getShippingAddress().getZip() + " "
                                    + order.getShippingAddress().getCountry() + "</td></tr></table>");

                            List<Product> orderProducts = order.getProducts();

                            out.println("<p>Products for Order:" + order.getId() + "</p>");
                            out.println("<table>");
                            out.println("<tr><td>ID</td><td>Name</td><td>Desc</td><td>"
                                    + "Price</td><td>Designer</td></tr>");
                            for (Product orderProduct : orderProducts) {
                                out.println("<tr><td>" + orderProduct.getId() + "</td><td>" + orderProduct.getName()
                                        + "</td><td>" + orderProduct.getDescription()
                                        + "</td><td>" + orderProduct.getPrice()
                                        + "</td><td>" + orderProduct.getDesigner().getFirstName() + " " + orderProduct.getDesigner().getLastName() + "</td></tr>");


                            }
                            out.println("</table>");


                        }
                    }
                }
            }
            if (request.isUserInRole("DESIGNER")) {
                out.println("<h5>Welcome, you are a Designer: " + designer.getUser().getUserName() + "</h5>");
                //out.println("<h3>Designer functionality goes here</h3>");
                out.println("<h3>Hi, " + designer.getFirstName() + " " + designer.getLastName() + "</h3>");
                out.println("<p>You own the brand: " + designer.getBrand().getName() + "</p>");
                out.println("<p>List of products sold: </p>");
                if (designer.getProducts().size() > 0) {
                    out.println("<table>");
                    out.println("<tr><td>Name</td><td>Description</td><td>Price"
                            + "</td><td>Purchased By</td></tr>");

                    List<Product> products = designer.getProducts();
                    for (Product product : products) {
                        out.println("<tr><td>" + product.getName()
                                + "</td><td>" + product.getDescription()
                                + "</td><td>" + product.getPrice()
                                + "</td><td>" + product.getCustomer().getFirstName() + " " + product.getCustomer().getLastName() + "</td></tr>");
                    }
                    out.println("</table>");
                }
            }
            out.println("</body>");
            out.println("</html>");
            out.println("<h4><a href='" + request.getContextPath() + "/logout'>Logout</a></h4>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
