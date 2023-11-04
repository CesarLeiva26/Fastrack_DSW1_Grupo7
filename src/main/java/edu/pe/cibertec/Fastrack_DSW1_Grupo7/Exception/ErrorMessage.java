package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorMessage {

    private Integer statusCode;
    private Date dateError;
    private String message;
    private String description;
}
