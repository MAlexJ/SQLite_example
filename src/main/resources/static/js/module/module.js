'use strict';

let app = angular.module('app', ['ui.router', 'ngSanitize']);

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
                    let id = {'idSubCategory':$stateParams.id};
                    return RestAPI.post('ddl', id);
                }
            }
        },
        {
            name: 'dml',
            url: '/dml',
            component: 'dml',
            resolve: {
                dml: function (RestAPI) {
                    return RestAPI.get('dml');
                }
            }
        },
        {
            name: 'dmlSubCategory',
            parent: 'dml',
            url: '{id}',
            component: 'dmlSubCategory',
            resolve: {
                dmlSubCategory: function (RestAPI, $stateParams) {
                    let id = {'idSubCategory':$stateParams.id};
                    return RestAPI.post('dml', id);
                }
            }
        },
        {
            name: 'dcl',
            url: '/dcl',
            component: 'dcl',
            resolve: {
                dcl: function (RestAPI) {
                    return RestAPI.get('dcl');
                }
            }
        },
        {
            name: 'dclSubCategory',
            parent: 'dcl',
            url: '{id}',
            component: 'dclSubCategory',
            resolve: {
                dclSubCategory: function (RestAPI, $stateParams) {
                    let id = {'idSubCategory':$stateParams.id};
                    return RestAPI.post('dcl', id);
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
                    let id = {'idSubCategory':$stateParams.id};
                    return RestAPI.post('tcl', id);
                }
            }
        },
        {
            name: 'console',
            url: '/console',
            component: 'console'
        } ,
       {
            name: 'info',
            url: '/info',
            component: 'info'
        }
    ];

    states.forEach(function (state) {
        $stateProvider.state(state);
    });

    $urlRouterProvider.otherwise("/ddl");
});
