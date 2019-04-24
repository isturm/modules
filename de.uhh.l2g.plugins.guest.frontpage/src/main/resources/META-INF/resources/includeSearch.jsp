<portlet:actionURL name="test" var="searchURL"/>

<aui:form action="${searchURL}" method="POST" name="submitForm" >
	<aui:input name="findVideos" id="findVideos" label="" inlineField="true" value="${memberDTO.findVideos}"/>
</aui:form>		 