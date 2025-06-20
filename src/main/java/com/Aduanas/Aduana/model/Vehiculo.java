package com.Aduanas.Aduana.model;

import com.Aduanas.Aduana.model.PaisOrigen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String patente;

    @Column (nullable = false)
    private String marca;

    @Column (nullable = false)
    private String modelo;

    @Column (nullable = false)
    private String color;

    @Enumerated(EnumType.STRING)
    private PaisOrigen paisOrigen;

    @OneToOne
    private TramiteFormularioSalidaOIngreso tramite;
}
