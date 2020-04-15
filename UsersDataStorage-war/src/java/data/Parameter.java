package data;

import java.util.Objects;

public class Parameter {
    private String name;
    private int value;

    public Parameter() {
    }

    public Parameter(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Provides 2.2.4.3.2
     * @param val 
     */
    public void setValueFromString(String val) {
        try {
            value = Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }
    }
    
    /**
     * Provides 2.2.4.3.5
     * @return 
     */
    public String convertToListItem() {
        return "<li>" + name + " - " + value + "</li>";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parameter other = (Parameter) obj;
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Parameter{" + "name=" + name + ", value=" + value + '}';
    }
    
}
