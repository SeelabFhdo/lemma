# command-exists-promise
![npm](https://img.shields.io/npm/v/command-exists-promise.svg) ![Travis (.com)](https://img.shields.io/travis/com/raftario/command-exists.svg?label=travis+build) ![AppVeyor](https://img.shields.io/appveyor/ci/raftario/command-exists.svg?label=appveyor+build)  
Node module to check if a command-line command exists.
Forked from [command-exists](https://github.com/mathisonian/command-exists).
## Installation
```console
# For npm users
$ npm i command-exists-promise

# For yarn users
$ yarn add command-exists-promise
```
## Usage
The function returns a promise that will resolve to `true` if the command exists and `false` if it doesn't.  
On UNIX, the promise will resolve to `true` if the command is a path to an executable file. On Windows, it will resolve to `true` for any existing file.
### Promise
```js
const commandExists = require('command-exists-promise')

commandExists('ls')
  .then(exists => {
    if (exists) {
      // The command exists
    } else {
      // The command doesn't exist
    }
  })
  .catch(err => {
    // Should never happen but better handle it just in case
  })
```
### Await
```js
const commandExists = require('command-exists-promise')

try {
  const exists = await commandExists('ls')
  if (exists) {
    // The command exists
  } else {
    // The command doesn't exist
  }
} catch (err) {
  // Should never happen but better handle it just in case
}
```
