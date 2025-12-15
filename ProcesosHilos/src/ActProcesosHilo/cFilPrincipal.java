package ActProcesosHilo;

import ActProcesosHilo.cFil;

public class cFilPrincipal {

  public static void main (String [] pArguments) {

    System . out . println ("Fil principal iniciat.");
    System . out . println ("Fil secundari iniciat.");

    cFil vObjecteFil = new cFil ("#1");
    vObjecteFil.sTemporitzacio(1000); //Llamamos a sTemporitzacio de cFil para decelerar el proceso hijo

    //alternativa: innecessari
    Thread vFil = new Thread (vObjecteFil); //Crea el hilo principal a partir del objeto cFil

    //alternativa: vObjecteFil
    vFil . start (); //Ejecutamos el hilo secundario

    try { //Usamos un try catch para que el padre espere al hijo que termine su ejecucion. (Padre se queda parado)
		vFil.join(); // El padre ahora se va a esperar a que el hijo termine lo suyo. (hace que el hilo que llama (el padre) se bloquee hasta que vFil (el hijo) termine su run()  )
		} 
    catch (InterruptedException e) { //Si alguien interrumpe al padre, lanza la excepcion
    	System.out.println("Proceso princippal interrumpido mientras estaba esperando al hijo"); 
    
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
