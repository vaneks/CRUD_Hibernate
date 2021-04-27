package com.vaneks.crud.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "skillName")
    private String name;

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @ManyToMany( fetch=FetchType.LAZY,cascade=CascadeType.ALL )
    @JoinTable(
            name = "dev_skills",
            joinColumns = { @JoinColumn(name = "skill_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "dev_id", referencedColumnName = "id") }
    )
    private List<Developer> developers;

    public Skill(){}

    @Override
    public String toString() {
        return id + " " + name;
    }

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
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id) &&
                Objects.equals(name, skill.name) &&
                Objects.equals(developers, skill.developers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, developers);
    }
}
