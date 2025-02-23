package com.iescamp;

import java.util.Arrays;
import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {

        String master[] = new String[4];
        String juego[][] = new String[10][4];

        String color;
        boolean sw1;
        int cont1, cont2, cont3, contM = 0, contH, conts, cont4, cont5;

        partida(master);

        cont1 = 0;
        while (cont1 < juego.length && contM != 4) {
            contM = 0;
            contH = 0;
            System.out.println("Ronda " + (cont1 + 1));
            for (cont2 = 0; cont2 < juego[cont1].length; cont2++) {
                System.out.print("Introduzca el " + (cont2 + 1) + "º color: ");
                color = pedirColor();
                juego[cont1][cont2] = color;
                System.out.println((cont2 + 1) + "º color guardado.");
            }
            for (cont3 = 0; cont3 < master.length; cont3++) {
                if (master[cont3].equalsIgnoreCase(juego[cont1][cont3])) {
                    contM++;
                } else {
                    cont4 = 0;
                    sw1 = true;
                    while (cont4 < juego[cont1].length && sw1) {
                        if (juego[cont1][cont4].equalsIgnoreCase(master[cont3])) {
                            contH++;
                            sw1 = false;
                        }
                        cont4++;
                    }
                }
            }
            System.out.println(" ");
            for (cont5 = 0; cont5 < juego[cont1].length; cont5++) {
                System.out.print(juego[cont1][cont5]);
                System.out.print("  ");
            }
            System.out.println("--> " + contM + " Muertos, " + contH + " heridos.");
            System.out.println(" ");
            cont1++;
        }
        System.out.println(" ");
        if (contM != 4) {
            System.out.println("Has perdido.");
        } else {
            System.out.println("Has ganado");
        }
        System.out.println("La solucion es:");
        for (conts = 0; conts < master.length; conts++) {
            System.out.print(master[conts]);
            System.out.print("  ");
        }
    }

    //Crear partida
    public static void partida(String partida[]) {
        int cont, x, cont1;
        String q;
        boolean sw1, sw2;

        Arrays.fill(partida, "A");
        for (cont = 0; cont < partida.length; cont++) {
            do {
                x = (int) (Math.random() * 6);
                if (x == 0) {
                    q = "ROJO";
                } else if (x == 1) {
                    q = "AZUL";
                } else if (x == 2) {
                    q = "VERDE";
                } else if (x == 3) {
                    q = "AMARILLO";
                } else if (x == 4) {
                    q = "NARANJA";
                } else {
                    q = "BLANCO";
                }
                cont1 = 0;
                sw1 = true;
                sw2 = false;
                while (cont1 < partida.length && sw1) {
                    if (partida[cont1].equals("A")) {
                        partida[cont1] = q;
                        sw1 = false;
                    } else {
                        if (partida[cont1].equals(q)) {
                            sw1 = false;
                            sw2 = true;
                        } else {
                            cont1++;
                        }
                    }
                }
            } while (sw2);
        }
    }

    //Validar entrada de colores.
    public static String pedirColor() {
        Scanner tecladoCad = new Scanner(System.in);
        String color;

        do {
            color = tecladoCad.nextLine();
            if (!(color.equalsIgnoreCase("rojo") || color.equalsIgnoreCase("azul") || color.equalsIgnoreCase("verde")
                    || color.equalsIgnoreCase("amarillo") || color.equalsIgnoreCase("naranja") || color.equalsIgnoreCase("blanco"))) {
                System.out.println("No ha introducido un valor valido, pruebe de nuevo.");
            }
        } while (!(color.equalsIgnoreCase("rojo") || color.equalsIgnoreCase("azul") || color.equalsIgnoreCase("verde")
                || color.equalsIgnoreCase("amarillo") || color.equalsIgnoreCase("naranja") || color.equalsIgnoreCase("blanco")));

        return color;

    }

}
