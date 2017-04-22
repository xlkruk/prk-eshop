var cartApp = angular.module ("cartApp", []);



cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/Shop/api/cart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/Shop/api/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    
    
    $scope.addToCart = function (productId) {
        $http.put('/Shop/api/cart/add/'+productId).success(function () {
           
            alert("Produkt pomyślnie dodany do koszyka!")
        });
    };


    $scope.removeFromCart = function (productId) {
        $http.delete('/Shop/api/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart();
        });
    };
    
    $scope.calculateGrandTotal = function(){
    	var grandTotal =0 ;
    		for ( var i=0;i<$scope.cart.cartItems.length;i++){
    			grandTotal += $scope.cart.cartItems[i].totalPrice;
    		}
    		return grandTotal;
    };
});