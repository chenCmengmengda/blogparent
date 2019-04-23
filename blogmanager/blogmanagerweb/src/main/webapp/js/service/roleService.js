roleApp.service('roleService',function($http){

   this.findPage=function(page,rows) {
        return $http.get('../role/list.do?page='+page+"&rows="+rows);
    }

    this.addRole=function(entity){
        return $http.post('../role/add.do',entity);
    }


});