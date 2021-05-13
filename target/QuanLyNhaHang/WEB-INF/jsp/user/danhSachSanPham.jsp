<%@ page pageEncoding="UTF-8"%>
<c:forEach items="${listSP}" var="item">
    <div class="col-sm-4">
        <div class="product-image-wrapper">
            <div class="single-products">
                <div class="productinfo text-center" data-id="${item.id}">
                    <img height="170px" width="255px" src="/resources/img/widget/${item.hinhAnh}" alt="" />
                    <h2>${item.giaTien}00 VNĐ</h2>
                    <p>${item.tenSP}</p>
                    <button class="btn btn-default add-to-cart click_category"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>