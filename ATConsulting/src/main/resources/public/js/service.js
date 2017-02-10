'use strict';

myApp.factory('ClaimService', ['$http', '$q', '$document', function ($http, $q) {
        return {
            fetchAllClaim: function () {
                return $http.get('/ATConsulting/application/claim')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching claim');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            fetchAllPerson: function () {
                return $http.get('/ATConsulting/application/person')
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching person');
                                    return $q.reject(errResponse);
                                }
                        );
            }

        };
    }]);


