"use strict";

const path = require("path");
const fs = require("fs");
const os = require("os");
const crypto = require("crypto");
const fetch = require("node-fetch");
const yauzl = require("yauzl");
const tar = require("tar");

function createDir(dir) {
  return new Promise((resolve, reject) => {
    fs.access(dir, (err) => {
      if (err && err.code === "ENOENT") {
        fs.mkdir(dir, (err) => {
          if (err) reject(err);
          resolve();
        });
      } else if (!err) resolve();
      else reject(err);
    });
  });
}

function download(dir, url) {
  return new Promise((resolve, reject) => {
    createDir(dir)
      .then(() => fetch(url))
      .then((response) => {
        const destFile = path.join(dir, path.basename(url));
        const destStream = fs.createWriteStream(destFile);
        response.body.pipe(destStream).on("finish", () => resolve(destFile));
      })
      .catch((err) => reject(err));
  });
}

function downloadAll(dir, url) {
  return download(dir, url + ".sha256.txt").then(() => download(dir, url));
}

function genChecksum(file) {
  return new Promise((resolve, reject) => {
    fs.readFile(file, (err, data) => {
      if (err) reject(err);

      resolve(crypto.createHash("sha256").update(data).digest("hex"));
    });
  });
}

function verify(file) {
  return new Promise((resolve, reject) => {
    fs.readFile(file + ".sha256.txt", "utf-8", (err, data) => {
      if (err) reject(err);

      genChecksum(file).then((checksum) => {
        checksum === data.split("  ")[0]
          ? resolve(file)
          : reject(new Error("File and checksum don't match"));
      });
    });
  });
}

function move(file) {
  return new Promise((resolve, reject) => {
    const newFile = path.join(
      path.dirname(require.main.filename),
      file.split(path.sep).slice(-1)[0],
    );

    fs.copyFile(file, newFile, (err) => {
      if (err) reject(err);

      fs.unlink(file, (err) => {
        if (err) reject(err);
        resolve(newFile);
      });
    });
  });
}

function extractZip(file, dir) {
  return new Promise((resolve, reject) => {
    yauzl.open(file, { lazyEntries: true }, (err, zipFile) => {
      if (err) reject(err);

      zipFile.readEntry();
      zipFile.on("entry", (entry) => {
        const entryPath = path.join(dir, entry.fileName);

        if (/\/$/.test(entry.fileName)) {
          fs.mkdir(entryPath, { recursive: true }, (err) => {
            if (err && err.code !== "EEXIST") reject(err);

            zipFile.readEntry();
          });
        } else {
          zipFile.openReadStream(entry, (err, readStream) => {
            if (err) reject(err);

            readStream.on("end", () => {
              zipFile.readEntry();
            });
            readStream.pipe(fs.createWriteStream(entryPath));
          });
        }
      });
      zipFile.once("close", () => {
        fs.unlink(file, (err) => {
          if (err) reject(err);
          resolve(dir);
        });
      });
    });
  });
}

function extractTarGz(file, dir) {
  return tar.x({ file: file, cwd: dir }).then(() => {
    return new Promise((resolve, reject) => {
      fs.unlink(file, (err) => {
        if (err) reject(err);
        resolve(dir);
      });
    });
  });
}

function extract(file) {
  const dir = path.join(path.dirname(file), "jre");

  return createDir(dir).then(() => {
    return path.extname(file) === ".zip"
      ? extractZip(file, dir)
      : extractTarGz(file, dir);
  });
}

/**
 * The API will decide if it needs to redirect from api.adoptopenjdk.net to
 * api.adoptium.net before finally redirecting to the binary. This function
 * handles the initial redirection if needed, otherwise it just returns the
 * location url for the binary.
 **/
function followToAdoptium(location) {
  if (/api.adoptium.net/g.test(location)) {
    return fetch(location, { redirect: "manual" }).then((response) =>
      response.headers.get("Location"),
    );
  } else return location;
}

/**
 * Installs a JRE copy for the app
 * @param {number} [version = 8] - Java Version (`8`/`9`/`10`/`11`/`12`)
 * @param {object} [options] - Installation Options
 * @param {string} [options.os] - Operating System (defaults to current) (`windows`/`mac`/`linux`/`solaris`/`aix`)
 * @param {string} [options.arch] - Architecture (defaults to current) (`x64`/`x32`/`ppc64`/`s390x`/`ppc64le`/`aarch64`/`sparcv9`)
 * @param {string} [options.openjdk_impl = hotspot] - OpenJDK Implementation (`hotspot`/`openj9`)
 * @param {string} [options.release = latest] - Release
 * @param {string} [options.type = jre] - Binary Type (`jre`/`jdk`)
 * @param {string} [options.heap_size] - Heap Size (`normal`/`large`)
 * @param {string} [options.vendor] - defaults to adoptopenjdk (`adoptopenjdk`/`eclipse`)
 * @return Promise<string> - Resolves to the installation directory or rejects an error
 * @example
 * const njre = require('njre')
 *
 * // Use default options
 * njre.install()
 *   .then(dir => {
 *     // Do stuff
 *   })
 *   .catch(err => {
 *     // Handle the error
 *   })
 *
 * // or custom ones
 * njre.install(11, { os: 'aix', arch: 'ppc64', openjdk_impl: 'openj9' })
 *   .then(dir => {
 *     // Do stuff
 *   })
 *   .catch(err => {
 *     // Handle the error
 *   })
 */
function install(version = 8, options = {}) {
  const {
    openjdk_impl = "hotspot",
    release = "latest",
    type = "jre",
    heap_size = "normal",
    vendor = "adoptopenjdk",
  } = options;

  options = { ...options, openjdk_impl, release, type, heap_size, vendor };

  let endpoint = null;
  if (options.vendor === "adoptopenjdk") endpoint = "api.adoptopenjdk.net";
  else if (options.vendor === "eclipse") endpoint = "api.adoptium.net";
  else
    return Promise.reject(
      new Error("Unsupported vendor. Use adoptopenjdk (default) or eclipse"),
    );

  const versionPath =
    options.release === "latest"
      ? "latest/" + version + "/ga"
      : "version/" + options.release;

  if (!options.os) {
    switch (process.platform) {
      case "aix":
        options.os = "aix";
        break;
      case "darwin":
        options.os = "mac";
        break;
      case "linux":
        options.os = "linux";
        break;
      case "sunos":
        options.os = "solaris";
        break;
      case "win32":
        options.os = "windows";
        break;
      default:
        return Promise.reject(new Error("Unsupported operating system"));
    }
  }
  if (!options.arch) {
    if (/^ppc64|s390x|x32|x64$/g.test(process.arch))
      options.arch = process.arch;
    else if (process.arch === "ia32") options.arch = "x32";
    else return Promise.reject(new Error("Unsupported architecture"));
  }

  const url =
    "https://" +
    endpoint +
    "/v3/binary/" +
    versionPath +
    "/" +
    options.os +
    "/" +
    options.arch +
    "/" +
    options.type +
    "/" +
    options.openjdk_impl +
    "/" +
    options.heap_size +
    "/" +
    options.vendor;

  const tmpdir = path.join(os.tmpdir(), "njre");

  return fetch(url, { redirect: "manual" })
    .then((response) => response.headers.get("Location"))
    .then((location) => followToAdoptium(location))
    .then((location) => downloadAll(tmpdir, location))
    .then(verify)
    .then(move)
    .then(extract);
}

module.exports = install;
