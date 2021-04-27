package com.vaneks.crud.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "dev_skills",
            joinColumns = { @JoinColumn(name = "dev_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id", referencedColumnName = "id") }
    )
    private List<Skill> skills;

    @ManyToMany( fetch=FetchType.LAZY,cascade=CascadeType.ALL )
    @JoinTable(
            name = "team_dev",
            joinColumns = { @JoinColumn(name = "dev_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "team_id", referencedColumnName = "id") }
    )
    private List<Team> team;



    public Developer(Long id, String firstName, String lastName, List<Skill> skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
    }

    public Developer() {}

    @Override
    public String toString() {
        return  id + " " + firstName + " " +  lastName + " " +  skills ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Team> getTeams() {
        return team;
    }

    public void setTeams(List<Team> teams) {
        this.team = teams;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id.equals(developer.id) &&
                firstName.equals(developer.firstName) &&
                lastName.equals(developer.lastName) &&
                skills.equals(developer.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, skills);
    }
}
