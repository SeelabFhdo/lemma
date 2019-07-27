package de.fhdo.lemma.typechecking

class TypesNotCompatibleException extends Exception {
    new(String targetTypeName, String sourceTypeName) {
        super('''Types «targetTypeName» and «sourceTypeName» are not compatible.''')
    }
}