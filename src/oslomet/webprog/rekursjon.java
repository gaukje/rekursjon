package oslomet.webprog;


import static javax.swing.JOptionPane.showInputDialog;

public class rekursjon {

    // Oppgave 1: Implementer fakultetsfunksjonen.
    public static int fakultet(int n){
        if(n == 0){
            return 1;
        } else {
            return n*fakultet(n-1);
        }
    }

    //Oppgave 2: Implementer både iterativ (med en løkke) og rekursiv summasjon.

    public static int sum(int n){
        if(n >= 1){
            return sum(n-1) + n;
        }
        return n;
    }

    public static int iterativSum(int n){
        int sum = 0;
        if(n < 0){
            return -1;
        }
        for (int i = 0; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static int binerSok(int [] liste, int v, int h, int x){
        if(h >= v){
            int midt = v + (h - 1) / 2;

            //Hvis elementet eksisterer i "midt":
            if(liste[midt] == x){
                return midt;
            }

            //Hvis elementet er mindre enn midt, befinner elementet
            //-seg på venstre side
            if(liste[midt] > x){
                return binerSok(liste, v, midt -1, x);
            }

            //Ellers kan elementet kunn befinnne seg på høyre side
            return binerSok(liste, midt + 1, h, x);
        }
        //Ender opp her dersom vi ikke finner tallet
        return -1;
    }

    public static void main(String[]args){
        System.out.println("Rekursjon");

        int n = Integer.parseInt(showInputDialog("Oppgi n"));

        System.out.println(n + " fakultet er " + fakultet(n));
        System.out.println("Summen av alle tall fra " + n + " til 1 er (rekursiv metode) " + sum(n));
        System.out.println("Summen av alle tall fra " + n + " til 1 er (iterativ metode) " + iterativSum(n));

        int [] liste = {61, 87, 154, 170, 275, 426, 503, 509, 512, 612, 653, 677, 703 ,765, 897, 908};
        int x = 275;

        int pos = binerSok(liste, 0, liste.length - 1, x);

        if (pos >= 0){
            System.out.println("Noekkelen " + x + " har posisjon " + pos);
        } else {
            System.out.println("Noekkelen " + x + " finnes ikke arrayet");
        }
    }
}

