<nav class="navbar navbar-expand-lg navbar-light bg-success">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Kimmy</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Beranda</a></li>
                    <%
                        if (request.getSession().getAttribute("auth") != null) {
                    %>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Keranjang <span class="badge badge-danger">${cart_list.size()}</span> </a></li>
                <li class="nav-item"><a class="nav-link" href="orders.jsp">Pesanan</a></li>
                <li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
                    <%
                    } else {
                    %>
                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="registrasi.jsp">Registrasi</a></li>
                    <%
                        }
                    %>
            </ul>
        </div>
    </div>
</nav>