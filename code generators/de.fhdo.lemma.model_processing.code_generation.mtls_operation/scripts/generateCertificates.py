import os
from subprocess import run
from logging import info, error, basicConfig, INFO
import sys
import traceback
from dataclasses import dataclass
from enum import Enum
from shutil import which
from typing import List


class ConfigurationException(Exception):
    pass


class ProfileType(Enum):
    MTLS = "mtls"
    MTLSDEV = "mtlsdev"


def check_empty_sys_env_var(variable: str) -> str:
    if variable.find("${") > -1:
        var = variable[variable.find("${") + 2:variable.find("}")]
        if not os.getenv(var):
            throw_configuration_exception("The system environment variable \"{var}\" is not defined!".format(var=var))
    return variable


def is_path_and_filename(path: str) -> bool:
    if path:
        return path != path.replace(os.path.dirname(path), "")
    else:
        print("Hallo")


def create_path_if_not_exists(path):
    path = os.path.dirname(path)
    if not os.path.exists(path):
        info(f"Create Path: {path}")
        print(f"Create Path: {path}")
        run_cli_command(f"mkdir -p {path}")


@dataclass
class CertificateConfigFile:
    """Class for keeping the certification parameter"""
    target_path: str
    absolute_path: str
    filename: str
    configParameter: List[tuple]

    def is_ca_config_file(self) -> bool:
        return "CertificationAuthority" in self.filename

    def get_profile(self) -> ProfileType:
        if ProfileType.MTLSDEV.value in self.filename:
            return ProfileType.MTLSDEV
        return ProfileType.MTLS

    def get_config_parameter(self, parameter: str, mandatory: bool = False) -> str:
        """Returns the value to a parameter. If the value is empty or not present,
        an exception is thrown. It can be controlled via the parameter mandatory
        whether an empty value is ok or not."""
        for config_parameter in self.configParameter:
            if config_parameter[0] == parameter:
                if mandatory and not config_parameter[1]:
                    throw_configuration_exception(f"The configuration parameter {parameter} must not be empty!")
                return config_parameter[1]

    def __post_init__(self):
        self.absolute_path = os.path.join(self.absolute_path, self.get_profile().name)
        if not self.is_ca_config_file():
            app_name = self.get_config_parameter("server.ssl.applicationName")
            self.private_key_filename = f"{app_name}_private_key.pem"
            self.certificate_filename = f"{app_name}_cert.pem"
            self.certificate_signing_request_filename = f"csr-for-{app_name}"
            self.key_store_filename = self.__get_filename_with_extension("server.ssl.key-store")
            self.trust_store_filename = self.__get_filename_with_extension("server.ssl.trust-store")
        else:
            self.ca_key_filename = self.__get_filename_with_extension("server.ssl.ca-key.file")
            self.ca_cert_filename = self.__get_filename_with_extension("server.ssl.ca-Cert.file")

    def __get_path_or_default_path(self, file: str):
        if is_path_and_filename(file):
            return os.path.join(self.target_path, file)
        else:
            return os.path.join(self.absolute_path, file)

    def __get_filename_with_extension(self, config_param: str) -> str:
        config_value = self.__get_path_or_default_path(self.get_config_parameter(config_param))
        create_path_if_not_exists(config_value)
        if config_param.find("store") > -1:
            return config_value if any(x in config_value for x in [".pfx", ".p12"]) else f"{config_value}.p12"
        else:
            return config_value if any(x in config_value for x in [".pem", ".crt"]) else f"{config_value}.pem"


@dataclass
class Profile:
    type: ProfileType
    ca_config: CertificateConfigFile
    client_configs: List[CertificateConfigFile]


profiles: List[Profile] = list()


def read_config_files(target_path: str, profile_types: list):
    config_files: List[CertificateConfigFile] = list()
    for absolute_path, _, files in os.walk(target_path):
        for file in files:
            for profile_type in profile_types:
                if file.endswith(f"{profile_type.value}.var"):
                    config_files.append(
                        CertificateConfigFile(target_path, absolute_path, file,
                                              __load_config_files(__check_file_path(absolute_path, file))))

    for profile_type in profile_types:
        profiles.append(create_profile(config_files, profile_type))


def create_profile(config_files: List[CertificateConfigFile], profile_type: ProfileType) -> Profile:
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
    info(f"Read config file: {path}")
    with open(path, 'r', encoding='utf-8') as infile:
        for line in infile:
            retval.append(__split_config_param(line))
    infile.close()
    return retval


def __split_config_param(param: str) -> tuple:
    return tuple(param.replace("\n", "").split("=", 1))


def __check_file_path(path: str, filename: str = "") -> str:
    """Checks if file path and file exist and returns the file path in the format of the operating system
    otherwise throws on throw_configuration_exception"""
    if path.startswith("~"):
        path = os.path.expanduser(path)
    filepath = os.path.join(path, filename)
    if not os.path.exists(filepath):
        throw_configuration_exception("Directory or file not found! {file}".format(file=filepath))
    return filepath


def throw_configuration_exception(message: str):
    error(message)
    raise ConfigurationException(message)


# -----------------------------------------------------------------------------------------
# OpenSSL functions
def check_openssl_is_installed():
    __is_installed("openssl")


def check_keytool_is_installed():
    __is_installed("keytool")


def __is_installed(command: str):
    if which(command) is None:
        throw_configuration_exception(
            f"The command '{command}' was not found! This command is required to create the certificates!")
    else:
        info(f"The command '{command}' was found!")


def __check_password(password: str) -> str:
    password = check_empty_sys_env_var(password)
    if password == "":
        throw_configuration_exception("The system variable is not set or the password is empty!")
    return password


def create_certificate_authority(config_file: CertificateConfigFile):
    """Generate a certificate authority by given CertificateConfigFile"""
    absolute_path = check_empty_sys_env_var(config_file.absolute_path)
    ca_key_filename = os.path.join(absolute_path, config_file.ca_key_filename)
    ca_cert_filename = os.path.join(absolute_path, config_file.ca_cert_filename)
    ca_password = check_empty_sys_env_var(
        config_file.get_config_parameter("server.ssl.server.ca-password", mandatory=True))
    cipher = check_empty_sys_env_var(config_file.get_config_parameter("server.ssl.cipher", mandatory=True))
    bit_length = check_empty_sys_env_var(config_file.get_config_parameter("server.ssl.bitLength", mandatory=True))
    subject = check_empty_sys_env_var(config_file.get_config_parameter("server.ssl.subject", mandatory=True))
    cert_type = check_empty_sys_env_var(
        config_file.get_config_parameter("server.ssl.certificateStandard", mandatory=True))
    expiration_time_days = check_empty_sys_env_var(
        config_file.get_config_parameter("server.ssl.key-store.validityInDays"))

    # Create profile directory
    run_cli_command(f"mkdir -p {absolute_path}")

    # Generating a private key for the certificate authority
    run_cli_command(
        f"openssl genrsa -{cipher} -passout pass:\"{ca_password}\" -out \"{ca_key_filename}\" {bit_length}")

    # Generating a certificat for the certificate authority
    run_cli_command(
        f"openssl req -new -passin pass:\"{ca_password}\" -key \"{ca_key_filename}\" -{cert_type} "
        f"-days {expiration_time_days} -out {ca_cert_filename} -subj \"/CN={subject}\"")


def create_client_keystore(profile: Profile):
    """Generate for each client a java keystore by given spring boot config profile"""
    create_certificate_authority(profile.ca_config)

    ca_absolute_path = check_empty_sys_env_var(profile.ca_config.absolute_path)
    cipher = check_empty_sys_env_var(profile.ca_config.get_config_parameter("server.ssl.cipher"))
    ca_key_file = os.path.join(ca_absolute_path, profile.ca_config.ca_key_filename)
    ca_cert_file = os.path.join(ca_absolute_path, profile.ca_config.ca_cert_filename)
    ca_name = profile.ca_config.get_config_parameter("server.ssl.ca-name", mandatory=True)
    ca_password = profile.ca_config.get_config_parameter("server.ssl.server.ca-password", mandatory=True)

    for client_config in profile.client_configs:
        absolute_path = check_empty_sys_env_var(client_config.absolute_path)
        csr_file = os.path.join(absolute_path, client_config.certificate_signing_request_filename)
        client_cert_file = os.path.join(absolute_path, client_config.certificate_filename)
        client_key_file = os.path.join(absolute_path, client_config.private_key_filename)
        client_keystore_file = client_config.key_store_filename
        client_truststore_file = client_config.trust_store_filename
        client_name = client_config.get_config_parameter("server.ssl.applicationName", mandatory=True)

        bit_length = check_empty_sys_env_var(client_config.get_config_parameter("server.ssl.bitLength"))
        expiration_time_days = check_empty_sys_env_var(
            client_config.get_config_parameter("server.ssl.key-store.validityInDays", mandatory=True))
        key_store_password = check_empty_sys_env_var(
            client_config.get_config_parameter("server.ssl.key-store-password", mandatory=True))
        trust_store_password = check_empty_sys_env_var(
            client_config.get_config_parameter("server.ssl.trust-store-password", mandatory=True))
        subject = check_empty_sys_env_var(client_config.get_config_parameter("server.ssl.subject", mandatory=True))

        # Create profile directory
        run_cli_command(f"mkdir -p {absolute_path}")

        # Generating a private key for the client
        run_cli_command(
            f"openssl genrsa -{cipher} -passout pass:\"{key_store_password}\" -out \"{client_key_file}\" {bit_length}")

        # Generating a certificate-signing request for the client
        run_cli_command(f"openssl req -passin pass:{key_store_password} -new -key {client_key_file} "
                        f"-out {csr_file} -subj \"/CN={subject}\"")

        # # Generating the client's CA signed certificate
        run_cli_command(
            f"openssl x509 -req -passin pass:{ca_password} -days {expiration_time_days} -in {csr_file} "
            f"-CA {ca_cert_file} -CAkey {ca_key_file} -set_serial 01 -out {client_cert_file}")

        # Creating a Java KeyStore with the clients’s public/private keys
        run_cli_command(
            f"openssl pkcs12 -export -passout pass:{key_store_password} -passin pass:{key_store_password} "
            f"-in {client_cert_file} -inkey {client_key_file} -out {client_keystore_file} -name {client_name}")

        # Remove truststore and creating a new Java TrustStore with the ca’s certificate
        run_cli_command(f"rm -rf {client_truststore_file}")
        run_cli_command(
            f"keytool -import -file {ca_cert_file} -alias {ca_name} -noprompt -keystore {client_truststore_file} "
            f"-storepass {trust_store_password}")


def run_cli_command(command: str):
    if command == "" or command is None:
        throw_configuration_exception("Command can't be empty!")
    proc = run(command, shell=True, capture_output=True)
    if proc.returncode != 0:
        if len(proc.stderr) > 0:
            info(proc.stderr.decode('utf-8'))
        throw_configuration_exception(f"Command has an error: {command}")
    else:
        if len(proc.stderr) > 0:
            info(proc.stderr.decode('utf-8'))


# -----------------------------------------------------------------------------------------


def generate_cetificates():
    for profile in profiles:
        info(f"Generate Certificates for profile: {profile.type.value} ")
        create_client_keystore(profile)


def main(argv: list):
    if len(argv) < 2:
        print(
            f"Missing command line argument: \n\t"
            f"First argument: generated target sources folder\n\t"
            f"Second optional argument: profile {ProfileType.MTLS.value} or {ProfileType.MTLSDEV.value}\n\t"
            f"Default are both profiles")
        sys.exit(1)
    target_path = __check_file_path(argv[1])
    basicConfig(filename=os.path.join(target_path, "generateCertificates.log"), level=INFO,
                format='%(asctime)s %(levelname)s %(message)s')
    info('Started')
    info(f"Generated target sources folder: {target_path}")
    profile_types: list
    if len(argv) > 2:
        if str(argv[2]).lower() in [ProfileType.MTLS.value, ProfileType.MTLSDEV.value]:
            profile_types = [ProfileType[str(argv[2]).upper()]]
        else:
            throw_configuration_exception(f"Invalid argument: {argv[2]}")
    else:
        profile_types = [ProfileType.MTLS, ProfileType.MTLSDEV]

    info(f"Process the profiles: {', '.join(profile.value for profile in profile_types)}")
    check_openssl_is_installed()
    check_keytool_is_installed()
    read_config_files(target_path, profile_types)
    generate_cetificates()
    info('Finished')


if __name__ == '__main__':
    # todo remove when development is complete
    sys.argv = ["name", "~/masterthesis/lemmasecuritymodelgencode"]

    try:
        main(sys.argv)
    except SystemExit as err:
        pass
    except ConfigurationException as err:  # catch *all* exceptions
        print("Es ist ein Fehler aufgetreten: {0}\n{1}\n{2}".format(__file__, err, traceback.format_exc()))
        sys.exit(1)
