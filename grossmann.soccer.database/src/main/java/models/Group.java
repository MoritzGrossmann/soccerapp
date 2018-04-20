package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_group", schema = "soccer", catalog = "")
public class Group {
    private int id;
    private String name;
    private int orderId;
    private Collection<Match> matches;

    public Group() {
    }

    @Id
    @Column(name = "GroupID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GroupName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "GroupOrderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                orderId == group.orderId &&
                Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, orderId);
    }

    @OneToMany(mappedBy = "group")
    public Collection<Match> getMatches() {
        return matches;
    }

    public void setMatches(Collection<Match> matches) {
        this.matches = matches;
    }
}
