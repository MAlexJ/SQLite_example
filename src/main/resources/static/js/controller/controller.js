'use strict';

/**
 * Start page: default select the first tab
 */
myAdmin.controller('adminLanguageController', function ($scope, $state) {
    // go to active first link
    $state.go('language_list');
});

myAdmin.controller('adminLanguageListController', function ($scope, $http) {

});
