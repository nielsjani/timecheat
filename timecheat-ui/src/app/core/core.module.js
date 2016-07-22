import initRouter from "core/core.router.run";
import UserService from "core/core.user.service";

export default angular
    .module("app.core", [
        "ngAnimate",
        "ui.bootstrap",
        "ui.router",
        "ngResource",
        "ngCookies",
        "fixed.table.header"
    ])
    .service("userService", UserService)
    .run(initRouter);
