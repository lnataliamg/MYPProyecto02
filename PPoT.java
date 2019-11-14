/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */

import java.util.Scanner;

public class PPoT extends Minijuego{

    //Personaje p1;
    //Personaje p2;

    //int ganador;
    //int turnoP1;
    //int turnoP2;
    public PPoT(Jugador jugador1, Jugador jugador2){
      super(jugador1, jugador2);
    }
    public String getNombreJuego(){
      return "Piedra, papel o tijera";
    }


    public void ejecutarJuego(){
        System.out.println("!Hora de Minijuego¡");
        System.out.println("!Turno De jugar¡\n!Piedra, Papel o Tijeras¡");
        System.out.println("El mejor de 3 rondas\nReglas");
        System.out.println("Ingrese el numero correspondiente a lo que desea tirar.");
        System.out.println("1. Piedra\n2. Papel\n3. Tijeras");


        int turnoP1;
        int turnoP2;
        int ganador = 0;
        int winsP1 = 0;
        int winsP2 = 0;

        Scanner sc = new Scanner(System.in);

        do{
            if(ganador == 3){
                System.out.println("Empate, Tiren de nuevo");
            }


            System.out.println("Ronda 1");

            System.out.println("Turno del Jugador 1: "+jugador1.getName()+" \nIngresa el numero:");
            turnoP1 = sc.nextInt();

            System.out.println("Turno del Jugador 2: "+jugador2.getName()+" \nIngresa el numero:");
            turnoP2 = sc.nextInt();

            if((turnoP1 == 1 || turnoP1 == 2 || turnoP1 == 3) && (turnoP2 == 1 || turnoP2 == 2 || turnoP2 == 3)){

            switch(turnoP1){
                case 1: //Piedra
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 3; //Donde 3 es empate
                        break;

                        case 2: //Papel
                            ganador = 2; //Donde 2 es que ganó P2
                        break;

                        case 3: //Tijeras
                            ganador = 1; //Donde 1 es que ganó P1
                        break;
                    }
                break;

                case 2: //Papel
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 1; //Donde 1 es que ganó P1
                        break;

                        case 2: //Papel
                            ganador = 3; //Donde 3 es empate
                        break;

                        case 3: //Tijeras
                            ganador = 2; //Donde 2 es que ganó P2
                        break;
                    }
                break;

                case 3: //Tijeras
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 2; //Donde 2 es que ganó P2
                        break;

                        case 2: //Papel
                            ganador = 1; //Donde 1 es que ganó P1
                        break;

                        case 3: //Tijeras
                            ganador = 3; //Donde 3 es empate
                        break;
                    }
                break;
            }

            if (ganador == 1)
                winsP1++;

            if (ganador == 2)
                winsP2++;
        }else{
                System.out.println("Valor no válido");
            }

        }while (ganador != 1 && ganador != 2 );


        do{
            if(ganador == 3){
                System.out.println("Empate, Tiren de nuevo.");
            }

            System.out.println("Ronda 2");

            System.out.println("Turno del Jugador 1: "+jugador1.getName()+"\nIngresa el numero:");
            turnoP1 = sc.nextInt();

            System.out.println("Turno del Jugador 2: "+jugador2.getName()+"\nIngresa el numero:");
            turnoP2 = sc.nextInt();

            if((turnoP1 == 1 || turnoP1 == 2 || turnoP1 == 3) && (turnoP2 == 1 || turnoP2 == 2 || turnoP2 == 3)){

            switch(turnoP1){
                case 1: //Piedra
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 3; //Donde 3 es empate
                        break;

                        case 2: //Papel
                            ganador = 2; //Donde 2 es que ganó P2
                        break;

                        case 3: //Tijeras
                            ganador = 1; //Donde 1 es que ganó P1
                        break;
                    }
                break;

                case 2: //Papel
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 1; //Donde 1 es que ganó P1
                        break;

                        case 2: //Papel
                            ganador = 3; //Donde 3 es empate
                        break;

                        case 3: //Tijeras
                            ganador = 2; //Donde 2 es que ganó P2
                        break;
                    }
                break;

                case 3: //Tijeras
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 2; //Donde 2 es que ganó P2
                        break;

                        case 2: //Papel
                            ganador = 1; //Donde 1 es que ganó P1
                        break;

                        case 3: //Tijeras
                            ganador = 3; //Donde 3 es empate
                        break;
                    }
                break;
            }

            if (ganador == 1)
                winsP1++;

            if (ganador == 2)
                winsP2++;
        }else{
                System.out.println("Valor no válido");
            }

        }while (ganador != 1 && ganador != 2 );

        do{
            if(ganador == 3){
                System.out.println("Empate, Tiren de nuevo");
            }

            System.out.println("Ronda 3");

            System.out.println("Turno del Jugador 1: "+jugador1.getName()+"\nIngresa el numero:");
            turnoP1 = sc.nextInt();

            System.out.println("Turno del Jugador 2: "+jugador2.getName()+"\nIngresa el numero:");
            turnoP2 = sc.nextInt();

            if((turnoP1 == 1 || turnoP1 == 2 || turnoP1 == 3) && (turnoP2 == 1 || turnoP2 == 2 || turnoP2 == 3)){

            switch(turnoP1){
                case 1: //Piedra
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 3; //Donde 3 es empate
                        break;

                        case 2: //Papel
                            ganador = 2; //Donde 2 es que ganó P2
                        break;

                        case 3: //Tijeras
                            ganador = 1; //Donde 1 es que ganó P1
                        break;
                    }
                break;

                case 2: //Papel
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 1; //Donde 1 es que ganó P1
                        break;

                        case 2: //Papel
                            ganador = 3; //Donde 3 es empate
                        break;

                        case 3: //Tijeras
                            ganador = 2; //Donde 2 es que ganó P2
                        break;
                    }
                break;

                case 3: //Tijeras
                    switch(turnoP2){
                        case 1: //Piedra
                            ganador = 2; //Donde 2 es que ganó P2
                        break;

                        case 2: //Papel
                            ganador = 1; //Donde 1 es que ganó P1
                        break;

                        case 3: //Tijeras
                            ganador = 3; //Donde 3 es empate
                        break;
                    }
                break;
            }

            if (ganador == 1)
                winsP1++;

            if (ganador == 2)
                winsP2++;
        }else{
                System.out.println("Valor no válido");
            }

        }while (ganador != 1 && ganador != 2 );

        if(winsP1 > winsP2)
            System.out.println("¡Ganador "+jugador1.getName()+"!");

        if(winsP2 > winsP1)
            System.out.println("¡Ganador "+jugador2.getName()+"!");
    }
}
