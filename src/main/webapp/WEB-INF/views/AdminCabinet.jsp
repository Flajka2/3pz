<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Landing Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="stylesheet" href="${contextPath}/css/animate.css">
    <link rel="stylesheet" href="${contextPath}/css/main.css">
    <link rel="stylesheet" href="${contextPath}/css/carousel.css">
</head>
<body>
<header id="header" class="header">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <img src="${contextPath}/img/logo.png" alt="Logo" class="logo animated bounce">
            </div>
            <div class="col-lg-5">
                <nav>
                    <ul class="menu d-flex justify-content-center animated rubberBand">
                        <li class="menu__item">
                            <a href="${contextPath}/index.jsp">Home</a>
                        </li>
                        <li class="menu__item">
                            <a href="#">News</a>
                        </li>
                        <li class="menu__item">
                            <a href="#">Events</a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-2">
                <div class="login animated fadeInRight">
                    <a href="${contextPath}/logout">LogOut</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <h2>Hi admin!</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-6">
                <div class="main">
                    <h3 class="main__title">
                        Personal information of users
                    </h3>
                    <div class="main__intro">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim, voluptates.
                    </div>
                    <p class="main__text">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam beatae commodi doloremque esse et id obcaecati, quia voluptatum. Consequatur distinctio fuga inventore laborum,
                        porro recusandae reprehenderit sapiente. Commodi, dolore dolorem.
                    </p>
                </div>
            </div>
            <div class="col-lg-6">
                <h4 class="text-center">List of all users</h4>
                <div align="center">
                    <table class="tg">
                        <tr>
                            <th>User</th>
                            <th>Access</th>
                            <th>Block/Unblock</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${allUsers}" var="user" varStatus="status">
                            <tr valign="top">
                                <td>${user.lastname} ${user.name}</td>
                                <td>
                                    <c:if test = "${user.access == true}">
                                        active
                                    </c:if>
                                    <c:if test = "${user.access == false}">
                                        blocked
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test = "${user.access == true}">
                                        <a href="${contextPath}/blockUser?access=false&id_user=${user.id}">Block</a>
                                    </c:if>
                                    <c:if test = "${user.access == false}">
                                        <a href="${contextPath}/blockUser?access=true&id_user=${user.id}">Unblock</a>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="${contextPath}/deleteUser?id_user=${user.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>    
</header>

<footer id="footer" class="footer">
    <div class="container">
        <div class="row text-center text-xs-center text-sm-left text-md-left">
            <div class="col-xs-12 col-sm-3 col-md-3">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-3 col-md-3">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Videos</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-3 col-md-3">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href="https://wwwe.sunlimetech.com" title="Design and developed by"><i class="fa fa-angle-double-right"></i>Imprint</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-3 col-md-3">
                <h5>Quick links</h5>
                <ul class="list-unstyled quick-links">
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Home</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>About</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>FAQ</a></li>
                    <li><a href="javascript:void();"><i class="fa fa-angle-double-right"></i>Get Started</a></li>
                    <li><a href="https://wwwe.sunlimetech.com" title="Design and developed by"><i class="fa fa-angle-double-right"></i>Imprint</a></li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
                <ul class="list-unstyled list-inline social text-center">
                    <li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-facebook-f"></i></a></li>
                    <li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-twitter"></i></a></li>
                    <li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-instagram"></i></a></li>
                    <li class="list-inline-item"><a href="javascript:void();"><i class="fab fa-google-plus-g"></i></a></li>
                    <li class="list-inline-item"><a href="javascript:void();" target="_blank"><i class="fa fa-envelope"></i></a></li>
                </ul>
            </div>
            </hr>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
                <p class="h6">&copy All right Reversed</p>
            </div>
            </hr>
        </div>
    </div>
</footer>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>