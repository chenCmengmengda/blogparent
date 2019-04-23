var blogId;
var vue=new Vue({

    el:"#blogInfo",
    data: {
        blogInfo :[],

    },

    methods:{

        findOne:function(id){
            var _this = this;
            axios.get("/blog/"+id).then(function (response) {
                _this.blogInfo= response.data;
                console.log(_this.blogInfo);
            }).catch(function (err) {
                console.log(err);
            });
        },

    },
    created(){
        blogId=getUrlKey('id');
        this.findOne(blogId);
    //    alert( blogId);
    },
    filters:{
      dataFormat:function(time){
          var date=new Date(time);
          return date.format("yyyy-MM-dd hh:mm:ss");
      }
    },
});