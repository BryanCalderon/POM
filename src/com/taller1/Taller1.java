package com.taller1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taller1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("ingrese la masa (KG):");
            Double weight = Double.parseDouble(reader.readLine());
            System.out.println("ingrese la estatura (CM/M):");
            Double height = Double.parseDouble(reader.readLine()) / 100.0;
            if (height < 0.1)
                height *= 100.0;

            Person person = new Person(weight, height);

            Double imc = person.calculateIMC();
            System.out.println("IMC:" + imc);

            String clasification = clasificateIMC(imc);
            System.out.println("clasification: " + clasification);
        } catch (NumberFormatException e) {
            System.out.println("Datos no validos");
        } catch (IOException e) {
            System.out.println("Error al intentar leer los datos");
        }
    }

    private static String clasificateIMC(Double imc) {
        String result;
        if (imc < 18.5) {
            result = "Bajo peso";
        } else if (imc > 18.5 && imc < 24.9) {
            result = "Rango normal";
        } else if (imc > 24.9 && imc < 29.9) {
            result = "Sobrepeso";
        } else {
            result = "Obesidad";
        }
        return result;
    }

}
