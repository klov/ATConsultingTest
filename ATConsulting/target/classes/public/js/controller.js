'use strict';

myApp.controller('AppCtrl', ['ClaimService', function (Service) {
    var self = this;
    self.labels = [];
    self.series = [];
    self.charOption= {
        scales: {
            yAxes: [{
                ticks: {
                    min: 0,
                    stepSize: 0.5
                }
            }]
        }
    };
    self.data = [ ];
    self.selectP={};
    self.claims = [];
    self.category = {IE:"ИП",LE:"ЮР",NP:"ФЛ"};
    self.categoryKey = ["ИП","ЮР","ФЛ"];
    self.fetchAllClaim = function () {
        Service.fetchAllClaim()
                .then(
                        function (response) {
                            self.claims = response;
                        },
                        function (errResponse) {
                            console.error('Error while fetching Claim');
                        }
                );
    };
    
     self.fetchAllPerson = function () {
        Service.fetchAllPerson()
                .then(
                        function (response) {
                            self.persons = response;
                        },
                        function (errResponse) {
                            console.error('Error while fetching person');
                        }
                );
    };
    
     self.selsectCategory = function(){
         var data = [];
         var labels =[];
         var ser ={};
         self.series = self.selectP.name;
         for(var i=0;i <self.claims.length; i++){
             var claim = self.claims[i];
             if(self.category[self.claims[i].personID.categoryRecipients] == self.selectP ){
                 if(!ser[self.claims[i].date])
                 {
                     ser[self.claims[i].date] = 0;
                 }
                 ser[self.claims[i].date]++;
             }
         }
         
         for(var id in ser){
             data.push(ser[id]);
             labels.push(id);
         }
         self.data = data;
         self.labels = labels;
                
     };
    

    self.fetchAllClaim();
    self.fetchAllPerson();
}]);
       