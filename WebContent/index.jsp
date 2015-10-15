<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="WEB-INF/template-top.jsp" />


<tag:notloggedin>
	<div id="headerwrap">
		<header class="clearfix">
			<h1>
				<span>Yummy!</span> Find Delicious Food!
			</h1>

			<div class="container">
				<div class="row">
					<div class="span12">
						<c:forEach var="error" items="${errors}">
							<h2 style="color: red; text-align: center">${error}</h2>
						</c:forEach>
						<br>
						<br>
						<br> <a href="signin"><img
							src="./images/Sign-in-with-Twitter-darker.png" /></a>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<ul class="icon">
							<li><a href="#" target="_blank"><i
									class="icon-flickr-circled"></i></a></li>
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
</tag:notloggedin>
<tag:loggedin>
	<div id="headerwrap">
		<header class="clearfix">
			<h3>
				<span>Welcome! </span> ${twitter.screenName} ！
			</h3>
			
			<h2>
				<span>Share your #Yummy! Ideas! </span> 
			</h2>

			<div class="container">
				<div class="row">
					<div class="span12">
						<c:forEach var="error" items="${errors}">
							<h2 style="color: red; text-align: center">${error}</h2>
						</c:forEach>
					</div>
				</div>

				<form action="./post" method="post">
				<br>
					<input type="text" name="text" value="#Yummy!" class="cform-text" size="40" title="postTwitter"> 
					<br><br><br>
					<input type="submit" name="post" value="Share" class="cform-submit" />
				</form>
			</div>
		</header>
	</div>
</tag:loggedin>
</body>
</html>

