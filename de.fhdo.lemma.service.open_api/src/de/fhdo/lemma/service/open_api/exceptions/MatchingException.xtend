package de.fhdo.lemma.service.open_api.exceptions

import java.lang.Exception

class MatchingException extends Exception {
    new(String string) {
        super(string)
    }
}