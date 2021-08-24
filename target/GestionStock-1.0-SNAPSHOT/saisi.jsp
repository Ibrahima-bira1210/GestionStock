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
        <div class="panel-heading">Creer Produit</div>
        <div class="panel-body">
            <form action="save.do" method="POST">
                <div class="form-group">
                    <label for="designation" class="control-label">Designation</label>
                    <input type="text" class="form-control" name="designation" id="designation" placeholder="Designation" required/>
                </div>
                <div class="form-group">
                    <label for="Prix" class="control-label">Prix</label>
                    <input type="text" class="form-control" name="prix" id="Prix" placeholder="Prix" required/>
                </div>
                <div class="form-group">
                    <label for="quantite" class="control-label">Qunatite</label>
                    <input type="text" class="form-control" name="quantite" id="quantite" placeholder="quantite" required />
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
