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
        <h1 class="h3 mb-0 text-gray-800">NOWY UŻYTKOWNIK</h1>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form method="post">
                    <table class="table">
                        <tr>
                            <th>NAZWA UŻYTKOWNIKA</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="username" value="nazwa"></th>
                        </tr>
                        <tr>
                            <th>EMAIL UŻYTKOWNIKA </th>
                        </tr>
                        <tr>
                            <th><input type="text" name="email" value="email"></th>
                        </tr>
                        <tr>
                            <th>HASŁO UŻYTKOWNIKA</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="password" value="hasło"></th>
                        </tr>
                    </table>
                    <button type="submit" class="btn btn-primary">Zapisz</button>
                    <button type="submit" href="/list" class="nav-link">List</button>

                </form>
            </div>
        </div>
    </div>
</div>
</div>


<%@ include file="/users/footer.jsp" %>
