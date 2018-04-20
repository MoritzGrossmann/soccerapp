package models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "t_location", schema = "soccer", catalog = "")
public class Location {
    private int locationiD;
    private String locationCity;
    private String locationStadium;
    private Collection<Match> tMatchesByLocationiD;

    public Location(int locationiD, String locationCity, String locationStadium) {
        this.locationiD = locationiD;
        this.locationCity = locationCity;
        this.locationStadium = locationStadium;
    }

    public Location() {
    }

    @Id
    @Column(name = "LocationiD")
    public int getLocationiD() {
        return locationiD;
    }

    public void setLocationiD(int locationiD) {
        this.locationiD = locationiD;
    }

    @Basic
    @Column(name = "LocationCity")
    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    @Basic
    @Column(name = "LocationStadium")
    public String getLocationStadium() {
        return locationStadium;
    }

    public void setLocationStadium(String locationStadium) {
        this.locationStadium = locationStadium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (locationiD != location.locationiD) return false;
        if (locationCity != null ? !locationCity.equals(location.locationCity) : location.locationCity != null)
            return false;
        if (locationStadium != null ? !locationStadium.equals(location.locationStadium) : location.locationStadium != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationiD;
        result = 31 * result + (locationCity != null ? locationCity.hashCode() : 0);
        result = 31 * result + (locationStadium != null ? locationStadium.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tLocationByLocationId")
    public Collection<Match> gettMatchesByLocationiD() {
        return tMatchesByLocationiD;
    }

    public void settMatchesByLocationiD(Collection<Match> tMatchesByLocationiD) {
        this.tMatchesByLocationiD = tMatchesByLocationiD;
    }
}
