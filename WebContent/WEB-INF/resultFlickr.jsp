<!-- Team 1 -->
<!-- 02/10/2015 -->
<!-- Task 8-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<section id="portfolio" class="single-page scrollblock">
	<h1 align="center">Do you want any of these #Yummy! food items? Hmmm..its delicious</h1>
	<br>
	<br>
	<div class="container">
		<c:forEach var="error" items="${errors}">
			<h5 style="color: red; text-align: center">${error}</h5>
		</c:forEach>
		<div class="row">

			<form method="POST" action="resultFlickr.do">

				<c:if test="${empty flickrs}">
					<p align="center">No result found. Please try another keyword.</p>
				</c:if>
				<c:if test="${!empty flickrs}">
					<c:forEach items="${flickrs}" var="flickr">
						<div class="span4">
							<div class="mask2">

								<a href="${flickr.url}" rel="prettyPhoto"> <img alt=""
									src="${flickr.url}"></a>
								<div class="inside">
									<hgroup>
										<h2>${flickr.title}</h2>
									</hgroup>
								</div>
								<br>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</form>
		</div>
	</div>
</section>
<jsp:include page="template-bottom.jsp" />