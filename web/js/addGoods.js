/**
 * Created by xiong on 2015/11/22.
 */
(function($){
    $("#btn-submit").on("click",function(){
        alert("9899");
        var params = $("#addGoods-form").serialize();
        $.ajax({
            url:'./addGoods.action',
            type:'post',
            data:params,
            dataType:'json',
            success:function(data){
                switch(data.status)
                {
                    case 100:alert("1");
                    case -200:alert("2");
                    case 1000:alert("3");
                    default :alert("4");
                }
            }
        });
    });
})(jQuery);
