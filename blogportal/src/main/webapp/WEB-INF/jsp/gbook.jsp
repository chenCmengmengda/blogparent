<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>首页_陈C个人博客 - 一个站在java后端开发之路的技术员个人博客网站</title>
  <meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
  <meta name="description" content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/base.css" rel="stylesheet">
  <link href="css/index.css" rel="stylesheet">
  <link href="css/m.css" rel="stylesheet">
  <script src="js/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="js/hc-sticky.js"></script>
  <script type="text/javascript" src="js/comm.js"></script>
  <!--[if lt IE 9]-->
  <script src="js/modernizr.js"></script>
  <!--[endif]-->
</head>
<body>
<header class="header-navigation" id="header">
  <nav><div class="logo"><a href="/">陈C个人博客</a></div>
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
        <p><b>陈C</b>，一个90后萌新站长！17年入坑。一直潜心研究java后端技术，
          一边学习一边积累经验，分享一些个人学习心得。</p>
      </ul>
    </div>
    <div class="wdxc">
      <h2>我的相册</h2>
      <ul>
        <li><a href="/"><img src="images/1.jpg"></a></li>
        <li><a href="/"><img src="images/2.jpg"></a></li>
        <li><a href="/"><img src="images/4.jpg"></a></li>
        <li><a href="/"><img src="images/1.jpg"></a></li>
        <li><a href="/"><img src="images/2.jpg"></a></li>
        <li><a href="/"><img src="images/4.jpg"></a></li>
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
  <main class="r_box">
    <div class="gbook">
      <div class="fb">
        <ul>
          <p class="fbtime"><span> 2018-07-21 </span> 夜月归途</p>
          <p class="fbinfo">从青姐朋友圈分享的文章《我为什么要做个人网站》过来的，自习看了下你的网站非常不错，看的出来你一直在坚持!</p>
        </ul>
      </div>
      <div class="hf">
        <ul>
          <p class="zzhf"><font color="#FF0000">站长回复:</font>感谢捧场啊！看了你的网站，有两个月没更新了哦~</p>
        </ul>
      </div>
      <div class="fb">
        <ul>
          <p class="fbtime"><span> 2018-07-10 </span> 周宏</p>
          <p class="fbinfo">读《从今日起，我永久卸载今日头条》有感。正如作者所说，这个APP抓住了很多人性的特点，在简单、重复、爽这三点上做到了极致。但是我认为永久卸载这个想法比较荒诞，任何东西你只要有自控力，就能将它为我所用。曾经一度我也是刷头条根本停不下来</p>
        </ul>
      </div>
      <div class="hf">
        <ul>
          <p class="zzhf"><font color="#FF0000">站长回复:</font>嗯，我也是自制力有限，删除头条就是矫枉过正而已，这个因人而异，不强求他人，也不想标题党。</p>
        </ul>
      </div>
      <div class="fb">
        <ul>
          <p class="fbtime"><span> 2018-07-09 </span> 文颖</p>
          <p class="fbinfo">加油吖</p>
        </ul>
      </div>
      <div class="hf">
        <ul>
          <p class="zzhf"><font color="#FF0000">站长回复:</font>感谢第一条留言的支持！：）</p>
        </ul>
      </div>
      <div class="gbox">
        <form action="../../enews/index.php" method="post" name="form1" id="form1">
          <p> <strong>来说点儿什么吧...</strong></p>
          <p><span> 您的姓名:</span>
            <input name="name" type="text" id="name">
            *</p>
          <p><span>联系邮箱:</span>
            <input name="email" type="text" id="email">
            *</p>
          <p><span class="tnr">留言内容:</span>
            <textarea name="lytext" cols="60" rows="12" id="lytext"></textarea>
          </p>
          <p>
            <input type="submit" name="Submit3" value="提交">
            <input name="enews" type="hidden" id="enews" value="AddGbook">
          </p>
        </form>
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
