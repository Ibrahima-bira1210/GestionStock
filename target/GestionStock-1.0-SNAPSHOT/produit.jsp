<%--
  Created by IntelliJ IDEA.
  User: ibrahima
  Date: 13-08-2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Produit</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
   <%@include file="header.jsp"%>
    <div class="container col-md-10 col-md-offset-1">
        <div class="panel panel-primary">
            <div class="panel-heading">Recherche Produit</div>
            <div class="panel-body">
                <form action="chercher.do" method="get">
                    <label>Mot cle</label>
                    <input type="text" name="motCle">
                    <button text="submit" class="btn btn-primary" value="${model.motCle}">Chercher</button>
                </form>
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>DESIGNATION</th>
                        <th>PRIX</th>
                        <th>Quantite</th>
                        <th>Supprimer</th>
                        <th>Editer</th>
                    </tr>
                    <c:forEach items="${model.produits}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.designation}</td>
                            <td>${p.prix}</td>
                            <td>${p.quantite}</td>
                            <td><a onclick="return confirm("Etes vous sure de vouloir supprimer?")" href="suprimer.do?id=${p.id}">delete</a></td>
                            <td><a href="edit.do?id=${p.id}">edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
