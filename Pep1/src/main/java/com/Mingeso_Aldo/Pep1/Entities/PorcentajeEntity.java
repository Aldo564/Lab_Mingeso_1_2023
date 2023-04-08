package com.Mingeso_Aldo.Pep1.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "porcentaje")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PorcentajeEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_PORCENTAJE;

    private String cod_proveedor;
    private int grasa;
    private int solido;

    private String fecha; // Asi se sabe con que excel de acopio va
}
