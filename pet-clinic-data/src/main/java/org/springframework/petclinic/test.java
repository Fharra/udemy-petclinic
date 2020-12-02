package org.springframework.petclinic;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int codigoCorrecto = 1024;
        int codigoIntroducido;
        int contadorIntentosCodigo=0;

        do {
            System.out.println("introduzca un codigo: ");
            codigoIntroducido = entrada.nextInt();
            contadorIntentosCodigo++;
            if(codigoIntroducido==codigoCorrecto) {
                System.out.println("codigo correcto");
            }
        } while(codigoIntroducido != codigoCorrecto && contadorIntentosCodigo < 3);
    }
}