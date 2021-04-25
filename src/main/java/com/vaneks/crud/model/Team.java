package com.vaneks.crud.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "team_dev",
            joinColumns = { @JoinColumn(name = "team_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "dev_id", referencedColumnName = "id") }
    )
    private List<Developer> developers;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private TeamStatus teamStatus;

    public  Team(){};

    public Team(TeamStatus teamStatus, Long id, String name, List<Developer> developers) {
        this.id = id;
        this.name = name;
        this.developers = developers;
        this.teamStatus = teamStatus;
    }
    public TeamStatus getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(TeamStatus teamStatus) {
        this.teamStatus = teamStatus;
    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return teamStatus + " " + id + " " + name + " " + developers;
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

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) &&
                name.equals(team.name) &&
                developers.equals(team.developers) &&
                teamStatus == team.teamStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, developers, teamStatus);
    }
}
