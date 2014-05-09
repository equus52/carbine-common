package equus.carbine.extension;

import org.apache.commons.lang3.StringUtils;

/**
 * Extension class of {@link String}.
 * 
 * @see {@link StringUtils}
 */
public final class StringExtensions {

    private StringExtensions() {}

    /**
     * Returns byte length.
     * 
     * @param str the String
     * @return byte length.
     */
    public static int lengthByte(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        return str.getBytes().length;
    }

    /**
     * Gets sub String by byte.
     * 
     * @param str the String
     * @param begin begin byte position
     * @param end end byte position
     * @return sub String
     */
    public static String subStringBytes(String str, int begin, int end) {
        byte[] bytes = str.getBytes();

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

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static String strip(String str) {
        return StringUtils.strip(str);
    }

    public static String strip(String str, String stripChars) {
        return StringUtils.strip(str, stripChars);
    }

    public static String stripStart(String str, String stripChars) {
        return StringUtils.stripStart(str, stripChars);
    }

    public static String stripEnd(String str, String stripChars) {
        return StringUtils.stripEnd(str, stripChars);
    }

    public static int indexOfIgnoreCase(String str, String searchStr) {
        return StringUtils.indexOfIgnoreCase(str, searchStr);
    }

    public static boolean contains(String str, char searchChar) {
        return StringUtils.contains(str, searchChar);
    }

    public static boolean contains(String str, String searchStr) {
        return StringUtils.contains(str, searchStr);
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        return StringUtils.containsIgnoreCase(str, searchStr);
    }

    public static String left(String str, int len) {
        return StringUtils.left(str, len);
    }

    public static String right(String str, int len) {
        return StringUtils.right(str, len);
    }

    public static String mid(String str, int pos, int len) {
        return StringUtils.mid(str, pos, len);
    }

    public static String deleteWhitespace(String str) {
        return StringUtils.deleteWhitespace(str);
    }

    public static String removeStart(String str, String remove) {
        return StringUtils.removeStart(str, remove);
    }

    public static String removeEnd(String str, String remove) {
        return StringUtils.removeEnd(str, remove);
    }

    public static String removeStartIgnoreCase(String str, String remove) {
        return StringUtils.removeStartIgnoreCase(str, remove);
    }

    public static String removeEndIgnoreCase(String str, String remove) {
        return StringUtils.removeEndIgnoreCase(str, remove);
    }

    public static String remove(String str, String remove) {
        return StringUtils.remove(str, remove);
    }

    public static String remove(String str, char remove) {
        return StringUtils.remove(str, remove);
    }

    public static String repeat(String str, int repeat) {
        return StringUtils.repeat(str, repeat);
    }

    public static String repeat(String str, String separator, int repeat) {
        return StringUtils.repeat(str, separator, repeat);
    }

    public static String rightPad(String str, int size, char padChar) {
        return StringUtils.rightPad(str, size, padChar);
    }

    public static String leftPad(String str, int size, char padChar) {
        return StringUtils.leftPad(str, size, padChar);
    }

    public static String capitalize(String str) {
        return StringUtils.capitalize(str);
    }

    public static String uncapitalize(String str) {
        return StringUtils.uncapitalize(str);
    }

    public static boolean isAlpha(String str) {
        return StringUtils.isAlpha(str);
    }

    public static boolean isAlphaSpace(String str) {
        return StringUtils.isAlphaSpace(str);
    }

    public static boolean isAlphanumeric(String str) {
        return StringUtils.isAlphanumeric(str);
    }

    public static boolean isAlphanumericSpace(String str) {
        return StringUtils.isAlphanumericSpace(str);
    }

    public static boolean isNumeric(String str) {
        return StringUtils.isNumeric(str);
    }

    public static boolean isNumericSpace(String str) {
        return StringUtils.isNumericSpace(str);
    }

    public static boolean isWhitespace(String str) {
        return StringUtils.isWhitespace(str);
    }

    public static String reverse(String str) {
        return StringUtils.reverse(str);
    }

    public static String abbreviate(String str, int maxWidth) {
        return StringUtils.abbreviate(str, maxWidth);
    }

}
