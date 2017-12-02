<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-list"></span> List Employee
		</strong>
		<div class="pull-right">
			<a href="javascript:void(0);" onclick="addForm('pegawai')">
				<span class="glyphicon glyphicon-plus-sign"></span> Add Employee
			</a>
			<a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="refresh('pegawai')" title="Refresh Employee">
                 <span class="glyphicon glyphicon-refresh"></span>
             </a>
		</div>
    </div>

	<div class="panel-body">
		<table id="chek" class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>Badge Number</th>
					<th>Gender</th>
					<th>Name</th>
					<th>Street</th>
					<th>User Id</th>
					<th>Department</th>
					<th>Ubah</th>
					<th>Hapus</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${pegawais.size() > 0}">
				<c:forEach items="${pegawais}" var="pegawai">
					<tr>
						<td>${pegawai.id}</td>
						<td>${pegawai.badgeNumber}</td>
						<td>${pegawai.gender}</td>
						<td>${pegawai.name}</td>
						<td>${pegawai.street}</td>
						<td>${pegawai.userId}</td>
						<td>${pegawai.departments.deptName}</td>
						<td><a href="javascript:void(0);" onclick="editForm('pegawai', '${pegawai.id}')"><span class="glyphicon glyphicon-edit"></span></a></td>
						<td><a href="javascript:void(0);" onclick="deleteData('pegawai', '${pegawai.id}')"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
				</c:when>
                		<c:otherwise>
                		    <tr align="center">
                			    <td colspan="8">No Employees available</td>
                		    </tr>
                		</c:otherwise>
                </c:choose>
			</tbody>
		</table>
	</div>
		<c:if test="${pegawais.size() > 0}">
    		<div class="panel-footer">
    			Showing ${number+1} to ${size} of ${totalElements}
    			<ul class="pagination pull-right" style="margin:-7px;">
    				<c:choose>
    					<c:when test="${current == 1}">
    						<li class="disabled"><a href="javascript:void(0);">First</a></li>
    						<li class="disabled"><a href="javascript:void(0);">Prev</a></li>
    					</c:when>
    					<c:otherwise>
    						<li><a href="javascript:void(0);" onclick="list('pegawai', '1')">First</a></li>
    						<li><a href="javascript:void(0);" onclick="list('pegawai', '${current - 1}')">Prev</a></li>
    					</c:otherwise>
    				</c:choose>
    				<c:forEach begin="${begin}" end="${end}" var="i">
    					<c:choose>
    						<c:when test="${i == current}">
    							<li class="active"><a href="javascript:void(0);" onclick="list('pegawai', '${i}')">${i}</a></li>
    						</c:when>
    						<c:otherwise>
    							<li><a href="javascript:void(0);" onclick="list('pegawai', '${i}')">${i}</a></li>
    						</c:otherwise>
    					</c:choose>
    				</c:forEach>
    				<c:choose>
    					<c:when test="${current == totalPages}">
    						<li class="disabled"><a href="javascript:void(0);">Next</a></li>
    						<li class="disabled"><a href="javascript:void(0);">Last</a></li>
    					</c:when>
    					<c:otherwise>
    						<li><a href="javascript:void(0);" onclick="list('pegawai', '${current + 1}')">Next</a></li>
    						<li><a href="javascript:void(0);" onclick="list('pegawai', '${totalPages}')">Last</a></li>
    					</c:otherwise>
    				</c:choose>
    			</ul>
    		</div>
    	</c:if>
</div>