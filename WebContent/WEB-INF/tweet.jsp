<!-- Team 1 -->
<!-- 01/15/2015 -->
<!-- Task 7-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />
<style>
p {
	font-size: large;
	color: white;
}
</style>
<div id="headerwrap">
	<header class="clearfix">
		<div class="container">
			<div class="row">
				<div class="span12">
					<h3>Tweet with Photo!</h3>
					<br>
					<c:forEach var="error" items="${errors}">
						<h2 style="color: red; text-align: center">${error}</h2>
					</c:forEach>


					<form method="post" action="tweet.do">
						<p>What is your #Yummy! mind saying?</p>
						<input type="text" name="tweet_state" value="#Yummy!"
							class="cform-text" size="40" title="State"><br><br>
						<p>Please write the path of the photo you want to post in the
							following text field</p>
						<input type="text" name="photo_dir" value="photo"
							class="cform-text" size="40" title="Photo Dir">
						<p></p>
						<input type="submit" value="Submit" class="cform-submit">
					</form>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />