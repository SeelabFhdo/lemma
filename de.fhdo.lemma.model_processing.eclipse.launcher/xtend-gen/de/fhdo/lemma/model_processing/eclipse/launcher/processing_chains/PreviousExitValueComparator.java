package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains;

import com.google.common.base.Objects;
import com.google.common.collect.HashBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Helper class for managing exit value comparators and performing comparisons for a given
 * comparator.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class PreviousExitValueComparator {
  /**
   * Wrapper for comparator information
   */
  private static class ComparatorInfo {
    @Accessors(AccessorType.PROTECTED_GETTER)
    private final String userRepresentation;
    
    @Accessors(AccessorType.PROTECTED_GETTER)
    private final Function2<? super Integer, ? super Integer, ? extends Boolean> comparatorFunction;
    
    /**
     * Constructor
     */
    public ComparatorInfo(final String userRepresentation, final Function2<? super Integer, ? super Integer, ? extends Boolean> comparatorFunction) {
      this.userRepresentation = userRepresentation;
      this.comparatorFunction = comparatorFunction;
    }
    
    @Pure
    protected String getUserRepresentation() {
      return this.userRepresentation;
    }
    
    @Pure
    protected Function2<? super Integer, ? super Integer, ? extends Boolean> getComparatorFunction() {
      return this.comparatorFunction;
    }
  }
  
  /**
   * Enumeration of comparator identifiers
   */
  public enum Comparator {
    LOWER,
    
    LOWER_OR_EQUAL,
    
    EQUAL,
    
    GREATER,
    
    GREATER_OR_EQUAL;
  }
  
  private static final Map<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo> COMPARATORS = Collections.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>unmodifiableMap(CollectionLiterals.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>newHashMap(Pair.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>of(PreviousExitValueComparator.Comparator.LOWER, new PreviousExitValueComparator.ComparatorInfo("<", 
    ((Function2<Integer, Integer, Boolean>) (Integer actualExitValue, Integer expectedExitValue) -> {
      return Boolean.valueOf((actualExitValue.compareTo(expectedExitValue) < 0));
    }))), Pair.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>of(PreviousExitValueComparator.Comparator.LOWER_OR_EQUAL, new PreviousExitValueComparator.ComparatorInfo("<=", 
    ((Function2<Integer, Integer, Boolean>) (Integer actualExitValue, Integer expectedExitValue) -> {
      return Boolean.valueOf((actualExitValue.compareTo(expectedExitValue) <= 0));
    }))), Pair.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>of(PreviousExitValueComparator.Comparator.EQUAL, new PreviousExitValueComparator.ComparatorInfo("==", 
    ((Function2<Integer, Integer, Boolean>) (Integer actualExitValue, Integer expectedExitValue) -> {
      return Boolean.valueOf(Objects.equal(actualExitValue, expectedExitValue));
    }))), Pair.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>of(PreviousExitValueComparator.Comparator.GREATER, new PreviousExitValueComparator.ComparatorInfo(">", 
    ((Function2<Integer, Integer, Boolean>) (Integer actualExitValue, Integer expectedExitValue) -> {
      return Boolean.valueOf((actualExitValue.compareTo(expectedExitValue) > 0));
    }))), Pair.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo>of(PreviousExitValueComparator.Comparator.GREATER_OR_EQUAL, new PreviousExitValueComparator.ComparatorInfo(">=", 
    ((Function2<Integer, Integer, Boolean>) (Integer actualExitValue, Integer expectedExitValue) -> {
      return Boolean.valueOf((actualExitValue.compareTo(expectedExitValue) >= 0));
    })))));
  
  /**
   * User representations of comparators
   */
  private static final HashBiMap<PreviousExitValueComparator.Comparator, String> COMPARATOR_USER_REPRESENTATIONS = HashBiMap.<PreviousExitValueComparator.Comparator, String>create(MapExtensions.<PreviousExitValueComparator.Comparator, PreviousExitValueComparator.ComparatorInfo, String>mapValues(PreviousExitValueComparator.COMPARATORS, ((Function1<PreviousExitValueComparator.ComparatorInfo, String>) (PreviousExitValueComparator.ComparatorInfo it) -> {
    return it.userRepresentation;
  })));
  
  /**
   * Get the user representations of all comparators
   */
  public static Set<String> getUserRepresentationValues() {
    return PreviousExitValueComparator.COMPARATOR_USER_REPRESENTATIONS.values();
  }
  
  /**
   * Get the user representation of a given comparator
   */
  public static String getUserRepresentation(final PreviousExitValueComparator.Comparator comparator) {
    if ((comparator == null)) {
      return "";
    }
    final String userRepresentation = PreviousExitValueComparator.COMPARATOR_USER_REPRESENTATIONS.get(comparator);
    if ((userRepresentation == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Invalid exit value comparator \"");
      _builder.append(comparator);
      _builder.append("\"");
      throw new IllegalArgumentException(_builder.toString());
    }
    return userRepresentation;
  }
  
  /**
   * Get the internal representation of a comparator from its user representation. An internal
   * comparator representation corresponds to the comparator's literal from the Comparator
   * enumeration.
   */
  public static PreviousExitValueComparator.Comparator getInternalRepresentation(final String userRepresentation) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(userRepresentation);
    if (_isNullOrEmpty) {
      return null;
    }
    final PreviousExitValueComparator.Comparator comparator = PreviousExitValueComparator.COMPARATOR_USER_REPRESENTATIONS.inverse().get(userRepresentation);
    if ((comparator == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      _builder.append(userRepresentation);
      _builder.append("\" does not exist");
      String _plus = ("Exit value comparator with user representation " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    return comparator;
  }
  
  /**
   * Check if a given exit value matches an expected one in the sense of a given comparator
   */
  public static Boolean matches(final int actualExitValue, final int expectedExitValue, final PreviousExitValueComparator.Comparator comparator) {
    final PreviousExitValueComparator.ComparatorInfo comparatorInfo = PreviousExitValueComparator.COMPARATORS.get(comparator);
    if ((comparatorInfo == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Invalid exit value comparator \"");
      _builder.append(comparator);
      _builder.append("\"");
      throw new IllegalArgumentException(_builder.toString());
    }
    return comparatorInfo.comparatorFunction.apply(Integer.valueOf(actualExitValue), Integer.valueOf(expectedExitValue));
  }
}
