package de.fhdo.lemma.service.openapi.exceptions;

@SuppressWarnings("all")
public class MatchingException extends Exception {
  public MatchingException(final String string) {
    super(string);
  }
}
