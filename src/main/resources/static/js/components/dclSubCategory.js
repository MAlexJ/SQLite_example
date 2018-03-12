'use strict';

app.component('dclSubCategory', {
    bindings: {dclSubCategory: '<'},
    template:
        ` <h3>dclSubCategory:  {{$ctrl.dclSubCategory.data}} </h3>`
});
