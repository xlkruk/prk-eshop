var cartApp = angular.module ("cartApp", []);



cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function (cartId) {
        $http.get('/Shop/api/cart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/Shop/api/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    
    
    $scope.addToCart = function (productId) {
        $http.put('/Shop/api/cart/add/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/Shop/api/cart/cartId'));
            alert("Produkt pomyślnie dodany do koszyka!")
        });
    };


    $scope.removeFromCart = function (productId) {
        $http.delete('/Shop/api/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart($http.get('/Shop/api/cart/cartId'));
        });
    };
});