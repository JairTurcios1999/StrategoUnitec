
package stratego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Logica_Tablero {

//VARIABLES GLOBALES
    boolean AsignaciondeLugares = true;
    boolean TurnoHeroe = true;
    int ContadorSeleccion = 0;
int GanadorPorBandera = 0;
    Personaje[][] MatrizTablero;
    Personaje[][] MatrizHeroe;
    Personaje[][] MatrizVillano;

    int seleccionX;
    int seleccionY;

    int seleccionHeroeX = -1;
    int seleccionHeroeY = -1;

    Dimension CoordTablero_Viejas = new Dimension(-1, -1);

    // boolean turnoHeroe = true;
    //CONSTRUCTOR
    public Logica_Tablero() {

        String NombresPersonajes[] = {"Black Widow", "Night Crawler", "Elektra", "Storm", "Dr Strange", "Elena", "Gambit", "SpiderGirl", "Iceman", "Emma Frost",
            "She Hulk", "Coloso", "Antman", "Bestia", "Mole", "Punisher", "Blade", "Ghost Rider", "Antorcha Humana", "Mujer Invisible",
            "Cyclops", "Thor", "Ironman", "Hulk", "Silver Surfer", "Daredevil", "Namor", "Aguja Dinamica", "Spiderman", "Nick el Furioso",
            "Profesor X", "Capitan America", "Mr Fantastic", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "PLANETA"};
        
        
        
        
          String NombresPersonajesVillanos[] = {"Espia", "Centinela", "Centinela", "Ultron", "Morbius (El Morboso)", "Sandman", "El Lider", "Poison", "Elektro (EHH)", "Rhino",
            "El Lagarto", "El Hombre Topo", "Jugernaut", "Carnage", "Black Cat", "Thanos", "Abominacion", "Craven", "Mystique", "Octopus",
            "Misterioso", "Deadpool (Batman)", "Wishplash", "Craneo Rojo", "OnSlaught", "Spot", "Apocalypse", "Duende Verde", "Venom", "Kin Pin",
            "Magneto", "Galactus", "Doom", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "PLANETA"};

        //                   Altura Anchura
        MatrizTablero = new Personaje[10][10];
        MatrizHeroe = new Personaje[10][4];
        MatrizVillano = new Personaje[10][4];

        //ancho
        for (int i = 0; i < MatrizTablero.length; i++) {

            for (int j = 0; j < MatrizTablero[0].length; j++) {
                MatrizTablero[i][j] = null;
            }
        }

        MatrizTablero[4][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][3] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][3] = new Personaje(0, "Muro", -1, true);

        MatrizTablero[4][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][7] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][7] = new Personaje(0, "Muro", -1, true);

        //IMPRESION GENERAL
        System.out.println("===============TABLERO==================");
        for (int i = 0; i < MatrizTablero.length; i++) {

            for (int j = 0; j < MatrizTablero[0].length; j++) {

                if (MatrizTablero[i][j] == null) {
                    System.out.print("0");
                } else {
                    System.out.print(MatrizTablero[i][j].getRango());
                }

            }

            System.out.println();
        }

        int RangosBase[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int PersonajesBase[] = {1, 8, 5, 4, 4, 4, 3, 2, 1, 1, 6, 1};

        int Lugar = 0;
        int Completados = 0;
        int Personajes = 1;

        for (int i = 0; i < MatrizHeroe.length; i++) {

            for (int j = 0; j < MatrizHeroe[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }

                MatrizHeroe[i][j] = new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], true);
                Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }

            }
        }

        //IMPRESION Heroe
        System.out.println("===============Heroe==================");
        for (int i = 0; i < MatrizHeroe.length; i++) {

            for (int j = 0; j < MatrizHeroe[0].length; j++) {

                System.out.print(MatrizHeroe[i][j].getRango());
            }

            System.out.println();
        }
//Villano
        Lugar = 0;
        Completados = 0;
        Personajes = 1;
        for (int i = 0; i < MatrizVillano.length; i++) {

            for (int j = 0; j < MatrizVillano[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }

                MatrizVillano[i][j] = new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], false);
                Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }

            }
        }

        //IMPRESION Villano
        System.out.println("===============Villano==================");
        for (int i = 0; i < MatrizVillano.length; i++) {

            for (int j = 0; j < MatrizVillano[0].length; j++) {

                System.out.print(MatrizVillano[i][j].getRango());
            }

            System.out.println();
        }

    }// FIN CONSTRUCTOR

    public Logica_Tablero(boolean JuegodePrueba) {
        JuegodePrueba = true;
        AsignaciondeLugares = false;
        String NombresPersonajes[] = {"Black Widow", "Night Crawler", "Elektra", "Storm", "Dr Strange", "Elena", "Gambit", "SpiderGirl", "Iceman", "Emma Frost",
            "She Hulk", "Coloso", "Antman", "Bestia", "Mole", "Punisher", "Blade", "Ghost Rider", "Antorcha Humana", "Mujer Invisible",
            "Cyclops", "Thor", "Ironman", "Hulk", "Silver Surfer", "Daredevil", "Namor", "Aguja Dinamica", "Spiderman", "Nick el Furioso",
            "Profesor X", "Capitan America", "Mr Fantastic", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "PLANETA"};
        
        
        
        
          String NombresPersonajesVillanos[] = {"Espia", "Centinela", "Centinela", "Ultron", "Morbius (El Morboso)", "Sandman", "El Lider", "Poison", "Elektro (EHH)", "Rhino",
            "El Lagarto", "El Hombre Topo", "Jugernaut", "Carnage", "Black Cat", "Thanos", "Abominacion", "Craven", "Mystique", "Octopus",
            "Misterioso", "Deadpool (Batman)", "Wishplash", "Craneo Rojo", "OnSlaught", "Spot", "Apocalypse", "Duende Verde", "Venom", "Kin Pin",
            "Magneto", "Galactus", "Doom", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "BOMBA", "PLANETA"};

        //                   Altura Anchura
        MatrizTablero = new Personaje[10][10];
        MatrizHeroe = new Personaje[10][4];
        MatrizVillano = new Personaje[10][4];

        //ancho
        for (int i = 0; i < MatrizTablero.length; i++) {

            for (int j = 0; j < MatrizTablero[0].length; j++) {
                MatrizTablero[i][j] = null;

            }
        }

        MatrizTablero[4][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][2] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][3] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][3] = new Personaje(0, "Muro", -1, true);

        MatrizTablero[4][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][6] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[4][7] = new Personaje(0, "Muro", -1, true);
        MatrizTablero[5][7] = new Personaje(0, "Muro", -1, true);

        //IMPRESION GENERAL
        System.out.println("===============TABLERO==================");
        for (int i = 0; i < MatrizTablero.length; i++) {

            for (int j = 0; j < MatrizTablero[0].length; j++) {

                if (MatrizTablero[i][j] == null) {

                    System.out.print("0");

                } else {
                    System.out.print(MatrizTablero[i][j].getRango());
                }

            }

            System.out.println();
        }

        int RangosBase[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int PersonajesBase[] = {1, 8, 5, 4, 4, 4, 3, 2, 1, 1, 6, 1};

        int Lugar = 0;
        int Completados = 0;
        int Personajes = 1;

             ArrayList<Personaje> ListadeHeroes = new   ArrayList<Personaje>();
        
        for (int i = 0; i < MatrizHeroe.length; i++) {

            for (int j = 0; j < MatrizHeroe[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }

                
                MatrizHeroe[i][j] = new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], true);
                 ListadeHeroes.add(new Personaje(Personajes, NombresPersonajes[Personajes - 1], RangosBase[Lugar], true));
                 
                 
             //   MatrizHeroe[i][j].setVivo(false);
                
                  
                  Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }

            }
        }

        //IMPRESION Heroe
        System.out.println("===============Heroe==================");
        for (int i = 0; i < MatrizHeroe.length; i++) {

            for (int j = 0; j < MatrizHeroe[0].length; j++) {

                System.out.print(MatrizHeroe[i][j].getID());
            }

            System.out.println();
        }
//Villano
        Lugar = 0;
        Completados = 0;
        Personajes = 1;
        
                 ArrayList<Personaje> ListadeVillanos = new   ArrayList<Personaje>();
        
        for (int i = 0; i < MatrizVillano.length; i++) {

            for (int j = 0; j < MatrizVillano[0].length; j++) {
                if (Completados == 0) {
                    Completados = PersonajesBase[Lugar];
                }

                MatrizVillano[i][j] = new Personaje(Personajes, NombresPersonajesVillanos[Personajes - 1], RangosBase[Lugar], false);
                  ListadeVillanos.add(new Personaje(Personajes, NombresPersonajesVillanos[Personajes - 1], RangosBase[Lugar], false));
                
             //   MatrizVillano[i][j].setVivo(false);
                Completados--;
                Personajes++;
                if (Completados == 0) {
                    Lugar++;
                }

            }
        }

        //IMPRESION Villano
        System.out.println("===============Villano==================");
        for (int i = 0; i < MatrizVillano.length; i++) {

            for (int j = 0; j < MatrizVillano[0].length; j++) {

                System.out.print(MatrizVillano[i][j].getID());
            }

            System.out.println();
        }

        
    
        
        
        
        
        
        
        
        
        
        
        
        System.out.println("========GENERACION RANDOM=======");
     
              LinkedHashSet<Integer> PosicionesHeroe = new LinkedHashSet<Integer>();
         Random randNum = new Random();

        for (int i = 0; i < 40; i++) {

            if (i == 0) {
  PosicionesHeroe.add(randNum.nextInt(39 - 32) + 32);
                
            } else if (i <= 3 && i >= 1) {
while(PosicionesHeroe.size() < 4){
             Integer[] LHSArray = new Integer[PosicionesHeroe.size()];
        LHSArray = PosicionesHeroe.toArray(LHSArray);
                    
                    
                    
                     PosicionesHeroe.add((LHSArray[0])+1);
                        PosicionesHeroe.add((LHSArray[0])-1);
                              PosicionesHeroe.add((LHSArray[0])-10);
                
}
           } else if (i <= 6 && i >= 4) {
                while(PosicionesHeroe.size() < 7){
                  PosicionesHeroe.add(randNum.nextInt(40 - 21) + 21);
                } 

            } else if (i <= 14 && i >= 7) {
                System.out.println("Aa");
  while(PosicionesHeroe.size() < 15){
                 PosicionesHeroe.add(randNum.nextInt(20 - 1) + 1);
                 } 
            }else{
                     while (PosicionesHeroe.size() != 40) {
                         int Temporal = randNum.nextInt(40-1)+1;
         PosicionesHeroe.add(Temporal);
         if(Temporal==37){
              PosicionesHeroe.add(40);
         }
                     }
                     
            } 

        }

        System.out.println(PosicionesHeroe);
        
        
              Integer[] Posiciones = new Integer[PosicionesHeroe.size()];
        Posiciones = PosicionesHeroe.toArray(Posiciones);
        
        AsignarLugar(Posiciones, 0, ListadeHeroes, 39, false);
        
        for(int i = 1; i <= 6; i++){
            AsignarLugar(Posiciones, i, ListadeHeroes, 39-i, false);
        }
         
        
        for(int i = 7; i <= 14; i++){
            AsignarLugar(Posiciones, i, ListadeHeroes, 1+(i-7), false);
        }
          AsignarLugar(Posiciones, 15, ListadeHeroes, 0, false);
          
         for(int i = 16; i < 40; i++){
               AsignarLugar(Posiciones, i, ListadeHeroes, 9+(i-16), false);
         }
      
//RANDOM VILLANO

     LinkedHashSet<Integer> PosicionesVillano = new LinkedHashSet<Integer>();
         Random randNumV = new Random();

        for (int i = 0; i < 40; i++) {

            if (i == 0) {
  PosicionesVillano.add(randNum.nextInt(39 - 32) + 32);
                
            } else if (i <= 3 && i >= 1) {
while(PosicionesVillano.size() < 4){
             Integer[] LHSArray = new Integer[PosicionesVillano.size()];
        LHSArray = PosicionesVillano.toArray(LHSArray);
                    
                    
                    
                     PosicionesVillano.add((LHSArray[0])+1);
                        PosicionesVillano.add((LHSArray[0])-1);
                              PosicionesVillano.add((LHSArray[0])-10);
                
}
           } else if (i <= 6 && i >= 4) {
                while(PosicionesVillano.size() < 7){
                  PosicionesVillano.add(randNum.nextInt(40 - 21) + 21);
                } 

            } else if (i <= 14 && i >= 7) {
              
  while(PosicionesVillano.size() < 15){
                 PosicionesVillano.add(randNum.nextInt(20 - 1) + 1);
                 } 
            }else{
                     while (PosicionesVillano.size() != 40) {
                         int Temporal = randNum.nextInt(40-1)+1;
         PosicionesVillano.add(Temporal);
         if(Temporal==37){
              PosicionesVillano.add(40);
         }
                     }
                     
            } 

        }
        
        
          Integer[] PosicionesV = new Integer[PosicionesVillano.size()];
        Posiciones = PosicionesVillano.toArray(PosicionesV);
        
        AsignarLugar(PosicionesV, 0, ListadeVillanos, 39, true);
        
        for(int i = 1; i <= 6; i++){
            AsignarLugar(PosicionesV, i, ListadeVillanos, 39-i, true);
        }
         
        
        for(int i = 7; i <= 14; i++){
            AsignarLugar(PosicionesV, i, ListadeVillanos, 1+(i-7), true);
        }
          AsignarLugar(PosicionesV, 15, ListadeVillanos, 0, true);
          
         for(int i = 16; i < 40; i++){
               AsignarLugar(PosicionesV, i, ListadeVillanos, 9+(i-16), true);
         }
        
        
    }//CONST

    
    public void AsignarLugar( Integer[]  Posiciones, int i, ArrayList<Personaje> ListaPersonajes, int lugar, boolean EsVillano){
       
        if(EsVillano){
            switch (Posiciones[i]) {
    case 1:
   this.MatrizTablero[3][0] = ListaPersonajes.get(lugar);
        break;
    case 2:
         this.MatrizTablero[3][1] = ListaPersonajes.get(lugar);
        break;
    case 3:
           this.MatrizTablero[3][2] = ListaPersonajes.get(lugar);
        break;
    case 4:
        this.MatrizTablero[3][3] = ListaPersonajes.get(lugar);
        break;
    case 5:
     this.MatrizTablero[3][4] = ListaPersonajes.get(lugar);
        break;
    case 6:
        this.MatrizTablero[3][5] = ListaPersonajes.get(lugar);
        break;
    case 7:
          this.MatrizTablero[3][6] = ListaPersonajes.get(lugar);
        break;
    case 8:
          this.MatrizTablero[3][7] = ListaPersonajes.get(lugar);
        break;
    case 9:
         this.MatrizTablero[3][8] = ListaPersonajes.get(lugar);
        break;
    case 10:
         this.MatrizTablero[3][9] = ListaPersonajes.get(lugar);
        break;
    case 11:
      this.MatrizTablero[2][0] = ListaPersonajes.get(lugar);
        break;
    case 12:
         this.MatrizTablero[2][1] = ListaPersonajes.get(lugar);
        break;
    case 13:
        this.MatrizTablero[2][2] = ListaPersonajes.get(lugar);
        break;
    case 14:
        this.MatrizTablero[2][3] = ListaPersonajes.get(lugar);
        break;
    case 15:
     this.MatrizTablero[2][4] = ListaPersonajes.get(lugar);
        break;
    case 16:
         this.MatrizTablero[2][5] = ListaPersonajes.get(lugar);
        break;
    case 17:
       this.MatrizTablero[2][6] = ListaPersonajes.get(lugar);
        break;
    case 18:
          this.MatrizTablero[2][7] = ListaPersonajes.get(lugar);
        break;
    case 19:
         this.MatrizTablero[2][8] = ListaPersonajes.get(lugar);
        break;
    case 20:
          this.MatrizTablero[2][9] = ListaPersonajes.get(lugar);
        break;
    case 21:
       this.MatrizTablero[1][0] = ListaPersonajes.get(lugar);
        break;
    case 22:
         this.MatrizTablero[1][1] = ListaPersonajes.get(lugar);
        break;
    case 23:
         this.MatrizTablero[1][2] = ListaPersonajes.get(lugar);
        break;
    case 24:
         this.MatrizTablero[1][3] = ListaPersonajes.get(lugar);
        break;
    case 25:
         this.MatrizTablero[1][4] = ListaPersonajes.get(lugar);
        break;
    case 26:
         this.MatrizTablero[1][5] = ListaPersonajes.get(lugar);
        break;
    case 27:
          this.MatrizTablero[1][6] = ListaPersonajes.get(lugar);
        break;
    case 28:
         this.MatrizTablero[1][7] = ListaPersonajes.get(lugar);
        break;
    case 29:
        this.MatrizTablero[1][8] = ListaPersonajes.get(lugar);
        break;
    case 30:
        this.MatrizTablero[1][9] = ListaPersonajes.get(lugar);
        break;
    case 31:
            this.MatrizTablero[0][0] = ListaPersonajes.get(lugar);
        break;
    case 32:
            this.MatrizTablero[0][1] = ListaPersonajes.get(lugar);
        break;
    case 33:
          this.MatrizTablero[0][2] = ListaPersonajes.get(lugar);
        break;
    case 34:
            this.MatrizTablero[0][3] = ListaPersonajes.get(lugar);
        break;
    case 35:
           this.MatrizTablero[0][4] = ListaPersonajes.get(lugar);
        break;
    case 36:
            this.MatrizTablero[0][5] = ListaPersonajes.get(lugar);
        break;
    case 37:
           this.MatrizTablero[0][6] = ListaPersonajes.get(lugar);
        break;
    case 38:
            this.MatrizTablero[0][7] = ListaPersonajes.get(lugar);
        break;
    case 39:
           this.MatrizTablero[0][8] = ListaPersonajes.get(lugar);
        break;
    case 40:
           this.MatrizTablero[0][9] = ListaPersonajes.get(lugar);
        break;
   
}
        }else{
              switch (Posiciones[i]) {
    case 1:
   this.MatrizTablero[6][0] = ListaPersonajes.get(lugar);
        break;
    case 2:
         this.MatrizTablero[6][1] = ListaPersonajes.get(lugar);
        break;
    case 3:
           this.MatrizTablero[6][2] = ListaPersonajes.get(lugar);
        break;
    case 4:
        this.MatrizTablero[6][3] = ListaPersonajes.get(lugar);
        break;
    case 5:
     this.MatrizTablero[6][4] = ListaPersonajes.get(lugar);
        break;
    case 6:
        this.MatrizTablero[6][5] = ListaPersonajes.get(lugar);
        break;
    case 7:
          this.MatrizTablero[6][6] = ListaPersonajes.get(lugar);
        break;
    case 8:
          this.MatrizTablero[6][7] = ListaPersonajes.get(lugar);
        break;
    case 9:
         this.MatrizTablero[6][8] = ListaPersonajes.get(lugar);
        break;
    case 10:
         this.MatrizTablero[6][9] = ListaPersonajes.get(lugar);
        break;
    case 11:
      this.MatrizTablero[7][0] = ListaPersonajes.get(lugar);
        break;
    case 12:
         this.MatrizTablero[7][1] = ListaPersonajes.get(lugar);
        break;
    case 13:
        this.MatrizTablero[7][2] = ListaPersonajes.get(lugar);
        break;
    case 14:
        this.MatrizTablero[7][3] = ListaPersonajes.get(lugar);
        break;
    case 15:
     this.MatrizTablero[7][4] = ListaPersonajes.get(lugar);
        break;
    case 16:
         this.MatrizTablero[7][5] = ListaPersonajes.get(lugar);
        break;
    case 17:
       this.MatrizTablero[7][6] = ListaPersonajes.get(lugar);
        break;
    case 18:
          this.MatrizTablero[7][7] = ListaPersonajes.get(lugar);
        break;
    case 19:
         this.MatrizTablero[7][8] = ListaPersonajes.get(lugar);
        break;
    case 20:
          this.MatrizTablero[7][9] = ListaPersonajes.get(lugar);
        break;
    case 21:
       this.MatrizTablero[8][0] = ListaPersonajes.get(lugar);
        break;
    case 22:
         this.MatrizTablero[8][1] = ListaPersonajes.get(lugar);
        break;
    case 23:
         this.MatrizTablero[8][2] = ListaPersonajes.get(lugar);
        break;
    case 24:
         this.MatrizTablero[8][3] = ListaPersonajes.get(lugar);
        break;
    case 25:
         this.MatrizTablero[8][4] = ListaPersonajes.get(lugar);
        break;
    case 26:
         this.MatrizTablero[8][5] = ListaPersonajes.get(lugar);
        break;
    case 27:
          this.MatrizTablero[8][6] = ListaPersonajes.get(lugar);
        break;
    case 28:
         this.MatrizTablero[8][7] = ListaPersonajes.get(lugar);
        break;
    case 29:
        this.MatrizTablero[8][8] = ListaPersonajes.get(lugar);
        break;
    case 30:
        this.MatrizTablero[8][9] = ListaPersonajes.get(lugar);
        break;
    case 31:
            this.MatrizTablero[9][0] = ListaPersonajes.get(lugar);
        break;
    case 32:
            this.MatrizTablero[9][1] = ListaPersonajes.get(lugar);
        break;
    case 33:
          this.MatrizTablero[9][2] = ListaPersonajes.get(lugar);
        break;
    case 34:
            this.MatrizTablero[9][3] = ListaPersonajes.get(lugar);
        break;
    case 35:
           this.MatrizTablero[9][4] = ListaPersonajes.get(lugar);
        break;
    case 36:
            this.MatrizTablero[9][5] = ListaPersonajes.get(lugar);
        break;
    case 37:
           this.MatrizTablero[9][6] = ListaPersonajes.get(lugar);
        break;
    case 38:
            this.MatrizTablero[9][7] = ListaPersonajes.get(lugar);
        break;
    case 39:
           this.MatrizTablero[9][8] = ListaPersonajes.get(lugar);
        break;
    case 40:
           this.MatrizTablero[9][9] = ListaPersonajes.get(lugar);
        break;
   
}
        }
       
    }
    
    
    
    //------------------------GETS SETS-----------------------------------
    public Personaje[][] getMatrizTablero() {
        return this.MatrizTablero;
    }

    public Personaje[][] getMatrizHeroe() {
        return MatrizHeroe;
    }

    public Personaje[][] getMatrizVillano() {
        return MatrizVillano;
    }

    public int getGanadorPorBandera() {
        return GanadorPorBandera;
    }
    
    

    public boolean isTurnoHeroe() {
        return TurnoHeroe;
    }

    public void setMatrizTablero(Personaje[][] MatrizTablero) {
        this.MatrizTablero = MatrizTablero;
    }

    public void setMatrizHeroe(Personaje[][] MatrizHeroe) {
        this.MatrizHeroe = MatrizHeroe;
    }

    public void setMatrizVillano(Personaje[][] MatrizVillano) {
        this.MatrizVillano = MatrizVillano;
    }

    public void setTurnoHeroe(boolean TurnoHeroe) {
        this.TurnoHeroe = TurnoHeroe;
    }

    public void setGanadorPorBandera(int GanadorPorBandera) {
        this.GanadorPorBandera = GanadorPorBandera;
    }

    
    
    //-----------------------------------------------------------
    public boolean AunTieneNulos(int Posicion) {
        for (int i = 0; i < MatrizTablero.length; i++) {
            if (MatrizTablero[Posicion][i] == null) {
                return true;
            }
        }

        return false;
    }

    public boolean Movimiento(Dimension Tablero, Dimension CuadroHeroes, Dimension CuadroVillanos) {

        if (AsignaciondeLugares) {

            if (TurnoHeroe) {
                if ((CuadroHeroes.height != -1 && CuadroHeroes.width != -1)) {
                    System.out.println("Y: " + CuadroHeroes.height);
                    System.out.println("X: " + CuadroHeroes.width);

                    System.out.println("Y: " + Tablero.height);
                    System.out.println("AX: " + Tablero.width);
                    MatrizTablero[Tablero.height][Tablero.width] = MatrizHeroe[CuadroHeroes.height][CuadroHeroes.width];
                    MatrizHeroe[CuadroHeroes.height][CuadroHeroes.width].setVivo(true);
                    ContadorSeleccion++;
                    if (ContadorSeleccion == 40) {
                        TurnoHeroe = false;
                    }
                    System.out.println("SL: " + ContadorSeleccion);
                    return true;
                }
            } else {
                if (CuadroVillanos.height != -1 && CuadroVillanos.width != -1) {
                    System.out.println("Y: " + CuadroVillanos.height);
                    System.out.println("X: " + CuadroVillanos.width);

                    if (MatrizTablero[Tablero.height][Tablero.width] == null) {
                        MatrizTablero[Tablero.height][Tablero.width] = MatrizVillano[CuadroVillanos.height][CuadroVillanos.width];
                        MatrizVillano[CuadroVillanos.height][CuadroVillanos.width].setVivo(true);
                    }

                    ContadorSeleccion--;
                    if (ContadorSeleccion == 0) {
                        TurnoHeroe = true;
                        AsignaciondeLugares = false;
                    }
                    System.out.println("SL: " + ContadorSeleccion);
                    return true;
                }
            }
        } else {

            //  TurnoHeroe=!TurnoHeroe;
            //     return false;
            return Controlador_de_Movimientos(Tablero);
        }

        return false; // Si es cierto entonces se actualiza la matriz
    }

    public boolean Controlador_de_Movimientos(Dimension CoordenadasNuevas) {
try{
        if (CoordTablero_Viejas.width == -1 && CoordTablero_Viejas.height == -1) {
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] == null) { // no selecciono

                JOptionPane.showMessageDialog(null, "Debes Seleccionar a Un player");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }

            //si es bomba
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 11) {
                JOptionPane.showMessageDialog(null, "Las bombas no pueden moverse");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            //si es bandera
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 12) {
                JOptionPane.showMessageDialog(null, "Los planetas no pueden moverse");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }
            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 41) {
                JOptionPane.showMessageDialog(null, "Zona Prohibida");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }

            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano() != this.TurnoHeroe) {
                JOptionPane.showMessageDialog(null, "Error no es su turno");
                CoordTablero_Viejas = new Dimension(-1, -1);
                return false;
            }

            //JOptionPane.showMessageDialog(null, "Primer Movimiento");
            CoordTablero_Viejas = new Dimension(CoordenadasNuevas.width, CoordenadasNuevas.height);
            return false;
        } else {

            if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] != null) { // Selecciono Pero choca o ZONA PROHIBIDA
                if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == -1) {
                    JOptionPane.showMessageDialog(null, "Zona Prohibida");
                    CoordTablero_Viejas = new Dimension(-1, -1);
                    return false;
                } else if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano() != TurnoHeroe) {

                    // CoordTablero_Viejas = new Dimension(-1,-1);
                    if(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango()==2){
                    //     JOptionPane.showMessageDialog(null, "Combate" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano());

                        int reply = JOptionPane.showConfirmDialog(null, "Deseas Combatir?", "Combate", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {

                            return Combates(CoordenadasNuevas);
                    }}else
                    if ((CoordenadasNuevas.height == CoordTablero_Viejas.height + 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height - 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width +1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width -1)
                            
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                            
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                               || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            
                            ) {
                        //SE COMBATE

                  //      JOptionPane.showMessageDialog(null, "Combate" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano());

                        int reply = JOptionPane.showConfirmDialog(null, "Deseas Combatir?", "Combate", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {

                            return Combates(CoordenadasNuevas);
                        } else {
                            return false;
                        }
                        
                        
                        

                    } else {

                        JOptionPane.showMessageDialog(null, "No se puede combate" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano());

                        return false;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El lugar esta ocupado");
                    CoordTablero_Viejas = new Dimension(-1, -1);
                    return false;
                }

            }

          //  JOptionPane.showMessageDialog(null, "Segundo Movimiento");

            if (movimientos_porFicha(CoordenadasNuevas)) {

                //SE MOVIO
                MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
                MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
                setTurnoHeroe(!this.TurnoHeroe);

                String Turno = "";
                if (TurnoHeroe) {
                    Turno = "HEROE";
                } else {
                    Turno = "VILLANO";
                }
                JOptionPane.showMessageDialog(null, "TURNO DE: " + Turno);

                CoordTablero_Viejas = new Dimension(-1, -1);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Movimieno no valido");
            }

        }

        return false;
}catch(Exception e){
    System.out.println("Error, no hubo seleccion anterior, o se selecciono un lugar nulo");
    return false;
}
    }
//determina si = true o no = false se mueve a la matriz

    public boolean movimientos_porFicha(Dimension CoordenadasNuevas) {

        if (CoordenadasNuevas.height != CoordTablero_Viejas.height && CoordenadasNuevas.width != CoordTablero_Viejas.width) {
            return false;
        } 
           
        if( MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango()!=2){
           
              if ((CoordenadasNuevas.height == CoordTablero_Viejas.height + 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height - 1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width +1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width -1)
                            
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                            
                            || (CoordenadasNuevas.height == CoordTablero_Viejas.height+1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width-1)
                               || (CoordenadasNuevas.height == CoordTablero_Viejas.height-1
                            && CoordenadasNuevas.width == CoordTablero_Viejas.width+1)
                            
                            ) {
              return true;
              }
            
            return false;
        }
        
return true;
        // return false;
    }

    public boolean Combates(Dimension CoordenadasNuevas) {

        //CREAR AQUI UN TRY CATCH SI ES NULL
        /*
    Las piezas con RANGO 3, son las UNICAS que pueden destruir las piezas bombas (NOVA BLAST o PUMPKIN BOMB)
 Las piezas con RANGO 2 se pueden mover (como la torre en el ajedrez) X cantidad de espacios vacíos de manera ortogonal. Se pueden quedar en una posición vacía o atacar directamente a un oponente.
 Las piezas con RANGO 1 pueden ser derrotados por cualquiera, PERO, si ellos atacan pueden destruir a las piezas RANGO 10 o salvar la Tierra!
 Las piezas bombas NO se pueden mover y destruyen a todas las piezas que las ataca EXCEPTO las de RANGO 3.
 Las piezas TIERRA NO se pueden mover y el que la capture gana el juego.
 
         //Personaje que ataca
          //  MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width]
            
            
                    //Personaje Atacado
         //   MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width]

         */
        ImageIcon icon1;
        ImageIcon icon2;
        //=============================================TEMPORAL=========================================

        System.out.println("========COORDENADAS COMBATE==========");
        System.out.println("Villano X: " + CoordenadasNuevas.width);
        System.out.println("Villano Y: " + CoordenadasNuevas.height);
        System.out.println("Heroe X: " + CoordTablero_Viejas.width);
        System.out.println("Heroe Y: " + CoordTablero_Viejas.height);

        if (this.TurnoHeroe) {
            icon1 = new ImageIcon(getClass().getResource("/recursos/Tablero/Villanos/" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID() + ".jpg"));

            icon2 = new ImageIcon(getClass().getResource("/recursos/Tablero/Heroes/" + MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID() + ".jpg"));

        } else {
            icon1 = new ImageIcon(getClass().getResource("/recursos/Tablero/Heroes/" + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID() + ".jpg"));

            icon2 = new ImageIcon(getClass().getResource("/recursos/Tablero/Villanos/" + MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID() + ".jpg"));
        }

        String Texto = 
                "<html><br><br>"+ MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getNombre() +"<br><br>"
                + "\nRango: " + MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()+"<br><br>"
                + "\n VS "+"<br><br>"
                + "\n"+  MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getNombre()+"<br><br>"
                + "\nRango: "+ MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() + "</html>";
        

        JPanel Panel_Combate = new JPanel();
        JPanel Temporal = new JPanel();
        JLabel Icono1 = new JLabel(icon1);
        JLabel Icono2 = new JLabel(icon2);
        Temporal.add(Icono1);
        Temporal.add(Icono2);
        JLabel MostrarTexto = new JLabel(Texto, SwingConstants.CENTER);

        Panel_Combate.setLayout(new BorderLayout());

        Panel_Combate.add(MostrarTexto, BorderLayout.NORTH);

        Panel_Combate.add(Temporal, BorderLayout.CENTER);

        Panel_Combate.add(MostrarTexto, BorderLayout.SOUTH);

        
       setTurnoHeroe(!this.TurnoHeroe);
       
        //VERIFICAR SI UNO ES NULO [[[[TEMPORAL]]]]]

        if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] == null || MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] == null) {
            JOptionPane.showMessageDialog(null, "Combate No valido temporal");

            return false;
        }

        // Planeta Encontrado
        if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 12) {
if(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano()){
      JOptionPane.showMessageDialog(
                null,
                "EL PLANETA!! :)",
                "Planeta Encontrado", JOptionPane.PLAIN_MESSAGE,icon2 );
   this.setGanadorPorBandera(1);
}else{
           JOptionPane.showMessageDialog(
                null,
                "EL PLANETA!! :)",
                "Planeta Encontrado", JOptionPane.PLAIN_MESSAGE,icon1 );
    
    this.setGanadorPorBandera(2);
}
         
            return true;
        }

        //Bombas vencen a todos menos a las de rango 3
        if (MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 11) {
            if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() == 3) {
               JOptionPane.showMessageDialog(
                null,
                "NO BOOM :)",
                "BOMBA DESACTIVADA", JOptionPane.PLAIN_MESSAGE,icon2 );
                
                
                PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID());
                MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
                      MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
                return true;
            } 
               JOptionPane.showMessageDialog(
                null,
                "BOOM!!!",
                "BOMBA", JOptionPane.PLAIN_MESSAGE,icon1 );
                PersonajeMuerto(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano(), MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID());
                MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            

            return true;
        }
        
       
             JOptionPane.showMessageDialog(
                null,
                Panel_Combate,
                "Combate", JOptionPane.PLAIN_MESSAGE);

       
        
        

        // Los heroes nivel 1 pueden vencer nivel 10
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() == 1 && MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango() == 10) {

            PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango());
            MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
             MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }

        //Si el rango es mayor entonces mata al contrario
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() > MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()) {

            PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID());
            MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width];
             MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }

        //Si el rango es menor entonces muere el atacante
        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() < MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()) {

            PersonajeMuerto(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano(), MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID());
            MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width];
                 MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width]= null;
            return true;
        }

        if (MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getRango() == MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getRango()) {

            PersonajeMuerto(MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].isHeroe_Villano(), MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width].getID());
            PersonajeMuerto(MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].isHeroe_Villano(), MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width].getID());
            MatrizTablero[CoordenadasNuevas.height][CoordenadasNuevas.width] = null;
            MatrizTablero[CoordTablero_Viejas.height][CoordTablero_Viejas.width] = null;
            return true;
        }

        return false;
    }

    public void PersonajeMuerto(boolean esHeroeVillano, int IdPersonaje) { // Cuando Pierde un Combate el Heroe pasa a morir

        if (esHeroeVillano) {//si es true es heroe

            for (int i = 0; i < this.MatrizHeroe.length; i++) {
                for (int j = 0; j < this.MatrizHeroe[0].length; j++) {
                    if (this.MatrizHeroe[i][j].getID() == IdPersonaje) {
                        System.out.println("===========PRUEBAS COMBATE============");
                        System.out.println(IdPersonaje);
                        this.MatrizHeroe[i][j].setVivo(false);
                    }
                }
            }

        } else {
            for (int i = 0; i < this.MatrizVillano.length; i++) {
                for (int j = 0; j < this.MatrizVillano[0].length; j++) {
                    if (this.MatrizVillano[i][j].getID() == IdPersonaje) {
                        this.MatrizVillano[i][j].setVivo(false);
                    }
                }
            }

        }
    }

    
    public int SinMovimientos(){
        boolean VillanoTieneMovimientos = false;
         boolean HeroeTieneMovimientos = false;
       
        
    for (int i = 0; i < this.MatrizTablero.length; i++) {
                for (int j = 0; j < this.MatrizTablero[0].length; j++) {
                    if(MatrizTablero[i][j] != null){
                        
                        
                        if(MatrizTablero[i][j].isHeroe_Villano()){
                        
                    
                            if(i==0 && j==0){
                                
                                 if(this.MatrizTablero[i][j+1]==null
                                   || this.MatrizTablero[i+1][j]==null){
                            HeroeTieneMovimientos=true;
                        
                                
                            }
                                 
                            }else if(i==0 && j==9){
                                 if( this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ){
                                 HeroeTieneMovimientos=true;
                       
                                
                            }
                                
                            }else if(i==9 && j==0){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                         
                                
                            }
                                
                            }else if(i==9 && j==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null   ){
                                 HeroeTieneMovimientos=true;
                           
                                
                            }
                                
                            }else if(i==0){
                                 if(this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                         
                                
                            }
                                
                            }else if(j==0){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                     ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                           
                                
                            }
                                
                            }else if(i==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                          
                            }
                                
                            }else if(j==9){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null   ){
                                 HeroeTieneMovimientos=true;
                        
                                
                            }
                                
                            }else if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                 HeroeTieneMovimientos=true;
                      
                                
                            }
                        
                        
                        
                        
                        
                    }else{
                            
                                if(i==0 && j==0){
                                
                                 if(this.MatrizTablero[i][j+1]==null
                                   || this.MatrizTablero[i+1][j]==null){
                                VillanoTieneMovimientos=true;
                       
                                
                            }
                                 
                            }else if(i==0 && j==9){
                                 if( this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ){
                                     VillanoTieneMovimientos=true;
                        
                                
                            }
                                
                            }else if(i==9 && j==0){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;
                           
                                
                            }
                                
                            }else if(i==9 && j==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null   ){
                                     VillanoTieneMovimientos=true;
                           
                                
                            }
                                
                            }else if(i==0){
                                 if(this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;
                             
                                
                            }
                                
                            }else if(j==0){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                     ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;
                            
                                
                            }
                                
                            }else if(i==9){
                                 if(this.MatrizTablero[i-1][j]==null 
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;
                              
                                
                            }
                                
                            }else if(j==9){
                                 if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null   ){
                                     VillanoTieneMovimientos=true;
                               
                                
                            }
                                
                            }else if(this.MatrizTablero[i-1][j]==null || this.MatrizTablero[i+1][j]==null
                                    || this.MatrizTablero[i][j-1]==null    ||this.MatrizTablero[i][j+1]==null){
                                     VillanoTieneMovimientos=true;
                               
                                
                            }
                        
                        
                            
                            
                        }
                        
                        
                        
                    }
                }
    }
      
    if(VillanoTieneMovimientos && HeroeTieneMovimientos){
        return 1;
    }else if(VillanoTieneMovimientos){
        return 2;
    }else if(HeroeTieneMovimientos){
        return 3;
    }else{
        return 4;
    }
    
    
    
    
    
    }
    
    
    
    
   
    
    
    
    
    
    
    
    
}
