package edu.pe.cibertec.Fastrack_DSW1_Grupo7.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}