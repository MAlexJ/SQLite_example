'use strict';

app.component('console', {
    bindings: {console: '<'},
    controller: function (RestAPI, $scope) {
        $scope.runSql = function () {
            if ($scope.sqlQuery) {
                let query = {'query': $scope.sqlQuery};
                RestAPI.post('console', query)
                    .then(function (response) {
                        $scope.result = response.data;
                        $scope.sqlQuery = '';
                    });
            }
        }
    },
    template:
        `<div class="container">
    <div class="row justify-content-md-center" style="padding-top: 40px;">
        <div class="row"
             style="padding-top: 40px;  padding-left: 20px; padding-right: 20px; background: #eceeef; border-radius: 10px;">
            <div class="row">
                <div class="col-lg-12" style="padding-bottom: 20px;">
                    <div class="col-lg-3 align-self-start">
                        <div class="form-group">
                            <label for="sel"><h4>Select database: </h4></label>
                            <select class="form-control" id="sel">
                                <option>db_console.db</option>
                                <option>db_app.db</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <p>Description:<br>*db_console.db is default database for app</p>
                    </div>
                </div>
                <div class="col-lg-12" style="padding-bottom: 40px;">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-10 col-sm-6 col-6">
                                <h4>SQL Statement:</h4>
                            </div>
                            <div class="col-lg-1 col-sm-3 col-3" style="padding-left: 40px;">
                                <button type="button" class="btn btn-sm btn-outline-success" data-toggle="modal"
                                        data-target="#historyModal">History
                                </button>
                            </div>
                            <div class="col-lg-1 col-sm-3 col-3" style="padding-left: 30px;">
                                <button type="button" class="btn btn-sm btn-outline-success" data-toggle="modal"
                                        data-target="#helpModal">Help
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <textarea ng-model="sqlQuery" style="width: 100%" rows="5" id="comment"></textarea>
                    </div>
                    <div class="col-lg-12" style="padding-top: 15px;">
                        <p>Edit the SQL Statement, and click "Run SQL" to see the result.</p>
                    </div>
                    <div class="col-lg-12">
                        <button ng-click="runSql()" type="button" class="btn btn-success">Run SQL</button>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="col-lg-12">
                        <h4>Result:</h4>
                    </div>
                    <div class="col-lg-12">
                        <p>Click "Run SQL" to execute the SQL statement above.</p>
                        <p ng-show="result.error" class="bg-warning text-white">{{result.message}}</p>
                        <p>{{result}}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="historyModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">The history of SQL queries</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                Modal body..
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="helpModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">SQLite - Help Guide</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <h5 style="text-align: center">SQLite - Overview</h5>
                <br>
                <p>This chapter helps you understand what is SQLite, how it differs from SQL, why it is needed and the
                    way in which it handles the applications Database.</p>
                <p>QLite is a software library that implements a self-contained, server less, zero-configuration,
                    transactional SQL database engine.</p>
                <br>
                <p>
                    List the tables in your database:<br>
                    <b>SELECT name FROM sqlite_master WHERE type='table';</b>
                </p>
                <p>
                    Create a new table:<br>
                    <b>CREATE TABLE company( id INT PRIMARY KEY NOT NULL, name TEXT);</b>
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>`
});
