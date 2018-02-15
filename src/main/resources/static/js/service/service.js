'use strict';

app.factory('RestAPI', ['$http', function ($http) {
       var Response = {};
        Response.get = function(url){
          return $http.get("/app/subcategory/"+url);
        };
        return Response;
    }]);
