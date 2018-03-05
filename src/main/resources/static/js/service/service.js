'use strict';

app.factory('RestAPI', ['$http', function ($http) {
    let Response = {};

    Response.get = function (url) {
        return $http.get("/app/subcategory/" + url);
    };

    Response.post = function (url, inData) {
        return $http.post("/app/subcategory/"+url, inData);
    };

    return Response;
}]);
