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
<div class="container col-md-8 col-md-offset-2 col-xs-12">
    <div class="panel panel-primary">
        <div class="panel-heading">Confirmation</div>
        <div class="panel-body">
            <div class="form-group">
                <label>ID:</label>
                <label>${produit.id}</label>
            </div>
            <div class="form-group">
                <label>designation:</label>
                <label>${produit.designation}</label>
            </div>
            <div class="form-group">
                <label>prix:</label>
                <label>${produit.prix}</label>
            </div>
            <div class="form-group">
                <label>Quantite:</label>
                <label>${produit.quantite}</label>
            </div>
        </div>
    </div>
</div>
</body>
</html>

