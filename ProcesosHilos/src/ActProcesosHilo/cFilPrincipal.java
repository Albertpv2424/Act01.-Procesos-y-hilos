package ActProcesosHilo;

import java.util.Scanner;

import ActProcesosHilo.cFil;

public class cFilPrincipal {

  public static void main (String [] pArguments) {

	  Scanner sc = new Scanner(System.in);
	  
	  int numHijos = 0;

	  System.out.println("Fil principal iniciat.");

	  // Pedimos al usuario cuántos procesos hijos quiere crear (pedimos 10 como el numero maximo y 1 como el minimo)
	  System.out.print("Introduce el número de procesos hijos (max 10): ");
	  numHijos = sc.nextInt();

	  // Limitamos el número de hijos a un máximo de 10 / Si es mas de 10 le pondremos 10 si es mas pequeño que 1 en 1
	  if (numHijos > 10) {
		  System.out.println("Número fuera del rango, se establecerá en 10.");
		  numHijos = 10;
	  } else if (numHijos < 1) {
		  System.out.println("Número fuera del rango, se establecerá en 1.");
		  numHijos = 1;
	  }

	  // Creamos un array para almacenar los hilos hijos que iremos creando
	  Thread[] hilosHijos = new Thread[numHijos];

	  // Creamos y arrancamos cada hilo hijo con el bucle
	  for (int i = 0; i < numHijos; i++) {

		  // Creamos un objeto cFil con nombre +1
		  cFil hijo = new cFil("#" + (i + 1));

		  // Asignamos una temporización diferente a cada hijo de rapido a lento llamando a la funcion del hijo cfil
		  hijo.sTemporitzacio(100 * (i + 1));

		  // Creamos el hilo cada vez que pase el bucle
		  Thread hilo = new Thread(hijo);

		  // Guardamos los hilos en el array que hemos creado
		  hilosHijos[i] = hilo;

		  // Iniciamos el hilo una vez acabada la creacion de
		  hilo.start();
	  }

	  System.out.println("Todos los hijos han sido iniciados.");

	  // Ahora el padre espera a que todos los hijos terminen pera poder ser ejecutado
	  for (int i = 0; i < hilosHijos.length; i++) {
		    try {
		        hilosHijos[i].join(); // El padre espera a cada hijo 
		    } catch (InterruptedException e) { //Si no es asi lo interrumpe y myestra mensaje
		        System.out.println("Proceso principal interrumpido mientras esperaba a un hijo");
		    }
		}
	  
	  System . out . println ("Iniciant execució procés principal");

	  try { //Bucle proceso ppal, y cuando se despierta manda mensaje

		  for (int vComptador = 0; vComptador < 10; vComptador ++) {

			  Thread . sleep (500);

			  System . out . println ("Despertant aturada " + vComptador + " procès principal");

		  }

	  }

	  catch (InterruptedException pExcepcio) {

		  System . out . println ("Interrompent execució procès principal");

	  }

	  System . out . println ("Acabant execució procès principal");

  }

}
