package de.fhdo.lemma.service.open_api.exceptions;

@SuppressWarnings("all")
public class MatchingException extends Exception {
  public MatchingException(final String string) {
    super(string);
  }
}
