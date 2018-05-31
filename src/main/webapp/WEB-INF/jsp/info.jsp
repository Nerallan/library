<!DOCTYPE HTML>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="/js/jquery-1.10.2.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script>
        function add_account(){
            $.post({
                url:"/add_account"

            });
            location.reload();
        }
         function block_account(){
            var account_id = $("#accounts").val();
            if(account_id){
                $.post({
                    url:"/block_account",
                    data:{
                        "accountName": account_id
                    }
                });
                location.reload();
            }

        }

        function get_cards(){
            var account_id = $("#accounts").val();
            $.get({
                url:"/get_cards",
                data:{
                    "accountName": account_id
                },
                success:function(str){
                    $.each(str.split(","), function(value) {
                         $('#cards')
                             .append($("<option></option>")
                                        .attr("value",value)
                                        .text(value));
                    });
                }
            });

         }


         function add_card(){
             var account_id = $("#accounts").val();
             if(account_id){
                $.post({
                    url:"/add_card",
                    data:{
                        "accountId":account_id
                    },
                });
                location.reload();
            }
         }


    </script>
</head>
<body>
<div>
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-toggle="#bs-example-navbar-collapse-1">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">ABank</a>
            </div>


            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#" class="active">LOGIN</a></li>
                    <li><a href="#">EXCHANGE RATES</a></li>
                    <li><a href="#">DEPARTMENTS</a></li>
                    <li><a href="#">BANK CARDS</a></li>
                    <li><a href="#">VACANCY</a></li>
                    <li><a href="#">ABOUT US</a></li>


                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">INTERNET BANKING<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">INFO</li>
                            <li class="divider"></li>
                            <li><a href="#">INTERNET BANK FEATURES</a></li>
                            <li><a href="#">INSTRUCTIONS FOR USE</a></li>
                        </ul>
                    </li>
                </ul>

                <div class="navbar-collapse colapse">
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Site search">
                            <button type="submit" class="btn btn-success">Search</button>
                        </div>
                    </form>

                </div>
    </nav>
</div>


<div class="body">
    <div>
        Client</br>
        Name:${name}</br>
        Surname: ${surname}</br>
    </div>
    </br>
    <div>
        LIST OF ACCOUNTS:
        <select onchange="get_cards();" style="width:200px;" id="accounts">
            <c:forEach var="item" items="${accounts}">
                <option value="${item.id}">${item.id}|${item.balance}</option>
            </c:forEach>
        </select>

        <span style="margin-right:20px;" id="add_account">
            <button type="button" class="btn btn-success" onclick="add_account();">add account</button>
        </span>
        <span id="block_account">
            <button type="button" class="btn btn-danger" onclick="block_account();">block account</button>
        </span>
    </div>


    <div style="margin-top:40px;">
        LIST OF CARDS:
        <span style="margin-right:20px;">
           <select style="width:200px;" id="cards">

           </select>
        </span>
        <span id="add_card">
                <button type="button" class="btn btn-success">add card</button>
        </span>
    </div>

    <div style="margin-top:40px;">
        LIST OF PAYMENTS:
        <span>
            <select style="width:200px;" id="list_accounts">
                     <c:forEach var="item" items="${list_accounts}">
                         <option value="${item}">${item}</option>
                     </c:forEach>
                 </select>
         </span>
        <span style="margin-left:30px;" id="pay">
                    <button type="button" class="btn btn-info">pay now</button>
                </span>

        <span style="margin-left:30px;" id="add_money">
                          <button type="button" class="btn btn-info" id="put_money">to put 100 rubles</button>
                      </span>
    </div>

    <div style="margin-left:30px;">
        <button type="button" class="btn btn-info">LOG OUT</button>
    </div>
</body>
<style>
    #accounts,cards,list_accounts{
       -webkit-appearance: button;
       -webkit-border-radius: 2px;
       -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.1);
       -webkit-padding-end: 20px;
       -webkit-padding-start: 2px;
       -webkit-user-select: none;
       background-image: url(http://i62.tinypic.com/15xvbd5.png), -webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5);
       background-position: 97% center;
       background-repeat: no-repeat;
       border: 1px solid #AAA;
       color: #555;
       font-size: inherit;
       margin: 20px;
       overflow: hidden;
       padding: 5px 10px;
       text-overflow: ellipsis;
       white-space: nowrap;
       width: 300px;
    }
    .body{
           margin-left:30px;
    }
    body{
        font-style:Georgia, serif;
            font-weight: 450;
            }



</style>
</body>
</html>