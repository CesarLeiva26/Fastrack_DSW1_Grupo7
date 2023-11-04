package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detallesordenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalleorden;
    @ManyToOne
    @JoinColumn(name = "idorden", referencedColumnName = "idorden")
    private Orden orden;
}