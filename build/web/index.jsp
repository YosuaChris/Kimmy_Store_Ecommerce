<%@page import="connection.DbCon"%>
<%@page import="dao.ProductDao"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("person", auth);
    }
    ProductDao pd = new ProductDao(DbCon.getConnection());
    List<Product> products = pd.getAllProducts();
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if (cart_list != null) {
        request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/include/head.jsp"%>
        <title>Kimmy Shop</title>
    </head>
    <body>
        <%@include file="/include/navbar.jsp"%>

        <div class="container">
            <div class="card-header my-3">All Products</div>
            <div class="row">
                <%                    if (!products.isEmpty()) {
                        for (Product p : products) {
                %>
                <div class="col-md-3 my-3">
                    <div class="card w-100">
                        <img class="card-img-top" style="width: 250px; height: 250px" src="product-image/<%=p.getImage()%>"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title"><%=p.getName()%></h5>
                            <h6 class="price">Harga Rp. <%=p.getPrice()%></h6>
                            <h6 class="category">Kategori <%=p.getCategory()%></h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Tambah</a> 
                                <a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Beli Sekarang</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                        }
                    } else {
                        out.println("There is no proucts");
                    }
                %>

            </div>
        </div>

        <%@include file="/include/footer.jsp"%>
    </body>
</html>