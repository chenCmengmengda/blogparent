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
        width:"100%",
        //指定上传文件参数名称
        filePostName  : "uploadFile",
        //指定上传文件请求的url。
        uploadJson : '/pic/upload.do',
        //上传类型，分别为image、flash、media、file
        dir : "image",

        //调用kindeditor的afterCreate回调函数对kindeditor功能进行“扩展”，实现图片粘贴上传。
        afterCreate:function() {
            var editerDoc = this.edit.doc;//得到编辑器的文档对象
            var cmd=this.edit.cmd;
            //监听粘贴事件, 包括右键粘贴和ctrl+v
            $(editerDoc).bind('paste', null, function (e) {
                /*获得操作系统剪切板里的项目，e即kindeditor,
                 *kindeditor创建了originalEvent(源事件)对象，
                 *并指向了浏览器的事件对象，而chrome浏览器
                 *需要通过clipboardData(剪贴板数据)对象的items
                 *获得复制的图片数据。
                 */
                var ele = e.originalEvent.clipboardData.items;
                for (var i = 0; i < ele.length; ++i) {
                    //判断文件类型
                    if ( ele[i].kind == 'file' && ele[i].type.indexOf('image/') !== -1 ) {
                        var file = ele[i].getAsFile();//得到二进制数据
                        //创建表单对象，建立name=value的表单数据。
                        var formData = new FormData();
                        formData.append("uploadFile",file);//name,value

                        //用jquery Ajax 上传二进制数据
                        $.ajax({
                            url : '/pic/upload.do',
                            type : 'POST',
                            data : formData,
                            // 告诉jQuery不要去处理发送的数据
                            processData : false,
                            // 告诉jQuery不要去设置Content-Type请求头
                            contentType : false,
                            dataType:"json",
                            beforeSend:function(){
                                //console.log("正在进行，请稍候");
                            },
                            success : function(responseStr) {
                                //上传完之后，生成图片标签回显图片，假定服务器返回url。
                                var src = responseStr.url;
                                var imgTag = "<img src='"+src+"' border='0'/>";

                            //    console.info(imgTag);
                                //kindeditor提供了一个在焦点位置插入HTML的函数，调用此函数即可。
                                cmd.inserthtml(imgTag);



                            },
                            error : function(responseStr) {
                                console.log("error");
                            }
                        });

                    }

                }


            });
        }
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
    },

}

function getUrlKey(name){
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
}