/**
 * 
 */

angular
    .module("benchmarks", ["ui.router"])
    .config(configure)

configure.$inject = ['$stateProvider', '$urlRouterProvider']

function configure($stateProvider, $urlRouterProvider){
    
    $stateProvider
    
    .state('home', {
        url: '/',
        controller: 'HomeController',
        controllerAs: 'HC',
        templateUrl: 'html/home.html;'
    })
    
    .state('search', {
        url: '/search',
        controller: 'SearchController',
        controllerAs: 'SC',
        templateUrl:'html/search.html'
    })
    
    .state('results', {
        url: '/results',
        conroller: 'ResultsController',
        controllerAs: 'RC',
        templateURL: 'html/results.html'
    })
    
}
