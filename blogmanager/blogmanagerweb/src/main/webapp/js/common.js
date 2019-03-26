/**
 * jquery插件
 * 表单数据封装为json对象
 */
(function($){
    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);
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
        dir : "image"
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
        this.initOnePicUpload();
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
    /**
     * 初始化单图片上传组件 <br/>
     * 选择器为：.onePicUpload <br/>
     * 上传完成后会设置input内容以及在input后面追加<img>
     */
    initOnePicUpload : function(){
        $(".onePicUpload").click(function(){
            var _self = $(this);
            KindEditor.editor(bl.kingEditorParams).loadPlugin('image', function() {
                this.plugin.imageDialog({
                    showRemote : false,
                    clickFn : function(url, title, width, height, border, align) {
                        var input = _self.siblings("input");
                        input.parent().find("img").remove();
                        input.val(url);
                        input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
                        this.hideDialog();
                    }
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
