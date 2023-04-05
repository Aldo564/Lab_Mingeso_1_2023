package com.Mingeso_Aldo.Pep1.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "acopio")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AcopioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String id_acopio;

    private String fecha;
    private String turno;
    private String proveedor;
    private String kg_leche;
}
