<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页_陈C个人博客 - 一个站在java后端开发之路的技术员个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description" content="陈C个人博客，是一个站在java后端开发之路的萌新程序员个人网站。" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
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
          <li><a href="/"><img src="images/4.jpg"></a></li>
          <li><a href="/"><img src="images/4.jpg"></a></li>
          <li><a href="/"><img src="images/4.jpg"></a></li>
          <li><a href="/"><img src="images/4.jpg"></a></li>
          <li><a href="/"><img src="images/4.jpg"></a></li>
          <li><a href="/"><img src="images/4.jpg"></a></li>
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
      <p>陈C，一个90后萌新站长！17年入行。一直潜心研究java后端技术，一边学习一边积累经验。<br />
           <br />
            我目前还在学习阶段，所以不存在所谓的成熟且稳定的开发团队，到目前为止只是跟着教程从零开发过一个电商网站，
          但是我并不满足于此，教程终究只是一个思想及经验，不自己动手消化是没用的，为了让自己得到更多锻炼，我还是决定自己实现一个网站，思来想去，什么网站好呢?于是我选择了个人博客项目。
          <br />
          <br />
          为什么我选择博客，个人认为有以下好处，在博客的开发过程会涉及很多实用的系统，比如博客cms系统，
          评论系统，用户管理系统，如果我能开发出这些系统的主要逻辑，那相信这些将会成为将来开发道路上宝贵的经验。<br />
          <br />
          最后，虽然我目前在博客园上分享技术心得，但是我始终希望能有自己的博客站点来陪伴我成长。

          <br>
          <img src="images/4.jpg">
            <br />

            我的个人微信号 Chen1029693356</p>
          <br />
          <h2>About my blog</h2>
          &nbsp;
          <p>域 名：www.chencblog.xyz</p>
          <br />
         <p>服务器：腾讯云学生服务器</p>
          <br />
          <p>备案号：Copyright © 赣ICP备18013122号</p>
          <br />
          <p>程 序：前台修改自杨青前辈的模板，后端数据库代码为本人设计</p>
  
     </ul>
  </div>
</article>
<footer>
  <p>Design by <a href="#" target="_blank">陈C个人博客</a> <a href="/">Copyright © 赣ICP备18013122号</a></p>
</footer>

</body>
</html>
