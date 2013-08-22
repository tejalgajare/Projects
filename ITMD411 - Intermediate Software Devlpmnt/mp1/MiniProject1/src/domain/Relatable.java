package domain;

/**
 * This is an interface which contains two boolean methods- isMassSmaller and
 * isDiameterGreater
 *
 * @see Planet 
 * @author Tejal Gajare
 */
public interface Relatable {

    boolean isMassSmaller(Object other);

    boolean isDiameterGreater(Object other);
}
