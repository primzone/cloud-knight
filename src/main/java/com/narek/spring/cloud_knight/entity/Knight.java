package com.narek.spring.cloud_knight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Knight {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
//    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 3, message = "Имя должно состоять минимум из 3 символов")
    private String name;

    private int level;

    private double str;

    private double def;

    private double hp;


//    @NotBlank(message = "Пожалуйста, укажите город")
    @Size(min = 3, message = "Имя города должно состоять минимум из 3 символов")
    private String fromCity;

    private int killedMonsters;



    @OneToOne()
    @JoinColumn(name = "user_id", unique = true)
    private User owner;



    public Knight() {
    }


    public Knight(String name, User owner,String fromCity) {
        this.name = name;

        this.owner = owner;
        this.fromCity = fromCity;
    }


    public int getKilledMonsters() {
        return killedMonsters;
    }

    public void setKilledMonsters(int killedMonsters) {
        this.killedMonsters = killedMonsters;
    }


    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
