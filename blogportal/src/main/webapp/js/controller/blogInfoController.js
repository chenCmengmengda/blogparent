var blogId;
var vue=new Vue({

    el:"#blogInfo",
    data: {
        blogInfo :[],
        blogLike:"",
    },

    methods:{

        findOne:function(id){
            if(id==null || id==""){
                return;
            }
            var _this = this;
            axios.get("/blog/"+id).then(function (response) {
                if(response.data.status==200) {
                    _this.blogInfo = response.data.data;
                    console.log(_this.blogInfo);

                }
            }).catch(function (err) {
                console.log(err);
            });
        },

        addBlogLike:function(){
            if(blogId==null || blogId==""){
                return;
            }
            var _this = this;
            axios.get("/blog/addBlogLike?id="+blogId).then(function (response) {
                if(response.data.status==200){
                    _this.getBlogLike();//重新获取点赞数
                } else{
                    alert("系统正在维护，暂时不能点赞");
                }

            }).catch(function (err) {
                console.log(err);
            });
        },
        getBlogLike:function(){
            if(blogId==null || blogId==""){
                return;
            }
            var _this = this;
            axios.get("/blog/getBlogLike?id="+blogId).then(function (response) {
                if(response.data.status==200) {
                    _this.blogLike = response.data.data;
                }
            }).catch(function (err) {
                console.log(err);
            });
        }

    },
    created(){
        blogId=getUrlKey('id');
        this.findOne(blogId);
        this.getBlogLike(blogId);
    //    alert( blogId);
    },
    filters:{
      dataFormat:function(time){
          var date=new Date(time);
          return date.format("yyyy-MM-dd hh:mm:ss");
      }
    },
});