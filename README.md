# chencBlog
个人博客前后台整站

这是一个使用ssm+maven实现的博客。

### 目前已实现的模块： 
用户管理

博客编写修改及删除

相册上传

后台登录系统  

前台系统博客列表及内容展示

留言以及回复

### 安装说明：
1.sql文件在blogparent->src->resources
导入mysql

blogmanager-web,blogportal,blogrest这三个工程的src->resources下都有数据库连接配置文件db.properties，连接数据库修改里面的配置信息即可

2.上传图片需要配置ftp图片服务器地址，用户名，密码
在blogmanager下的blogmanagerweb->src->resources中的resource.properties
修改ftp相应配置

在此之前需要准备nginx+ftp的图片服务器

3.点赞功能需要准备redis服务器,在blog-rest工程中resource目录下jedis.xml中配置，
redis的key管理可以配置在resource.properties

4.搜索功能需要准备solr服务器,在blog-search工程中resource目录下solr.xml和
resource.properties中配置

### 许可：
GPL v3

