'use strict';

app.component('tclSubCategory', {
 bindings: {tclSubCategory: '<'},
 template:
 `<div ng-bind-html="$ctrl.tclSubCategory.data.htmlSubCategory"></div>`
});
