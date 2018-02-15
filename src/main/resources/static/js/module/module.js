'use strict';

var app = angular.module('app', ['ui.router']);
var base_url = '';

app.config(function ($locationProvider, $stateProvider, $urlRouterProvider) {

    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');

    var ddl = {
        name: 'ddl',
        url: '/ddl',
        templateUrl: base_url + '/app/ddl',
        controller: 'ddlController'
    };

    var dml = {
        name: 'dml',
        url: '/dml',
        templateUrl: base_url + '/app/dml',
        controller: 'dmlController'
    };

    var tcl = {
        name: 'tcl',
        url: '/tcl',
        templateUrl: base_url + '/app/tcl',
        controller: 'tclController'
    };

    $stateProvider.state(ddl);
    $stateProvider.state(dml);
    $stateProvider.state(tcl);

    $urlRouterProvider.otherwise("/ddl");
});
