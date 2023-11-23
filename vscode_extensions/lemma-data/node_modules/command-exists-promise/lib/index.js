'use strict'

const exec = require('child_process').exec
const fs = require('fs')
const path = require('path')

const windows = process.platform === 'win32'

function fileExists (command) {
  return new Promise(res =>
    fs.access(command, err => res(!err))
  )
}

function executable (command) {
  return new Promise(res =>
    fs.access(command, fs.constants.X_OK, err => res(!err))
  )
}

function clean (input) {
  if (windows) {
    if (/[^A-Za-z0-9_\/:=-]/.test(input)) {
      input = '\'' + input.replace(/'/g, '\'\\\'\'') + '\''
      input = input
        .replace(/^(?:'')+/g, '')
        .replace(/\\'''/g, '\\\'')
    }

    return input
  } else {
    if (/[\\]/.test(input)) {
      const dirname = '"' + path.dirname(input) + '"'
      const basename = '"' + path.basename(input) + '"'
      return dirname + ':' + basename
    }

    return '"' + input + '"'
  }
}

function commandExistsUnix (command, cleanCommand) {
  return new Promise(res => {
    fileExists(command).then(exists => {
      if (!exists) {
        exec('command -v ' + cleanCommand +
          ' 2>/dev/null' +
          ' && { echo >&1 ' + cleanCommand + '; exit 0; }',
          (err, stdout) => res(!!stdout))
      } else executable(command).then(exists => res(exists))
    })
  })
}

function commandExistsWindows (command, cleanCommand) {
  return new Promise(res => {
    if (/[\x00-\x1f<>:"|?*]/.test(command)) res(false)
    exec('where ' + cleanCommand, err => {
      if (err) {
        fileExists(command).then(exists => res(exists))
      } else res(true)
    })
  })
}

function commandExists (command) {
  const cleanCommand = clean(command)

  return windows
    ? commandExistsWindows(command, cleanCommand)
    : commandExistsUnix(command, cleanCommand)
}

module.exports = commandExists
