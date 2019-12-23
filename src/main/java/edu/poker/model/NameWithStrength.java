package edu.poker.model;

import edu.poker.validators.ValidationException;
import lombok.Data;

import java.util.Map;

/**
 * Common name with strength pair class implementation. Instances of this class are compared by strength
 */
@Data
public abstract class NameWithStrength implements Comparable<NameWithStrength> {

    private String name;
    private Integer strength;

    public NameWithStrength() {}

    public NameWithStrength(String name) {
        this.name = name;
        this.strength = getNamesWithStrengthsMap().get(this.name);
    }

    protected abstract Map<String, Integer> getNamesWithStrengthsMap();

    public void validate() throws ValidationException {
        if (!getNamesWithStrengthsMap().containsKey(name)) {
            throw new ValidationException(String.format("No such %s: %s", getClass().getSimpleName(), name));
        }
    }

    @Override
    public int compareTo(NameWithStrength o) {
        return strength.compareTo(o.strength);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof NameWithStrength)) {
            return false;
        } else {
            return ((NameWithStrength) o).strength.equals(this.strength);
        }
    }
}
