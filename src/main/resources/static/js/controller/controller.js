'use strict';

app.controller('ddlController', function ($scope, $http, RestAPI) {
 RestAPI.get("dml")
        .then(function (response) {
                $scope.myData = response.data;
           });

  $scope.sendText = function() {
        var Indata = {'text': $scope.text};
        $http.post("/app/subcategory/ddl", Indata);
           console.log( $scope.text );
            $scope.text = '';
    };

});

app.controller('dmlController', function ($scope, $http) {

});

app.controller('tclController', function ($scope, $http) {

});
