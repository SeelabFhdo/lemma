package de.fhdo.lemma.service.openapi.exceptions

import java.lang.Exception

class ParsingException extends Exception {
	new(String string) {
        super(string)
    }
}