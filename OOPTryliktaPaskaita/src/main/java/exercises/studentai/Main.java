package exercises.studentai;

public class Main {
    public static void main(String[] args) throws StudentuGrupiuKlaida{

        StudentuGrupe studentuGrupe = new StudentuGrupe();
        studentuGrupe.perziuretiStudentus();
        System.out.println("------------------------------------------------------------------------------------");
        Studentas studentas = new Studentas("Tadas","Vaiciunas","24",8.8);
        studentuGrupe.papildytiSarasa(studentas);
        studentuGrupe.perziuretiStudentus();
        System.out.println("------------------------------------------------------------------------------------");
        studentuGrupe.pasalintiIsSaraso(studentas);
        studentuGrupe.perziuretiStudentus();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Studentu saraso paieska nurodzius vidurkiu intervala.->");
        studentuGrupe.studentuSarasasNurodziusVidurkiuIntervala(7.0,9.0);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Studento duomenu paieska nurodzius varda,pavarde ir grupe.->");
        studentuGrupe.studentoPaieskaNurodziusVardaPavardeGrupe("Deivis","Blazys","21b");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Geriausiai besimokancio studento paieska, nurodzius grupes koda.->");
        studentuGrupe.geriausiaVidurkiTurintisStudentasNurodytojeGrupeje("10a");

    }
}
