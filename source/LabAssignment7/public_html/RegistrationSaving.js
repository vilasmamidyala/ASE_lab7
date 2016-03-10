

var registrationap = angular.module("register",[]);

registrationap.controller("RegistrationController", function($scope,$http, $httpParamSerializerJQLike){
    
$scope.SaveRegistration = function(first,last,email,phone,user,pass) {
   console.log("inside login function");
$http({
    method: 'POST',
    url : 'https://api.mongolab.com/api/1/databases/ase_spring/collections/assignment7/?apiKey=fLr-gBAV6_SS8Qtf-0-MEBlfR51d2nQr',
    data: JSON.stringify({
                FirstName: first,
                LastName: last,
                Emailid: email,
                Phone: phone,
                UserName: user,
                password: pass
            }),
    contentType: "application/json"
}).success(function() {
    $scope.first = "";
    $scope.last = "";
    $scope.email = "";
    $scope.phone = "";
    $scope.user = "";
    $scope.pass = "";
    
    $scope.msg ="Registration Successful";
        })
}
    
});