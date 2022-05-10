package lt.bit.Bendrabutis;
//Bendrabutyje kiekviename kambaryje yra fiksuojama, kiek elektros energijos
//(kilovatvalandėmis) išnaudojama per mėnesį. Bendrabučio gyventojai susitarė, kad kiekvieno
//kambario gyventojai kas mėnesį mokės vienodą įmoką už elektrą - tai yra tiek, kiek vidutiniškai
//kambaryje buvo suvartota elektros. Parašykite programą, kuri surastų tą sumą.
//Pradiniai duomenys pateikti duomenų faile Duomenys.txt atskirose eilutėse:
//● pirmas skaičius - kambarių skaičius bendrabutyje;
//● antras skaičius - elektros kaina litais už kilovatvalandę;
//● likusieji n skaičių - kiekvieno kambario suvartota elektros energija kilovatvalandėmis.
//19
//Rezultatų faile Rezultatai.txt turi būti įrašyta:
//● už kokią sumą suvartota energijos kiekviename kambaryje, nurodant kambario numerį ir
//pinigų sumą dviejų ženklų po kablelio tikslumu;
//● kokią pinigų sumą už sunaudotą elektros energiją turi sumokėti viso bendrabučio
//gyventojai;
//● kokią pinigų sumą už elektros energiją turės sumokėti vieno kambario gyventojai.

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BendrabutisMain {
    public static void main(String[] args) {
        String failoKelias = "JavaSestaSavaite/src/lt/bit/Bendrabutis/Duomenys.txt";
        String rezultatuFailoKelias = "JavaSestaSavaite/src/lt/bit/Bendrabutis/Rezultatai.txt";
        BendrabuciuElektrosMenesineImoka duomenys = skaityti(failoKelias);
        spausdinti(rezultatuFailoKelias, duomenys);
        System.out.println(duomenys.getKwKaina());
        System.out.println(duomenys.getButuKw());
    }
    public static BendrabuciuElektrosMenesineImoka skaityti (String kelias) {
        BendrabuciuElektrosMenesineImoka ats = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(kelias));
            String eilute = br.readLine();
            int butuKiekis = Integer.parseInt(eilute);
            eilute = br.readLine();
            double kwKaina = Double.parseDouble(eilute);
            List<Double> butuKw = new ArrayList<>();
            for (int i = 0; i < butuKiekis; i++) {
                eilute = br.readLine();
                double sunaudotaKw = Double.parseDouble(eilute);
                butuKw.add(sunaudotaKw);
            }
            ats = new BendrabuciuElektrosMenesineImoka(kwKaina,butuKw);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ats;
    }

    public static void spausdinti (String kelias, BendrabuciuElektrosMenesineImoka duomenys){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(kelias));
            double visuSuma=0;
            for (int j=0;j<duomenys.getButuKw().size();j++ ){
                double butasMoka = duomenys.getKwKaina()*duomenys.getButuKw().get(j);
                visuSuma = visuSuma + butasMoka;
                bw.write(j+1 +". "+String.format("%.2f",butasMoka)+ " Lt.\n" );
   //             bw.newLine();
            }
            bw.write("Is viso sunaudota: uz "+String.format("%.2f",visuSuma)+ " Lt.\n");
            bw.write("Vieno kambario gyventojai mokes: "+String.format("%.2f",visuSuma/duomenys.getButuKw().size())+ " Lt.\n");


            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
