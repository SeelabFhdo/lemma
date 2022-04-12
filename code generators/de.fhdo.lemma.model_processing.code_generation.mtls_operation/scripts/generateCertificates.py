import os
import sys
import traceback
import subprocess
import logging
from dataclasses import dataclass
from enum import Enum
from shutil import which
from typing import List

target_path = os.path.expanduser("~/masterthesis/lemmasecuritymodelgencode")


class ConfigurationException(Exception):
    pass


class Profiletype(Enum):
    MTLS = "mtls"
    MTLSDEV = "mtlsdev"


# todo check path for windows
def get_absolute_path(path: str) -> str:
    if path.startswith("~"):
        return os.path.expanduser(path)
    return path


def get_sys_env_var(variable: str) -> str:
    print("xxx: " + variable)
    if variable.find("${") > -1:
        var = variable[variable.find("${") + 2:variable.find("}")]
        print("yyy:" + var)
        env = os.getenv(var)
        if env:
            return str(env) + variable[variable.find("}") + 1:]
        else:
            throw_configuration_exception("The system environment variable \"{var}\" is not defined!".format(var=var))
    return variable


@dataclass
class CertificateConfigFile:
    """Class for keeping the certification parameter"""
    rootDir: str
    filename: str
    configParameter: List[tuple]

    def is_ca_config_file(self) -> bool:
        return "CertificationAuthority" in self.filename

    def get_profile(self) -> Profiletype:
        if Profiletype.MTLSDEV.value in self.filename:
            return Profiletype.MTLSDEV
        return Profiletype.MTLS

    def get_config_parameter(self, parameter: str) -> str:
        for tuple in self.configParameter:
            if tuple[0] == parameter:
                return tuple[1]
        return ""


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
                    CertificateConfigFile(rootdir, file, __load_config_files(os.path.join(rootdir, file))))

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
        raise ConfigurationException(
            "No configuration found for the certificate authority in profile {profile_type}!".format(
                profile_type=profile_type.value))
    return Profile(profile_type, ca_config, client_configs)


def __load_config_files(path) -> list:
    retval = list()
    with open(path, 'r', encoding='utf-8') as infile:
        for line in infile:
            retval.append(__split_config_param(line))
    infile.close()
    return retval


def __split_config_param(param: str) -> tuple:
    retval = param.replace("\n", "").split("=", 1)
    if retval[1].find("${") > -1:
        run_cli_command("export {var}=geheim; ".format(var=retval[1][retval[1].find("${") + 2:retval[1].find("}")]))
    return tuple(retval)


def throw_configuration_exception(message: str):
    logging.error(message)
    raise ConfigurationException(message)


# -----------------------------------------------------------------------------------------
# OpenSSL functions
def check_openssl_is_installed():
    if which("openssl") is None:
        throw_configuration_exception("This script requires an installation of openssl!")


def __check_password(password: str):
    password = get_sys_env_var(password)
    if password == "":
        throw_configuration_exception("The system variable is not set or the password is empty!")
    return password


def generate_rsa_privat_key(path: str, filename: str, password: str, cipher: str = "aes256", bitlength: int = 4096):
    """Generating a private key for the application or certificate authority!"""
    password = __check_password(password)

    if not os.path.exists(os.path.join(path, filename)):
        throw_configuration_exception("Directory or file not found! {file}".format(
            file=os.path.join(path, filename)))
    run_cli_command(
        "openssl genrsa -{cipher} -passout pass:\"{password}\" -out \"{path}/{filename}_key.pem\" {bitrate}".format(
            cipher=cipher, password=password, path=path, filename=filename.replace(".var", ""), bitrate=bitlength))


def generate_public_key(path: str, filename: str, password: str, subject: str, cert_type: str = "x509",
                        expiration_time_days: int = 365):
    """Generating a public key for the certificate authority"""
    password = __check_password(password)
    if subject == "":
        raise ConfigurationException("No subject was specified!")

    run_cli_command(
        "openssl req -new -passin pass:{password} -key {path}/{filename}_key.pem -{cert_type}" +
        " -days {expiration_time_days} -out {path}/{filename}_ca_cert.pem -subj \"/CN={subject}\"".format(
            password=password, path=path, filename=filename.replace(".var", ""), cert_type=cert_type,
            expiration_time_days=expiration_time_days, subject=subject))


def create_certificate_authority(config_file: CertificateConfigFile):
    """Generate a Certificat Authority by given CertificateConfigFile"""
    path = get_sys_env_var(config_file.rootDir)
    filename = get_sys_env_var(config_file.filename)
    password = get_sys_env_var(config_file.get_config_parameter("server.ssl.server.ca-password"))
    cipher = get_sys_env_var(config_file.get_config_parameter("server.ssl.cipher"))
    bitrate = int(get_sys_env_var(config_file.get_config_parameter("server.ssl.bitLength")))
    subject = get_sys_env_var(config_file.get_config_parameter("server.ssl.subject"))
    cert_type = get_sys_env_var(config_file.get_config_parameter("server.ssl.certificateStandard"))
    expiration_time_days = get_sys_env_var(config_file.get_config_parameter("server.ssl.key-store.validityInDays"))

    # run commands for generating ca key file and cert file
    generate_rsa_privat_key(path, filename, password, cipher, bitrate)
    generate_public_key(path, filename, password, subject, cert_type, expiration_time_days)


def create_client_keystore(profile: Profile):
    """Generate for each client a java keystore by given spring boot config profile"""

    for client_config in profile.client_configs:
        path = get_sys_env_var(client_config.rootDir)
        filename = get_sys_env_var(client_config.filename)
        bitLength = get_sys_env_var(client_config.get_config_parameter("server.ssl.bitLength"))
        cipher = get_sys_env_var(client_config.get_config_parameter("server.ssl.cipher"))
        # key_store = get_sys_env_var(client_config.get_config_parameter("server.ssl.key-store"))
        key_store_password = get_sys_env_var(client_config.get_config_parameter("server.ssl.key-store-password"))

        # Generating a private key for the application
        generate_rsa_privat_key(path, filename, key_store_password, cipher=cipher, bitlength=bitLength)

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
    """Generate client java truststore by given CertificateConfigFile"""
    command1 = "keytool -import -file $KEYPATH/ca/ca_cert.pem -alias ca -noprompt -keystore $appfolder/truststore_$1.p12 -storepass $PASS"


def run_cli_command(command: str) -> bool:
    if command == "" or command is None:
        throw_configuration_exception("Command can't be empty!")
    print(command)
    proc = subprocess.Popen(command, stderr=subprocess.PIPE, stdout=subprocess.PIPE, shell=True)
    logging.info(command)
    for line in proc.stderr:
        logging.error(line)
    for line in proc.stdout:
        logging.info(line)
    return proc.returncode if True else False


# -----------------------------------------------------------------------------------------


def generate_cetificates():
    for profile in profiles:
        print("Profile: {profile}".format(profile=profile.type.value))
        print("CA:")
        create_certificate_authority(profile.ca_config)
        create_client_keystore(profile)
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


def main():
    print(target_path)
    logging.info('Started')
    check_openssl_is_installed()
    read_config_files(target_path)
    generate_cetificates()
    logging.info('Finished')


if __name__ == '__main__':
    logging.basicConfig(filename=os.path.join(target_path, "generateCertificates.log"), level=logging.INFO,
                        format='%(asctime)s %(message)s')
    try:
        main()
    except SystemExit as err:
        pass
    except ConfigurationException as err:  # catch *all* exceptions
        print("Es ist ein Fehler aufgetreten: {0}\n{1}\n{2}".format(__file__, err, traceback.format_exc()))
        sys.exit(1)
