import CoreModule from "core/core.module";
import WidgetsModule from "widgets/widgets.module";
import TimecheatOverviewComponent from "timecheat/overview/timecheat.overview.component";
import timecheatOverviewRouteConfig from "timecheat/overview/timecheat.overview.route.config";

export default angular
    .module("app.timecheat.overview", [CoreModule.name, WidgetsModule.name])
    .component("timecheatOverview", TimecheatOverviewComponent)
    .config(timecheatOverviewRouteConfig);
