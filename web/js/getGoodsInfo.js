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
                            "<label>"+"��Ʒ����"+value.goodsId+"</label><br>"+
                            "<label>"+"��������"+value.goodsName+"</label><br>"+
                            "<label>"+"��浥λ"+value.unit+"</label><br>"+
                            "<label>"+"��װ���"+value.spec+"</label><br>"+
                            "<label>"+"��Դ"+value.source+"</label><br>"+
                            "<label>"+"��ϵ��"+value.contact+"</label><br>"+
                            "<label>"+"��ϵ�绰"+value.tel+"</label><br>"+
                            "<label>"+"��澯��ֵ"+value.alertValue+"</label><br>"
                        );
                    });
                } else {
                    $("#searchResult").html("���ִ���" + data.msg);
                }
            },
            //error: function(jqXHR){
            //    alert("��������" + jqXHR.status);
            //},
        });
    });
});
