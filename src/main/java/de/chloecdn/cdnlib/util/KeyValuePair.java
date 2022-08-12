package de.chloecdn.cdnlib.util;

public record KeyValuePair<A, B>(A key, B value) {

    @Override
    public String toString() {
        return key.toString() + ":" + value.toString();
    }
}
