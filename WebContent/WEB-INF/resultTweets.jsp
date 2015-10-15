<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="template-top.jsp" />

<div id="headerwrap">
	<header class="clearfix">
		<div class="container">
			<div class="row">
				<h3>
					Showing tweets for the search keyword: ${keyword}<br> <br>
				</h3>
				<div class="span12">
					<div style="background-color: white; opacity: 1">
						<b> <br> <c:forEach var="displayTweet"
								items="${display_tweets_list}" varStatus="status">
								<div class="span2 offset1" style="padding-right:50px;">
									<div class="teamalign">
										<img class="team-thumb img-circle" alt=""
											src="${displayTweet.profile_image_url_https }"
											data-src-2x="${displayTweet.profile_image_url_https }"
											data-scribe="element:avatar"> <br>
									</div>
									<div class="job-position">${displayTweet.name }</div>
									<div class="job-position">@${displayTweet.sreen_name}</div>
								</div>

								
								<br><p align ="left" style="padding-right:30px;margin-left:30px;">${displayTweet.text}<br>
					${displayTweet.created_at}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp source:${displayTweet.source }<br>


								<a href='${displayTweet.expanded_url}' rel="nofollow"
									onclick='javascript:window.open(${displayTweet.expanded_url}, "_blank", 
					"scrollbars=1,resizable=1,height=300,width=450");'
									title='Pop Up'>${displayTweet.expanded_url }</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<a href='${displayTweet.url}' rel="nofollow"
									onclick='javascript:window.open(${displayTweet.url }, "_blank", 
					"scrollbars=1,resizable=1,height=300,width=450");'
									title='Pop Up'>${displayTweet.url }</a>
								<br>
								
								<c:choose>

						<c:when test="${not empty displayTweet.media_url_https}">
							<!-- Main menu with font awesome icon -->
							
								<a href='${displayTweet.media_url_https}' rel="nofollow"
									onclick='javascript:window.open(${displayTweet.media_url_https }, "_blank", 
					"scrollbars=1,resizable=1,height=300,width=450");'
									title='Pop Up'><img src = "${displayTweet.media_url_https }"></a>
								
						</c:when>
						
						<c:otherwise>
							
						</c:otherwise>
					</c:choose>
								<br><br>
								<br>
								<hr>
							</c:forEach>
							</p>

						</b>
					</div>
				</div>
			</div>
		</div>
	</header>
</div>
<jsp:include page="template-bottom.jsp" />