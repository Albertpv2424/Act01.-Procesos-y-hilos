package ActProcesosHilo;

import ActProcesosHilo.cFil;

public class cFilPrincipal {

  public static void main (String [] pArguments) {

    System . out . println ("Fil principal iniciat.");
    System . out . println ("Fil secundari iniciat.");

    cFil vObjecteFil = new cFil ("#1");
    vObjecteFil.sTemporitzacio(100); //Llamamos a sTemporitzacio de cFil para acelerar el proceso

    //alternativa: innecessari
    Thread vFil = new Thread (vObjecteFil); //Crea el hilo principal a partir del objeto cFil

    //alternativa: vObjecteFil
    vFil . start (); //Ejecutamos el hilo secundario

    System . out . println ("Iniciant execució procés principal");

    try { //Bucle proceso mas lento, y cuando se despierta manda mensaje

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
