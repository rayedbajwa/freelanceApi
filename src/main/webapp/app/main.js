angular.module('hello', [])
    .controller('home', function($scope, $http) {
        $http.get('/api/users/get-all').then(function(res) {
            $scope.user = res.data;
        });
    })