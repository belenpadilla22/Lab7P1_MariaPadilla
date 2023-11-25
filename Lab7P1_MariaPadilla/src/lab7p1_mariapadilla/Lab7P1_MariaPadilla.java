/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_mariapadilla;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author belen
 */
public class Lab7P1_MariaPadilla {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Fila 2, asiento 6
        System.out.println(" ---- BIENVENIDO AL TRES EN RAYA  ----");
        System.out.println(" 1. Tres en raya:  ");
        System.out.println(" 2. Puntos de silla: ");
        System.out.println(" 3. Salir ");
        System.out.println(" Ingrese una opcion: ");
        int opcion = leer.nextInt();
        while (opcion > 0 && opcion < 3) {
            switch (opcion) {
                case 1:

                    char resp = 's';
                    int size = 3;
                    char[][] matriz = new char[size][size];
                    System.out.println(" Tablero actual ");
                    matriz = generar(size);
                    imprimir(matriz);
                    boolean ganador = false;
                    int contador;
                    while (resp == 's' || resp == 'S') {
                        contador = 0;
                        System.out.println(" Es el turno de x :  ");
                        System.out.println(" Ingrese la fila (0,1,2) : ");
                        int fila = leer.nextInt();
                        System.out.println(" Ingrese la columna (0,1,2): ");
                        int columna = leer.nextInt();
                        if ((fila >= 0 && fila <= 2) && (columna >= 0 && columna <=2)) {
                            System.out.println(" El usuario ha elegido la posicion:" + "( " + fila + "," + columna + ")");
                            if (verificarPosicionValida(matriz, fila, columna) == false) {
                                contador++;
                                System.out.println(" Turno X: ");
                                matriz[fila][columna] = 'x';
                                imprimir(matriz);
                                ganador = verificacionVictoria(matriz, 'x');
                                if (ganador) {
                                    System.out.println(" x ha ganador ");
                                    break;
                                }

                            }

                            int fil = 0 + ran.nextInt(3);
                            int col = 0 + ran.nextInt(3);
                            System.out.println(" La computadora ha elegido la posicion " + fil + "," + col);
                            boolean valid = verificarPosicionValida(matriz, fil, col);
                            if (valid == false) {
                                contador++;
                                System.out.println("Turno 0: " );
                                System.out.println(" Es el turno de 0: ");
                                matriz[fil][col] = '0';
                                ganador = verificacionVictoria(matriz, '0');
                                imprimir(matriz);
                                if (ganador) {
                                    System.out.println(" 0 ganador ");
                                    break;
                                }
                            } 
                            if (contador == 9) {
                                System.out.println(" Empate ");
                            }

                        }

                        System.out.println(" Desea seguir [s/n] : ");
                        
                        resp = leer.next().charAt(0);
                    }

                    break;
                case 2:
                    System.out.println(" Ingrese el numero de fila: ");
                    int fila = leer.nextInt();
                    System.out.println(" Ingrese el numero de columna: ");
                    int columna = leer.nextInt();
                    int matrizllena[][] = new int[fila][columna];
                    System.out.println(" Matriz generada: ");
                    matrizllena = generarIntMatrizAleatotia(fila, columna);
                    imprimirint(matrizllena);
                    encontrarPuntosSilla(matrizllena,fila,columna);
                    

                    break;

            }
            System.out.println(" ---- BIENVENIDO AL TRES EN RAYA  ----");
            System.out.println(" 1. Tres en raya:  ");
            System.out.println(" 2. Puntos de silla: ");
            System.out.println(" 3. Salir ");
            System.out.println(" Ingrese una opcion: ");
            opcion = leer.nextInt();
        }

    }

    public static char[][] generar(int size) {
        char temporal[][] = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temporal[i][j] = ' ';

            }

        }
        return temporal;
    }

    public static void imprimir(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" [ " + matriz[i][j] + " ] ");
            }
            System.out.println("");

        }

    }

    public static boolean verificarPosicionValida(char[][] matriz, int fila, int columna) {
        boolean existe = false;
        if (matriz[fila][columna] == ' ') {
            existe = false;
        } else if (matriz[fila][columna] == 'x') {

            existe = true;
        } else {

            existe = true;

        }

        return existe;

    }

    public static boolean verificacionVictoria(char[][] x, char ganador) {
        int cont;
        for (int i = 0; i < x.length; i++) {
            cont = 0;
            for (int j = 0; j < x[0].length; j++) {
                if (i == j && x[i][j] == ganador) {
                    cont++;
                }
            }
            if (cont == 3) {
                return true;
            }
        }

        for (int i = 0; i < x.length; i++) {
            cont = 0;
            for (int j = 0; j < x[0].length; j++) {
                if (i + j == x.length - 1 && x[i][j] == ganador) {
                    cont++;

                }
                if (cont == 3) {
                    return true;
                }

            }

        }
        for (int i = 0; i < x.length; i++) {
            cont = 0;
            for (int j = 0; j < x[0].length; j++) {
                if (x[i][j] == ganador) {
                    cont++;

                }
                if (cont == 3) {
                    return true;
                }

            }

        }
        for (int i = 0; i < x.length; i++) {
            cont = 0;
            for (int j = 0; j < x[0].length; j++) {
                if (x[j][i] == ganador) {
                    cont++;

                }
                if (cont == 3) {
                    return true;
                }

            }

        }
        return false;
    }

    public static int[][] generarIntMatrizAleatotia(int fila, int columna) {
        int[][] temporal = new int[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = ran.nextInt(100);
            }

        }
        return temporal;
    }

    public static void imprimirint(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" [ " + matriz[i][j] + " ] ");
            }
            System.out.println("");

        }

    }

    public static void encontrarPuntosSilla(int[][] mat, int fila, int columna) {
        boolean hayPunto = false;
        int c=0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (maximocolumna(mat,j,mat[i][j]) && minimofila (mat,i,mat[i][j])){
                    System.out.println(" El punto silla de la matriz es [" + i + "][" + j + "]: " + mat[i][j]);
                    hayPunto = false;
                    c++;
                }
            }
        }
        
        if(hayPunto == false && c==0)
        {
            System.out.println("No se encontro ningun punto silla");
        }
    }
    public static boolean maximocolumna (int [][]matriz, int columna, int num){
        boolean maximo=true;
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[i][columna] > num)
            {
                maximo = false;
            }
        }
    
    
    return maximo;
    
    }
    public static boolean minimofila (int [][]matriz, int fila, int num){
        boolean maximo=true;
        for (int i = 0; i < matriz.length; i++) {
            if(matriz[fila][i] < num)
            {
                maximo = false;
            }
        }
    
    
    return maximo;
    
    }


}
