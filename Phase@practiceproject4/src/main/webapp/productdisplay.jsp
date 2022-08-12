<%@  page import= "java.util.List" %>
<%@page  import= "com.samples.domain.Product" %>

 <%
   Product product = (Product)session.getAttribute("Products");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table class ="table">
   <tbody>
    <tr>
    <td>id: </td>>
    <td><%=product.getId() %></td>>
    </tr>
    <tr>
    <td>PNAME: </td>>
    <td><%=product.getPName() %></td>>
    </tr>
    <tr>
    <td>PCOST: </td>>
    <td><%=product.getPcost() %></td>>
    </tr>
    <tr>
    <td>PCATEGORY: </td>>
    <td><%=product.getPcategory() %></td>>
    </tr>
   </tbody>
  </table>
  <p><a href="product.html">Back</a>
</body>
</html>