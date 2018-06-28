
var app = angular.module("app", [ "ngRoute" ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'userCtrl'
	});
	$routeProvider.when('/restaurants', {
		templateUrl : 'restaurant.html',
		controller : 'restaurantCtrl'
	});
	$routeProvider.when('/items', {
		templateUrl : 'items.html',
		controller : 'itemsCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);

app.controller("restaurantCtrl", function($scope, $http) {

	$scope.fetchRestaurant = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8090/restaurant/getAll'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveRestaurant = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8090/restaurant/create',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.restaurant
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchRestaurant();
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("itemsCtrl", function($scope, $http) {

	$scope.fetchItems = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8090/restaurant/getAllItems'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.items = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveItem = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8090/restaurant/addItems',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.item
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchItems();
			$scope.items = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("userCtrl", function($scope, $http) {

	$scope.fetchUsers = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8090/user/all'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.users = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveUser = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8090/user/create',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.user
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchUsers();
			$scope.users = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});