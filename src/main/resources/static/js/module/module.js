'use strict';

let app = angular.module('app', ['ui.router']);

app.config(function ($locationProvider, $stateProvider, $urlRouterProvider) {
    $locationProvider.html5Mode(true);
    $locationProvider.hashPrefix('!');

    let states = [
        {
            name: 'ddl',
            url: '/ddl',
            component: 'ddl',
            resolve: {
                ddl: function (RestAPI) {
                    return RestAPI.get('ddl');
                }
            }
        },
        {
            name: 'ddlSubCategory',
            parent: 'ddl',
            url: '{id}',
            component: 'ddlSubCategory',
            resolve: {
                ddlSubCategory: function (RestAPI, $stateParams) {
                    return RestAPI.post('ddl', $stateParams.id);
                }
            }
        },
        {
            name: 'dml',
            url: '/dml',
            component: 'dml'
        },
        {
            name: 'dmlSubCategory',
            parent: 'dml',
            url: '{id}',
            component: 'dmlSubCategory',
            resolve: {
                dmlSubCategory: function (RestAPI, $stateParams) {
                    return RestAPI.post('dml', $stateParams.id);
                }
            }
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
        },
        {
            name: 'tclSubCategory',
            parent: 'tcl',
            url: '{id}',
            component: 'tclSubCategory',
            resolve: {
                tclSubCategory: function (RestAPI, $stateParams) {
                    return RestAPI.post('tcl', $stateParams.id);
                }
            }
        }
    ];

    states.forEach(function (state) {
        $stateProvider.state(state);
    });

    $urlRouterProvider.otherwise("/ddl");
});
