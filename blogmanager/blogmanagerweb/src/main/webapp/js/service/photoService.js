photoApp.service('photoService',function($http){
   this.findPage=function(page,rows){
       return $http.get('../photo/list.do?page='+page+"&rows="+rows);
    }

    this.add=function(entity){
       return $http.post('../photo/add.do',entity);
    }

    this.delete=function(ids){
       return $http.get('../photo/delete.do?ids='+ids);
    }
});