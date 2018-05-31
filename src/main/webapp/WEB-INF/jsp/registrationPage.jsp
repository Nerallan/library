<!DOCTYPE HTML>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<html>
<head>
    <title>ABank</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="/js/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script>

        function login(){
            if($("#client_passwd1").val()==$("#client_passwd2").val()){
                $.post({
                    url: "/add-new-user",
                    timeout: 30000,
                    cache: false,
                    data: {
                        "name" : $("#client_name").val(),
                        "surname" :  $("#client_surname").val(),
                        "passwd" : $("#client_passwd1").val(),
                        "login" : $("#client_login").val()
                                        }

                });
            }

        }

    </script>

</head>
<body>
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


<div class="jubmotron">
    <div class="inputdata">
        <h1>Log in to the system</h1>
    </div>
</div>

<form role="form" class="inputdata">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="input" class="form-control" id="client_name" placeholder="input name">
    </div>
    <div class="form-group">
        <label for="surname">Surname</label>
        <input type="input" class="form-control" id="client_surname" placeholder="input surname">
    </div>
    <div class="form-group">
            <label for="login">Login</label>
            <input type="input" class="form-control" id="client_login" placeholder="input login">
        </div>
    <div class="form-group">
        <label for="passwd">Password</label>
        <input type="password" class="form-control" id="client_passwd1" placeholder="input password">
    </div>
    <div class="form-group">
        <label for="passwd">Password</label>
        <input type="password" class="form-control" id="client_passwd2" placeholder="input password">
    </div>
    <button type="submit" class="btn btn-success" id="button_id" onclick="login();">login</button>
</form>
<style>
      input[type="input"]{
        width: 300px;
        height: 40px;
    }
    input[type="password"]{
            width: 300px;
            height: 40px;
        }
    .inputdata{
        margin-left:200px;
        margin-top:200px;
    }
    body{
        font-style:Georgia, serif;
            font-weight: 450;
            }

</style>
</body>
</html>
