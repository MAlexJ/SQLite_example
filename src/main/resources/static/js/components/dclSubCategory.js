'use strict';

app.component('dclSubCategory', {
    bindings: {dclSubCategory: '<'},
    template:
        `<div ng-bind-html="$ctrl.dclSubCategory.data.html"></div>`
});
