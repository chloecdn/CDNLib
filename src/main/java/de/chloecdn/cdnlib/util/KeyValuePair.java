package de.chloecdn.cdnlib.util;

/**
 * This class can be used in places where you need to assign a specific value to a key, when you need to get that assigned value later.
 * This is for example used for the Translation Utils.
 *
 * @param key   the key
 * @param value the value
 * @param <A>   the key's type
 * @param <B>   the value's type
 */
public record KeyValuePair<A, B>(A key, B value) {

    @Override
    public String toString() {
        return key.toString() + ":" + value.toString();
    }
}
