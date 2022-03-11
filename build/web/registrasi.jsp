<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/include/head.jsp"%>
        <title>Kimmy Registrasi</title>
    </head>
    <body>
        <%@include file="/include/navbar.jsp"%>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">User Registrasi</div>
                <div class="card-body">
                    <form action="RegistrasiServlet" method="post">
                        <div class="form-group">
                            <label>Name</label> 
                            <input type="text" name="registrasi-name" class="form-control" placeholder="Input Name">
                        </div>
                        <div class="form-group">
                            <label>Email address</label> 
                            <input type="email" name="registrasi-email" class="form-control" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label>Password</label> 
                            <input type="password" name="registrasi-password" class="form-control" placeholder="Password">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Sign Up</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/include/footer.jsp"%>
    </body>
</html>
