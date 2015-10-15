<!-- Team 1 -->
<!-- 02/10/2015 -->
<!-- Task 8-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

	<section id="feature">
		<div class="container">
			<div class="row">
				<div class="span12">
					<article>
						<h1>Current Top Trending Yummy Topics in USA</h1>

						<script src="js/tagcanvas.min.js" type="text/javascript"></script>
						<script type="text/javascript">
							window.onload = function() {
								try {
									TagCanvas
											.Start(
													'myCanvas',
													'tags',
													{
														textFont : 'Impact,"Arial Black",sans-serif',
														textColour : '#0B3B39',
														textHeight : 25,
													});
								} catch (e) {
									// something went wrong, hide the canvas container
									document
											.getElementById('myCanvasContainer').style.display = 'none';
								}
							};
						</script>

						<div id="myCanvasContainer">

							<canvas id="myCanvas" width="700" height="500"
								style="cursor: pointer;"></canvas>

						</div>

						<div id="tags">
							<ul>
								<c:forEach items="${tweetBeanArray}" var="hash">
									<li><a
										href="<c:url value="${hash.url}">
									</c:url>"><c:out
												value="${hash.tag}"></c:out> </a></li>
								</c:forEach>
							</ul>
						</div>

						<c:forEach var="error" items="${errors}">
							<div class="span12">
								<div class="span8">

									<div class="well login-register">
										<h5 style="color: red; text-align: center">${error}</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</article>
				</div>
			</div>
		</div>
	</section>



<jsp:include page="template-bottom.jsp" />