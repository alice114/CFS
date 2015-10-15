<!-- Team 1 -->
<!-- 02/10/2015 -->
<!-- Task 8-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />
<div id="headerwrap">
	<header class="clearfix">
		<h3>Upload Photo to Flickr!</h3>

		<div class="container">
			<div class="row">
				<div class="span12">
					<c:forEach var="error" items="${errors}">
						<h2 style="color: red; text-align: center">${error}</h2>
					</c:forEach>

					<p style="font-size: large; color:white;">Add a new picture:</p>

					<form method="post" action="uploadPhoto.do"
						enctype="multipart/form-data">
						<input type="text" name="dir" value="" class="cform-text"
							size="40" title="your email"> <br><br><br><input type="submit"
							value="Upload Photo" name="button" class="cform-submit">
					</form>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />