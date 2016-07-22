export default $stateProvider => {
    "ngInject";
    $stateProvider.state("timecheat", {
        abstract: true,
        url: "/timecheat",
        template: "<ui-view/>"
    });
};
