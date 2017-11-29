package classes.components;

import interfaces.pair.PairInterface;

import java.util.Objects;

/**
 * Container to ease passing around a tuple of two objects. This object provides a sensible
 * implementation of equals(), returning true if equals() is true on each of the contained
 * objects.
 */
public class Pair<F, S> implements PairInterface{

    private final F key;
    private final S value;

    /**
     * Constructor for a Pair.
     *
     * @param key the first object in the Pair
     * @param value the second object in the pair
     */
    public Pair(F key, S value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Checks the two objects for equality by delegating to their respective
     * {@link Object#equals(Object)} methods.
     *
     * @param o the {@link Pair} to which this one is to be checked for equality
     * @return true if the underlying objects of the Pair are both considered
     *         equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !this.getClass().isInstance(o.getClass())) return false;

        Pair<?, ?> pair = (Pair<?,?>) o;

        if (key != null ? !key.equals(pair.key) : pair.key!= null) return false;
        if (value != null ? !value.equals(pair.value) : pair.value != null) return false;

        return true;
    }

    /**
     * Compute a hash code using the hash codes of the underlying objects
     *
     * @return a hashcode of the Pair
     */
    @Override
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.key == null ? 0 : this.key.hashCode());
    }

    /**
     * @return F key to the pair
     */

    public F getKey() {
        return this.key;
    }

    /**
     * @return S value of F
     */
    public S getValue() {
        return this.value;
    }

    /**
     * Convenience method for creating an appropriately typed pair.
     * @param a the first object in the Pair
     * @param b the second object in the pair
     * @return a Pair that is templatized with the types of a and b
     */
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    /**
     *@return a shallow copy of this
     */
    public Object pair() throws CloneNotSupportedException {
        return this.clone();
    }
}
