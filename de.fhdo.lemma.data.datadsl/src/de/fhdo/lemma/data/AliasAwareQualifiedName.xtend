package de.fhdo.lemma.data

import org.eclipse.xtext.naming.QualifiedName
import java.io.IOException
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream
import java.util.List
import com.google.common.base.Function
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream
import java.util.Arrays

@Deprecated
/**
 * This class was part of the first implementation of import aliases where we tried to achieve that
 * the representation of an import in the form
 * "importAlias::importedNameSegment1.importedNameSegment2" is implemented as a special
 * QualifiedName instance. However, this class is not used, hence obsolete and will be removed in
 * the future.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class AliasAwareQualifiedName extends QualifiedName {
    var AliasAwareQualifiedName lowerCase;
    var String alias
    var int hash

    protected new(String... segments) {
        super(segments)
    }

    def setAlias(String alias) {
        this.alias = alias

        if (alias !== null) {
            val hashParts = newArrayList(alias)
            hashParts.addAll(segments)
            hash = Arrays.hashCode(hashParts)
        } else
            hash = Arrays.hashCode(segments)
    }

    def getAlias() {
        return alias
    }

    private static def newFromQualifiedName(QualifiedName qualifiedName) {
        return new AliasAwareQualifiedName(qualifiedName.segments)
    }

    def static AliasAwareQualifiedName create(String alias, QualifiedName qualifiedName) {
        val aliasAwareQualifiedName = newFromQualifiedName(qualifiedName)
        aliasAwareQualifiedName.setAlias(alias)
        return aliasAwareQualifiedName
    }

    def static AliasAwareQualifiedName create(String alias, String... segments) {
        val aliasAwareQualifiedName = newFromQualifiedName(create(segments))
        aliasAwareQualifiedName.setAlias(alias)
        return aliasAwareQualifiedName
    }

    def static AliasAwareQualifiedName createFromStream(String alias,
        EObjectInputStream eObjectInputStream) throws IOException {
        val aliasAwareQualifiedName = newFromQualifiedName(createFromStream(eObjectInputStream))
        aliasAwareQualifiedName.setAlias(alias)
        return aliasAwareQualifiedName
    }

    def static AliasAwareQualifiedName create(String alias, List<String> segments) {
        val aliasAwareQualifiedName = newFromQualifiedName(create(segments))
        aliasAwareQualifiedName.setAlias(alias)
        return aliasAwareQualifiedName
    }

    def static AliasAwareQualifiedName create(String alias, String singleSegment) {
        val aliasAwareQualifiedName = newFromQualifiedName(create(singleSegment))
        aliasAwareQualifiedName.setAlias(alias)
        return aliasAwareQualifiedName
    }

    def static <F> Function<F, AliasAwareQualifiedName> aliasAwareWrapper(Function<F,
        String> nameFunction) {
        return new Function<F, AliasAwareQualifiedName>() {
            override AliasAwareQualifiedName apply(F from) {
                val name = nameFunction.apply(from)
                if (name === null)
                    return null
                return newFromQualifiedName(create(name))
            }
        }
    }

    override AliasAwareQualifiedName toLowerCase() {
        if (lowerCase === null) {
            var isLowerCase = !super.segments.exists[it != it.toLowerCase]
            if (alias !== null)
                isLowerCase = isLowerCase && alias == alias.toLowerCase

            if (isLowerCase)
                lowerCase = this
            else {
                lowerCase = new AliasAwareQualifiedNameLowerCase(super.segments.map[it.toLowerCase])
                if (alias !== null)
                    lowerCase.setAlias(alias.toLowerCase)
            }
        }

        return lowerCase
    }

    static class AliasAwareQualifiedNameLowerCase extends AliasAwareQualifiedName {
        new(String[] segments) {
            super(segments);
        }

        override AliasAwareQualifiedName toLowerCase() {
            return this;
        }

        override hasLowerCase() {
            return true;
        }

        override writeToStream(EObjectOutputStream eObjectOutputStream) throws IOException {
            val segmentCount = getSegmentCount()
            eObjectOutputStream.writeCompressedInt(segmentCount)
            eObjectOutputStream.writeSegmentedString(null)
            getSegments().forEach[eObjectOutputStream.writeSegmentedString(it)]
        }
    }

    override AliasAwareQualifiedName toUpperCase() {
        val qualifiedName = super.toUpperCase
        val aliasAwareQualifiedName = new AliasAwareQualifiedName(qualifiedName.segments)
        if (alias !== null)
            lowerCase.setAlias(alias.toUpperCase)
        return aliasAwareQualifiedName
    }

    override boolean isEmpty() {
        segments.length == 0 && (alias === null || alias.length == 0)
    }

    override hashCode() {
        return hash
    }

    override equals(Object obj) {
        if (obj === this)
            return true

        if (obj instanceof AliasAwareQualifiedName) {
            val other = obj as AliasAwareQualifiedName
            if (hash != other.hash)
                return false;
            if (alias === null)
                return other.alias === null
            return alias == other.alias && Arrays.equals(segments, other.segments);
        } else if (alias === null && obj instanceof QualifiedName) {
            val other = obj as QualifiedName
            return Arrays.equals(segments, other.segments);
        }

        return false;
    }

    package def hasLowerCase() {
        return lowerCase !== null
    }

    override equalsIgnoreCase(Object obj) {
        if (obj === this)
            return true;

        if (obj instanceof AliasAwareQualifiedName) {
            val other = obj as AliasAwareQualifiedName

            if (hasLowerCase() && other.hasLowerCase())
                return toLowerCase().equals(other.toLowerCase())

            val segmentCount = getSegmentCount();
            if (segmentCount != other.getSegmentCount())
                return false

            var i = 0
            while (i < segmentCount) {
                if (!getSegment(i).equalsIgnoreCase(other.getSegment(i)))
                    return false
                i++
            }

            if (alias === null)
                return other.alias === null

            return alias.equalsIgnoreCase(other.alias)
        } else if (alias === null && obj instanceof QualifiedName)
            return super.equalsIgnoreCase(this)

        return false;
    }

    override compareTo(QualifiedName qualifiedName) {
        return compareTo(qualifiedName, false)
    }

    override compareToIgnoreCase(QualifiedName qualifiedName) {
        return compareTo(qualifiedName, true)
    }

    override compareTo(QualifiedName qualifiedName, boolean ignoreCase) {
        val segmentsWithAlias = newArrayList(if (alias !== null) alias else "")
        segmentsWithAlias.addAll(segments)

        var String otherAlias = ""
        if (qualifiedName instanceof AliasAwareQualifiedName)
            otherAlias = (qualifiedName as AliasAwareQualifiedName).alias
        val otherSegmentsWithAlias = newArrayList(otherAlias)
        otherSegmentsWithAlias.addAll(qualifiedName.segments)

        val sharedSegmentIndex = Math.min(segmentsWithAlias.length, otherSegmentsWithAlias.length)
        var i = 0
        while (i < sharedSegmentIndex) {
            var int result

            if (ignoreCase)
                result = segmentsWithAlias.get(i).compareToIgnoreCase(otherSegmentsWithAlias.get(i))
            else
                result = segmentsWithAlias.get(i).compareTo(otherSegmentsWithAlias.get(i))

            if (result != 0)
                return result

            i++
        }

        return segmentsWithAlias.length - otherSegmentsWithAlias.length
    }

    override startsWith(QualifiedName prefix) {
        return startsWith(prefix, false)
    }

    override startsWithIgnoreCase(QualifiedName prefix) {
        return startsWith(prefix, true)
    }

    override startsWith(QualifiedName prefix, boolean ignoreCase) {
        val segmentsWithAlias = newArrayList(if (alias !== null) alias else "")
        segmentsWithAlias.addAll(segments)

        var String prefixAlias = ""
        if (prefix instanceof AliasAwareQualifiedName)
            prefixAlias = (prefix as AliasAwareQualifiedName).alias
        val prefixSegmentsWithAlias = newArrayList(prefixAlias)
        prefixSegmentsWithAlias.addAll(prefix.segments)

        if (prefixSegmentsWithAlias.length > segmentsWithAlias.length)
            return false

        var i = 0
        while (i < prefixSegmentsWithAlias.length) {
            var boolean startsWith

            if (ignoreCase)
                startsWith = segmentsWithAlias.get(i)
                    .equalsIgnoreCase(prefixSegmentsWithAlias.get(i))
            else
                startsWith = segmentsWithAlias.get(i) == prefixSegmentsWithAlias.get(i)

            if (!startsWith)
                return false

            i++
        }

        return true
    }

    override toString() {
        return toString(".");
    }

    override toString(String delimiter) {
        return toString(delimiter, "::")
    }

    def toString(String delimiter, String aliasDelimiter) {
        var string = super.toString(delimiter)
        if (alias !== null)
            string = alias + aliasDelimiter + string
        return string
    }
}