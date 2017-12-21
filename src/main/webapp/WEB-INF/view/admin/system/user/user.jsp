<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/homeNav.jsp"></jsp:include>
<%--<jsp:include page="/user.do/findAll"></jsp:include>--%>
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
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>密码</th>
                                    <th>角色集</th>
                                    <th>邮箱</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${userList}">
                                    <tr>
                                        <td>${user.name}</td>
                                        <td>${user.password}</td>
                                        <td>${user.roleIds}</td>
                                        <td>email</td>
                                        <td><a href="${pageContext.request.contextPath}/admin/user/updatePage?id=${user.id}">修改</a></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/user/delete?id=${user.id}"
                                               onclick="return confirm('是否要删除该用户')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <a href="${pageContext.request.contextPath}/admin/user/addPage" class="btn btn-primary"
                               role="button">添加用户</a>
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

