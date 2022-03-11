package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import connection.DbCon;
import dao.ProductDao;
import model.*;
import java.util.*;
import java.text.DecimalFormat;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
        ProductDao pDao = new ProductDao(DbCon.getConnection());
        cartProduct = pDao.getCartProducts(cart_list);
        double total = pDao.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
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
      out.write("        <style type=\"text/css\">\n");
      out.write("\n");
      out.write("            .table tbody td{\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("            .btn-incre, .btn-decre{\n");
      out.write("                box-shadow: none;\n");
      out.write("                font-size: 25px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
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

                        if (auth != null) {
                    
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
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container my-3\">\n");
      out.write("            <table class=\"table table-light\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Name</th>\n");
      out.write("                        <th scope=\"col\">Category</th>\n");
      out.write("                        <th scope=\"col\">Price</th>\n");
      out.write("                        <th scope=\"col\">Buy Now</th>\n");
      out.write("                        <th scope=\"col\">Cancel</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
                                    if (cart_list != null) {
                            for (Cart c : cartProduct) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(c.getName());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(c.getCategory());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( dcf.format(c.getPrice()));
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"order-now\" method=\"post\" class=\"form-inline\">\n");
      out.write("                                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( c.getId());
      out.write("\" class=\"form-input\">\n");
      out.write("                                <div class=\"form-group d-flex justify-content-between\">\n");
      out.write("                                    <a class=\"btn bnt-sm btn-incre\" href=\"quantity-inc-dec?action=inc&id=");
      out.print(c.getId());
      out.write("\"><i class=\"fas fa-plus-square\"></i></a> \n");
      out.write("                                    <input type=\"text\" name=\"quantity\" class=\"form-control\"  value=\"");
      out.print(c.getQuantity());
      out.write("\" readonly> \n");
      out.write("                                    <a class=\"btn btn-sm btn-decre\" href=\"quantity-inc-dec?action=dec&id=");
      out.print(c.getId());
      out.write("\"><i class=\"fas fa-minus-square\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary btn-sm\">Buy</button>\n");
      out.write("                            </form>\n");
      out.write("                        </td>\n");
      out.write("                        <td><a href=\"remove-from-cart?id=");
      out.print(c.getId());
      out.write("\" class=\"btn btn-sm btn-danger\">Remove</a></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    ");

                            }
                        }
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <div class=\"input-group mb-3\">\n");
      out.write("                <div class=\"input-group-prepend\">\n");
      out.write("                    <span class=\"input-group-text\">Upload</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"custom-file\">\n");
      out.write("                    <input type=\"file\" class=\"custom-file-input\" id=\"inputGroupFile01\">\n");
      out.write("                    <label class=\"custom-file-label\" for=\"inputGroupFile01\">Choose file</label>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"d-flex py-3\"><h3>Total Price: $ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(total>0)?dcf.format(total):0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h3> <a class=\"mx-3 btn btn-primary\" href=\"cart-check-out\">Check Out</a></div>\n");
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
