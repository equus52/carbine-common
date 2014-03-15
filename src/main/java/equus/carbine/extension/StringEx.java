package equus.carbine.extension;

import lombok.Data;
import lombok.Delegate;
import lombok.NonNull;

import org.apache.commons.lang.StringUtils;

/**
 * Extension class of {@link String}. {@code null} origin is not allowed.
 * 
 * @see {@link StringUtils}
 */
@Data
public class StringEx {

    @Delegate
    @NonNull
    final String origin;

    /**
     * Returns byte length.
     * 
     * @return byte length.
     */
    public int lengthByte() {
        if (origin.isEmpty()) {
            return 0;
        }
        return origin.getBytes().length;
    }

    /**
     * Gets sub String by byte.
     * 
     * @param begin begin byte position
     * @param end end byte position
     * @return sub String
     */
    public String subStringBytes(int begin, int end) {
        byte[] bytes = origin.getBytes();

        if (begin < 0) {
            throw new StringIndexOutOfBoundsException(begin);
        }
        if (end > bytes.length) {
            throw new StringIndexOutOfBoundsException(end);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException(end - begin);
        }

        final byte[] subBytes = new byte[end - begin];
        for (int i = begin; i < end; i++) {
            subBytes[i - begin] = bytes[i];
        }
        return new String(subBytes);
    }

    public boolean isBlank() {
        return StringUtils.isBlank(origin);
    }

    public boolean isNotBlank() {
        return StringUtils.isNotBlank(origin);
    }

    public String strip() {
        return StringUtils.strip(origin);
    }

    public String strip(String stripChars) {
        return StringUtils.strip(origin, stripChars);
    }

    public String stripStart(String stripChars) {
        return StringUtils.stripStart(origin, stripChars);
    }

    public String stripEnd(String stripChars) {
        return StringUtils.stripEnd(origin, stripChars);
    }

    public int indexOfIgnoreCase(String searchStr) {
        return StringUtils.indexOfIgnoreCase(origin, searchStr);
    }

    public boolean contains(char searchChar) {
        return StringUtils.contains(origin, searchChar);
    }

    public boolean contains(String searchStr) {
        return StringUtils.contains(origin, searchStr);
    }

    public boolean containsIgnoreCase(String searchStr) {
        return StringUtils.containsIgnoreCase(origin, searchStr);
    }

    public String left(int len) {
        return StringUtils.left(origin, len);
    }

    public String right(int len) {
        return StringUtils.right(origin, len);
    }

    public String mid(int pos, int len) {
        return StringUtils.mid(origin, pos, len);
    }

    public String deleteWhitespace() {
        return StringUtils.deleteWhitespace(origin);
    }

    public String removeStart(String remove) {
        return StringUtils.removeStart(origin, remove);
    }

    public String removeEnd(String remove) {
        return StringUtils.removeEnd(origin, remove);
    }

    public String removeStartIgnoreCase(String remove) {
        return StringUtils.removeStartIgnoreCase(origin, remove);
    }

    public String removeEndIgnoreCase(String remove) {
        return StringUtils.removeEndIgnoreCase(origin, remove);
    }

    public String remove(String remove) {
        return StringUtils.remove(origin, remove);
    }

    public String remove(char remove) {
        return StringUtils.remove(origin, remove);
    }

    public String repeat(int repeat) {
        return StringUtils.repeat(origin, repeat);
    }

    public String repeat(String separator, int repeat) {
        return StringUtils.repeat(origin, separator, repeat);
    }

    public String rightPad(int size, char padChar) {
        return StringUtils.rightPad(origin, size, padChar);
    }

    public String leftPad(int size, char padChar) {
        return StringUtils.leftPad(origin, size, padChar);
    }

    public String capitalize() {
        return StringUtils.capitalize(origin);
    }

    public String uncapitalize() {
        return StringUtils.uncapitalize(origin);
    }

    public boolean isAlpha() {
        return StringUtils.isAlpha(origin);
    }

    public boolean isAlphaSpace() {
        return StringUtils.isAlphaSpace(origin);
    }

    public boolean isAlphanumeric() {
        return StringUtils.isAlphanumeric(origin);
    }

    public boolean isAlphanumericSpace() {
        return StringUtils.isAlphanumericSpace(origin);
    }

    public boolean isNumeric() {
        return StringUtils.isNumeric(origin);
    }

    public boolean isNumericSpace() {
        return StringUtils.isNumericSpace(origin);
    }

    public boolean isWhitespace() {
        return StringUtils.isWhitespace(origin);
    }

    public String reverse() {
        return StringUtils.reverse(origin);
    }

    public String abbreviate(int maxWidth) {
        return StringUtils.abbreviate(origin, maxWidth);
    }

}
