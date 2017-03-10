<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p> Hello ${user.systemId}! This is my new module that I have created</p>
<form method="post" action="manage.form">
<fieldset>
<table style="padding:20px">
<legend>
Search Concept by name
</legend>
<tr>
<td><label for="searchString"> Enter the Concept Name:</lable></td>
<td><input type="text" id="searchStr" name="searchStr"></td>
</tr>
<tr>
<td colspan="2" style="padding-left:50px;">
<input type="submit" value="Search" name="submit" id="submit">
</td>
</tr>
</table>
</fieldset>
<table class="box">
<th>ID</th>
<th>ConceptName</th>
<th>Check</th>

<c:forEach var="concept" items="${conceptList}">
<tr class="evenRow">
<td>${concept.id}</td>
<td>${concept.name}</td>
<td>
		<input TYPE=checkbox name=sports VALUE=Basketball>
	</td>
</tr>
</c:forEach>
</table>
</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>