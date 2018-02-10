'use strict';

var myAdmin = angular.module('myAdmin', ['ui.router']);

//maven properties
var base_url = '${active.url}';

myAdmin.config(function ($stateProvider, $urlRouterProvider) {

    // :::::::::::::::::::::::::::::::::::::::::::::::
    // ************** analytics **********************
    // :::::::::::::::::::::::::::::::::::::::::::::::
    var analytics = {
        name: 'analytics',
        url: '/analytics',
        templateUrl: base_url + '/admin/analytics',
        controller: 'adminAnalyticsController'
    };
    var analytics_page = {
        parent: 'analytics',
        name: 'analytics_page',
        url: '/analytics_page',
        templateUrl: base_url + '/admin/analytics_page',
        controller: 'adminAnalyticsPageController'
    };

    // :::::::::::::::::::::::::::::::::::::::::::::::
    // ************** symptoms ***********************
    // :::::::::::::::::::::::::::::::::::::::::::::::
    var symptoms = {
        name: 'symptoms',
        url: '/symptoms',
        templateUrl: base_url + '/admin/symptoms',
        controller: 'adminSymptomsController'
    };
    var symptoms_list = {
        parent: 'symptoms',
        name: 'symptoms_list',
        url: '/symptoms_list',
        templateUrl: base_url + '/admin/symptoms_list',
        controller: 'adminSymptomsListController'
    };
    var symptoms_create = {
        parent: 'symptoms',
        name: 'symptoms_create',
        url: '/symptoms_create',
        templateUrl: base_url + '/admin/symptoms_create',
        controller: 'adminSymptomsCreateController'
    };
    var symptoms_approve = {
        parent: 'symptoms',
        name: 'symptoms_approve',
        url: '/symptoms_approve',
        templateUrl: base_url + '/admin/symptoms_approve',
        controller: 'adminSymptomsApproveController'
    };


    $stateProvider.state(analytics);
    $stateProvider.state(analytics_page);

    $stateProvider.state(symptoms);
    $stateProvider.state(symptoms_list);
    $stateProvider.state(symptoms_create);
    $stateProvider.state(symptoms_approve);

    $urlRouterProvider.otherwise("/analytics");
});