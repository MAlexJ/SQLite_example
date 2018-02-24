'use strict';

let app = angular.module('app', ['ui.router']);

app.config(function ($locationProvider, $stateProvider, $urlRouterProvider) {

    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');

    let states = [
        {
            name: 'ddl',
            url: '/ddl',
            component: 'ddl'
        },
        {
            name: 'dml',
            url: '/dml',
            component: 'dml'
        },
        {
            name: 'tcl',
            url: '/tcl',
            component: 'tcl',
            resolve: {
                tcl: function (RestAPI) {
                    return RestAPI.get('tcl');
                }
            }
        }
    ];

    states.forEach(function(state) {
        $stateProvider.state(state);
    });

    $urlRouterProvider.otherwise("/ddl");
});
