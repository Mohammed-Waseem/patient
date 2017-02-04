var app = angular.module("myApp",[]);
app.filter('ageFilter', function() {
    function calculateAge(bday) { // birthday is a date
        var ageDifMs = Date.now() - bday.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    return function(bday) { 
          return calculateAge(bday);
    }; 
});
app.controller('myCntrl',function($scope){
	
	 $scope.clear = function(){
		 $scope.firstName =" ";
		 $scope.lastName ="";
		 $scope.bday ="";
		 $scope.age="";
		 $scope.gender="";
		 $scope.phone="";
		 $scope.textArea="";
	 }
	
});