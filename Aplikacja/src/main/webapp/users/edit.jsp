<%--
  Created by IntelliJ IDEA.
  User: krzysztofburoszek
  Date: 20/12/2020
  Time: 07:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/users/header.jsp" %>

<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">MODYFIKACJA</h1>
    </div>
    <form method="post">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <form method="post">
                        <table class="table">
                            <tr>
                                <th>NOWA NAZWA UŻYTKOWNIKA:  </th>
                            </tr>
                            <tr>
                                <th><input value="${userDao.userName}" name="userDao" type="text"/></th>
                            </tr>
                            <tr>
                                <th>NOWY EMAIL UŻYTKOWNIKA</th>
                            </tr>
                            <tr>
                                <th><input value="${userDao.email}" name="email" type="text"/></th>
                            </tr>
                            <tr>
                                <th>NOWE HASŁO UŻYTKOWNIKA</th>
                            </tr>
                            <tr>
                                <th><input type="text" name="password"></th>
                            </tr>
                        </table>
                        <button type="submit" class="btn btn-primary">ZAPISZ</button>
                        <a href='<c:url value="/list"/>'>LISTA</a>
                    </form>
                </div>
            </div>
        </div>
    </form>
</div>
</div>


<%@ include file="/users/footer.jsp" %>
