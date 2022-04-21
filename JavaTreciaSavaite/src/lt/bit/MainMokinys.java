package lt.bit;
// Sukurti klase Mokinys,kuri turetu siuos laukus: vardas, pavarde, klase, pazymiu masyvas.

public class MainMokinys {
    public static void main(String[] args) {

        Mokinys mokinys1 = sukurtiMokini("Jonas", "Jonaitis", "11b", new int[]{4, 8, 10});
        Mokinys mokinys2 = sukurtiMokini("Petras", "Petraitis", "10b", new int[]{5, 9, 10});
        Mokinys mokinys3 = sukurtiMokini("Tomas", "Tomaitis", "9b", new int[]{6, 10, 10});
        Mokinys mokinys4 = sukurtiMokini("Vytas", "Vytaitis", "8b", new int[]{7, 10, 10});
        Mokinys mokinys5 = sukurtiMokini("Linas", "Linaitis", "7b", new int[]{8, 10, 10});
        Mokinys mokinys6 = sukurtiMokini("Jurga", "Jurgaite", "6b", new int[]{9, 10, 10,10});
        Mokinys mokinys7 = sukurtiMokini("Ineta", "Inetaite", "5b", new int[]{10, 10, 10,8});
        Mokinys mokinys8 = sukurtiMokini("Dovile", "Dovilaite", "4b", new int[]{9, 9, 10});
        Mokinys mokinys9 = sukurtiMokini("Simas", "Simaitis", "5c", new int[]{8, 9, 10});
        Mokinys mokinys10 = sukurtiMokini("Laurynas", "Laurinaitis", "6d", new int[]{7, 9, 10});
        Mokinys mokinys11 = sukurtiMokini("Donatas", "Donaitis", "7a", new int[]{6, 9, 10});
        Mokinys mokinys12 = sukurtiMokini("Zigmas", "Zigmaitis", "9e", new int[]{5, 9, 10});

        //kuriam mokiniu masyva
        Mokinys[] mokiniai = new Mokinys[]{mokinys1,mokinys2,mokinys3,mokinys4,mokinys5,mokinys6,mokinys7,mokinys8,mokinys9,mokinys10,mokinys11,mokinys12};
        //printinam masyva
//        for(Mokinys mokinys: mokiniai){
//           System.out.println(mokinys);
//
//        }
        //geriausias mokinys
        Mokinys geriausias = Mokinys.gautiGeriausiaiBesimokanti(mokiniai);
        System.out.println(geriausias);

        //Priskiriam nauja reiksme naudojant set
//        mokinys1.setPavarde("Petraitis");
//        //Istraukiam info apie mokini,tiksliau jo pavarde isgaunam naudodami get
//        System.out.println(mokinys1.getPavarde());
//        // printinam mokinio pazymiu vidurki -> 2 uzduoties galutinis rez
//        System.out.println(mokinys2.pazymiuVidurkis());
    }

    // uzduoties dalis 1 - Sukurti funkcija siam objektui sukurti ir ji grazinti

    public static Mokinys sukurtiMokini(String vardas, String pavarde, String klase, int[] pazymiai) {
        return new Mokinys(vardas, pavarde, klase, pazymiai);
    }
    //kitos uzduotys (2,3,4) mokinio klasej aprasytos

    //Susikurti mokiniu masyva
    //1.Susikurti kelis objektus mokinys1, mokinys2.... DONE
    //2.Susideti juos i masyva  DONE
    //3.Atspausdinti ju laukus  DONE



}
