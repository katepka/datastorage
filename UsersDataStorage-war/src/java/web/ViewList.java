package web;

import bean.SelectBeanLocal;
import data.Attribute;
import data.Parameter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewList", urlPatterns = {"/ViewList"})
public class ViewList extends HttpServlet {

    @EJB
    private SelectBeanLocal selectBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Searching result</title>");
            out.println("</head>");
            out.println("<body>");

            if (request.getParameter("view") != null) {
                request.getRequestDispatcher("viewdata.jsp").forward(request, response);
            }

            if (request.getParameter("input") != null) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            if (request.getParameter("search") != null) {
                out.println("<h3> Searching result: </h3>");

//                Collection<Parameter> searchingResult = null;

                String searchType = request.getParameter("searchType");
                String nameTemplate = request.getParameter("nameTemplate");
                String lowerBound = request.getParameter("lowerBound");
                String upperBound = request.getParameter("upperBound");
                String result = "";
                
                System.out.println(searchType);
                System.out.println(nameTemplate);
                System.out.println(lowerBound + " <> " + upperBound);

                if (searchType != null) {
                    switch (searchType) {
                        case "all":
                            result = selectBean.selectAll();
//                            searchingResult = Attribute.getParams();
                            break;
                        case "byname":
                            if (!nameTemplate.isEmpty()) {
                                result = selectBean.selectByNameTemplate(nameTemplate);
//                                searchingResult = Attribute.getParamsListByName(nameTemplate);
                            } else {
                                result = selectBean.selectAll();
//                                searchingResult = Attribute.getParams();
                            }
                            break;
                        case "byval":
                            try {
                                int low = Integer.parseInt(lowerBound);
                                int up = Integer.parseInt(upperBound);
                                if (low >= up) {
                                    out.println("The first bound of the interval must be less than the second");
                                } else {
                                    result = selectBean.selectByValInterval(low, up);
//                                    searchingResult = Attribute.getParamsListByVal(low, up);
                                }
                            } catch (NumberFormatException nfe) {
                                nfe.printStackTrace();
                                out.println("Interval values must be integers");
                        }
                        break;
                        default:
                            result = selectBean.selectAll();
//                            searchingResult = Attribute.getParams();
                            System.out.println("Unrecognized type of a search");
                    }

                } else {
                    result = selectBean.selectAll();
//                    searchingResult = Attribute.getParams();
                }

//                for (Parameter param : searchingResult) {
//                    out.println(param.convertToListItem());
//                }
                out.println(result);

            }

            out.println("</body>");
            out.println("</html>");
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
