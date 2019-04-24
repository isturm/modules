<portlet:actionURL name="/search" var="actionURL"/>

<aui:form action="${actionURL}" method="POST" name="submitForm">
	<aui:input name="findVideos" id="findVideos" label="" inlineField="true" value="${memberDTO.findVideos}"/>
</aui:form>		