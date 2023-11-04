package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ordenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorden;

    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Cliente cliente;
}
