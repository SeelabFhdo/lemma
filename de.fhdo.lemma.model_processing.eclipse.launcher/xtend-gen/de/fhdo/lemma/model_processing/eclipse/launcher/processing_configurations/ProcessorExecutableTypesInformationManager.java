package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Class to manage information about types of model processor executables.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ProcessorExecutableTypesInformationManager {
  /**
   * Domain concept to store coherent information about model processor executables
   */
  public static class ProcessorExecutableTypeInformation {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private ProcessorExecutableType processorExecutableType;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String label;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String printableInSentenceString;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Function2<? super Shell, ? super ProcessingConfiguration, ? extends String> inputSupportFunction;
    
    /**
     * Constructor
     */
    public ProcessorExecutableTypeInformation(final ProcessorExecutableType processorExecutableType, final String label, final String printableInSentenceString, final Function2<? super Shell, ? super ProcessingConfiguration, ? extends String> inputSupportFunction) {
      this.processorExecutableType = processorExecutableType;
      this.label = label;
      this.printableInSentenceString = printableInSentenceString;
      this.inputSupportFunction = inputSupportFunction;
    }
    
    @Pure
    public ProcessorExecutableType getProcessorExecutableType() {
      return this.processorExecutableType;
    }
    
    @Pure
    public String getLabel() {
      return this.label;
    }
    
    @Pure
    public String getPrintableInSentenceString() {
      return this.printableInSentenceString;
    }
    
    @Pure
    public Function2<? super Shell, ? super ProcessingConfiguration, ? extends String> getInputSupportFunction() {
      return this.inputSupportFunction;
    }
  }
  
  private static final HashMap<ProcessorExecutableType, ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation> MANAGED_INFO = CollectionLiterals.<ProcessorExecutableType, ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation>newHashMap();
  
  private static final BiMap<ProcessorExecutableType, String> LABEL_VIEW = HashBiMap.<ProcessorExecutableType, String>create();
  
  /**
   * Register new information about model processor executables
   */
  public static void register(final ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation... info) {
    final Consumer<ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation> _function = (ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation it) -> {
      ProcessorExecutableTypesInformationManager.MANAGED_INFO.put(it.processorExecutableType, it);
      ProcessorExecutableTypesInformationManager.LABEL_VIEW.put(it.processorExecutableType, it.label);
    };
    ((List<ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation>)Conversions.doWrapArray(info)).forEach(_function);
  }
  
  /**
   * Get the text label of the given ProcessorExecutableType. Throw an IllegalArgumentException in
   * case no label was registered for the type.
   */
  public static String label(final ProcessorExecutableType literal) {
    final String label = ProcessorExecutableTypesInformationManager.LABEL_VIEW.get(literal);
    String _xifexpression = null;
    if ((label != null)) {
      _xifexpression = label;
    } else {
      throw new IllegalArgumentException(("Unsupported processor executable type: " + literal));
    }
    return _xifexpression;
  }
  
  /**
   * Get the literal from the ProcessorExecutableType enumeration matching the given executable
   * type label. Throw an IllegalArgumentException in case no label was registered for the type.
   */
  public static ProcessorExecutableType literal(final String label) {
    final ProcessorExecutableType literal = ProcessorExecutableTypesInformationManager.LABEL_VIEW.inverse().get(label);
    ProcessorExecutableType _xifexpression = null;
    if ((literal != null)) {
      _xifexpression = literal;
    } else {
      throw new IllegalArgumentException(("Unsupported processor executable type label: " + label));
    }
    return _xifexpression;
  }
  
  /**
   * Get the string representation of the given ProcessorExecutableType which allows printing the
   * executable type within a sentence
   */
  public static String printableInSentenceString(final ProcessorExecutableType literal) {
    final ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation info = ProcessorExecutableTypesInformationManager.MANAGED_INFO.get(literal);
    String _printableInSentenceString = null;
    if (info!=null) {
      _printableInSentenceString=info.printableInSentenceString;
    }
    return _printableInSentenceString;
  }
  
  /**
   * Check if the given ProcessorExecutableType has an input support function
   */
  public static boolean hasInputSupport(final ProcessorExecutableType literal) {
    final ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation info = ProcessorExecutableTypesInformationManager.MANAGED_INFO.get(literal);
    return ((info != null) && (info.inputSupportFunction != null));
  }
  
  /**
   * Get the input support function of the given ProcessorExecutableType. Throw an
   * IllegalArgumentException in case no input support function was registered for the type.
   */
  public static Function2<? super Shell, ? super ProcessingConfiguration, ? extends String> inputSupportFunction(final ProcessorExecutableType literal) {
    final ProcessorExecutableTypesInformationManager.ProcessorExecutableTypeInformation info = ProcessorExecutableTypesInformationManager.MANAGED_INFO.get(literal);
    if ((info == null)) {
      throw new IllegalArgumentException(("Unsupported processor executable type: " + literal));
    }
    return info.inputSupportFunction;
  }
}
