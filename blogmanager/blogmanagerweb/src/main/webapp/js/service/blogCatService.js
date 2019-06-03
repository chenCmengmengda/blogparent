blogCatApp.service('blogCatService',function($http){

    this.getBlogCatList=function(page,rows){
        return $http.get('../blog/getBlogCatList.do?page='+page+'&rows='+rows);
    }

    this.addBlogCat=function(entity){
        return $http.post('../blog/addBlogCat.do',entity);
    }

    
});