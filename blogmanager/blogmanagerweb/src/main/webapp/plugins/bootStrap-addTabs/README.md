 **评论关闭** 
如果有意见或建议请到[Issues](https://git.oschina.net/hbbcs/bootStrap-addTabs/issues)中发表。

 **Demo** 
[Demo Url](http://hbbcs.oschina.io/bootstrap-addtabs/)

 **UPDATE** 
- **2017/10/24 刷新页面保持tabs状态，不再需要jquery.cookie支持，转用HTML5 localStorage，$.addtabs.set('store','true')**
- 2017/10/14 刷新页面保持tabs状态，需要jquery.cookie支持，$.addtabs.set('cookie','true')
- 2017/08/22 改变ajax方式，增加ajax参数调用
- 2017/08/21 增加加载条，$.addtabs.set("loadbar",false)关闭
- 2017/04/21 修正更新方式按链接是否使用ajax，修正重复刷新BUG
- 2017/03/14 更新版本到2.0
- 2017/02/23 增加拖动，支持HTML5的浏览器可用
- 2017/02/15 规范代码，修正BUG
- 2017/02/09 更改右键菜单，增加右键菜单local设置
- 2016/12/16 修正点击按钮/链接会刷新已打开TAB
- 2016/10/13 新增TAB右键菜单，取消右键关闭，注：不希望关闭的tab，不要设置ID
- 2016/09/20 新增1、直接在TAB上点右键关闭其他TAB，并激活当前tab;2、关闭所有打开TAB的按钮
- 2016/06/23 隐藏关闭按钮，鼠标指向TAB时显示
- 2016/02/04 修改主体JS文件，更灵活，更规范
- 2016/01/25 修改IFrame支持IE，修改一些BUG，增加iframeClass样式表
- 2015/12/19 重新编写了代码，增加一些参数及函数
- theme/fonts 目录下的文件我就没有上传了，就是使用Bootstrap中的fonts文件
- 11月增加了折叠TABS的代码，防止打开过多影响页面
- 最近在做一个前端，需要点击按钮创建一个可关闭的标签页，没有找到合适的，最后想到不如改造一下bootstrap省事。

**Usage** 
STEP 1、引入文件
```
<link rel="stylesheet" href="./bootstrap.addtabs.css" type="text/css" media="screen" />
<script type="text/javascript" src="./bootstrap.addtabs.js"></script>
```
STEP 2、设置按钮或链接
```
<a class="list-group-item" data-addtab="userMenu1" data-target="#tabs2" data-url="./example/ajax/mailbox.txt">
    用户菜单1
</a>
```
或使用标准的json
```
<a class="list-group-item" data-addtab='{"id":"mail","url": "./example/ajax/button.html","target": "#tabs1"}'>
    用户菜单2
</a>
```
ajax调用方式
```
<a class="list-group-item" data-addtab="mail1"  data-ajax='{"async":false}'  data-url="example/ajax/mailbox.txt">
    Use Ajax
</a>
```
json可用参数
```
{
    "id": string,
    "target": string|object,
    "title": string,
    "content": string, //设置content,url将不起作用
    "url": string,
    "ajax": json
}
```
至此就可以使用此插件。


关闭所有增加的TAB
```
$('#closeAll1').click(function () {
    $.addtabs.closeAll('#tabs1');
})
```
子窗口不加载bootstrap-addtabs的环境下，在父窗口增加TAB。
```
$('#testbutton').click(function() {
    window.parent.window.$.addtabs.add({
        target: "#tabs1",
        url: "example/ajax/mailbox.txt",
        title: "test"
    });
})
```
iframe子窗口关闭父窗口的TABS
```
$(function() {
    window.parent.window.$.addtabs.close('#tab_message');
})
```
**参数**
```
target       string|object 同一页面如果存在多个nav-tabs，可以使用此参数设定增加TAB的目标
content      string|html   直接指定内容
close        bool          是否可以关闭，默认是true
monitor      string        监视的区域,默认是body
iframe       bool          使用iframe，false使用ajax,默认true
iframeHeight num           固定TAB中IFRAME高度
callback     function(){}  关闭后回调函数
contextmenu  bool          是否启用右键菜单，默认true
loadbar      bool          是否显示加载条，默认是true
store        bool          将打开的tab页记录到客户端存储中，刷新页面时自动打开，默认使用
ajax         object        全局调用ajax的默认参数
local:{
    'refreshLabel': '刷新此标签',
    'closeThisLabel': '关闭此标签',
    'closeOtherLabel': '关闭其他标签',
    'closeLeftLabel': '关闭左侧标签',
    'closeRightLabel': '关闭右侧标签'，
    'loadbar': '正在加载内容，请稍候．．．'
}
```
设置方法
```
$.addtabs({"target":"#tabs1",...})
```
或
```
$.addtabs.set({"target":"#tabs1"});
```
或
```
$.addtabs.set("target","#tabs1");
```