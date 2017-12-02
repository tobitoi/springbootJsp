<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${path}/js/jquery.save.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<c:choose>
				<c:when test="${isNew}"><span class="glyphicon glyphicon-plus-sign"></span></c:when>
				<c:otherwise><span class="glyphicon glyphicon-edit"></span></c:otherwise>
			</c:choose> Check In And Out
		</strong>
	</div>
	<form:form method="post" class="form-horizontal" action="${path}/checkInOut/add" commandName="checkInOutForm" id="submitcheckInOutForm">
		<form:hidden path="id"/>
        <form:hidden path="workCode"/>
        <form:hidden path="verifyCode"/>
        <form:hidden path="checkType"/>


        <div class="panel-body">

        <div class="form-group" >
            <label class="col-md-2 control-label">Pegawai : </label>
               <div class="col-md-4">
                    <form:select class="form-control" path="pegawaiId" disabled="false">
                        <c:forEach  items="${pegawais}" var="pegawai" >
                            <form:option value="${pegawai.id}">${pegawai.name} </form:option>
                        </c:forEach>
                    </form:select>
               </div>
        </div>

         <script>$("#datetimepicker").datetimepicker(); </script>
         <div class="form-group">
        	<label class="col-md-2 control-label">Check In Time : </label>
        		<div class="col-md-4">
        		    <form:input type="text" id="datetimepicker" class="form-control" path="checkInTime"  required="true"/>
        		</div>
         </div>

         <script>$("#datetimepicker1").datetimepicker(); </script>
         <div class="form-group">
            <label class="col-md-2 control-label">Check Out Time : </label>
                <div class="col-md-4">
                    <form:input type="text" id="datetimepicker1" class="form-control" path="checkOutTime"  required="true"/>
                </div>
         </div>

          <div class="form-group" >
             <label class="col-md-2 control-label">Shift : </label>
                <div class="col-md-4">
                   <form:select  class="form-control" path="shiftId" >
                       <c:forEach items="${shifts}" var="shift" >
                          <form:option value="${shift.id}">${shift.name}</form:option>
                       </c:forEach>
                   </form:select>
                </div>
          </div>
        </div>

		<div class="panel-footer">
			<form:button value="Save" class="btn btn-xs btn-default">
				<span class="glyphicon glyphicon-floppy-disk"></span>
				<c:choose>
					<c:when test="${isNew}"> Save</c:when>
					<c:otherwise> Update</c:otherwise>
				</c:choose>
			</form:button>
		</div>
	</form:form>
</div>