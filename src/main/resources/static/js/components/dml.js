'use strict';

app.component('dml', {
    template:  `<h3>{{$ctrl.greeting}} galaxy!</h3> <button ng-click="$ctrl.toggle()">toggle greeting</button>`,

    controller: function() {
        this.greeting = 'hello';

        this.toggle = function() {
            this.greeting = (this.greeting === 'hello') ? 'whats up' : 'hello'
        }
    }
});