'use strict';

app.controller('ddlController', function ($scope, $http, RestAPI) {
    RestAPI.get("ddl")
        .then(function (response) {
            $scope.subCategoryList = response.data;
        });

    $scope.sendText = function () {
        var inData = {'text': $scope.text};
        $http.post("/app/subcategory/ddl", inData); // todo set  type >>> application/json
        $scope.text = '';
    };

});

app.controller('ddlTemplateController', function ($scope, $http) {

});

app.controller('dmlController', function ($scope, $http) {

});

app.controller('tclController', function ($scope, $http) {

});
