<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>登录</title>

    <!-- Bootstrap Core CSS -->
    <link href="/EnhancedTutorial/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/EnhancedTutorial/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/EnhancedTutorial/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/EnhancedTutorial/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you util the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">请登录</h3>
                </div>
                <div class="panel-body">
                <div>
                	<span id = "message"></span>
                </div>
                    <form role="form" location="EnhancedTutorial/login">
                            <div class="form-group">
                                <input id="username" class="form-control" placeholder="账户名" name="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input id="password" class="form-control" placeholder="密码" name="password" type="password">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="RememberMe">记住我
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input id ="login" type="button" value="登录" class="btn btn-primary form-control" >
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/EnhancedTutorial/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/EnhancedTutorial/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/EnhancedTutorial/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/EnhancedTutorial/dist/js/sb-admin-2.js"></script>

<!-- Background -->
<script src="/EnhancedTutorial/bower_components/login/jquery.backstretch.min.js"></script>
<script src="/EnhancedTutorial/bower_components/login/scripts.js"></script>
<script type="text/javascript">

	$(function() {
		$("#login").click(function() {
			var name = $("#username").val();
			var pwd = $("#password").val();
			var url = $("#location").val();
			$.ajax({
				url:"/EnhancedTutorial/login",
				type:"post",
				data:{
					"username":name,
					"password":pwd
				},
				dataType:"json",
				success:function() {

				},
				error:function(res) {
					var a = res.responseText;
					if(a == 'ok'){
						location.href="home";
					}
					$("#message").text(a);
				}
			});
		});

	});
</script>
</body>

</html>
