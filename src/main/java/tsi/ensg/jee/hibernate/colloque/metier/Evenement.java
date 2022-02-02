package tsi.ensg.jee.hibernate.colloque.metier;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;



@Entity(name = "Evenement")
//@Table(name = "Evenement")
public class Evenement {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    //@GeneratedValue(strategy = GenerationType.AUTO)

    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "event_generator")
    //@SequenceGenerator(name="event_generator", sequenceName = "event_seq", allocationSize=50)


    //@Column(name="id_ev", updatable = false, nullable = false)
    public int id_ev;
    @Column(name="num_even", nullable = false)
    public int num_even;
    @Column(name="titre", nullable = false)
    public String titre;
    @Column(name="theme",nullable = false)
    public String theme;
    @Column(name="start_date", nullable = false)
    public String start_date;
    @Column(name="duree",nullable = false)
    public int duree;
    @Column(name="max_participants", nullable = false)
    public int max_participants;
    @Column(name="description", nullable = false)
    public String description;
    @Column(name="organisateur", nullable = false)
    public String organisateur;
    @Column(name="type", nullable = false)
    public String type;
   // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   // @JoinTable(name = "Participant_Evenement",
    //        joinColumns = { @JoinColumn(name = "id_ev") },
       //     inverseJoinColumns = { @JoinColumn(name = "id_parti") })



    @ManyToMany
    @JoinTable(name = "participant_evenement",
            joinColumns = { @JoinColumn(name = "id_ev") },
            inverseJoinColumns = { @JoinColumn(name = "id_parti")},
            uniqueConstraints = @UniqueConstraint(columnNames = {
                  "id_ev", "id_parti" }))

    @Cascade({CascadeType.MERGE, CascadeType.SAVE_UPDATE})


    private List<Participant> participants = new ArrayList<Participant>();

    //saveOrUpdate

    public Evenement(){

    }

    //, ArrayList<Participant> participants

    public Evenement(int num_even, String titre, String theme, String start_date, int duree, int max_participants, String description, String organisateur, String type){

        this.num_even = num_even;
        this.titre = titre;
        this.theme = theme;
        this.start_date = start_date;
        this.duree = duree;
        this.max_participants = max_participants;
        this.description = description;
        this.organisateur = organisateur;
        this.type = type;
        //this.participants = participants;


    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id_ev=" + id_ev +
                ", num_even=" + num_even +
                ", titre='" + titre + '\'' +
                ", theme='" + theme + '\'' +
                ", start_date='" + start_date + '\'' +
                ", duree=" + duree +
                ", max_participants=" + max_participants +
                ", description='" + description +'\'' +
                ", organisateur='" + organisateur +'\'' +
                ", type='" + type +'\'' +
                //", participants='" + participants +'\'' +
                '}';
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
        participant.getAttending_events().add( this );
    }

    public void removeParticipant(Participant participant) {
        participants.remove( participant );
        participant.getAttending_events().remove( this );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return id_ev == evenement.id_ev && num_even == evenement.num_even
                && Objects.equals(titre, evenement.titre)
                && Objects.equals(theme, evenement.theme)
                && Objects.equals(start_date, evenement.start_date)
                && duree == evenement.duree
                && max_participants == evenement.max_participants
                && Objects.equals(description, evenement.description)
                && Objects.equals(organisateur, evenement.organisateur)
                && Objects.equals(type, evenement.type);
    }


    @Override
    public int hashCode() {
        return Objects.hash( num_even, titre, theme,start_date,duree,max_participants,description,organisateur,type);}

    public int getId() {
        return id_ev;
    }
    public void setId(int id){
        this.id_ev = id_ev;
    }

    public int getNum_even(){return num_even;}
    public void setNum_even(int num_even){this.num_even = num_even;}

    public String getTitre(){return titre;}
    public void setTitre(String titre){this.titre = titre;}

    public String getTheme() {return theme;}
    public void setTheme(String theme){this.theme = theme;}

    public String getStart_date(){return start_date;}
    public void setStart_date(String start_date){this.start_date = start_date;}

    public int getDuree(){return duree;}
    public void setDuree(int duree){this.duree = duree;}

    public int getMax_participants(){return max_participants;}
    public void setMax_participants(int max_participants){this.max_participants = max_participants;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public String getOrganisateur(){return organisateur;}
    public void setOrganisateur(String organisateur){this.organisateur = organisateur;}

    public String getType(){return type;}
    public void setType(String type){this.type = type;}

    public List<Participant> getParticipants(){return participants;}
    public void setParticipants(List<Participant> participants){this.participants = participants;}

}
