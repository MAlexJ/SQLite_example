'use strict';

app.component('subCategory', {
 bindings: {subCategory: '<'},
 template:  `
 <h3> {{$ctrl.subCategory.data}} </h3>
 `
});
