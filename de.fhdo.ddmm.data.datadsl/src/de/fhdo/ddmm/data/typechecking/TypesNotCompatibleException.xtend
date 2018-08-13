package de.fhdo.ddmm.data.typechecking

class TypesNotCompatibleException extends Exception {
	new(String targetTypeName, String sourceTypeName) {
		super('''Types «targetTypeName» and «sourceTypeName» are not compatible.''')		
	}
}