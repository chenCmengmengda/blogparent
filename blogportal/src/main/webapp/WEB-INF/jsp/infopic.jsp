﻿<!doctype html>
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
  <script type="text/javascript" src="js/hc-sticky.js"></script>
  <script type="text/javascript" src="js/comm.js"></script>
  <!--[if lt IE 9]-->
  <script src="js/modernizr.js"></script>
  <!--[endif]-->
</head>
<body>
<header class="header-navigation" id="header">
  <nav><div class="logo"><a href="/">陈C的个人博客</a></div>
    <h2 id="mnavh"><span class="navicon"></span></h2>
    <ul id="starlist">
      <li><a href="index.html">网站首页</a></li>
      <li><a href="share.html">我的相册</a></li>
      <li><a href="list.html">我的日记</a></li>
      <li><a href="about.html">关于我</a></li>
      <li><a href="gbook.html">留言</a></li>
      <li><a href="info.html">内容页</a></li>
      <li><a href="infopic.html">内容页</a></li>
    </ul>
  </nav>
</header>
<article>
  <aside class="l_box">
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
        <li><a href="/"><img src="images/1.jpg"></a></li>
        <li><a href="/"><img src="images/2.jpg"></a></li>
        <li><a href="/"><img src="images/4.jpg"></a></li>
        <li><a href="/"><img src="images/1.jpg"></a></li>
        <li><a href="/"><img src="images/4.jpg"></a></li>
        <li><a href="/"><img src="images/2.jpg"></a></li>
      </ul>
    </div>
    <div class="search">
      <form action="/e/search/index.php" method="post" name="searchform" id="searchform">
        <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字词" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字词'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字词'}" type="text">
        <input name="show" value="title" type="hidden">
        <input name="tempid" value="1" type="hidden">
        <input name="tbname" value="news" type="hidden">
        <input name="Submit" class="input_submit" value="搜索" type="submit">
      </form>
    </div>
    <div class="fenlei">
      <h2>文章分类</h2>
      <ul>
        <li><a href="/">学无止境（33）</a></li>
        <li><a href="/">日记（19）</a></li>
        <li><a href="/">慢生活（520）</a></li>
        <li><a href="/">美文欣赏（40）</a></li>
      </ul>
    </div>

    <div class="guanzhu">
      <h2>关注我 么么哒</h2>
      <ul>
        <img src="images/wx.jpg">
      </ul>
    </div>
  </aside>
  <main>
    <div class="picsbox">
      <div class="bodymodal"></div>

      <div class="share">
        <p class="diggit">
          <a href="JavaScript:makeRequest('/e/public/digg/?classid=3&amp;id=19&amp;dotop=1&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET','');"> 很赞哦！
          </a>
          (<b id="diggnum"><script type="text/javascript" src="/e/public/ViewClick/?classid=2&id=20&down=5"></script>13</b>)
        </p>
      </div>
      <div class="nextinfo">
        <p>上一篇：<a href="">作为一个设计师,如果遭到质疑你是否能恪守自己的原则?</a></p>
        <p>下一篇：<a href="">返回列表</a></p>
      </div>
      <div class="news_pl">
        <h2>文章评论</h2>
        <div class="gbko">
          <script src="/e/pl/more/?classid=77&amp;id=106&amp;num=20"></script>
          <div class="fb">
            <ul>
              <p class="fbtime"><span>2018-07-24 11:52:38</span>dancesmile</p>
              <p class="fbinfo">这才是我要的朋友圈</p>
            </ul>
          </div>
          <div class="fb">
            <ul>
              <p class="fbtime"><span>2018-07-24 08:52:48</span> 卜野</p>
              <p class="fbinfo"></p>
              <div class="ecomment"><span class="ecommentauthor">网友 家蚂蚁 的原文：</span>
                <p class="ecommenttext">坚持哟!看你每天都有写，请继续加油，再接再厉哦</p>
              </div>
            </ul>
          </div>

          <script>
              function CheckPl(obj)
              {
                  if(obj.saytext.value=="")
                  {
                      alert("您没什么话要说吗？");
                      obj.saytext.focus();
                      return false;
                  }
                  return true;
              }
          </script>
          <form action="/e/pl/doaction.php" method="post" name="saypl" id="saypl" onsubmit="return CheckPl(document.saypl)">
            <div id="plpost">
              <p class="saying"><span><a href="/e/pl/?classid=77&amp;id=106">共有<script type="text/javascript" src="/e/public/ViewClick/?classid=77&amp;id=106&amp;down=2"></script>2条评论</a></span>来说两句吧...</p>
              <p class="yname"><span>用户名:</span>
                <input name="username" type="text" class="inputText" id="username" value="" size="16">
              </p>
              <p class="yzm"><span>验证码:</span>
                <input name="key" type="text" class="inputText" size="16">
              </p>
              <input name="nomember" type="hidden" id="nomember" value="1" checked="checked">
              <textarea name="saytext" rows="6" id="saytext"></textarea>
              <input name="imageField" type="submit" value="提交">
              <input name="id" type="hidden" id="id" value="106">
              <input name="classid" type="hidden" id="classid" value="77">
              <input name="enews" type="hidden" id="enews" value="AddPl">
              <input name="repid" type="hidden" id="repid" value="0">
              <input type="hidden" name="ecmsfrom" value="/joke/talk/2018-07-23/106.html">
            </div>
          </form>
        </div>
      </div>
    </div>
  </main>
</article>
<footer>
  <p>Design by <a href="#" target="_blank">陈C个人博客</a> <a href="/">Copyright © 赣ICP备18013122号</a></p>
</footer>
<a href="#" class="cd-top">Top</a>
</body>
</html>
