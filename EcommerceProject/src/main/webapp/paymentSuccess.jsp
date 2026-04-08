<%
    String amount = request.getParameter("amount");
    String method = request.getParameter("method");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Payment Success</title>
    <style>
        body { font-family: Arial; background:#d4edda; color:#155724; text-align:center; padding:50px; }
        h2 { font-size:32px; }
        p { font-size:20px; }
        a { display:inline-block; margin-top:20px; padding:10px 20px; background:#28a745; color:white; text-decoration:none; border-radius:6px; }
        a:hover { background:#218838; }
    </style>
</head>
<body>
    <h2>✅ Payment Successful!</h2>
    <p>Amount Paid: ₹<%= amount %></p>
    <p>Payment Method: <%= method %></p>
    <a href="productList.jsp">Continue Shopping</a>
</body>
</html>
