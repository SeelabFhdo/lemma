package de.fhdo.lemma.data.avro.ui.to_lemma;

import de.fhdo.lemma.data.avro.ui.to_lemma.AvroToLemmaDialog;
import java.util.Comparator;
import java.util.List;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Content provider for the tree viewer in the Avro-to-LEMMA conversion dialog.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SchemaTreeContentProvider implements ITreeContentProvider {
  /**
   * Get root elements
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    return ((Object[])Conversions.unwrapArray(this.sortByName(((List<?>) inputElement)), Object.class));
  }

  /**
   * Helper to sort Avro protocols, namespaces, and schemas in the form of elements as expected by
   * the tree viewer by their names
   */
  private List<?> sortByName(final List<?> elements) {
    return IterableExtensions.sortWith(elements, new Comparator<Object>() {
      @Override
      public int compare(final Object o1, final Object o2) {
        final String s1 = SchemaTreeContentProvider.this.sortableString(o1);
        final String s2 = SchemaTreeContentProvider.this.sortableString(o2);
        int _xifexpression = (int) 0;
        if (((s1 == null) && (s2 == null))) {
          _xifexpression = 0;
        } else {
          int _xifexpression_1 = (int) 0;
          if ((s1 == null)) {
            _xifexpression_1 = 1;
          } else {
            int _xifexpression_2 = (int) 0;
            if ((s2 == null)) {
              _xifexpression_2 = (-1);
            } else {
              _xifexpression_2 = s1.compareTo(s2);
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xifexpression = _xifexpression_1;
        }
        return _xifexpression;
      }
    });
  }

  /**
   * Get sortable string from Avro protocols, namespaces, and schemas
   */
  private String sortableString(final Object o) {
    String _switchResult = null;
    boolean _matched = false;
    if (o instanceof AvroToLemmaDialog.AvroProtocol) {
      _matched=true;
      _switchResult = ((AvroToLemmaDialog.AvroProtocol)o).getProtocol().getName();
    }
    if (!_matched) {
      if (o instanceof AvroToLemmaDialog.AvroNamespace) {
        _matched=true;
        _switchResult = ((AvroToLemmaDialog.AvroNamespace)o).getNamespace();
      }
    }
    if (!_matched) {
      if (o instanceof AvroToLemmaDialog.AvroSchemaWithNamespace) {
        _matched=true;
        _switchResult = ((AvroToLemmaDialog.AvroSchemaWithNamespace)o).getSchema().getName();
      }
    }
    return _switchResult;
  }

  /**
   * Get children of parent element
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    List<?> _switchResult = null;
    boolean _matched = false;
    if (parentElement instanceof AvroToLemmaDialog.AvroProtocol) {
      _matched=true;
      _switchResult = ((AvroToLemmaDialog.AvroProtocol)parentElement).getChildren();
    }
    if (!_matched) {
      if (parentElement instanceof AvroToLemmaDialog.AvroNamespace) {
        _matched=true;
        _switchResult = ((AvroToLemmaDialog.AvroNamespace)parentElement).getChildren();
      }
    }
    if (!_matched) {
      if (parentElement instanceof AvroToLemmaDialog.AvroSchemaWithNamespace) {
        _matched=true;
        _switchResult = ((AvroToLemmaDialog.AvroSchemaWithNamespace)parentElement).getChildren();
      }
    }
    if (!_matched) {
      _switchResult = CollectionLiterals.<Object>emptyList();
    }
    return ((Object[])Conversions.unwrapArray(_switchResult, Object.class));
  }

  /**
   * Get parent of an element
   */
  @Override
  public Object getParent(final Object element) {
    Object _switchResult = null;
    boolean _matched = false;
    if (element instanceof AvroToLemmaDialog.AvroNamespace) {
      _matched=true;
      _switchResult = ((AvroToLemmaDialog.AvroNamespace)element).getParent();
    }
    if (!_matched) {
      if (element instanceof AvroToLemmaDialog.AvroSchemaWithNamespace) {
        _matched=true;
        _switchResult = ((AvroToLemmaDialog.AvroSchemaWithNamespace)element).getParent();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }

  /**
   * Determine if the given element has children
   */
  @Override
  public boolean hasChildren(final Object element) {
    boolean _isEmpty = ((List<Object>)Conversions.doWrapArray(this.getChildren(element))).isEmpty();
    return (!_isEmpty);
  }
}
