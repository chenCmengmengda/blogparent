<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页_陈C个人博客 - 一个站在java后端开发之路的技术员个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description" content="陈C个人博客，是一个站在java后端开发之路的萌新程序员个人网站。" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="css/base.css" rel="stylesheet"/>
<link href="css/index.css" rel="stylesheet"/>
<link href="css/m.css" rel="stylesheet"/>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/comment.css">
  <script type="text/javascript" src="/js/jquery.min.js"></script>
  <script type="text/javascript" src="/js/jquery.flexText.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
  <!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<header>
  <div class="logo">陈C的个人博客</div>
  <nav id="nav">
    <ul>
      <li><a href="/index.html">网站首页</a></li>
      <li><a href="/share.html">我的相册</a></li>
      <li><a href="/list.html">我的日记</a></li>
      <li><a href="/about.html">关于我</a></li>
      <li><a href="/gbook.html">留言</a></li>
      <li><a href="/info.html">内容页</a></li>
      <li><a href="/infopic.html">内容页</a></li>
    </ul>
  </nav>   
  <script>
window.onload = function ()
{
var obj=null;
var As=document.getElementById('nav').getElementsByTagName('a');
obj = As[0];
for(i=1;i<As.length;i++){if(window.location.href.indexOf(As[i].href)>=0)
obj=As[i];}
obj.id='selected'
}
</script> 
</header>
<div class="mnav">
    <ul>
      <li><a href="/index.html">网站首页</a></li>
      <li><a href="/share.html">我的相册</a></li>
      <li><a href="/list.html">我的日记</a></li>
      <li><a href="/about.html">关于我</a></li>
      <li><a href="/gbook.html">留言</a></li>
      <li><a href="/info.html">内容页</a></li>
      <li><a href="/infopic.html">内容页</a></li>
    </ul>
  </div>
<article>
  <div class="l_box">
    <div class="about_me">
      <h2>关于我</h2>
      <ul>
        <i><img src="images/4.jpg"></i>
        <p><b>陈C</b>，一个90后萌新站长！17年入坑。一直潜心研究java后端技术，一边学习一边积累经验，分享一些个人学习心得。</p>
      </ul>
    </div>
    <div class="wdxc">
      <h2>我的相册</h2>
      <ul>
        <li><a href="/"><img src="images/7.jpg"></a></li>
        <li><a href="/"><img src="images/8.jpg"></a></li>
        <li><a href="/"><img src="images/9.jpg"></a></li>
        <li><a href="/"><img src="images/10.jpg"></a></li>
        <li><a href="/"><img src="images/11.jpg"></a></li>
        <li><a href="/"><img src="images/12.jpg"></a></li>
      </ul>
    </div>
    <div class="guanzhu">
      <h2>关注我 么么哒</h2>
      <ul>
        <img src="images/wx.jpg">
      </ul>
    </div>
  </div>
  <div class="r_box">
     <ul class="about">
       <h2>留言板</h2>
       <%--<textarea style="width:800px;height:300px;visibility:hidden;" name="comment" id="comment"></textarea>--%>
       <%--<input type="button" value="发送" style="float: right" onclick="submit()"/>--%>
         <!--
      此评论textarea文本框部分使用的https://github.com/alexdunphy/flexText此插件
  -->
         <div class="commentAll">
           <!--评论区域 begin-->
           <div class="reviewArea clearfix">
             <textarea class="content comment-input" placeholder="Please enter a comment&hellip;" onkeyup="keyUP(this)"></textarea>
             <a href="javascript:;" class="plBtn">评论</a>
           </div>
           <!--评论区域 end-->
           <!--回复区域 begin-->
           <div class="comment-show">
             <div class="comment-show-con clearfix">
               <div class="comment-show-con-img pull-left"><img src="images/4.jpg" alt=""></div>
               <div class="comment-show-con-list pull-left clearfix">
                 <div class="pl-text clearfix">
                   <a href="#" class="comment-size-name">chenC : </a>
                   <span class="my-pl-con">&nbsp;来啊 造作啊!</span>
                 </div>
                 <div class="date-dz">
                   <span class="date-dz-left pull-left comment-time">2017-5-2 11:11:39</span>
                   <div class="date-dz-right pull-right comment-pl-block">
                     <a href="javascript:;" class="removeBlock">删除</a>
                     <a href="javascript:;" class="date-dz-pl pl-hf hf-con-block pull-left">回复</a>
                     <span class="pull-left date-dz-line">|</span>
                     <a href="javascript:;" class="date-dz-z pull-left"><i class="date-dz-z-click-red"></i>赞 (<i class="z-num">666</i>)</a>
                   </div>
                 </div>
                 <div class="hf-list-con"></div>
               </div>
             </div>
           </div>
           <!--回复区域 end-->
         </div>
     </ul>
  </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">陈C个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>

</body>
<script type="text/javascript">
    var blogAddEditor ;
    //页面初始化完毕后执行此方法
    $(function(){
        //创建富文本编辑器
        blogAddEditor = Blog.createEditor("#comment");
        //初始化类目选择和图片上传器
        Blog.init({fun:function(node){

        }});
    });

    function submit(){
        alert(blogAddEditor.text());
    }
</script>

</html>
