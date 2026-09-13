import java.util.Scanner;

public class Main {

    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args)
    {
        //1 afiseaza abonamentu
        String nume="Mario";
        int varsta=20;
        String tip="premium";
        int durata=3;
        double pret=450;
        boolean continui=true;
        while(continui)
        {
            System.out.println("===== GYM MEMBERSHIP MANAGER =====\n" +
                    "\n" +
                    "1. Afiseaza abonamentul\n" +
                    "2. Schimba tipul abonamentului\n" +
                    "3. Schimba durata abonamentului\n" +
                    "4. Calculeaza pretul\n" +
                    "5. Verifica statusul abonamentului\n" +
                    "6. Exit\n" +
                    "\n" +
                    "Alege o optiune:");
            int alegere= scanner.nextInt();
            switch (alegere) {
                case 1-> afisareAbonament(nume, varsta, tip, durata, pret);
                case 2-> tip=schimbaAbonament(tip);
                case 3-> durata=timp(durata);
                case 4-> pret=pret(pret,durata,tip);
                case 5-> System.out.println(verificaStatus(durata));
                case 6 -> continui=false;
                default -> System.out.println("Invalid, alegeti din nou!\n");
            }
        }
        System.out.println("Multumesc ca ati ales service ul nostru \nLa revedere!");
        scanner.close();
    }

    static void afisareAbonament(String nume,int varsta,String tip,int durata,double pret)
    {
        System.out.println("=====Abonament=====");
        System.out.printf("Nume: %s\n",nume);
        System.out.printf("Varsta: %d \n",varsta );
        System.out.printf("Tip: %s \n",tip);
        System.out.printf("Durata: %d luni\n",durata);
        System.out.printf("Pret: %.2f lei\n \n \n\n\n",pret);
    }

    static String schimbaAbonament(String tip)
    {
        System.out.println("Alege tipul de abonament \n1.Basic \n2.Standard\n3.Premium");
        int numar= scanner.nextInt();
        switch(numar)
        {
            case 1 -> tip="Basic";
            case 2 -> tip="Standard";
            case 3 -> tip="Premium";
            default -> System.out.println("Optiunea nu este valida");
        }
        return tip;
    }

    static int timp(int durata)
    {
        System.out.println("Pe ce perioada de timp vrei sa ti faci abonamentul? ");
        durata=scanner.nextInt();
        while(durata>20 || durata<1)
        {
            System.out.println("ai introdus o durata nevalida, incearca din nou(1-20 luni)");
            durata=scanner.nextInt();
        }
        return durata;
    }

    static double pret(double pret, int durata, String tip)
    {
        double pretAbonament=0;
        switch(tip){
            case "Basic" -> {
                pretAbonament=100;
                if(durata>=6){pret=durata*pretAbonament*0.90;}
                else {pret=durata*pretAbonament;}
                System.out.println(pret);
            }
            case "Standard" ->{
                pretAbonament=150;
                if(durata>=6){pret=durata*pretAbonament*0.90;}
                else {pret=durata*pretAbonament;}
                System.out.println(pret);
            }
            case "Premium" ->{
                pretAbonament=200;
                if(durata>=6){pret=durata*pretAbonament*0.90;}
                else {pret=durata*pretAbonament;}
                System.out.println(pret);
            }
            default -> System.out.println("Nu ai abonament Bro lock in pls");
        }
        return pret;
    }

    static String verificaStatus(int durata)
    {
        if(durata>0)
        {
            return "ACTIV";
        }
        else
        {
            return "EXPIRAT";
        }
    }
}