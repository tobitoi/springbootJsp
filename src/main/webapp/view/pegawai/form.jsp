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
			</c:choose> Employee
		</strong>
	</div>
	<form:form method="post" class="form-horizontal" action="${path}/pegawai/add" commandName="pegawaiForm" id="submitPegawaiForm">
		<form:hidden path="id"/>
		<div class="panel-body">
			<div class="form-group">

				<div class="col-md-10">
					<form:hidden class="form-control" path="id" placeholder="Enter Street, Landmark and other details" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Badge Number : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="badgeNumber" placeholder="Enter Badge Number" required="true"/>
				</div>

				<label class="col-md-2 control-label">Name : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="name" placeholder="Enter Name" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Street : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="street" placeholder="Enter Street" required="true"/>
				</div>

				<label class="col-md-2 control-label">User Id : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="userId" placeholder="Enter User Id" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Gender :</label>
				<div class="col-md-4">
					<form:select class="form-control" path="gender">

							<option value="Pria">Pria</option>
                            <option value="Wanita">Wanita</option>

					</form:select>
				</div>
			</div>
			<div class="form-group">
            	<label class="col-md-2 control-label">Departments :</label>
           			<div class="col-md-4">
       					<form:select class="form-control" path="deptId">
       						<c:forEach items="${departments}" var="department">
            					<form:option value="${department.id}">${department.deptName}</form:option>
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