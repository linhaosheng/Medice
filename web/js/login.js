/**
 * Created by CosPotato on 2015/10/29.
 */
(function($){
    document.onkeydown = function(e){
        var ev = document.all ? window.event : e;
        if(ev.keyCode==13) {
            $("#btn-login").click();
        }
    }
    $("#btn-login").on('click',function(){
        var params = $("#login-frm").serialize();
        $.ajax({
            url:'/login.action',
            type:'post',
            data:params,
            dataType:'json',
            success:function(data){
                if(data.status < 0){

                    alert(data.message);
                }
            }
        });
    });
})(jQuery);