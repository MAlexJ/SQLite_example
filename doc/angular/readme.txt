

*****************************************************************************************************************************************************

 Client Side

 Data needs to be grouped in an object array as payload - Indata:

 var Indata = {'product': $scope.product, 'product2': $scope.product2 };
 Pass the payload through $http.post as the second argument:

 $http.post("http://localhost:53263/api/Products/", Indata).then(function (data, status, headers, config) {
    alert("success");
 },function (data, status, headers, config) {
    alert("error");
 });

*****************************************************************************************************************************************************
DESCRIPTION:  Get Data from AngularJS HTTP post call in controller from factory

make sure your service is returning a promise so you can call it's then method, look at the documentation for $q for more information on promises :

function getCustomerGraphData(payload, config, $q) {
   // initialize the defer object
   var deferred = $q.defer();

    var data = {
        user_selection: JSON.stringify(payload),
        index_info: JSON.stringify(config.index_info),
        column_config: JSON.stringify(config.Results)
    };

    console.log("data", data);

    $http({
        url: 'URL',
        method: "POST",
        data: $.param(data),
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(function(response) {
        var customer = response.data;

        console.log("data", customer);

        // resolve the promise with your data
        deferred.resolve(customer);
    });

    // return the promise
    return deferred.promise;

}

*****************************************************************************************************************************************************
DESCRIPTION:  Using the constant method

// app.js
angular.module('myApp', [
        'ngCookies',
        'ngResource',
        'ngSanitize',
        'ngRoute'
    ])
    .constant('config', {
        mySetting: 42
    })
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
// main.js
angular.module('myApp')
    .controller('MainCtrl', [
        '$scope', 'config',
        function ($scope, config) {
            console.log(config.mySetting);
        }
    ]);


    *****************************************************************************************
