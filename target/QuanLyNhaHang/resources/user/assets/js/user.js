$(document).ready(function () {
    $("tr[data-id] input").on("input",qty=function b() {
        var id=$(this).closest("tr").attr("data-id");
        var price=$(this).closest("tr").attr("data-price");
        var qty=$(this).val();
        $.ajax({
            url:`/giohang/update/${id}/${qty}`,
            success: function (response) {
                $("#totalbill").html(response[0]);
            }
        });
        var amt=qty*price+" VNĐ";
        $(this).closest("tr").find("p.amt").html(amt);
    });

    $(".click-remove-p").click(function () {
        var id=$(this).closest("tr").attr("data-id");
        $.ajax({
            url:"/giohang/remove/"+id,
            success: function (response) {
                Swal.fire(
                    'Success!',
                    'Successfully delete to your order detail!',
                    'success'
                )
                // alert(response)
            }
        });$(this).closest("tr").remove();
    });

    $(".click-clear").click(function () {
        $.ajax({
            url:"/giohang/clear/",
            success: function (response) {
                $("table>tbody").html("");
                Swal.fire(
                    'Thành công!',
                    'Xóa sạch giỏ hàng thành công!',
                    'success'
                )
                // alert(response)
            }
        });
    });
    $(".click_category").click(function () {
        var id=$(this).closest("div").attr("data-id");
        $.ajax({
            url:"/giohang/add/"+id,
            success: function (response) {
                Swal.fire(
                    'Thành công!',
                    'Thêm sản phẩm vào giỏ hàng thành công!',
                    'success'
                )
                // alert(response)
            }
        });
    });

});