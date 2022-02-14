<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/login/admin/common" var="url"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="${url}/head.jsp"/>
</head>
<body>
<jsp:include page="${url}/header.jsp"/>

<div class="container-fluid">
    <h3>EDIT PRODUCT</h3>
    <p><c:if test="${requestScope.checkEdit}">EDIT Thành Công !</c:if></p>
</div>

<div class="container col-md-9">
    <div class="row">
        <div class="col-md-6">
            <h3>Form EDIT PRODUCT </h3>
            <form>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="ID" name="id" disabled>
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="SERIAL" name="serial" value="${requestScope.product.serial}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="NAME" name="name" value="${requestScope.product.name}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="number" class="form-control" placeholder="Category" name="category" value="${requestScope.category}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="number" class="form-control" placeholder="Brand" name="brand" value="${requestScope.brand}">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">$</span>
                    <input type="text" class="form-control" aria-label="Dollar amount" placeholder="Price" name="price" value="${requestScope.product.price}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="QUANTITY" name="quantity" value="${requestScope.product.quantity}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="DESCRIPTION" name="description" value="${requestScope.product.description}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="IMG LINK" name="imageURL" value="${requestScope.product.img}">
                </div>
                <div class="input-group mt-3 mb-3">
                    <input type="text" class="form-control" placeholder="CREATE DATE">
                </div>
                <input type="submit" value="EDIT PRODUCT" href="admin?action=edit&id=${requestScope.product.id}">
            </form>
        </div>
    </div>
</div>