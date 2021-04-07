package com.narek.spring.cloud_knight.entity;

import javax.persistence.*;

@Entity
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double str;

    private double def;

    private double hp;




    @OneToOne()
    @JoinColumn(name = "user_id", unique = true)
    private User owner;


    public Monster() {
    }

    public Monster(double str, double def, double hp) {
        this.str = str;
        this.def = def;
        this.hp = hp;
    }

    public Monster(int str, int def, int hp, User owner) {
        this.str = str;
        this.def = def;
        this.hp = hp;
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getStr() {
        return str;
    }

    public void setStr(double str) {
        this.str = str;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
