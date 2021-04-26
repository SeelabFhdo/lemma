package de.fhdo.lemma.live_validation.model;

import java.util.Objects;

/**
 * Class representing the range of an issue (follows LSP's
 * <a href="https://microsoft.github.io/language-server-protocol/specification#textDocument_publishDiagnostics">
 *  Range semantics
 * </a>).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public class IssueRange {
    private int lineNumber;
    private int column;
    private int offset;
    private int length;

    public IssueRange(int lineNumber, int column, int offset, int length) {
        this.lineNumber = lineNumber;
        this.column = column;
        this.offset = offset;
        this.length = length;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (IssueRange) o;
        return lineNumber == that.lineNumber && column == that.column && offset == that.offset && length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumber, column, offset, length);
    }

    @Override
    public String toString() {
        return "IssueRange{" +
                "lineNumber=" + lineNumber +
                ", column=" + column +
                ", offset=" + offset +
                ", length=" + length +
                '}';
    }
}
