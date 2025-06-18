package com.Aduanas.Aduana.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer run;

    @Column(nullable = false)
    private Integer dv;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String segundoNombre;

    @Column(nullable = false)
    private String apellidoPaterno;

    @Column(nullable = false)
    private String apellidoMaterno;

    @Column(nullable = false)
    private String claveUnica;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nacionalidad;
}
