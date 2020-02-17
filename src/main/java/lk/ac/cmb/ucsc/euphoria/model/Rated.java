package lk.ac.cmb.ucsc.euphoria.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Rated {
    @EmbeddedId
    private  RateIdentity id;
    private String rated;

    public Rated() {
    }

    public Rated(RateIdentity id){
        this.id = id;
        rated = "No";
    }

    public Rated(RateIdentity id,String rated){
        this.id = id;
        this.rated = rated;
    }

    public RateIdentity getId() {
        return id;
    }

    public void setId(RateIdentity id) {
        this.id = id;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }
}
