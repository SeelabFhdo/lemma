'use strict';

import * as net from 'net';
import * as vscode from 'vscode';

import { workspace, ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, StreamInfo } from 'vscode-languageclient/node';

const { JavaCaller } = require("java-caller");

let client: LanguageClient;
let host: string;
let port: number;

export function init() {
    host = vscode.workspace.getConfiguration('lemma-technology-mapping').get("technologyMapping.languageServerHost");
    port = vscode.workspace.getConfiguration('lemma-technology-mapping').get("technologyMapping.languageServerPort");
    if(host === null || host === undefined) {
        host = "localhost";
    }
    if(port === null || port === undefined) {
        port = 5011;
    }
}

export async function startLanguageServer() {
    //Starting the language server Fat JAR
    const java = new JavaCaller({
        classPath: __dirname + '/../src/de.fhdo.lemma.technology.mappingdsl.ide-0.8.6-SNAPSHOT-ls.jar',
        useAbsoluteClassPaths: true,
        mainClass: 'de.fhdo.lemma.technology.mappingdsl.ide.ServerLauncher'
    });
    const { status, stdout, stderr } = await java.run([host, port.toString()]);
    return {status, stdout, stderr} ;
}

export async function activate(context: ExtensionContext) {
    //Init the language server options and start the language server
    init();
    startLanguageServer();

    //Wait two seconds so the language server has enough time to start
    await new Promise((res) => setTimeout(res, 2000));
    
    let connectionInfo = {
        port: port
    };
    let serverOptions = () => {
        // Connect to language server via socket
        let socket = net.connect(connectionInfo);
        let result: StreamInfo = {
            writer: socket,
            reader: socket
        };
        return Promise.resolve(result);
    };
    
    let clientOptions: LanguageClientOptions = {
        documentSelector: [{ scheme: 'file', language: 'mapping'}],
        synchronize: {
            fileEvents: workspace.createFileSystemWatcher('**/*.mapping')
        }
    };
    
    // Create the language client and start the client.
    client = new LanguageClient('LEMMA Technology Mapping Modeling Language Server', serverOptions, clientOptions);

    client.start();
}
export function deactivate(): Thenable<void> | undefined {
    if (!client) {
	return undefined;
    }
    return client.stop();
}
