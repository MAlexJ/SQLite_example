'use strict';

app.component('ddlSubCategory', {
 bindings: {ddlSubCategory: '<'},
 template:
 `
 <h3>ddlSubCategory:  {{$ctrl.ddlSubCategory.data}} </h3>
 `
});
