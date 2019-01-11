# System Commands Plugin for Apache Cordova

Cordova Plugin for calling system commands.


## Install

### Locally

```
cordova plugin add https://github.com/kelvionald/cordova-plugin-systemcommand.git
```

## Usage

### exec

```js
systemcommand.exec(command, successCallback, errorCallback);
```

- => `successCallback` is called in case successful call
- => `errorCallback` is called if something went wrong

### Example
```js
systemcommand.exec('whoami', x => console.log(x), x => console.log(x));
```

## Platform Support

Android only.
