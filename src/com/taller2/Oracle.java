package com.taller2;

public class Oracle extends Bdatos {

    @Override
    public void conectar() {
        System.out.println("Conectando a BD oracle");
    }

    @Override
    public void consultar() {
        System.out.println("Consultando a BD oracle");
    }

    @Override
    public void insertar() {
        System.out.println("Insertando en BD oracle");

    }

    @Override
    public void eliminar() {
        System.out.println("Eliminando BD oracle");
    }
}
