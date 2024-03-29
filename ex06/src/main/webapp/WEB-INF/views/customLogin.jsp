<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec " %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3D//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<h1>Custom Login Page</h1>
<h2><c:out value="${error}" /></h2>
<h2><c:out value="${logout}" /></h2>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                    
						<!-- 반드시 post 방식으로 /login 에 전송 -->
						<form role="form" method="post" action="/login">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="userid" type="text" name="username" autofocus />
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" type="text" name="password" type="password" value="" />
								</div>
							
								<div class="checkbox">
									<label>
										<input type="checkbox" name="remember-me"> Remember Me
									</label>
								</div>
								<a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
								<img alt="카카오로그인" src="/resources/img/kakao_login_medium_narrow.png" onclick="loginWithKakao()" >
							</fieldset>
							
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						</form>
						
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
    
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
	
    <script type="text/javascript">
    $(document).ready(function(){
        Kakao.init('script앱키 입력');
        Kakao.isInitialized();
    });

    function loginWithKakao() {
        Kakao.Auth.authorize({ 
        redirectUri: 'http://localhost:8080/kakao_callback' 
        }); // 등록한 리다이렉트uri 입력
    }
    
    <script type="text/javascript">
    	
    $(".btn-success").on("click", function(e) {
    	
    	e.preventDefault();
    	$("form").submit();
    	
    });
    </script>

</body>
</html>