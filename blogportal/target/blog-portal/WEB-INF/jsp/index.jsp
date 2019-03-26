<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页_陈C个人博客 - 一个站在java后端开发之路的技术员个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description" content="陈C个人博客，是一个站在java后端开发之路的萌新程序员个人网站。" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/base.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<link href="/css/m.css" rel="stylesheet">
<!--[if lt IE 9]>-->
  <script type="text/javascript" src="/js/jquery.min.js"></script>
<script src="/js/modernizr.js"></script>
<script src="/js/vue.js"></script>
  <script src="/js/public.js"></script>
  <script type="text/javascript">
    window.onload = function ()
    {
      var obj=null;
      var As=document.getElementById('nav').getElementsByTagName('a');
      obj = As[0];
      for(i=1;i<As.length;i++){if(window.location.href.indexOf(As[i].href)>=0)
        obj=As[i];}
      obj.id='selected'
    }

    $(function(){
      getBlogList(1,10);
    });

    function getBlogList(page,rows){
      var obj={page:page,rows:rows};
      doDataSyn("/blog/list",obj,function(data){
        new Vue({
          el:"#blogList",
          data:data,

        });
      });
    }

    function showBlog(id){
        alert(id);
    }

  </script>
  <!--[endif]-->
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

</header>
<div class="mnav">
    <ul>
      <li><a href="/index.html">网站首页</a></li>
      <li><a href="/share.html">我的相册</a></li>
      <li><a href="/list.html">我的日记</a></li>
      <li><a href="/about.html">关于我</a></li>
      <li><a href="/gbook.html">留言</a></li>
      <li><a href="/blog">内容页</a></li>
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
    <div class="tuijian">
      <h2>站长推荐</h2>
      <ul>
        <li><a href="/">你是什么人便会遇上什么人</a></li>
        <li><a href="/">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></li>
        <li><a href="/">第二届 优秀个人博客模板比赛参选活动</a></li>
        <li><a href="/">个人博客模板《绅士》后台管理</a></li>
        <li><a href="/">你是什么人便会遇上什么人</a></li>
        <li><a href="/">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></li>
        <li><a href="/">第二届 优秀个人博客模板比赛参选活动</a></li>
        <li><a href="/">个人博客模板《绅士》后台管理</a></li>
      </ul>
    </div>
    <div class="links">
      <h2>友情链接</h2>
      <ul>
        <a href="http://chenCmengmengda.github.io">陈C的github主页</a> <a target="_blank" href="https://www.cnblogs.com/secret-ChenC/">陈C的博客园</a>
      </ul>
    </div>
    <div class="guanzhu">
      <h2>关注我 么么哒</h2>
      <ul>
        <img src="images/wx.jpg">
      </ul>
    </div>
  </div>
  <div id="blogList" class="r_box">
    <li v-for="blog in rows">
      <i><a href="/"><img src="images/4.jpg"></a></i>
      <h3><a :href="'/blog/'+blog.id+'.html'">{{ blog.title }}</a></h3>
      <p>{{ blog.summary }}</p>
    </li>


    <%--<c:forEach var="blog" items="${blogListResult.rows}">--%>
      <%--<li><i><a href="/"><img src="images/4.jpg"></a></i>--%>
        <%--<h3><a href="/blog/${blog.id}.html">${blog.title}</a></h3>--%>
        <%--<p>${blog.summary}</p>--%>
      <%--</li>--%>
    <%--</c:forEach>--%>
      <!-- 分页 -->
    <div class="pagelist">
      <a class="allpage"><b>{{ pages }}</b></a>&nbsp;&nbsp;
      <template v-if="page >= 5 && page <= pages-4">
        <template v-for="n in pages"  v-if="n >= page-3 && n <= page+5">
          <template v-if="n != page">
            <a :href="'javascript:getBlogList('+n+',10)'"  onclick="page(${i})">{{ n }}</a>&nbsp;&nbsp;
          </template>
          <template v-else>
            <a :href="'javascript:getBlogList('+n+',10)'" class="curPage">{{ page }}</a>&nbsp;&nbsp;
          </template>
        </template>
      </template>
      <template v-else-if="page < 5 && pages >= 9">
        <template v-for="n in pages" v-if="n <= 9">
          <template v-if="n != page">
            <a :href="'javascript:getBlogList('+n+',10)'"  onclick="page(${i})">{{ n }}</a>&nbsp;&nbsp;
          </template>
          <template v-else>
            <a :href="'javascript:getBlogList('+n+',10)'" class="curPage">{{ page }}</a>&nbsp;&nbsp;
          </template>
        </template>
      </template>
      <template v-if="page < 5 && pages < 9">
        <template v-for="n in pages">
          <template v-if="n != page">
            <a :href="'javascript:getBlogList('+n+',10)'"  onclick="getBlogList(n,10)">{{ n }}</a>&nbsp;&nbsp;
          </template>
          <template v-else>
            <a :href="'javascript:getBlogList('+n+',10)'" class="curPage" >{{ page }}</a>&nbsp;&nbsp;
          </template>
        </template>
      </template>

      <%--<a class="allpage"><b>${blogListResult.pages}</b></a>&nbsp;&nbsp;--%>
      <%--<c:if test="${page >=5 && page <= blogListResult.pages-4}">--%>
        <%--<c:forEach begin="${page-3}" end="${page+5}" var="i">--%>
          <%--<c:if test="${i} != ${page}">--%>
            <%--<a href="#" onclick="page(${i})">${i}</a>&nbsp;&nbsp;--%>
          <%--</c:if>--%>
          <%--<c:if test="${i == page}">--%>
            <%--<a href="#" class="curPage">${page}</a>&nbsp;&nbsp;--%>
          <%--</c:if>--%>
        <%--</c:forEach>--%>
      <%--</c:if>--%>
      <%--<c:if test="${page < 5 && blogListResult.pages>=9}">--%>
        <%--<c:forEach begin="1" end="9" var="i">--%>
          <%--<c:if test="${i != page}">--%>
            <%--<a href="#" onclick="page(${i})">${i}</a>&nbsp;&nbsp;--%>
          <%--</c:if>--%>
          <%--<c:if test="${i == page}">--%>
            <%--<a href="#" class="curPage">${page}</a>&nbsp;&nbsp;--%>
          <%--</c:if>--%>
        <%--</c:forEach>--%>
      <%--</c:if>--%>
      <%--<c:if test="${page < 5 && blogListResult.pages<9}">--%>
        <%--<c:forEach begin="1" end="${blogListResult.pages}" var="i">--%>
          <%--<c:if test="${i != page}">--%>
            <%--<a href="#" onclick="page(${i})">${i}</a>&nbsp;&nbsp;--%>
          <%--</c:if>--%>
          <%--<c:if test="${i == page}">--%>
            <%--<a href="#" class="curPage">${page}</a>&nbsp;&nbsp;--%>
          <%--</c:if>--%>
        <%--</c:forEach>--%>
      <%--</c:if>--%>
      <%--<a href="#" onclick="page(${page+1})">下一页</a>--%>
    </div>
  </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">陈C个人博客</a> <a href="/">Copyright © 赣ICP备18013122号</a></p>
</footer>

</body>
</html>
