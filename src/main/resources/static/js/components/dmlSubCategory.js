'use strict';

app.component('dmlSubCategory', {
 bindings: {dmlSubCategory: '<'},
 template:
  `
 <h3>dmlSubCategory:  {{$ctrl.dmlSubCategory.data}} </h3>
 `
});
