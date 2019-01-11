var exec = require('cordova/exec');

exports.exec = function(command, success, error) {
    exec(success, error, "SystemCommand", "execute", [command]);
};
