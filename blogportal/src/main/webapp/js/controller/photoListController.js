

var photoList=new Vue({
    el:"#photoList",
    data: {
        photoList :[],
        cur: 1,
        all: 8,
        msg: '',
        analysisRank:[],

    },
    components:{
        'vue-nav': Vnav

    },
    methods:{
        callback(data) {
            this.cur = data
            this.findPage(this.cur,8);
        },
        findPage:function(page, rows){
            var _this = this;
            axios.get("/photo/list?page="+page+"&rows="+rows).then(function (response) {
                _this.photoList= response.data;
                _this.all=response.data.pages;
                console.log(_this.photoList);

            }).catch(function (err) {
                console.log(err);
            });
            setTimeout(function(){
                if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
                    (function(){
                        window.scrollReveal = new scrollReveal({reset: true});
                    })();
                };
                },100);
        },


    },
    created(){
        this.findPage(this.cur,8);

    },


});