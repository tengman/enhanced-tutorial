<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/homeNav.jsp"></jsp:include>
<%--<jsp:include page="/user.do/findAll"></jsp:include>--%>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">角色管理</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        角色信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>角色名称</th>
                                    <th>角色描述</th>
                                    <th>拥有的资源</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="role" items="${roleList}">
                                    <tr>
                                        <td>${role.role}</td>
                                        <td>${role.desc}</td>
                                        <td>${role.resourceIds}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/role/delete?id=${role.id}"
                                               onclick="return confirm('是否要删除该角色')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <a href="${pageContext.request.contextPath}/admin/role/addPage" class="btn btn-primary"
                               role="button">添加角色</a>
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

