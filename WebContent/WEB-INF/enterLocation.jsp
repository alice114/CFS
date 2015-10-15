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
				<h3>Search On Twitter!</h3>
					<br>
					<c:forEach var="error" items="${errors}">
						<h2 style="color: red; text-align: center">${error}</h2>
					</c:forEach>
					<form method="post" action="viewTrends.do">
						<input type="text" name="keyword" value="" class="cform-text"
							size="40"><br><br>
							<h4 style = "color:white"><input type="radio" name = "option" value = "popular">&nbsp Popular<br>
							<input type="radio" name = "option" value = "recent">&nbsp Recent</h4><br><br><br>
							 <input type="submit" name = "submit"
							value="Search" class="cform-submit">
							
					</form>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />