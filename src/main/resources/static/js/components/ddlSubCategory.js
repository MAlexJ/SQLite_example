'use strict';

app.component('ddlSubCategory', {
 bindings: {ddlSubCategory: '<'},
 template:
 `<div ng-bind-html="$ctrl.ddlSubCategory.data.html"></div>`
});
