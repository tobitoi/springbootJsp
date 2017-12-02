<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title th:text="${page}"></title>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-list"></span> Check In Out List
		</strong>
		<div class="pull-right">
        	<a href="${path}/checkInOut/report" target="_blank" >
        		<span class="glyphicon glyphicon-plus-sign"></span> Print Report
        	</a>
        	  <a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="refresh('checkInOut')" title="Refresh Attendance">
                 <span class="glyphicon glyphicon-refresh"></span>
              </a>
        </div>
	</div>
	<div class="panel-body">
		<table id="chek" class="table table-bordered table-condensed table-hover table-striped">
			<thead>
			<tr>

				<th>User Id</th>
				<th>Name</th>
				<th>Check In Time</th>
				<th>Check In Out</th>
				<th> Shift </th>
				<th>Description</th>
			    <th>Action</th>

			</tr>
			</thead>
			<tbody>
			<c:choose>
            	<c:when test="${checkInOuts.size() > 0}">
			        <c:forEach items="${checkInOuts}" var="checkInOut">
                        <tr>
                           <td>${checkInOut.pegawai.userId}</td>
                            <td>${checkInOut.pegawai.name}</td>
                            <td>${checkInOut.checkInTime}</td>
                            <td>${checkInOut.checkOutTime}</td>
                            <td> ${checkInOut.shift.name}</td>
                             <td>${checkInOut.late}</td>
                            <td><a href="javascript:void(0);" onclick="editForm('checkInOut', '${checkInOut.id}')"><span class="glyphicon glyphicon-edit"></span></a></td>

                        </tr>
      		        </c:forEach>
      		    </c:when>
                    <c:otherwise>
                        <tr align="center">
                            td colspan="8">No Attendance available</td>
                        </tr>
                    </c:otherwise>
             </c:choose>
			</tbody>
		</table>
	</div>
    <c:if test="${checkInOuts.size() > 0}">
        <div class="panel-footer">
        	Showing ${number+1} to ${size} of ${totalElements}
        	    <ul class="pagination pull-right" style="margin:-7px;">
        		    <c:choose>
        			    <c:when test="${current == 1}">
        					<li class="disabled"><a href="javascript:void(0);">First</a></li>
        					<li class="disabled"><a href="javascript:void(0);">Prev</a></li>
        				</c:when>
        				<c:otherwise>
        					<li><a href="javascript:void(0);" onclick="list('checkInOut', '1')">First</a></li>
        					<li><a href="javascript:void(0);" onclick="list('checkInOut', '${current - 1}')">Prev</a></li>
        				</c:otherwise>
        			</c:choose>
        			    <c:forEach begin="${begin}" end="${end}" var="i">
        				    <c:choose>
        					    <c:when test="${i == current}">
        						    <li class="active"><a href="javascript:void(0);" onclick="list('checkInOut', '${i}')">${i}</a></li>
        						</c:when>
        					    <c:otherwise>
        							<li><a href="javascript:void(0);" onclick="list('checkInOut', '${i}')">${i}</a></li>
        						</c:otherwise>
        					</c:choose>
        			</c:forEach>
        			    <c:choose>
        					<c:when test="${current == totalPages}">
        					    <li class="disabled"><a href="javascript:void(0);">Next</a></li>
        						<li class="disabled"><a href="javascript:void(0);">Last</a></li>
        					</c:when>
        				    <c:otherwise>
        					    <li><a href="javascript:void(0);" onclick="list('checkInOut', '${current + 1}')">Next</a></li>
        					    <li><a href="javascript:void(0);" onclick="list('checkInOut', '${totalPages}')">Last</a></li>
        				    </c:otherwise>
        				</c:choose>
        		</ul>
        </div>
    </c:if>
</div>