/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S")
 * @param format 指定的格式
 */
Date.prototype.format = function(format){
    var o={
        "M+":this.getMonth()+1,//month
        "d+":this.getDate(),//day
        "h+":this.getHours(),//hour
        "m+":this.getMinutes(),//minute
        "s+":this.getSeconds(),//second
        "q+":Math.floor((this.getMonth()+3)/3),//quarter
        "S+":this.getMilliseconds()//millisecond
    };
    if(/(y+)/.test(format)){
        format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length));
    }
    for(var k in o){
        if(new RegExp("("+k+")").test(format)){
            format=format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+o[k]).substr((""+o[k]).length));
        }
    }
    return format;
};

var bl=Blog={
    // 编辑器参数
    kingEditorParams : {
        //指定上传文件参数名称
        filePostName  : "uploadFile",
        //指定上传文件请求的url。
        uploadJson : '/pic/upload',
        //上传类型，分别为image、flash、media、file
        dir : "image",
        width:"100%",
        height:"150px"
    },
    // 格式化时间
    formatDateTime : function(val,row){
        var now = new Date(val);
        return now.format("yyyy-MM-dd");
    },
    // 格式化连接
    formatUrl : function(val,row){
        if(val){
            return "<a href='"+val+"' target='_blank'>查看</a>";
        }
        return "";
    },
    //创建编辑器
    createEditor : function(select){
        return KindEditor.create(select, bl.kingEditorParams);
    },
    init : function(data){
        // 初始化图片上传组件
        this.initPicUpload(data);
    },
    // 初始化图片上传组件
    initPicUpload : function(data){
        $(".picFileUpload").each(function(i,e){
            var _ele = $(e);
            _ele.siblings("div.pics").remove();
            _ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
            // 回显图片
            if(data && data.pics){
                var imgs = data.pics.split(",");
                for(var i in imgs){
                    if($.trim(imgs[i]).length > 0){
                        _ele.siblings(".pics").find("ul").append("<li><a href='"+imgs[i]+"' target='_blank'><img src='"+imgs[i]+"' width='80' height='50' /></a></li>");
                    }
                }
            }
            //给“上传图片按钮”绑定click事件
            $(e).click(function(){
                var form = $(this).parentsUntil("form").parent("form");
                //打开图片上传窗口
                KindEditor.editor(bl.kingEditorParams).loadPlugin('multiimage',function(){
                    var editor = this;
                    editor.plugin.multiImageDialog({
                        clickFn : function(urlList) {
                            var imgArray = [];
                            KindEditor.each(urlList, function(i, data) {
                                imgArray.push(data.url);
                                form.find(".pics ul").append("<li><a href='"+data.url+"' target='_blank'><img src='"+data.url+"' width='80' height='50' /></a></li>");
                            });
                            form.find("[name=image]").val(imgArray.join(","));
                            editor.hideDialog();
                        }
                    });
                });
            });
        });
    },
    //异步ajax
    ajax:function(url,param,callback){
        $.ajax({
            url:url,
            data:param,
            type:'POST',
            dataType:'json',
            success:function(data){
                callback(data);
            }
        });
    },
    //同步ajax
    ajaxAsync:function(url,param,callback){
        $.ajax({
            url:url,
            data:param,
            type:'POST',
            async : false,
            dataType:'json',
            success:function(data){
                callback(data);
            }
        });
    }
}

//textarea高度自适应
$(function () {
    $('.content').flexText();
    createCommen();
});

//textarea限制字数
function keyUP(t){
    var len = $(t).val().length;
    if(len > 139){
        $(t).val($(t).val().substring(0,140));
    }
}
//点击评论创建评论条
function createCommen() {
    $('.commentAll').on('click', '.plBtn', function () {
        var myDate = new Date();
        //获取当前年
        var year = myDate.getFullYear();
        //获取当前月
        var month = myDate.getMonth() + 1;
        //获取当前日
        var date = myDate.getDate();
        var h = myDate.getHours();       //获取当前小时数(0-23)
        var m = myDate.getMinutes();     //获取当前分钟数(0-59)
        if (m < 10) m = '0' + m;
        var s = myDate.getSeconds();
        if (s < 10) s = '0' + s;
        var now = year + '-' + month + "-" + date + " " + h + ':' + m + ":" + s;
        //获取输入内容
        var oSize = $(this).siblings('.flex-text-wrap').find('.comment-input').val();
        console.log(oSize);
        //动态创建评论模块
        oHtml = '<div class="comment-show-con clearfix"><div class="comment-show-con-img pull-left"><img src="4.png" alt=""></div> <div class="comment-show-con-list pull-left clearfix"><div class="pl-text clearfix"> <a href="#" class="comment-size-name">David Beckham : </a> <span class="my-pl-con">&nbsp;' + oSize + '</span> </div> <div class="date-dz"> <span class="date-dz-left pull-left comment-time">' + now + '</span> <div class="date-dz-right pull-right comment-pl-block"><a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div><div class="hf-list-con"></div></div> </div>';
        if (oSize.replace(/(^\s*)|(\s*$)/g, "") != '') {
            $(this).parents('.reviewArea ').siblings('.comment-show').prepend(oHtml);
            $(this).siblings('.flex-text-wrap').find('.comment-input').prop('value', '').siblings('pre').find('span').text('');
        }
    });

    //点击回复动态创建回复块
    $('.comment-show').on('click','.pl-hf',function(){
        //获取回复人的名字
        var fhName = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
        //回复@
        var fhN = '回复@'+fhName;
        //var oInput = $(this).parents('.date-dz-right').parents('.date-dz').siblings('.hf-con');
        var fhHtml = '<div class="hf-con pull-left"> <textarea class="content comment-input hf-input" placeholder="" onkeyup="keyUP(this)"></textarea> <a href="javascript:;" class="hf-pl">评论</a></div>';
        //显示回复
        if($(this).is('.hf-con-block')){
            $(this).parents('.date-dz-right').parents('.date-dz').append(fhHtml);
            $(this).removeClass('hf-con-block');
            $('.content').flexText();
            $(this).parents('.date-dz-right').siblings('.hf-con').find('.pre').css('padding','6px 15px');
            //console.log($(this).parents('.date-dz-right').siblings('.hf-con').find('.pre'))
            //input框自动聚焦
            $(this).parents('.date-dz-right').siblings('.hf-con').find('.hf-input').val('').focus().val(fhN);
        }else {
            $(this).addClass('hf-con-block');
            $(this).parents('.date-dz-right').siblings('.hf-con').remove();
        }
    });
//评论回复块创建
    $('.comment-show').on('click','.hf-pl',function(){
        var oThis = $(this);
        var myDate = new Date();
        //获取当前年
        var year=myDate.getFullYear();
        //获取当前月
        var month=myDate.getMonth()+1;
        //获取当前日
        var date=myDate.getDate();
        var h=myDate.getHours();       //获取当前小时数(0-23)
        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
        if(m<10) m = '0' + m;
        var s=myDate.getSeconds();
        if(s<10) s = '0' + s;
        var now=year+'-'+month+"-"+date+" "+h+':'+m+":"+s;
        //获取输入内容
        var oHfVal = $(this).siblings('.flex-text-wrap').find('.hf-input').val();
        console.log(oHfVal)
        var oHfName = $(this).parents('.hf-con').parents('.date-dz').siblings('.pl-text').find('.comment-size-name').html();
        var oAllVal = '回复@'+oHfName;
        if(oHfVal.replace(/^ +| +$/g,'') == '' || oHfVal == oAllVal){

        }else {
            $.getJSON("json/pl.json",function(data){
                var oAt = '';
                var oHf = '';
                $.each(data,function(n,v){
                    delete v.hfContent;
                    delete v.atName;
                    var arr;
                    var ohfNameArr;
                    if(oHfVal.indexOf("@") == -1){
                        data['atName'] = '';
                        data['hfContent'] = oHfVal;
                    }else {
                        arr = oHfVal.split(':');
                        ohfNameArr = arr[0].split('@');
                        data['hfContent'] = arr[1];
                        data['atName'] = ohfNameArr[1];
                    }

                    if(data.atName == ''){
                        oAt = data.hfContent;
                    }else {
                        oAt = '回复<a href="#" class="atName">@'+data.atName+'</a> : '+data.hfContent;
                    }
                    oHf = data.hfName;
                });

                var oHtml = '<div class="all-pl-con"><div class="pl-text hfpl-text clearfix"><a href="#" class="comment-size-name">我的名字 : </a><span class="my-pl-con">'+oAt+'</span></div><div class="date-dz"> <span class="date-dz-left pull-left comment-time">'+now+'</span> <div class="date-dz-right pull-right comment-pl-block"> <a href="javascript:;" class="removeBlock">删除</a> <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a> <span class="pull-left date-dz-line">|</span> <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a> </div> </div></div>';
                oThis.parents('.hf-con').parents('.comment-show-con-list').find('.hf-list-con').css('display','block').prepend(oHtml) && oThis.parents('.hf-con').siblings('.date-dz-right').find('.pl-hf').addClass('hf-con-block') && oThis.parents('.hf-con').remove();
            });
        }
    });
//删除评论块
    $('.commentAll').on('click','.removeBlock',function(){
        var oT = $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con');
        if(oT.siblings('.all-pl-con').length >= 1){
            oT.remove();
        }else {
            $(this).parents('.date-dz-right').parents('.date-dz').parents('.all-pl-con').parents('.hf-list-con').css('display','none')
            oT.remove();
        }
        $(this).parents('.date-dz-right').parents('.date-dz').parents('.comment-show-con-list').parents('.comment-show-con').remove();

    });
//点赞
    $('.comment-show').on('click','.date-dz-z',function(){
        var zNum = $(this).find('.z-num').html();
        if($(this).is('.date-dz-z-click')){
            zNum--;
            $(this).removeClass('date-dz-z-click red');
            $(this).find('.z-num').html(zNum);
            $(this).find('.date-dz-z-click-red').removeClass('red');
        }else {
            zNum++;
            $(this).addClass('date-dz-z-click');
            $(this).find('.z-num').html(zNum);
            $(this).find('.date-dz-z-click-red').addClass('red');
        }
    });
}
