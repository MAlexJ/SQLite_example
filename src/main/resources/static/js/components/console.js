'use strict';

app.component('console', {
    bindings: {console: '<'},
    controller: function (RestAPI, $scope) {
    this.toggle = function () {
            if($scope.sqlQuery)
            {
                let query = {'query': $scope.sqlQuery};
                RestAPI.post('console', query)
                   .then(function(response) {
                        let data = response.data;
                        $scope.result = data
                        $scope.sqlQuery = ''
                });
            }
        }
    },
    template:
        `<div class="container">
    <div class="row justify-content-md-center" style="padding-top: 40px;">
        <div class="row" style="padding-top: 40px;  padding-left: 20px; padding-right: 20px; background: #eceeef; border-radius: 10px;">
            <div class="row">
                <div class="col-lg-12" style="padding-bottom: 35px;">
                    <div class="col-lg-12">
                        <h4>SQL Statement:</h4>
                    </div>
                    <div class="col-lg-12">
                        <textarea ng-model="sqlQuery" style="width: 100%" rows="5" id="comment"></textarea>
                    </div>
                    <div class="col-lg-12" style="padding-top: 15px;">
                        <p>Edit the SQL Statement, and click "Run SQL" to see the result.</p>
                    </div>
                    <div class="col-lg-12">
                        <button ng-click="$ctrl.toggle()" type="button" class="btn btn-success">Run SQL</button>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="col-lg-12">
                        <h4>Result:</h4>
                    </div>
                    <div class="col-lg-12">
                        <p>Click "Run SQL" to execute the SQL statement above.</p>
                        <p>{{result}}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
`
});
