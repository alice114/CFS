<!-- Team 1 -->
<!-- 02/10/2015 -->
<!-- Task 8-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />



<jsp:include page="template-bottom.jsp" />


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
				<p style="color:white"><b>
					Copy the link, and open in new tab.<br> Do not hit back button
					on the browser now.<br>
					<%
						String url = request.getAttribute("authUrl").toString();
					%>
					<a style = "background:orange; color:black" href="<%=url%>"><%=url%></a><br> Click on authorize the
					app, get the pin, and paste it in the box below.<br> </b>
					</p>
					<form action="access.do" method="post">
						<input type="text" name="pin"> <input type="hidden"
							name="service" value="<%=request.getAttribute("service")%>">
						<input type="hidden" name="requestToken"
							value="<%=request.getAttribute("requestToken")%>"> <input
							type="submit" name="authorize" value="authorize">


					</form>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />