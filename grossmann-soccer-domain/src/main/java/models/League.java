package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_league", schema = "soccer")
public class League implements Serializable {
    private int id;
    private String name;
    private Collection<Match> matches;

    public League() {
    }

    public League(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "LeagueID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LeagueName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return id == league.id &&
                Objects.equals(name, league.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "league")
    public Collection<Match> getMatches() {
        return matches;
    }

    public void setMatches(Collection<Match> league) {
        this.matches = league;
    }
}
