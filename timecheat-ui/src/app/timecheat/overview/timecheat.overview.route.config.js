export default $stateProvider => {
    "ngInject";
    $stateProvider.state("timecheat.overview", {
        url: "/overview",
        template: "<timecheat-overview></timecheat-overview>"
    });
};
