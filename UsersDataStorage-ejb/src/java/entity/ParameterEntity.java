package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "datastorage.usersdata")
@NamedQueries({@NamedQuery(name = "ParameterEntity.getAll", query = "SELECT e FROM ParameterEntity e"),
    @NamedQuery(name = "ParameterEntity.findByName",
                query = "SELECT e FROM ParameterEntity e WHERE e.name = :name"),
    // TODO: fix query:
    @NamedQuery(name = "ParameterEntity.findByNameTemplate",
                query = "SELECT e FROM ParameterEntity e WHERE e.name = :name"),
    // TODO: fix query:
    @NamedQuery(name = "ParameterEntity.findByValInterval",
                query = "SELECT e FROM ParameterEntity e WHERE e.value > :lowerBound AND e.value < :upperBound")
})
public class ParameterEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "value")
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParameterEntity)) {
            return false;
        }
        ParameterEntity other = (ParameterEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ParameterEntity[ id=" + id + " ]";
    }
    
}
