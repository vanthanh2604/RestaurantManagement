$(document).ready(function () {
    $(".btn-add-to-order").click(function () {
        var idBan=$(this).closest("div").attr("data-idBan");
        var idSP=$(this).closest("div").attr("data-idSP");
        $.ajax({
            url:"/admin/pos/add/table="+idBan+"&product="+idSP,
            success: function (response) {
                Swal.fire(
                    'Success!',
                    'Successfully added to your order!',
                    'success'
                )
                // alert(response)
            }
        });
    });
    $(".btn-delete-product-order-detail").click(function () {
        var idBan=$(this).closest("tr").attr("data-idBan");
        var idSP=$(this).closest("tr").attr("data-idSP");
        $.ajax({
            url:"/admin/pos/delete/table="+idBan+"&product="+idSP,
            success: function (response) {
                Swal.fire(
                    'Success!',
                    'Successfully delete to your order detail!',
                    'success'
                )
                $("#total-bill").html(response[0]);
                // alert(response)
            }
        });$(this).closest("tr").remove();
    });

    $("tr[data-idBan] input").on("input",qty=function b() {
        var idBan=$(this).closest("tr").attr("data-idBan");
        var idSP=$(this).closest("tr").attr("data-idSP");
        var price=$(this).closest("tr").attr("data-price");
        var qty=$(this).val();
        $.ajax({
            url:"/admin/pos/update/"+idBan+"/"+idSP+"/"+qty,
            success: function (response) {
                $("#total-bill").html(response[0]);
            }
        });
        var amt=qty*price+" $";
        $(this).closest("tr").find("td.amt").html(amt);
    });

    $(".btn-duyet").click(function () {
        var id=$(this).closest("tr").attr("data-id");
        var idHd=$(this).closest("tr").attr("data-idHd");
        $.ajax({
            url:`/admin/dondatban/xuly/${id}/${idHd}`,
            success: function (response) {
                Swal.fire(
                    'Success!',
                    'Successfully added to your order!',
                    'success'
                )
                $("#astatus").html("Đã duyệt");
                // alert(response)
            }
        });
    });
});

function a() {
    $(".update-order").click(function () {
        var idBan=$(this).closest("tr").attr("data-idBan");
        var idSP=$(this).closest("tr").attr("data-idSP");
        var qty=$(this).val();
        $.ajax({
            url:"/admin/pos/update/"+idBan+"/"+idSP+"/"+qty,
            success: function (response) {
                Swal.fire(
                    'Good job!',
                    'You clicked the button!',
                    'success'
                )
                $("#total-bill").html(response[0]);
            }
        });
    });

    $(".btn-report").click(function () {
        var to=$(this).closest("div").attr("data-to");
        var from=$(this).closest("div").attr("data-from");
        $.ajax({
            url:"/admin/report/list",
            success: function (response) {
                Swal.fire(
                    'Success!',
                    'Successfully added to your order!',
                    'success'
                )
                // alert(response)
            }
        });
    });
}

function thongbao() {
    Swal.fire(
        'Oh!',
        'The table is empty so there is no invoice.!',
        'warning'
    )
}







