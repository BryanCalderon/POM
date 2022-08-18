package com.taller2;

public class Mysql extends Bdatos {

    @Override
    public void conectar() {
        System.out.println("Conectando a BD Mysql");
    }

    @Override
    public void consultar() {
        System.out.println("Consultando a BD Mysql");
    }

    @Override
    public void insertar() {
        System.out.println("Insertando en BD Mysql");

    }

    @Override
    public void eliminar() {
        System.out.println("Eliminando BD Mysql");
    }
}
