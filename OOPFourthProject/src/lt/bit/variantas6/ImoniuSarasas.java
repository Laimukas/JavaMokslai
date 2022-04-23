package lt.bit.variantas6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ImoniuSarasas {

    private ArrayList<Imone> imoniuSarasas;

    public ImoniuSarasas(ArrayList<Imone> imoniuSarasas){
        this.imoniuSarasas = imoniuSarasas;
    }

    public void gautiInformacijaApieDaugiausiaiDarbuotojuTurinciaImone(){
        int darbuotojuSkaicius = Integer.MIN_VALUE;
        Imone daugiausiaiDarbuotojuTurintiImone = null;

        for(Imone imone : imoniuSarasas){
            if(imone.getDarbuotojuSkaicius() > darbuotojuSkaicius){
                darbuotojuSkaicius = imone.getDarbuotojuSkaicius();
                daugiausiaiDarbuotojuTurintiImone = imone;
            }
        }

        System.out.println(daugiausiaiDarbuotojuTurintiImone);
    }

    public void paieska(String imonesPavadinima, String direktoriausPavarde){
        imoniuSarasas.forEach(imone -> {
            if(imone.getImonesPavadinimas().equals(imonesPavadinima) &&
                    imone.getDirektoriausPavarde().equals(direktoriausPavarde)){
                System.out.println(imone);
            }
        });

        /*
         for(Imone imone : imonesSarasas){
            if(imone.getImonesPavadinimas().equals(imonesPavadinima) &&
                    imone.getDirektoriausPavarde().equals(direktoriausPavarde)){
                        System.out.println(imone);
                    }
         }
         */
    }

    public void paieska(String imonesPavadinimas, String direktoriausPavarde, String miestas, String telefonoNumeris){
        imoniuSarasas.forEach(imone -> {
            if(validuotiDuomenis(imone, imonesPavadinimas, direktoriausPavarde, miestas, telefonoNumeris)) {
                System.out.println(imone);
            }
        });
    }

    private boolean validuotiDuomenis(Imone imone, String imonesPavadinimas, String direktoriausPavarde,
                                      String miestas, String telefonoNumeris) {
        return imone.getImonesPavadinimas().equals(imonesPavadinimas) &&
                imone.getDirektoriausPavarde().equals(direktoriausPavarde) &&
                imone.getMiestas().equals(miestas) &&
                imone.getTelefonoNumeris().equals(telefonoNumeris);
    }

    public void rikiavimas(){
        Collections.sort(imoniuSarasas, (Comparator.comparing(Imone::getImonesPavadinimas)));

        for(int i = 0; i < imoniuSarasas.size(); i++){
            if(imoniuSarasas.size() - i == 1){
                break;
            }

            Imone pirmaImone = imoniuSarasas.get(i);
            Imone antraImone = imoniuSarasas.get(i + 1);

            if(pirmaImone.getImonesPavadinimas().equals(antraImone.getImonesPavadinimas())){
                if(pirmaImone.getMiestas().compareTo(antraImone.getMiestas()) > 0 ){
                    imoniuSarasas.remove(i);
                    imoniuSarasas.add(i, antraImone);
                    imoniuSarasas.remove(i + 1);
                    imoniuSarasas.add(i + 1, pirmaImone);
                }
            }
        }

        System.out.println(Arrays.toString(imoniuSarasas.toArray()));
    }
}
