<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/calendar/calendar.js"/>

<p> Hello ${user.systemId}! This is my new module that I have created</p>
<form method="post" action="manage.form">
<fieldset>
<table style="padding:20px">
<legend>
Pateints Search
</legend>
<tr>
<td><label for="Start Date"> Start Date:</lable></td>
<td><input type="text" id="StartDate" name="StartDate" onClick="showCalendar(this)"></td>
</tr>
<tr>
<td><label for="End Date"> End Date:</lable></td>
<td><input type="text" id="EndDate" name="EndDate" onClick="showCalendar(this)"></td>
</tr>
<tr>
<td colspan="2" style="padding-left:50px;">
<input type="submit" value="Search" name="submit" id="submit">
</td>
</tr>
</table>
</fieldset>
<table class="box">
<th>Person ID</th>
<th>Person Name</th>
<th>Date of Birth</th>
<th>Gender</th>

<c:forEach var="plist" items="${PatientsList}">
<tr class="evenRow">
<td>${plist.personID}</td>
<td>${plist.personName}</td>
<td>${plist.DOB}</td>
<td>${plist.gender}</td>
<td>
		<input TYPE=checkbox name=sports VALUE=person_id>
	</td>
</tr>
</c:forEach>
</table>
</form>
<%@ include file="/WEB-INF/template/footer.jsp"%>