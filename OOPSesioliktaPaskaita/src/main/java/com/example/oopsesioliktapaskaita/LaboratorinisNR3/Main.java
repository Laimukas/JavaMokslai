package com.example.oopsesioliktapaskaita.LaboratorinisNR3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws AdresuKnygutesKlaida{

        AdresuKnygute adresuKnygute = new AdresuKnygute();
        adresuKnygute.perziuretiAdresus();
        System.out.println("-------------------------------------------------------------------------------------");
        Adresas adresas=new Adresas("Milda","Mildute","Alytus","+37065463214");
        adresuKnygute.papildytiSarasa(adresas);
        adresuKnygute.perziuretiAdresus();
        System.out.println("-------------------------------------------------------------------------------------");
        adresuKnygute.pasalintiIsSaraso(adresas);
        adresuKnygute.perziuretiAdresus();
        System.out.println("-------------------------------------------------------------------------------------");
        adresuKnygute.nurodytoMiestoGyventojuKiekioPaieska("Vilnius");
        System.out.println("-------------------------------------------------------------------------------------");
        adresuKnygute.paieskaPagalVardaPavardeMiesta("Juozas","Juozaitis","Kaunas");
        System.out.println("-------------------------------------------------------------------------------------");
        adresuKnygute.paieskaPagalPavardeIrTelefNumSaliesKoda("Vytautas","+370");
        System.out.println("-------------------------------------------------------------------------------------");
        adresuKnygute.rikiavimasPagalPavardes(SortOrder.DESCENDING);
        System.out.println("-------------------------------------------------------------------------------------");
        adresuKnygute.rikiavimasPagalPavardeCollectionMetodu();

    }
}
