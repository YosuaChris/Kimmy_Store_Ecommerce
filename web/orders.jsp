<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.OrderDao"%>
<%@page import="connection.DbCon"%>
<%@page import="dao.ProductDao"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
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
            <div class="card-header my-3">All Orders</div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Tanggal</th>
                        <th scope="col">Nama</th>
                        <th scope="col">Kategori</th>
                        <th scope="col">Kuantitas</th>
                        <th scope="col">Harga</th>
                        <th scope="col">Batal</th>
                    </tr>
                </thead>
                <tbody>

                    <%if (orders != null) {
                            for (Order o : orders) {%>
                    <tr>
                        <td><%=o.getDate()%></td>
                        <td><%=o.getName()%></td>
                        <td><%=o.getCategory()%></td>
                        <td><%=o.getQunatity()%></td>
                        <td><%=dcf.format(o.getPrice())%></td>
                        <td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Batalkan Pesanan</a></td>
                    </tr>
                    <%}
                        }
                    %>

                </tbody>
            </table>
        </div>

        <%@include file="/include/footer.jsp"%>
    </body>
</html>