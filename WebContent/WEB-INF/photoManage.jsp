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
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Title and other stuffs -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,600,700'
	rel='stylesheet' type='text/css'>

<link href="<%=basePath%>style/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>style/font-awesome.css">
<link rel="stylesheet" href="<%=basePath%>style/flexslider.css">
<link rel="stylesheet" href="<%=basePath%>style/prettyPhoto.css">
<link href="<%=basePath%>style/style.css" rel="stylesheet">
<link href="<%=basePath%>style/bootstrap-responsive.css"
	rel="stylesheet">

<link rel="shortcut icon" href="<%=basePath%>/img/favicon/favicon.png">
<title>Food Explore</title>
<style>
.h7 {
	margin: 1px 0px;
	padding: 1px 0px;
	font-weight: 600;
	font-size: 30px;
	line-height: 70px;
	margin-top: 40px;
}
</style>

</head>


<body>
	<!-- Navbar starts -->

	<tr>
		<!-- Navigation bar is one table cell down the left side -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a>
					<div class="nav-collapse collapse">
						<ul class="nav pull-right">
							<c:choose>
								<c:when test="${ (empty title) }">
									<li><a href="upload.do"></i>Login</a></li>
								</c:when>
								<c:otherwise>
									<li><%=request.getAttribute("title")%></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- Navbar ends -->
	</tr>
<div class="matter">
				<div class="container-fluid">
					<p align="center">
						<span class="h7">Upload your own photo</span>
					</p>
					<br>
					<c:forEach var="error" items="${errors}">
						<h5 style="color: red; text-align: center">${error}</h5>
					</c:forEach>
				</div>
			</div>
	<!-- Navbar ends -->
	</tr>
<div class="content">
		<td valign="top">
 			<!-- JS --> <script src="<%=basePath%>js/jquery.js"></script> <script
				src="<%=basePath%>js/bootstrap.js"></script> <!-- Bootstrap --> <script
				src="<%=basePath%>js/filter.js"></script> <!-- Filter JS --> <script
				src="<%=basePath%>js/jquery.carouFredSel-6.1.0-packed.js"></script>
			<!-- CarouFredSel --> <script
				src="<%=basePath%>js/jquery.flexslider-min.js"></script> <!-- Flexslider -->
			<script src="<%=basePath%>js/jquery.isotope.js"></script> <!-- Isotope -->
			<script src="<%=basePath%>js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->
			<script src="<%=basePath%>js/jquery.tweet.js"></script> <!-- Tweet -->
			<script src="<%=basePath%>js/custom.js"></script> <!-- Main js file -->

			<div class="matter">
				<div class="container-fluid">
					<p align="center">
						<span class="h7">Photo Upload</span>
					</p>
					<br>
					<c:forEach var="error" items="${errors}">
						<h5 style="color: red; text-align: center">${error}</h5>
					</c:forEach>
				</div>
			</div>
			
<form method="post" action="upload.do" enctype="multipart/form-data">
		
		<table>
			<tr>
				<td>File: </td>
				<td colspan="2"><input type="file" name="file" value="${filename}"/></td>
			</tr>
			<tr>
				<td>Caption: </td>
				<td><input type="text" name="caption" value="${caption}"/></td>
				<td>(optional)</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="button" value="Upload File"/>
				</td>
			</tr>
		</table>
	</form>
</p>
<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="clearfix"></div>
	<footer>
		<div class="bor"></div>
		<p>
			<a>Copyright &copy Ebiz 2015 Team 1</a>
		</p>
	</footer>
	<tr>
	</tr>
</body>
</html>