var vue=new Vue({

    el:"#userMessage",
    data: {
        messageList:{},
        userMessage:{
            username:'',
            email:'',
            message:''
        },
        cur: 1,
        all: 8,
        msg: '',

    },
    components:{
        'vue-nav': Vnav

    },

    methods:{

        callback(data) {
            this.cur = data
            this.findPage(this.cur,10);
        },
        findPage:function(page, rows){
            var _this = this;
            axios.get("/message/list?page="+page+"&rows="+rows).then(function (response) {
                _this.messageList= response.data;
                _this.all=response.data.pages;
                console.log(_this.photoList);

            }).catch(function (err) {
                console.log(err);
            });

        },
        addMessage:function(){
            var _this = this;

            axios.post("/message/add",_this.userMessage).then(
                function(response){
                    if(response.data.status==200){
                        this.findPage(_this.cur,10);
                    } else{
                        alert("提交错误，系统正在维护");
                    }
                }
            )
        }

    },
    created(){
        this.findPage(this.cur,10);
        //    alert( blogId);
    },
    filters:{
        dataFormat:function(time){
            var date=new Date(time);
            return date.format("yyyy-MM-dd hh:mm:ss");
        }
    },
});