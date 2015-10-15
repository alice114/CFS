<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<jsp:include page="WEB-INF/template-top.jsp" />
  <head><title>Error</title></head>
  <body>Failed to connect to the Twitter API<br>
  ${exception.message}</body>
</html>