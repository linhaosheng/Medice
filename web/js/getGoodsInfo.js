/**
 * Created by xiong on 2015/11/23.
 */
$(document).ready(function(){
    var param=$("#goodsId").val();
    $("#search").click(function(){
        $.ajax({
            type:'post',
            url:'/getGoodsInfo.action',
            data:param,
            dataType:'json',
            success: function(data) {
                if (data.success) {
                    $(data.goodsInfo).each(function (i, value) {
                        $("#searchResult").append(
                            "<label>"+"物品条码"+value.goodsId+"</label><br>"+
                            "<label>"+"货物名称"+value.goodsName+"</label><br>"+
                            "<label>"+"库存单位"+value.unit+"</label><br>"+
                            "<label>"+"包装规格"+value.spec+"</label><br>"+
                            "<label>"+"来源"+value.source+"</label><br>"+
                            "<label>"+"联系人"+value.contact+"</label><br>"+
                            "<label>"+"联系电话"+value.tel+"</label><br>"+
                            "<label>"+"库存警戒值"+value.alertValue+"</label><br>"
                        );
                    });
                } else {
                    $("#searchResult").html("出现错误：" + data.msg);
                }
            },
            //error: function(jqXHR){
            //    alert("发生错误：" + jqXHR.status);
            //},
        });
    });
});
