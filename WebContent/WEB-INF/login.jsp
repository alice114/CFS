<!-- Team 1 -->
<!-- 02/10/2015 -->
<!-- Task 8-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>"></base>
<meta charset="utf-8">
<title>Yummy! Find Something To Eat!</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Styles -->
<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/style.css" rel="stylesheet">
<link rel='stylesheet' id='prettyphoto-css'
	href="<%=basePath%>css/prettyPhoto.css" type='text/css' media='all'>
<link href="<%=basePath%>css/fontello.css" type="text/css"
	rel="stylesheet">

<!-- Google Web fonts -->
<link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Patua+One'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>

<style>
body {
	padding-top: 60px;
}
</style>

</head>
<link href="<%=basePath%>css/bootstrap-responsive.css" rel="stylesheet">
<!-- Favicon -->
<link rel="shortcut icon" href="<%=basePath%>img/favicon.ico">
<!-- JQuery -->
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<!-- Load ScrollTo -->
<script type="text/javascript"
	src="<%=basePath%>js/jquery.scrollTo-1.4.2-min.js"></script>
<!-- Load LocalScroll -->
<script type="text/javascript"
	src="<%=basePath%>js/jquery.localscroll-1.2.7-min.js"></script>
<!-- prettyPhoto Initialization -->
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("a[rel^='prettyPhoto']").prettyPhoto();
	});
</script>
</head>

<body>
	<!-- Navbar starts -->
	<div class="navbar-wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a>
					<h1 class="brand">
						<a href="#top">Yummy!</a>
					</h1>
					<!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
					<nav class="pull-right nav-collapse collapse">
						<ul id="menu-main" class="nav">
							<c:choose>
								<c:when test="${ (empty title) }">
									<li><a href="login.do"></i>Login</a></li>
									<li><a href="register.do"></i>Register</a></li>
								</c:when>
								<c:otherwise>
									<li><%=request.getAttribute("title")%></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
				</div>
				<!-- /.container -->
			</div>
			<!-- /.navbar-inner -->
		</div>
		<!-- /.navbar -->
	</div>
	<!-- /.navbar-wrapper -->
	<div id="top"></div>
	<!-- ******************** HeaderWrap ********************-->
	<div id="headerwrap">
		<header class="clearfix">
			<h1>
				<span>Yummy!</span> Find Delicious Food!
			</h1>
			<div class="container">
				<form method="post" action="login.do">
					<div class="row">
						<div class="span12">
							<h2>Login</h2>
							<br><br>
							<c:forEach var="error" items="${errors}">
								<h2 style="color: red; text-align: center">${error}</h2>
							</c:forEach>
							<!-- Email -->
							<input type="text" name="username"
								value="" class="cform-text" placeholder ="username" size="20" title="your username"><br><br>
							<!-- Password -->
							<input type="password" name="password"
								value="" class="cform-text" placeholder ="password" size="20" title="your password"><br><br><br><br>
							<input type="submit" name="button" value="Login"
								class="cform-submit">
						</div>
					</div>
				</form>
				<div class="row">
					<div class="span12">
						<ul class="icon">
							<li><a href="#" target="_blank"><i
									class="icon-twitter-circled"></i></a></li>
							<li><a href="#" target="_blank"><i
									class="icon-gplus-circled"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
	</div>

	<div class="footer-wrapper">
		<div class="container">
			<footer>
				<small>Copyright &copy Ebiz 2015 Team 1 </small>
			</footer>
		</div>
	</div>
</body>
</html>

