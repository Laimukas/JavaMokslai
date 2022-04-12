package lt.bit;


import java.util.Scanner;

public class EdvinoAntraPamoka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //----------- 1 Uzduotis
        //
//Write an application that will read diameter of a circle (variable of type float) and
//calculate perimeter of given circle.
//Firstly, assume π = 3.14. Later, use value of π from built-in Math class.
        /*
        System.out.println("Koks apskritimo diametras?");
        float apskritimoDiametras = sc.nextFloat();

        double perimeter = apskritimoDiametras * Math.PI;
        System.out.println("Perimetras: "+perimeter);
        */

        //---------------2 Uzduotis
        //
        //Write an application calculating BMI (Body Mass Index) and checking if itЀs optimal or not.
        //Your application should read two variables: weight (in kilograms, type float) and height
        //(in centimeters, type int). BMI should be calculated given following formula:
        //The optimal BMI range is from 18.5 to 24.9, smaller or larger values are non-optimal
        //values. Your program should write "BMI optimal" or "BMI not optimal", according to the
        //assumptions above.
        /*
        System.out.println("Koks jusu svoris (kg.)?");
        float svoris = sc.nextFloat();
        System.out.println("Koks jusu ugis (cm.)?");
        int ugis = sc.nextInt();
        double ugisMetrais = (double) ugis/100;
        double bmi= svoris / Math.pow(ugisMetrais,2);

        // ||  - OR
        // &&  - AND
        //Ternerio metodas
        //String tekstas = bmi >= 18.5 && bmi <= 24.9 ? "BMI optimal" : "BMI not optimal";
       // System.out.println(tekstas);

        if (bmi>=18.5 && bmi <=24.9){
            System.out.println("BMI optimal");
        }else{
            System.out.println("BMI not optimal");
        }
        */

        // ----------------3 Uzduotis
        //Write a program for solving a quadratic equation. The program should take three integers
        //(coefficients of the quadratic equation a, b, c) and calculate the roots of the
        //equation
        // If delta ∆ comes out negative, print "Delta negative" and exit the program.
        //Formulas you'll need:
        /*
        System.out.println("Iveskite tris kintamuosius:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double delta = Math.pow(b,2) - 4*a*c;
        double x1 = -b - Math.sqrt(delta)/2*a;
        double x2 = -b + Math.sqrt(delta)/2*a;
        if (delta < 0) {
            System.out.println("Delta negative");
        } else {
            System.out.println("delta=" + delta + " x1=" + x1 + " x2=" + x2);
//cia bandom po kablelio palikt tik pora skaiciu,kad nemestu ilgo double atsakymo///*********************
// pvz ivedziau skaicius 1,16,2
            String skaicius = String.valueOf(x1);
         //   String.format("%.5g%n", skaicius);
            char[] charai = skaicius.toCharArray();
            int indeksas = 0;
            for (int i = 0; i< charai.length; i++){
                if(charai[i] == '.'){
                    indeksas = i;
                }
            }
            String skaiciusSuDviemSkaiciaisPoKablelio = skaicius.substring(0, indeksas + 3);
            System.out.println("x1 suapvalintas:" +skaiciusSuDviemSkaiciaisPoKablelio);
        }*/
//---------4Uzduotis-----
        //Write an application that takes a positive number from the user (type int) and writes all
        //numbers from 1 to the given number, each on the next line, with the following changes:
        //● in place of numbers divisible by 3, instead of a number the program should print "Fizz"
        //● in place of numbers divisible by 7, instead of a number the program should write
        //"Buzz"
        //● if the number is divisible by both 3 and 7, the program should print "Fizz buzz"
/*
        System.out.println("Iveskite teigiama skaiciu..");
        int skaicius = sc.nextInt();

        for (int i = 1; i <= skaicius; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                System.out.println("Fizz Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 7 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println("Skaicius " + i + " nesidalina is 3 arba 7");
            }
        }

*/
        //----------5Uzduotis

        //Write an application that takes a positive number from the user (type int) and prints all
        //prime numbers greater than 1 and less than the given number.
/*
        System.out.println("Iveskite teigiama skaiciu..");
        int skaicius = sc.nextInt();
        for (int i = 2; i <= skaicius; i++) {
            int counter = 0;
            for (int j = i; j >=2; j--){ //cia mes imam skaiciu,ji mazinam 1 ir einam iki 2

                if (i%j==0){
                    counter++;
                }
            }
            if(counter == 1){
                System.out.println("Pirminiai skaiciai "+i);
            }

        }*/

//------------6Uzduotis
//Write an application that takes a number n from the user (type int) and calculates the
//sum of the harmonic series from 1 to n, according to the formula below:
/*
        System.out.println("Iveskite skaiciu:");
        int n = sc.nextInt();
        double suma = 1;
        if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= n; i++) {
                double j = Double.valueOf(i);
                suma = suma + (1 / j);
            }
            System.out.println(suma);
        }

 */

        //-----------7Uzduotis

        // Fibonacci numeriai
        //Write an application that will take a positive number from the user (type int) and
        //calculate the Fibonacci number at the indicated index. For example, if the number equals
        //5, your program should print the fifth Fibonacci number. In Fibonacci sequence, each
        //number is the sum of the two preceding ones. For example, the first few Fibonacci
        //numbers are:
        //1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377…
/*
        System.out.println("Iveskite skaiciu:");
        int skaicius = sc.nextInt();
        int n1=0,n2=1,n3,i;
        System.out.print(n1+" "+n2);//printing 0 and 1

        for(i=2;i<skaicius;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }

 */
// Edvino sprendimo budas
    /*    System.out.println("Iveskite indeksa");
        int index = sc.nextInt();
        int firstNumber =0, secondNumber = 1, sum =0;
        System.out.print(firstNumber+" "+secondNumber);//printing 0 and 1

        for (int i=2;i<=index;i++){
            sum = firstNumber+secondNumber;
            firstNumber=secondNumber;
            secondNumber=sum;
            System.out.print(" "+sum);

            if (i == index){
                System.out.println(" Mums reikalingas indeksas yra: "+sum);
            }
        }*/
//kitas Edvino varijantas

        System.out.println("Iveskite indeksa");
        int index = sc.nextInt();

        int[]fibinaciNumbers = new int[index + 1];
        fibinaciNumbers[0]=0;
        fibinaciNumbers[1]=1;

        for (int i=0; i<index; i++){
            int j = i+1;
            int k = j+1;

            if (k>index){
                break;
            }

            fibinaciNumbers[k]=fibinaciNumbers[i]+fibinaciNumbers[j];
            System.out.println(fibinaciNumbers[k]); //atprintinu Fibinnacio skaicius pradedant nuo antro
        }

        System.out.println("mums reikalingas indeksas yra: "+fibinaciNumbers[fibinaciNumbers.length-1]);



        //----------8Uzduotis
        //Write an application that implements a simple calculator. The application should:
        //a. read first number (type float)
        //b. read one of following symbols: + - / *
        //c. read second number (type float)
        //d. return a result of given mathematical operation
        //If the user provides a symbol other than supported, the application should print "Invalid
        //symbol". If the entered action cannot be implemented (i.e. it is inconsistent with the
        //principles of mathematics), the application should print "Cannot calculate".

        /*
        Scanner scanner = new Scanner(System.in);
        float a = 0;
        float b = 0;

        try {
            System.out.println("Enter a");
            a = scanner.nextFloat();

            System.out.println("Enter operation (+-/*)");
            String operacija = scanner.next();

            System.out.println("Enter b");
            b = scanner.nextFloat();

            calculate(a, operacija, b);
        } catch (Exception e) {
            System.out.println("Illegal format,please provide numbers. Provided value: " + a + ", and " + b);
        }
    }

    private static void calculate(float a, String operacija, float b) {
        switch (operacija) {
            case "+":
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Cannot calculate. Division by zero prohibited. ");
                } else {
                    System.out.println(a + " / " + b + " = " + (a / b));
                }
                break;
            case "*":
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            default:
                System.out.println("Invalid simbol");
        }

         */

 //-----------10Uzduotis
 //Write an application that gets one positive number (type int) from the user and calculates
        // a sum of digits of the given number. Hint: to make some operations on every single digit
        //of the number (digit by digit), you can calculate the remainder of dividing the number by
        //10 (to get the value of the last digit) and divide the number by 10 (to "move" to the next
        //digit).
/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite skaiciu");
        int skaicius = scanner.nextInt();
        int suma = 0;

        while(skaicius>0){
            int digit = skaicius % 10;
            //suma = suma + digit
            suma += digit;
            // skaicius = skaicius / 10
            skaicius /=10;
        }
        System.out.println("Suma: " +suma);

        */
        //dar varijantas kaip imanoma issprest
/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite skaiciu");
        int ivestasSkaicius = scanner.nextInt();
        String skaiciusTikString = String.valueOf(ivestasSkaicius);
        char[] skaiciai = skaiciusTikString.toCharArray();

        int suma = 0;
        for (char skaicius :skaiciai){
            suma += Integer.parseInt(String.valueOf(skaicius));
        }
        System.out.println("Suma: " +suma);
*/

        //------------11Uzduotis
        //Write an application that will read texts (variables of the String type) until the user gives
        //the text "Enough!" and then writes the longest of the given texts (not including the text
        //"Enough!"). If the user does not provide any text, write "No text provided".
/*
        Scanner scanner = new Scanner(System.in);
        boolean arVykdyti = true;
        int ilgis = 0;
        String ilgiausiasZodis = null;

        while(arVykdyti){
            System.out.println("Iveskite teksta");
            String zodis = scanner.next();

            if (zodis.equals("Enough!")){
                arVykdyti=false;
            }else{
                if (zodis.length()>ilgis){
                    ilgis = zodis.length();
                    ilgiausiasZodis = zodis;
                }
            }

        }
        System.out.println(ilgiausiasZodis);

 */
    }

}



