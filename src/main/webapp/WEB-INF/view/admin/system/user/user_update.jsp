<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/homeNav.jsp"></jsp:include>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">用户管理</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        用户信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="${pageContext.request.contextPath}/admin/user/update" method="post">
                                <input style="display:none" name="id" value="${user.id}">
                                <label name="name">用户名 :${user.name}</label>
                                <p></p>
                                <label>新密码</label>
                                <input class="form-control" name="password">
                                <label>邮箱</label>
                                <input class="form-control" name="email">

                                <div class="form-group">
                                <label>角色列表：</label>
                                <select multiple="true" class="form-control" name="roleIds">
                                    <c:forEach var="role" items="${roleList}">
                                    		<c:if test="${role.selected == 1}">
                                    			<option selected="selected" value="${role.id}">${role.desc}</option>
                                    		</c:if>
                                    		<c:if test="${role.selected == -1}">
                                    			<option value="${role.id}">${role.desc}</option>
                                    		</c:if>
                                    </c:forEach>
                                </select>
                                    (按住shift键多选)
                                </div>
                                <label></label>
                                <button type="submit"
                                        class="btn btn-primary form-control">修改
                                </button>
                            </form>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>

    <!-- /.container-fluid -->
</div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/bottom.jsp"></jsp:include>
