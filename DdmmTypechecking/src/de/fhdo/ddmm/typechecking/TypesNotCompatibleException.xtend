package de.fhdo.ddmm.typechecking

class TypesNotCompatibleException extends Exception {
    new(String targetTypeName, String sourceTypeName) {
        super('''Types «targetTypeName» and «sourceTypeName» are not compatible.''')
    }
}