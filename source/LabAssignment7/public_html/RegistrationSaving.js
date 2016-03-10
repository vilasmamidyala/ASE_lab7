

var registrationap = angular.module("register",[]);

registrationap.controller("RegistrationController", function($scope,$http, $httpParamSerializerJQLike,$window){
    
$scope.SaveRegistration = function(first,last,email,phone,user,pass) {
   console.log("inside login function");
$http({
    method: 'POST',
    url : 'https://api.mongolab.com/api/1/databases/vilas_db/collections/studentinfo?apiKey=fzxmUdTtncu6dFiZy2tVlSBQt8-OsKg2',
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
    $window.location = 'index.html';
        })
}
    
});