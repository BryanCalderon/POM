package com.taller2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taller2 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean finish = false;
        String name = "";
        while (!finish) {
            try {
                System.out.println("Escriba el nombre de la base de datos a usar:");
                name = reader.readLine();
                System.out.println();
                Bdatos bdatos = getDB(name);
                manageDB(bdatos);

                System.out.println("\nPara salir oprima la letra Q");
                name = reader.readLine();

                if ("q".equalsIgnoreCase(name)) {
                    finish = true;
                }
            } catch (IOException e) {
                System.out.println("Error al intentar leer los datos");
            } catch (Exception e) {
                System.out.println("No se encontró la base de datos: " + name + "\n");
            }
        }
    }

    private static void manageDB(Bdatos bdatos) {
        bdatos.conectar();
        bdatos.consultar();
        bdatos.insertar();
        bdatos.eliminar();
    }

    private static Bdatos getDB(String name) throws Exception {
        if ("postgres".equalsIgnoreCase(name)) {
            return new Postgres();
        } else if ("oracle".equalsIgnoreCase(name)) {
            return new Oracle();
        } else if ("mysql".equalsIgnoreCase(name)) {
            return new Mysql();
        }
        throw new Exception("No se encontro Base de datos");
    }
}
