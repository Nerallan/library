<!DOCTYPE HTML>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=utf-8" %>

<html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="/js/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script>
function send(){

        $.post({
            url: "/login",
            timeout: 30000,
            cache: false,
            data: {
                "login" : $("#login_id").val(),
                "passwd" : $("#password_id").val()
                                },
             success : function(success){

             window.location.href='/info';}

             });

}

    </script>

    <!-- my css -->
    <link href="/WebContent/css/style.css"  rel="stylesheet" />
</head>
<body>
<div>

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Logo</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">HELLO</a></li>
                    <li><a href="login">LOGIN</a></li>
                    <li><a href="registration">REGISTRATION</a></li>
                    <li><a href="bookdata">BOOKS</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Merchandise</a></li>
                            <li><a href="#">Extras</a></li>
                            <li><a href="#">Media</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
                </ul>
            </div>
        </div>
    </nav>

</div>


<div class="body">
    <div>
        <input type="input" class="form-control" id="login_id" placeholder="Введите логин">
    </div>
</br>
    <div>
        <input type="password" class="form-control" id="password_id" placeholder="Введите пароль">
    </div>
</br>
    <div>
        <span>
            <button style="margin-right:30px;" id="button" type="button" class="btn btn-success" onclick="send();">ok</button>
        </span>
        <span>
        <a href="/registration">
            <button  type="button" class="btn btn-info" id="button2">registration</button>
        </a>
        </span>
    </div>
<div>


<style>
    body{
    font-style:Georgia, serif;
        font-weight: 450;
        }
    .body{
    margin-left:200px;
    margin-top:200px;
    }
    input[type="input"]{
            width: 300px;
            height: 40px;
        }
        input[type="password"]{
                width: 300px;
                height: 40px;
            }
</style>
</body>
</html>