'use strict';

app.component('info', {
    bindings: {info: '<'},
    controller: function ($location, $window) {
     this.toggleDoc = function () {
           $window.location.href = '/documentation/swagger-ui.html';
     }
     this.toggleGit = function () {
           $window.location.href = 'https://github.com/MAlexJ/SQLite_example';
     }
    },
    template:
     `<div class="container">
         <div class="row justify-content-md-center" style="padding-top: 40px;">
            <div class="jumbotron" style="padding-top: 40px;">
                <div class="row">
                    <div class="col-lg-12" style="padding-bottom: 35px;">
                        <div class="col-lg-12">
                            <h4>Information about the project</h4>
                        </div>
                             <div class="col-lg-12" style="padding-top: 15px;">
                                     <p>Documentation: <a href="#" ng-click="$ctrl.toggleDoc()">{webapp}/documentation/swagger-ui.html</a></p>
                                     <p>Project source code: <a href="#" ng-click="$ctrl.toggleGit()">github.com</a></p>
                                     <p>Technologies used in the project:</p>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>`
});
