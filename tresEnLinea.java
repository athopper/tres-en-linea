/*
 by AtHopper
 */
import java.util.Scanner;
public class tresEnLinea{
	public static void main( String[]  args){
  
	Scanner cap_teclado = new Scanner(System.in);
	Boolean turno = false;
	Boolean ganador = false;
	String simbolo = " ";
	int contador = 0;
	
	String n1 = "1";	
	String n2 = "2";
	String n3 = "3";
	String n4 = "4";
	String n5 = "5";
	String n6 = "6";
	String n7 = "7";
	String n8 = "8";
	String n9 = "9";
	String reset = "\u001B[0m";
  String rojo = "\u001B[31m";
  String verde = "\u001B[32m";
  String amarillo = "\u001B[33m";
  String laO = amarillo + "O" + reset;
	String laX = rojo + "X" + reset;


	ronda(rojo,verde,reset,laX,laO,contador,simbolo,ganador,turno,cap_teclado,n1,n2,n3,n4,n5,n6,n7,n8,n9);
	
	System.out.println("\n");

	}
	public static void llenarTablero(String n1, String n2, String n3, String n4, String n5, String n6, String n7,String n8,String n9){
	
		//vamos pintando el tablero con los valores de las variables
		System.out.print("\n "+ n1 +" | "+ n2 +" | "+ n3 +"\n");
		System.out.print("-----------\n");
		System.out.print(" "+ n4 +" | "+ n5 +" | "+ n6 +" \n");
		System.out.print("-----------\n");
		System.out.print(" "+ n7 +" | "+ n8 + " | " + n9 +" \n");
	}

	public static void ronda(String rojo, String verde, String reset, String laO, String laX, int contador, String simbolo, boolean ganador, boolean turno, Scanner cap_teclado, String n1, String n2, String n3, String n4, String n5, String n6, String n7,String n8,String n9){
		//mientras no tengamos ganador y el contador no sea 9
		//permanecemos en el bucle del juego
		while ( ganador == false || contador < 9 ){
		
		String ocupado = rojo + "Ya esta ocupado" + reset;
		llenarTablero(n1,n2,n3,n4,n5,n6,n7,n8,n9);
 		simbolo = miTurno(turno,laX,laO);
		System.out.println("El turno es de : " + simbolo);
		System.out.print("Que posicion quieres ocupar: ");
		//capturamos la opcion por teclado
		int jugada = cap_teclado.nextInt();
		
				
				//contemplamos las ociones libres de tablero
				//y vamos aumentando el contador
				switch (jugada){
					case 1:
					 if (n1 == "1"){
					  n1 = simbolo;
					  contador ++;
					 
					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }

					case 2: 
					 if (n2 == "2"){
					  n2 = simbolo;
					  contador ++;
					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 3:
					 if (n3 == "3"){
					  n3 = simbolo;
					  contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 4:
					 if (n4 == "4"){
					  n4 = simbolo;
					  contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 5: 
					 if (n5 == "5"){
					  n5 = simbolo;
					  contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 6:
					 if (n6 == "6"){
					  n6 = simbolo;
					 contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 7:
					 if (n7 == "7"){
					  n7 = simbolo;
					  contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 8:
					 if (n8 == "8"){
					  n8 = simbolo;
					  contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
					case 9:
					 if (n9 == "9"){
					  n9 = simbolo;
					  contador ++;

					 break;
					 }else{
					  System.out.println(ocupado);
					  turno = !turno; 
					 break;
					 }
				}
				//dependiendo de si se consumen las rondas o gana un jugador lo anunciamos
				ganador = verGanador(laX,laO,n1,n2,n3,n4,n5,n6,n7,n8,n9);

				 if (ganador == true){
				 System.out.print( "\n---------------------------"); 
				 System.out.print( verde + "\n TENEMOS UN GANADOR !!! " + reset + simbolo);
				 System.out.print( "\n---------------------------");
				 llenarTablero(n1,n2,n3,n4,n5,n6,n7,n8,n9);
				 break;
				 }else if( contador == 9){
				 System.out.print(rojo + "\n NO HA GANADO NADIE.... :( " + reset);
				 llenarTablero(n1,n2,n3,n4,n5,n6,n7,n8,n9);
				 break;
				 }
				 //negamos el turno y asi alternamos entre X y O
				

				 turno = !turno;
			}
		
	}
	public static String miTurno(boolean turno, String laX, String laO){
	//alternamos los turnos
		
		return turno ? laO : laX;
		
	}
	


	public static boolean verGanador(String laX, String laO, String n1, String n2, String n3, String n4, String n5, String n6, String n7,String n8, String n9){
			
			            //ver si la x gana
		      return(n1 == laX && n2 == laX && n3 == laX) ||
			        (n4 == laX && n5 == laX && n6 == laX) ||
                 	(n7 == laX && n8 == laX && n9 == laX) ||
                  	(n1 == laX && n4 == laX && n7 == laX) ||
                 	(n2 == laX && n5 == laX && n8 == laX) ||
                 	(n3 == laX && n6 == laX && n9 == laX) ||
                 	(n1 == laX && n5 == laX && n9 == laX) ||
              		(n3 == laX && n5 == laX && n7 == laX) ||
			            //ver si la O gana
			        (n1 == laO && n2 == laO && n3 == laO) ||
			        (n4 == laO && n5 == laO && n6 == laO) ||
               		(n7 == laO && n8 == laO && n9 == laO) ||
               		(n1 == laO && n4 == laO && n7 == laO) ||
               		(n2 == laO && n5 == laO && n8 == laO) ||
               		(n3 == laO && n6 == laO && n9 == laO) ||
               		(n1 == laO && n5 == laO && n9 == laO) ||
               		(n3 == laO && n5 == laO && n7 == laO);


		
          } 

}

