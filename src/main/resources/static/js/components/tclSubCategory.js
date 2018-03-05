'use strict';

app.component('tclSubCategory', {
 bindings: {tclSubCategory: '<'},
 template:
 `
 <h3>tclSubCategory:  {{$ctrl.tclSubCategory.data}} </h3>
 `
});
