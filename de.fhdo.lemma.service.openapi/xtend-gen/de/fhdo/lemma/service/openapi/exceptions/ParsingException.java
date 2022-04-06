package de.fhdo.lemma.service.openapi.exceptions;

@SuppressWarnings("all")
public class ParsingException extends Exception {
  public ParsingException(final String string) {
    super(string);
  }
}
