package com.andrey.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kobri on 14.05.2016.
 */

@Entity
@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "dep_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
