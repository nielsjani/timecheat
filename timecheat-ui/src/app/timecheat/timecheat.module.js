import TimecheatOverviewModule from "timecheat/overview/timecheat.overview.module";
import timecheatRouteConfig from "timecheat/timecheat.route.config";

export default angular
    .module("app.timecheat", [
        TimecheatOverviewModule.name
    ])
    .config(timecheatRouteConfig);
