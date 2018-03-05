'use strict';

app.component('ddl', {
    bindings: {ddl: '<'},
     template:
           `<div>
               <div class="container-fluid">
                   <div class="row">
                       <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
                           <ul class="nav nav-pills flex-column">
                                <li class="nav-item" ng-repeat="subCategory in  $ctrl.ddl.data track by $index">
                                   <a class="nav-link" ui-sref-active="active" ui-sref="subCategory({ id: subCategory.id })">
                                           {{subCategory.name}}
                                    </a>
                                </li>
                           </ul>
                       </nav>
                       <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                           <h1>Text</h1>
                           <section class="row text-center placeholders">
                               <ui-view>{{$ctrl.ddl.data}}</ui-view>
                           </section>
                       </main>
                   </div>
               </div>
           </div>`
});