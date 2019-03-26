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
<script src="js/scrollReveal.js"></script>
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

  <div class="pagelist"><a class="allpage"><b>99</b></a>&nbsp;&nbsp;<a href="#" class="curPage">1</a>&nbsp;&nbsp;<a href="#" onclick="page(2)">2</a>&nbsp;&nbsp;<a href="#" onclick="page(3)">3</a>&nbsp;&nbsp;<a href="#" onclick="page(4)">4</a>&nbsp;&nbsp;<a href="#" onclick="page(5)">5</a>&nbsp;&nbsp;<a href="#" onclick="page(6)">6</a>&nbsp;&nbsp;<a href="#" onclick="page(7)">7</a>&nbsp;&nbsp;<a href="#" onclick="page(8)">8</a>&nbsp;&nbsp;<a href="#" onclick="page(9)">9</a>&nbsp;&nbsp;<a href="#" onclick="page(2)">下一页</a></div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">陈C个人博客</a> <a href="/">Copyright © 赣ICP备18013122号</a></p>
</footer>
<script>
	if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
		(function(){
			window.scrollReveal = new scrollReveal({reset: true});
		})();
	};
</script>
</body>
</html>
