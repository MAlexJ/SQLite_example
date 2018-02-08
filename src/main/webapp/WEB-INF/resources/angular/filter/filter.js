'use strict';

// search by name
myAdmin.filter('customSearchFilter', function () {
    return function (input, term) {
        var regex = new RegExp(term || '', 'i');
        var obj = {};
        angular.forEach(input, function (v, i) {
            if (regex.test(v.name + '')) {
                obj[i] = v;
            }
        });
        return obj;
    };
});

myAdmin.filter('trustAsResourceUrl', ['$sce', function ($sce) {
    return function (val) {
        return $sce.trustAsResourceUrl(val);
    };
}]);
