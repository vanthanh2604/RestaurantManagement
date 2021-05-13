<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Danh mục món ăn</h2>
        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
            <div class="panel panel-default">
                <div class="panel-heading" data-id="id">
                    <h4 class="panel-title"><a href="/"><b>Tất cả</b></a></h4>
                </div>
            </div>
            <c:forEach items="${menu}" var="s">
                <div class="panel panel-default">
                    <div class="panel-heading" data-id="id">
                        <h4 class="panel-title"><a href="/danhmuc=${s.id}"><b>${s.tenTheLoai}</b></a></h4>
                    </div>
                </div>
            </c:forEach>
        </div><!--/category-products-->
    </div>
</div>
