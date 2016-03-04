/**
 * Created by xiong on 2015/11/23.
 */
$(document).ready(function(){
    var params = {
        pageNow : 0,
        pageSize: 20
    }
    $.ajax({
        url:'/checkStorage.action',
        type:'get',
        data:params,
        dataType:"json",
        success:function(data){
            $(data.xxList).each(function (i, value){
                $("#goods-list").append(
                    "<tr data-id='"+ value[0] +"'>" +
                    "<td><a href='#'>" + value[1] + "</a></td>" +
                    "<td>" + value[2] + "</td>" +
                    "<td>" + value[3] + "</td>" +
                    "<td>" + value[4] + "</td>" +
                    "<td>" + value[5] + "</td>" +
                    "</tr>"
                );
            });
            //显示有几条记录
            var totalCount = data.count;
            $("#total-count").html(totalCount);
        }

    });
});