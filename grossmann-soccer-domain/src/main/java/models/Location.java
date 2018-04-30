package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_location", schema = "soccer")
public class Location implements Serializable {
    private int id;
    private String city;
    private String stadium;
    private Collection<Match> matches;

    public Location() {
    }

    public Location(int id, String city, String stadium) {
        this.id = id;
        this.city = city;
        this.stadium = stadium;
    }

    @Id
    @Column(name = "LocationiD")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LocationCity")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "LocationStadium")
    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Objects.equals(city, location.city) &&
                Objects.equals(stadium, location.stadium);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, city, stadium);
    }

    @OneToMany(mappedBy = "location")
    public Collection<Match> getMatches() {
        return matches;
    }

    public void setMatches(Collection<Match> matches) {
        this.matches = matches;
    }
}
