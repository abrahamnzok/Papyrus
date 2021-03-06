package classes.components;

import interfaces.pair.PairInterface;

/**
 * Container to ease passing around a tuple of two objects. This object provides a sensible
 * implementation of equals(), returning true if equals() is true on each of the contained
 * objects.
 * This object is generic and is intended to be immutable.
 * @author Abraham Mubanzo
 */
public class Pair<F, S> implements PairInterface, Cloneable{


    /**
     * Object of any type {@code int} {@code String} {@code Object}
     * represents the key of the pair
     */
    private final F key;

    /**
     * Object of any type {@code int} {@code String} {@code Object}
     * represents the value of the pair
     */
    private final S value;

    /**
     * Constructor for a Pair.
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
        if (o == null || !(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.hashCode() == pair.key.hashCode() && value.hashCode() == pair.value.hashCode()
                || this.value.getClass().isInstance(pair.getValue())
                || (key != null ? key.equals(pair.getKey()) : pair.getKey() == null)
                && (value != null ? value.equals(pair.getValue()) : pair.getValue() == null);
    }
    /**
     * Computes a hash code using the hash codes of the underlying objects
     * @return a hashcode of the Pair
     */
    @Override
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
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
     * @param a the first object in the Pair .
     * @param b the second object in the pair .
     * @return a Pair that is templatized with the types of a and b .
     */
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    /**
     *@return a shallow copy of this .
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
