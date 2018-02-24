'use strict';

app.factory('RestAPI', ['$http', function ($http) {
    let Response = {};

    Response.get = function (url) {
        return $http.get("/app/subcategory/" + url);
    };

    Response.post = function (url, inData) {
        return $http.post("/app/subcategory/ddl", inData);
    };

    // $scope.sendText = function () {
    //     var inData = {'text': $scope.text};
    //     $http.post("/app/subcategory/ddl", inData); // todo set  type >>> application/json
    //     $scope.text = '';
    // };
    return Response;
}]);
