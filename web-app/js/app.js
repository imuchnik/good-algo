var app = angular.module("good", []);
app.controller('vsnSearchController', function($scope, $http){
    $scope.validationResult;

    $scope.validateAndSubmit =function(){
        $scope.validationResult=null;
        $scope.cars=[];

        var vsnValidation = /^[a-zA-Z]{6}[0-9]{6}$/;
        var validationResult=(vsnValidation.test($scope.searchString));

        if (validationResult){
           carLookup()
        }
        else
        $scope.validationResult="The string format is incorrect. Please enter 6 letters followed by 6 numbers";
      }

    function carLookup(){
        $http({method:"GET", url:"/TheGoodProject/search/"+$scope.searchString})
            .success(function(data){
                $scope.cars=data;
            });
    }
});