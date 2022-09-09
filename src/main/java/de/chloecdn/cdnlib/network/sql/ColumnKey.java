package de.chloecdn.cdnlib.network.sql;

public class ColumnKey<A> {

    private A key;

    public ColumnKey(A type, A key) {
        this.key = (A) key;
    }

    public A getKey() {
        return key;
    }
}
