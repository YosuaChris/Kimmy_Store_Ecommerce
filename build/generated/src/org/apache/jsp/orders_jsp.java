package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import dao.OrderDao;
import connection.DbCon;
import dao.ProductDao;
import model.*;
import java.util.*;

public final class orders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/include/head.jsp");
    _jspx_dependants.add("/include/navbar.jsp");
    _jspx_dependants.add("/include/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    List<Order> orders = null;
    if (auth != null) {
        request.setAttribute("person", auth);
        OrderDao orderDao = new OrderDao(DbCon.getConnection());
        orders = orderDao.userOrders(auth.getId());
    } else {
        response.sendRedirect("login.jsp");
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("</head>");
      out.write("\n");
      out.write("        <title>E-Commerce Cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-success\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"index.jsp\">Kimmy</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\n");
      out.write("                data-target=\"#navbarSupportedContent\"\n");
      out.write("                aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n");
      out.write("                aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"index.jsp\">Beranda</a></li>\n");
      out.write("                    ");

                        if (request.getSession().getAttribute("auth") != null) {
                    
      out.write("\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"cart.jsp\">Keranjang <span class=\"badge badge-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart_list.size()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span> </a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"orders.jsp\">Pesanan</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"log-out\">Logout</a></li>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">Login</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"registrasi.jsp\">Registrasi</a></li>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"card-header my-3\">All Orders</div>\n");
      out.write("            <table class=\"table table-light\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Date</th>\n");
      out.write("                        <th scope=\"col\">Name</th>\n");
      out.write("                        <th scope=\"col\">Category</th>\n");
      out.write("                        <th scope=\"col\">Quantity</th>\n");
      out.write("                        <th scope=\"col\">Price</th>\n");
      out.write("                        <th scope=\"col\">Cancel</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("\n");
      out.write("                    ");
if (orders != null) {
                            for (Order o : orders) {
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(o.getDate());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getCategory());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(o.getQunatity());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(dcf.format(o.getPrice()));
      out.write("</td>\n");
      out.write("                        <td><a class=\"btn btn-sm btn-danger\" href=\"cancel-order?id=");
      out.print(o.getOrderId());
      out.write("\">Cancel Order</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
