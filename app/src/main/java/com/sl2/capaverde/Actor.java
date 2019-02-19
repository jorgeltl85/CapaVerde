package com.sl2.capaverde;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Actor {
    @Id
    private Long id;

    private String nombre;
    private String apellido;

    @NotNull
    @Index(name = "AGE_IDX")
    private int edad;

    @NotNull
    private Long peliculaId;

    @Generated(hash = 1520066662)
    public Actor(Long id, String nombre, String apellido, int edad,
            @NotNull Long peliculaId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peliculaId = peliculaId;
    }

    @Generated(hash = 1859932406)
    public Actor() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Long getPeliculaId() {
        return this.peliculaId;
    }

    public void setPeliculaId(Long peliculaId) {
        this.peliculaId = peliculaId;
    }
}
