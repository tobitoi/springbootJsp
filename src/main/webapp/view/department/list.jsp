<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title th:text="${page}"></title>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-list"></span> Department List
		</strong>
	</div>
	<div class="panel-body">
		<table id="chek" class="table table-bordered table-condensed table-hover table-striped">
			<thead>
			<tr>
				<th>Department Id</th>
				<th>Department Name</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${departments}" var="departmen">
			<tr>
                <td>${departmen.dept_Id}</td>
				<td>${departmen.deptName}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
    <script type="text/javascript">
     $(document).ready( function () {
         $('#chek').DataTable();
     } );
    </script>
</div>