package com.vaneks
        .crud.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column (name = "skillName")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Developer developer;

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id.equals(skill.id) &&
                name.equals(skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
