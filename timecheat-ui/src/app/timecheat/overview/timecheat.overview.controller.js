/* eslint no-unused-expressions:0 */

export default class TimecheatOverviewController {

    constructor(userService) {
        "ngInject";
        this.userService = userService;
    }

    logIn() {
        this.userService.user = {username: this.username, password: this.password};
    }
}
