'use strict';

app.component('dmlSubCategory', {
 bindings: {dmlSubCategory: '<'},
 template:
  `<div ng-bind-html="$ctrl.dmlSubCategory.data.html"></div>`
});
