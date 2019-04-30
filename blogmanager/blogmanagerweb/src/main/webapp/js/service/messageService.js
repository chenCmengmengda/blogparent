messageApp.service('messageService',function($http){
    this.findPage=function(page,rows){
        return $http.get('../message/list.do?page='+page+"&rows="+rows);
    }

    this.findOne=function(messageId){
        return $http.get('../message/findOne.do?messageId='+messageId);
    }

    this.addReply=function(entity){
        return $http.post('/message/addReply.do',entity);
    }
});