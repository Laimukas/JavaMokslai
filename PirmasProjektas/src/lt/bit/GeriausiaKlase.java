package lt.bit;
//Giraitės mokykloje yra keturios dešimtos klasės: a, b, c ir d. Direktorius
//atlieka analizę, nori surasti geriausiai besimokančią dešimtokų klasę, pasižiūrėti, keliais balais
//kiekvienos kitos klasės vidurkis yra mažesnis už geriausiai besimokančios klasės vidurkį.
//Parašykite programą, kuri surastų, koks yra didžiausias vidurkis ir keliais balais skiriasi likusių
//klasių vidurkiai nuo geriausiai besimokančios klasės vidurkio.

//kadangi velnias zino ko reiks pridedant ar isimant elementus,tai importuoju viska naudodamas *

import java.util.*;

public class GeriausiaKlase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite keturiu klasiu vidurkius:");
        double pirma = sc.nextDouble();
        double antra = sc.nextDouble();
        double trecia = sc.nextDouble();
        double ketvirta = sc.nextDouble();
        double arr[] = {0, 0, 0, 0};
        arr[0] = pirma;
        arr[1] = antra;
        arr[2] = trecia;
        arr[3] = ketvirta;
        double num[] = {0, 0, 0, 0};
        num[0] = pirma;
        num[1] = antra;
        num[2] = trecia;
        num[3] = ketvirta;

        //printing added numbers to arr
        System.out.println("Visi vidurkiai: " + Arrays.toString(arr));

        //finds the highest value
        double max = arr[0];
        int index = 0;
        for (int counter = 0; counter < arr.length; counter++) {

            if (arr[counter] >= max) {
                // arr[index] = max - arr[index + 1];
                max = arr[counter];
                index = counter;
                num[0] = max - pirma;
                num[1] = max - antra;
                num[2] = max - trecia;
                num[3] = max - ketvirta;
                //num[index] = max - num[index + 1];
            }

        }
        //element to remove is index
        double element = 0.0;
        int size = 4, i=0,j=0;
        for(i=0; i<size; i++)
        {
            if(element==num[i])
            {
                for(j=i; j<(size-1); j++)
                    num[j] = num[j+1];
                break;
            }
        }
        System.out.println("\nDidziausias vidurkis yra: " + max);
        System.out.println("\nKitu klasiu vidurkiai skiriasi: ");
        for(i=0; i<(size-1); i++)
            System.out.print(num[i]+ " ");
        System.out.println(" ");

        System.out.println("\nidomumo delei printinu indexo verte: " + index);

        // Remove the element
        // num = removeTheElement(num, index);
        // num = yourArrayList.remove(num, index);



    }
}

