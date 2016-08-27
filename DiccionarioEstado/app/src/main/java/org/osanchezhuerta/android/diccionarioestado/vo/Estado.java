package org.osanchezhuerta.android.diccionarioestado.vo;

import java.io.Serializable;

/**
 * Created by sanchezocth on 25/08/2016.
 */
public class Estado implements Serializable {
    private int id;
    private String name;
    private String description;

    public Estado() {
        super();
    }

    public Estado(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
