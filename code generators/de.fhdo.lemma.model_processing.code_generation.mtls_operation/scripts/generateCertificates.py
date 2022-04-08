import os
import sys
import subprocess
import logging
from dataclasses import dataclass
from enum import Enum
from shutil import which
from typing import List

target_path = "/home/dominik/masterthesis/lemmasecuritymodelgencode"


class Profiletype(Enum):
    MTLS = "mtls"
    MTLSDEV = "mtlsdev"


@dataclass
class CertificateConfigFile:
    """Class for keeping the certification parameter"""
    rootDir: str
    filename: str
    configParameter: List[tuple]

    def is_ca_config_file(self) -> bool:
        return "CertificationAuthority" in self.filename

    def get_profile(self) -> Profiletype:
        if "mtlsdev" in self.filename:
            return Profiletype.MTLSDEV
        return Profiletype.MTLS

    # def get_config_parameter(self, parameter: str) -> str:
    #     return self.configParameter[parameter] if self.configParameter[parameter] else ""


@dataclass
class Profile:
    type: Profiletype
    ca_config: CertificateConfigFile
    client_configs: List[CertificateConfigFile]


profiles: List[Profile] = list()


def read_config_files(target_path: str):
    config_files: List[CertificateConfigFile] = list()
    for rootdir, _, files in os.walk(target_path):
        for file in files:
            if ".var" in file:
                config_files.append(
                    CertificateConfigFile(rootdir, file, load_config_files(os.path.join(rootdir, file))))

    profiles.append(create_profile(config_files, Profiletype.MTLS))
    profiles.append(create_profile(config_files, Profiletype.MTLSDEV))


def create_profile(config_files: List[CertificateConfigFile], profile_type: Profiletype) -> Profile:
    ca_config: CertificateConfigFile
    client_configs: List[CertificateConfigFile] = list()
    for config_file in config_files:
        if config_file.get_profile() == profile_type:
            if config_file.is_ca_config_file():
                ca_config = config_file
            else:
                client_configs.append(config_file)
    if not ca_config:
        sys.exit("No configuration found for the certificate authority in profile {profile_type}!".format(
            profile_type=profile_type.value))
    return Profile(profile_type, ca_config, client_configs)


def load_config_files(path) -> list:
    retval = list()
    with open(path, 'r', encoding='utf-8') as infile:
        for line in infile:
            retval.append(split_config_param(line))
    infile.close()
    return retval


def split_config_param(param: str) -> tuple:
    return tuple(param.replace("\n", "").split("=", 1))


# -----------------------------------------------------------------------------------------
# OpenSSL functions
def check_openssl_is_installed():
    if which("openssl") is None:
        message = "This script requires an installation of openssl!"
        logging.error(message)
        sys.exit(message)


def create_certificate_authority(configFile: CertificateConfigFile):
    generate_rsa_privat_key()
    command1 = "openssl genrsa -aes256 -passout pass:$PASS -out $KEYPATH/ca/ca_key.pem 4096 "
    command2 = "openssl req -new -passin pass:$PASS -key $KEYPATH/ca/ca_key.pem -x509 -days 365 -out $KEYPATH/ca/ca_cert.pem -subj \"/CN=ca.$DOMAIN\""


def create_client_keystore(configFile: CertificateConfigFile):
    bitLength = configFile.configParameter['server.ssl.bitLength']
    bypass_hostname_verifier = configFile.configParameter['server.ssl.bypass.hostname-verifier']
    key_aliasSuffix = configFile.configParameter['server.ssl.key-aliasSuffix']
    key_store = configFile.configParameter['server.ssl.key-store']
    key_store_password = configFile.configParameter['server.ssl.key-store-password']
    trust_store = configFile.configParameter['server.ssl.trust-store']
    trust_store_password = configFile.configParameter['server.ssl.trust-store-password']
    path = configFile.rootDir
    filename = configFile.filename
    # Generating a private key for the application
    generate_rsa_privat_key(path, filename, key_store_password, bitrate=bitLength)
    # Generating a certificate-signing request for the application
    command2 = "openssl req -passin pass:$PASS -new -key $appfolder/$1_key.pem -out $appfolder/csr-for-$1 -subj \"/CN=$1.$DOMAIN\""
    # Generating the application’s CA signed certificate
    command3 = "openssl x509 -req -passin pass:$PASS -days 365 -in $appfolder/csr-for-$1 -CA $KEYPATH/ca/ca_cert.pem -CAkey $KEYPATH/ca/ca_key.pem -set_serial 01 -out $appfolder/$1_cert.pem"
    # Creating a Java KeyStore with the application’s public/private keys
    command4 = "openssl rsa -passin pass:$PASS -in $appfolder/$1_key.pem -out $appfolder/$1_key.pem "
    command5 = "cat $appfolder/$1_key.pem $appfolder/$1_cert.pem >> $appfolder/$1_keys.pem"
    command6 = "openssl pkcs12 -export -passout pass:$PASS -in $appfolder/$1_keys.pem -out $appfolder/keystore_$1.p12 -name $1"
    command7 = "keytool -importkeystore -srcstorepass $PASS -srckeystore $appfolder/keystore_$1.p12 -srcstoretype pkcs12 -deststorepass $PASS -destkeystore $appfolder/$1.jks -deststoretype JKS"


def create_client_truststore(configFile: CertificateConfigFile):
    command1 = "keytool -import -file $KEYPATH/ca/ca_cert.pem -alias ca -noprompt -keystore $appfolder/truststore_$1.p12 -storepass $PASS"


def generate_rsa_privat_key(path: str, filename: str, password: str, cipher: str = "aes256", bitrate: int = 4096):
    if password.startswith("${"):
        password_var = password.replace("${", "").replace("}", "")
        password = os.environ.get(password_var)
    if password == "":
        sys.exit("The system {systemvar} variable is not set or the password is empty!".format(systemvar=password_var))
    if os.path.exists(os.path.join(path, filename)):
        sys.exit("Directory or file not found! {file}".format(
            file=os.path.join(path, filename)))
    run_cli_command(
        "openssl genrsa -{cipher} -passout pass:\"{password}\" -out \"{path}/{filename}_key.pem\" {bitrate}".format(
            cipher=cipher, password=password, path=path, filename=filename, bitrate=bitrate))


def run_cli_command(command: str) -> bool:
    if command == "" or command is None:
        sys.exit("Command can't be empty!")
    proc = subprocess.Popen(command, stderr=subprocess.PIPE, stdout=subprocess.PIPE)
    for line in proc.stderr:
        logging.error(line)
    for line in proc.stdout:
        logging.info(line)
    return proc.stderr > 0 if True else False


# -----------------------------------------------------------------------------------------


def generate_cetificates():
    for profile in profiles:
        print("Profile: {profile}".format(profile=profile.type.value))
        print("CA:")
        for caparam in profile.ca_config.configParameter:
            print("CA Param: {key} = {value}".format(key=caparam[0], value=caparam[1]))
        for client_config in profile.client_configs:
            print("File: {filename}".format(filename=client_config.filename))
            for param in client_config.configParameter:
                print("Param: {key} = {value}".format(key=param[0], value=param[1]))

        # print("\n")
        # if file.is_ca_config:
        #     pass
        #     # create_certificate_authority(file)
        # else:
        #     pass
        #     # create_client_keystore(file)
        #     # create_client_truststore(file)


if __name__ == '__main__':
    logging.basicConfig(filename=os.path.join(target_path, "generateCertificates.log"), level=logging.INFO,
                        format='%(asctime)s %(message)s')
    logging.info('Started')
    check_openssl_is_installed()
    read_config_files(target_path)
    generate_cetificates()
    logging.info('Finished')
