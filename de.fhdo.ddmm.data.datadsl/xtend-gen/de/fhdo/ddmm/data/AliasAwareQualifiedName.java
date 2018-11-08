package de.fhdo.ddmm.data;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Deprecated
@SuppressWarnings("all")
public class AliasAwareQualifiedName extends QualifiedName {
  public static class AliasAwareQualifiedNameLowerCase extends AliasAwareQualifiedName {
    public AliasAwareQualifiedNameLowerCase(final String[] segments) {
      super(segments);
    }
    
    @Override
    public AliasAwareQualifiedName toLowerCase() {
      return this;
    }
    
    @Override
    public boolean hasLowerCase() {
      return true;
    }
    
    @Override
    public void writeToStream(final BinaryResourceImpl.EObjectOutputStream eObjectOutputStream) throws IOException {
      final int segmentCount = this.getSegmentCount();
      eObjectOutputStream.writeCompressedInt(segmentCount);
      eObjectOutputStream.writeSegmentedString(null);
      final Consumer<String> _function = (String it) -> {
        try {
          eObjectOutputStream.writeSegmentedString(it);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.getSegments().forEach(_function);
    }
  }
  
  private AliasAwareQualifiedName lowerCase;
  
  private String alias;
  
  private int hash;
  
  protected AliasAwareQualifiedName(final String... segments) {
    super(segments);
  }
  
  public int setAlias(final String alias) {
    int _xblockexpression = (int) 0;
    {
      this.alias = alias;
      int _xifexpression = (int) 0;
      if ((alias != null)) {
        int _xblockexpression_1 = (int) 0;
        {
          final ArrayList<String> hashParts = CollectionLiterals.<String>newArrayList(alias);
          hashParts.addAll(this.getSegments());
          _xblockexpression_1 = this.hash = Arrays.hashCode(((Object[])Conversions.unwrapArray(hashParts, Object.class)));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = this.hash = Arrays.hashCode(((Object[])Conversions.unwrapArray(this.getSegments(), Object.class)));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getAlias() {
    return this.alias;
  }
  
  private static AliasAwareQualifiedName newFromQualifiedName(final QualifiedName qualifiedName) {
    List<String> _segments = qualifiedName.getSegments();
    return new AliasAwareQualifiedName(((String[])Conversions.unwrapArray(_segments, String.class)));
  }
  
  public static AliasAwareQualifiedName create(final String alias, final QualifiedName qualifiedName) {
    final AliasAwareQualifiedName aliasAwareQualifiedName = AliasAwareQualifiedName.newFromQualifiedName(qualifiedName);
    aliasAwareQualifiedName.setAlias(alias);
    return aliasAwareQualifiedName;
  }
  
  public static AliasAwareQualifiedName create(final String alias, final String... segments) {
    final AliasAwareQualifiedName aliasAwareQualifiedName = AliasAwareQualifiedName.newFromQualifiedName(QualifiedName.create(segments));
    aliasAwareQualifiedName.setAlias(alias);
    return aliasAwareQualifiedName;
  }
  
  public static AliasAwareQualifiedName createFromStream(final String alias, final BinaryResourceImpl.EObjectInputStream eObjectInputStream) throws IOException {
    final AliasAwareQualifiedName aliasAwareQualifiedName = AliasAwareQualifiedName.newFromQualifiedName(QualifiedName.createFromStream(eObjectInputStream));
    aliasAwareQualifiedName.setAlias(alias);
    return aliasAwareQualifiedName;
  }
  
  public static AliasAwareQualifiedName create(final String alias, final List<String> segments) {
    final AliasAwareQualifiedName aliasAwareQualifiedName = AliasAwareQualifiedName.newFromQualifiedName(QualifiedName.create(segments));
    aliasAwareQualifiedName.setAlias(alias);
    return aliasAwareQualifiedName;
  }
  
  public static AliasAwareQualifiedName create(final String alias, final String singleSegment) {
    final AliasAwareQualifiedName aliasAwareQualifiedName = AliasAwareQualifiedName.newFromQualifiedName(QualifiedName.create(singleSegment));
    aliasAwareQualifiedName.setAlias(alias);
    return aliasAwareQualifiedName;
  }
  
  public static <F extends Object> Function<F, AliasAwareQualifiedName> aliasAwareWrapper(final Function<F, String> nameFunction) {
    return new Function<F, AliasAwareQualifiedName>() {
      @Override
      public AliasAwareQualifiedName apply(final F from) {
        final String name = nameFunction.apply(from);
        if ((name == null)) {
          return null;
        }
        return AliasAwareQualifiedName.newFromQualifiedName(QualifiedName.create(name));
      }
    };
  }
  
  @Override
  public AliasAwareQualifiedName toLowerCase() {
    if ((this.lowerCase == null)) {
      final Function1<String, Boolean> _function = (String it) -> {
        String _lowerCase = it.toLowerCase();
        return Boolean.valueOf((!Objects.equal(it, _lowerCase)));
      };
      boolean _exists = IterableExtensions.<String>exists(super.getSegments(), _function);
      boolean isLowerCase = (!_exists);
      if ((this.alias != null)) {
        isLowerCase = (isLowerCase && Objects.equal(this.alias, this.alias.toLowerCase()));
      }
      if (isLowerCase) {
        this.lowerCase = this;
      } else {
        final Function1<String, String> _function_1 = (String it) -> {
          return it.toLowerCase();
        };
        List<String> _map = ListExtensions.<String, String>map(super.getSegments(), _function_1);
        AliasAwareQualifiedName.AliasAwareQualifiedNameLowerCase _aliasAwareQualifiedNameLowerCase = new AliasAwareQualifiedName.AliasAwareQualifiedNameLowerCase(((String[])Conversions.unwrapArray(_map, String.class)));
        this.lowerCase = _aliasAwareQualifiedNameLowerCase;
        if ((this.alias != null)) {
          this.lowerCase.setAlias(this.alias.toLowerCase());
        }
      }
    }
    return this.lowerCase;
  }
  
  @Override
  public AliasAwareQualifiedName toUpperCase() {
    final QualifiedName qualifiedName = super.toUpperCase();
    List<String> _segments = qualifiedName.getSegments();
    final AliasAwareQualifiedName aliasAwareQualifiedName = new AliasAwareQualifiedName(((String[])Conversions.unwrapArray(_segments, String.class)));
    if ((this.alias != null)) {
      this.lowerCase.setAlias(this.alias.toUpperCase());
    }
    return aliasAwareQualifiedName;
  }
  
  @Override
  public boolean isEmpty() {
    return ((((Object[])Conversions.unwrapArray(this.getSegments(), Object.class)).length == 0) && ((this.alias == null) || (this.alias.length() == 0)));
  }
  
  @Override
  public int hashCode() {
    return this.hash;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj == this)) {
      return true;
    }
    if ((obj instanceof AliasAwareQualifiedName)) {
      final AliasAwareQualifiedName other = ((AliasAwareQualifiedName) obj);
      if ((this.hash != other.hash)) {
        return false;
      }
      if ((this.alias == null)) {
        return (other.alias == null);
      }
      return (Objects.equal(this.alias, other.alias) && Arrays.equals(((Object[])Conversions.unwrapArray(this.getSegments(), Object.class)), ((Object[])Conversions.unwrapArray(other.getSegments(), Object.class))));
    } else {
      if (((this.alias == null) && (obj instanceof QualifiedName))) {
        final QualifiedName other_1 = ((QualifiedName) obj);
        return Arrays.equals(((Object[])Conversions.unwrapArray(this.getSegments(), Object.class)), ((Object[])Conversions.unwrapArray(other_1.getSegments(), Object.class)));
      }
    }
    return false;
  }
  
  boolean hasLowerCase() {
    return (this.lowerCase != null);
  }
  
  @Override
  public boolean equalsIgnoreCase(final Object obj) {
    if ((obj == this)) {
      return true;
    }
    if ((obj instanceof AliasAwareQualifiedName)) {
      final AliasAwareQualifiedName other = ((AliasAwareQualifiedName) obj);
      if ((this.hasLowerCase() && other.hasLowerCase())) {
        return this.toLowerCase().equals(other.toLowerCase());
      }
      final int segmentCount = this.getSegmentCount();
      int _segmentCount = other.getSegmentCount();
      boolean _notEquals = (segmentCount != _segmentCount);
      if (_notEquals) {
        return false;
      }
      int i = 0;
      while ((i < segmentCount)) {
        {
          boolean _equalsIgnoreCase = this.getSegment(i).equalsIgnoreCase(other.getSegment(i));
          boolean _not = (!_equalsIgnoreCase);
          if (_not) {
            return false;
          }
          i++;
        }
      }
      if ((this.alias == null)) {
        return (other.alias == null);
      }
      return this.alias.equalsIgnoreCase(other.alias);
    } else {
      if (((this.alias == null) && (obj instanceof QualifiedName))) {
        return super.equalsIgnoreCase(this);
      }
    }
    return false;
  }
  
  @Override
  public int compareTo(final QualifiedName qualifiedName) {
    return this.compareTo(qualifiedName, false);
  }
  
  @Override
  public int compareToIgnoreCase(final QualifiedName qualifiedName) {
    return this.compareTo(qualifiedName, true);
  }
  
  @Override
  public int compareTo(final QualifiedName qualifiedName, final boolean ignoreCase) {
    String _xifexpression = null;
    if ((this.alias != null)) {
      _xifexpression = this.alias;
    } else {
      _xifexpression = "";
    }
    final ArrayList<String> segmentsWithAlias = CollectionLiterals.<String>newArrayList(_xifexpression);
    segmentsWithAlias.addAll(this.getSegments());
    String otherAlias = "";
    if ((qualifiedName instanceof AliasAwareQualifiedName)) {
      otherAlias = ((AliasAwareQualifiedName) qualifiedName).alias;
    }
    final ArrayList<String> otherSegmentsWithAlias = CollectionLiterals.<String>newArrayList(otherAlias);
    otherSegmentsWithAlias.addAll(qualifiedName.getSegments());
    final int sharedSegmentIndex = Math.min(((Object[])Conversions.unwrapArray(segmentsWithAlias, Object.class)).length, ((Object[])Conversions.unwrapArray(otherSegmentsWithAlias, Object.class)).length);
    int i = 0;
    while ((i < sharedSegmentIndex)) {
      {
        int result = 0;
        if (ignoreCase) {
          result = segmentsWithAlias.get(i).compareToIgnoreCase(otherSegmentsWithAlias.get(i));
        } else {
          result = segmentsWithAlias.get(i).compareTo(otherSegmentsWithAlias.get(i));
        }
        if ((result != 0)) {
          return result;
        }
        i++;
      }
    }
    int _length = ((Object[])Conversions.unwrapArray(segmentsWithAlias, Object.class)).length;
    int _length_1 = ((Object[])Conversions.unwrapArray(otherSegmentsWithAlias, Object.class)).length;
    return (_length - _length_1);
  }
  
  @Override
  public boolean startsWith(final QualifiedName prefix) {
    return this.startsWith(prefix, false);
  }
  
  @Override
  public boolean startsWithIgnoreCase(final QualifiedName prefix) {
    return this.startsWith(prefix, true);
  }
  
  @Override
  public boolean startsWith(final QualifiedName prefix, final boolean ignoreCase) {
    String _xifexpression = null;
    if ((this.alias != null)) {
      _xifexpression = this.alias;
    } else {
      _xifexpression = "";
    }
    final ArrayList<String> segmentsWithAlias = CollectionLiterals.<String>newArrayList(_xifexpression);
    segmentsWithAlias.addAll(this.getSegments());
    String prefixAlias = "";
    if ((prefix instanceof AliasAwareQualifiedName)) {
      prefixAlias = ((AliasAwareQualifiedName) prefix).alias;
    }
    final ArrayList<String> prefixSegmentsWithAlias = CollectionLiterals.<String>newArrayList(prefixAlias);
    prefixSegmentsWithAlias.addAll(prefix.getSegments());
    int _length = ((Object[])Conversions.unwrapArray(prefixSegmentsWithAlias, Object.class)).length;
    int _length_1 = ((Object[])Conversions.unwrapArray(segmentsWithAlias, Object.class)).length;
    boolean _greaterThan = (_length > _length_1);
    if (_greaterThan) {
      return false;
    }
    int i = 0;
    while ((i < ((Object[])Conversions.unwrapArray(prefixSegmentsWithAlias, Object.class)).length)) {
      {
        boolean startsWith = false;
        if (ignoreCase) {
          startsWith = segmentsWithAlias.get(i).equalsIgnoreCase(prefixSegmentsWithAlias.get(i));
        } else {
          String _get = segmentsWithAlias.get(i);
          String _get_1 = prefixSegmentsWithAlias.get(i);
          boolean _equals = Objects.equal(_get, _get_1);
          startsWith = _equals;
        }
        if ((!startsWith)) {
          return false;
        }
        i++;
      }
    }
    return true;
  }
  
  @Override
  public String toString() {
    return this.toString(".");
  }
  
  @Override
  public String toString(final String delimiter) {
    return this.toString(delimiter, "::");
  }
  
  public String toString(final String delimiter, final String aliasDelimiter) {
    String string = super.toString(delimiter);
    if ((this.alias != null)) {
      string = ((this.alias + aliasDelimiter) + string);
    }
    return string;
  }
}
