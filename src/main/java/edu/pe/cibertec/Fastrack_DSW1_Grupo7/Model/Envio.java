package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "envios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idenvio;

    @ManyToOne
    @JoinColumn(name = "idorden", referencedColumnName = "idorden")
    private Orden orden;
}