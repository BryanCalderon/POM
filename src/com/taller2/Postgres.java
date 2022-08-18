package com.taller2;

public class Postgres extends Bdatos {

    @Override
    public void conectar() {
        System.out.println("Conectando a BD Postgres");
    }

    @Override
    public void consultar() {
        System.out.println("Consultando a BD Postgres");
    }

    @Override
    public void insertar() {
        System.out.println("Insertando en BD Postgres");

    }

    @Override
    public void eliminar() {
        System.out.println("Eliminando BD Postgres");
    }
}