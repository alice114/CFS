<!-- Team 1 -->
<!-- 01/15/2015 -->
<!-- Task 7-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<div id="headerwrap">
	<header class="clearfix">
		<div class="container">
			<div class="row">
				<div class="span12">
					<h2>Search Food On Flickr!</h2>
					<br>
					<c:forEach var="error" items="${errors}">
						<h2 style="color: red; text-align: center">${error}</h2>
					</c:forEach>
					
					<a href='#' onclick='javascript:window.open(${authURL}, "_blank", 
					"scrollbars=1,resizable=1,height=300,width=450");' title='Pop Up'>Authenticate URL: ${authURL}</a>
					<p>Please copy the above URL to your favorite browser to do authentication</p>
					<p>And then paste the pin into the test field below</p>
					<p>After that, click submit to continue</p>
					<form method="post" action="tweetAuth.do">
						<input type="text" name="pin" value="" class="cform-text" size="40" title="pin">
					    <input type="submit" value="Submit" class="cform-submit">
					</form>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />