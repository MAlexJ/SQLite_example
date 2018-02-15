'use strict';

app.controller('ddlController', function ($scope, $http, RestAPI) {
 RestAPI.get("dml")
        .then(function (response) {
                $scope.myData = response.data;
           });
});

app.controller('dmlController', function ($scope, $http) {

});

app.controller('tclController', function ($scope, $http) {

});
