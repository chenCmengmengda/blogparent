<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页_陈C个人博客 - 一个站在java后端开发之路的技术员个人博客网站</title>
<meta name="keywords" content="个人博客,陈C个人博客,个人博客模板,陈C" />
<meta name="description" content="陈C个人博客，是一个站在java后端开发之路的萌新程序员个人网站。" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/infopic.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/piccontent.min.js" type="text/javascript"></script>
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
  <div class="picsbox">
    <div class="bodymodal"></div>


    <div class="share">
      <p class="diggit"><a href="JavaScript:makeRequest('/e/public/digg/?classid=3&amp;id=19&amp;dotop=1&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET','');"> 很赞哦！ </a>(<b id="diggnum"><script type="text/javascript" src="/e/public/ViewClick/?classid=2&id=20&down=5"></script>13</b>)</p>
    </div>
  </div>
</article>
<footer>
  <p>Design by <a href="#" target="_blank">陈C个人博客</a> <a href="/">Copyright © 赣ICP备18013122号</a></p>
</footer>
</body>
</html>
