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
    <!--播放到第一张图的提示-->
    <div class="firsttop">
      <div class="firsttop_right">
        <div class="close2"> <a class="closebtn1" title="关闭" href="javascript:void(0)"></a> </div>
        <div class="replay">
          <h2 id="div-end-h2"> 已到第一张图片了。 </h2>
          <p> <a class="replaybtn1" href="javascript:;">重新播放</a> </p>
        </div>
      </div>
    </div>
    <!--播放到最后一张图的提示-->
    <div class="endtop">
      <div class="firsttop_right">
        <div class="close2"> <a class="closebtn2" title="关闭" href="javascript:void(0)"></a> </div>
        <div class="replay">
          <h2 id="H1"> 已到最后一张图片了。 </h2>
          <p> <a class="replaybtn2" href="javascript:;">重新播放</a> </p>
        </div>
      </div>
    </div>
    <!--弹出层结束--> 
    <!--图片特效内容开始-->
    <div class="piccontext">
      <h2> 上戏校花迪丽热巴清新写真宛若小仙女 </h2>
      <div class="source">
        <div class="source_left"><span>2018-5-7</span> </div>
        <div class="source_right"> <a href="javascript:;" class="list">列表查看</a> </div>
        <div class="source_right1"> <a href="javascript:;" class="gaoqing">高清查看</a> </div>
      </div>
      <!--大图展示-->
      <div class="picshow">
        <div class="picshowtop"> <a href="#"><img src="" alt="" id="pic1" curindex="0" /></a> <a id="preArrow" href="javascript:void(0)" class="contextDiv" title="上一张"><span id="preArrow_A"></span></a> <a id="nextArrow" href="javascript:void(0)" class="contextDiv" title="下一张"><span id="nextArrow_A"></span></a> </div>
        <div class="picshowtxt">
          <div class="picshowtxt_left"><span>1</span>/<i>12</i></div>
          <div class="picshowtxt_right"></div>
        </div>
        <div class="picshowlist">
          <div class="picshowlist_mid">
            <div class="picmidleft"> <a href="javascript:void(0)" id="preArrow_B"><span class="sleft"></span></a> </div>
            <div class="picmidmid">
              <ul>
                <li> <a href="javascript:void(0);"><img src="images/1.jpg" alt="" bigimg="images/1.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/2.jpg" alt="" bigimg="images/2.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/3.jpg" alt="" bigimg="images/3.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/4.jpg" alt="" bigimg="images/4.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/5.jpg" alt="" bigimg="images/5.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/6.jpg" alt="" bigimg="images/6.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/7.jpg" alt="" bigimg="images/7.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/8.jpg" alt="" bigimg="images/8.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/9.jpg" alt="" bigimg="images/9.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/10.jpg" alt="" bigimg="images/10.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/11.jpg" alt="" bigimg="images/11.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
                <li> <a href="javascript:void(0);"><img src="images/12.jpg" alt="" bigimg="images/12.jpg" text="《古剑》小师妹迪丽热巴清新写真宛若小仙女" /></a></li>
              </ul>
            </div>
            <div class="picmidright"> <a href="javascript:void(0)" id="nextArrow_B"><span class="sright"></span></a> </div>
          </div>
        </div>
      </div>
      
      <!--列表展示-->
      <div class="piclistshow">
        <ul>
          <li>
            <div class="picimg"><img src="images/1.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(1/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/2.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(2/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/3.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(3/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/4.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(4/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/5.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(5/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/6.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(6/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/7.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(7/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/8.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(8/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/9.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(9/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/10.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(10/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/11.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(11/12)</span></h3>
            </div>
          </li>
          <li>
            <div class="picimg"><img src="images/12.jpg" alt="" /></div>
            <div class="pictxt">
              <h3>《古剑》小师妹迪丽热巴清新写真宛若小仙女<span>(12/12)</span></h3>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <div class="pictext">
      <ul>
        游览普陀山一天时间足够了，如果考虑到还要来还愿，那就没必要一次把所有的地方都去到，如果只是单纯的旅游，那就把最重要的地方看看就可以了，普陀山并不是以景色著称的。普陀山上住宿餐饮价格都非常贵，住宿还好说，毕竟供不应求嘛，尤其是节假日，想要提前预定都不一定有房间，餐饮更是离谱，一般都是岛外四五倍的价格。所以建议大家像我们一样住在朱家尖，莲花路是朱家尖镇的中心，比较繁华热闹，住宿餐饮都集中在那里，岛上游玩去庙里体验素斋就可以啦。
      </ul>
    </div>
    <div class="share">
      <p class="diggit"><a href="JavaScript:makeRequest('/e/public/digg/?classid=3&amp;id=19&amp;dotop=1&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET','');"> 很赞哦！ </a>(<b id="diggnum"><script type="text/javascript" src="/e/public/ViewClick/?classid=2&id=20&down=5"></script>13</b>)</p>
    </div>
  </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">陈C个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
</body>
</html>
