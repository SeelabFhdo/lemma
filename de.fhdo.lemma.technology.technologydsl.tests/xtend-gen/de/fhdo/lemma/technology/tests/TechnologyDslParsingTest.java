/**
 * generated by Xtext 2.12.0
 */
package de.fhdo.lemma.technology.tests;

import com.google.inject.Inject;
import de.fhdo.lemma.technology.Technology;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(TechnologyDslInjectorProvider.class)
@SuppressWarnings("all")
public class TechnologyDslParsingTest {
  @Inject
  private ParseHelper<Technology> parseHelper;

  @Test
  public void loadModel() {
  }
}
