package equus.carbine.util;

import java.util.Collection;

import com.google.common.base.Preconditions;

/**
 * Additional utility class that extends {@link Preconditions}.
 */
public final class Preconditions2 {

    private Preconditions2() {}

    /**
     * Ensures that a string is not empty.
     * 
     * @param string a string ; * @return the non-empty string that was validated
     * @return the non-empty string that was validated
     * @throws NullPointerException if {@code string} is null
     * @throws IllegalArgumentException if {@code string} empty.
     */
    public static String checkNotEmpty(String string) {
        Preconditions.checkNotNull(string);
        if (string.length() == 0) {
            throw new IllegalArgumentException();
        }
        return string;
    }

    /**
     * Ensures that a string is not empty.
     * 
     * @param string a string
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty string that was validated
     * @throws NullPointerException if {@code string} is null
     * @throws IllegalArgumentException if {@code string} empty.
     */
    public static String checkNotEmpty(String string, Object errorMessage) {
        Preconditions.checkNotNull(string, errorMessage);
        if (string.length() == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return string;
    }

    /**
     * Ensures that a collection is not empty.
     * 
     * @param collection a collection
     * @param <T> type of Collection
     * @return the non-empty collection that was validated
     * @throws NullPointerException if {@code collection} is null
     * @throws IllegalArgumentException if {@code collection} empty.
     */
    @SuppressWarnings("rawtypes")
    public static <T extends Collection> T checkNotEmpty(T collection) {
        Preconditions.checkNotNull(collection);
        if (collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        return collection;
    }

    /**
     * Ensures that a collection is not empty.
     * 
     * @param collection a collection
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @param <T> type of Collection
     * @return the non-empty collection that was validated
     * @throws NullPointerException if {@code collection} is null
     * @throws IllegalArgumentException if {@code collection} empty.
     */
    @SuppressWarnings("rawtypes")
    public static <T extends Collection> T checkNotEmpty(T collection, Object errorMessage) {
        Preconditions.checkNotNull(collection, errorMessage);
        if (collection.size() == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return collection;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static short[] checkNotEmpty(short[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static short[] checkNotEmpty(short[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static int[] checkNotEmpty(int[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static int[] checkNotEmpty(int[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static long[] checkNotEmpty(long[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static long[] checkNotEmpty(long[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static float[] checkNotEmpty(float[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static float[] checkNotEmpty(float[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static double[] checkNotEmpty(double[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static double[] checkNotEmpty(double[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static byte[] checkNotEmpty(byte[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static byte[] checkNotEmpty(byte[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static char[] checkNotEmpty(char[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static char[] checkNotEmpty(char[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param <T> type of array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static <T> T[] checkNotEmpty(T[] array) {
        Preconditions.checkNotNull(array);
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    /**
     * Ensures that an array is not empty.
     * 
     * @param array an array
     * @param errorMessage the exception message to use if the check fails; will be converted to a string using
     *            {@link String#valueOf(Object)}
     * @param <T> type of array
     * @return the non-empty array that was validated
     * @throws NullPointerException if {@code array} is null
     * @throws IllegalArgumentException if {@code array} empty.
     */
    public static <T> T[] checkNotEmpty(T[] array, Object errorMessage) {
        Preconditions.checkNotNull(array, errorMessage);
        if (array.length == 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return array;
    }
}