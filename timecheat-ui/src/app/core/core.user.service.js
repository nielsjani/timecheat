export default class UserService {
    constructor() {
        "ngInject";
        this.user = {};
    }

    isLoggedIn() {
        return this.user.username !== undefined;
    }
}