package tsi.ensg.jee.hibernate.colloque.metier;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//@Entity(name = "Participant")
@Entity
@Table(name = "Participant")

//@Embeddable
public class Participant {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    //@GeneratedValue(strategy = GenerationType.AUTO)

    //@Column(name = "id_parti")


    public int id_parti;
    @Column(nullable = false)
    private int num_pers;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String date_naiss;
    @Column(nullable = false)
    private String organisation;
    @Column(nullable = false)
    private String observations;

    //fetch = FetchType.EAGER
    //@ManyToMany(cascade=CascadeType.ALL, mappedBy = "participants")

    @ManyToMany(fetch=FetchType.EAGER,mappedBy = "participants")
    //@JoinTable(name = "Participant_Evenement",
    //        joinColumns = { @JoinColumn(name = "id_parti") },
      //      inverseJoinColumns = { @JoinColumn(name = "id_ev") })
    @Fetch(FetchMode.SUBSELECT)
    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})

    //  @ManyToMany(mappedBy = "participants")
    private List<Evenement> attending_events = new ArrayList<>();

    public Participant(){

    }

    public Participant(int num_pers,String nom,String prenom,String email, String date_naiss, String organisation, String observations){

        this.num_pers = num_pers;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
       // this.attending_events = attending_events;

    }

    @Override
    public String toString() {
        return "Participant{" +
                "id_parti=" + id_parti +
                ", num_pers=" + num_pers +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", date_naiss='" + date_naiss + '\'' +
                ", organisation='" + organisation + '\'' +
                ", observations='" + observations +'\'' +
                //", attending_events='" + attending_events +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant participant = (Participant) o;
        return id_parti == participant.id_parti && num_pers == participant.num_pers
                && Objects.equals(nom, participant.nom)
                && Objects.equals(prenom, participant.prenom)
                && Objects.equals(email, participant.email)
                && Objects.equals(date_naiss, participant.date_naiss)
                && Objects.equals(organisation, participant.organisation)
                && Objects.equals(observations, participant.observations) ;
    }


    public void addEvenement(Evenement evenement) {
        attending_events.add(evenement);
        evenement.getParticipants().add( this );
    }

    public void removeEvenement(Evenement evenement) {
        attending_events.remove( evenement );
        evenement.getParticipants().remove( this );
    }


    @Override
    public int hashCode() {
        return Objects.hash( num_pers, nom, prenom,email,date_naiss,organisation,observations);}

    public int getId() {
        return id_parti;
    }
    public void setId(int id_parti){
        this.id_parti = id_parti;
    }

    public int getNum_pers(){return num_pers;}
    public void setNum_pers(int num_pers){this.num_pers = num_pers;}

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getDate_naiss() {return date_naiss;}
    public void setDate_naiss(String date_naiss) {this.date_naiss = date_naiss;}

    public String getOrganisation() {return organisation;}
    public void setOrganisation(String organisation) {this.organisation = organisation;}

    public String getObservations() {return observations;}
    public void setObservations(String observations) {this.observations = observations;}

    public List<Evenement> getAttending_events(){return attending_events;}
    public void setAttending_events(List<Evenement> attending_events) {this.attending_events = attending_events;}
}
