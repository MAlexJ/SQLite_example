'use strict';

app.controller('navBarController', function($state, $scope) {
    $scope.hidingNavBar = function() {
        if ($(window).width() <= 990) {
            console.log('hiding');
            $('#btn-menu-toggle').click();
        }
    }
});