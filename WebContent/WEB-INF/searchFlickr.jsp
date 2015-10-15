<!-- Team 1 -->
<!-- 01/15/2015 -->
<!-- Task 7-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<div id="headerwrap">
	<header class="clearfix">
		<h3>Search Food On Flickr!</h3>

		<div class="container">
			<div class="row">
				<div class="span12">

					<br>
					<c:forEach var="error" items="${errors}">
						<h2 style="color: red; text-align: center">${error}</h2>
					</c:forEach>
					<form method="post" action="searchFlickr.do">
						<input type="text" name="keyword" value="" class="cform-text"
							size="40" title="your email"> <input type="submit"
							value="Search" class="cform-submit">
					</form>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />