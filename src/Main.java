import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //String[] dna = dnaInput();
        String[] dna = {"ATGCAA", "CAGTGC", "TTATAT", "AGAACG", "GTCCCC", "TCACGT"};
        Mutante mutanteTest = new Mutante();
        System.out.println("¿ES MUTANTE?: " + mutanteTest.isMutant(dna));
    }

    public static String[] dnaInput(int lenght){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, ingrese las cadenas de ADN:");
        String[] dna = new String[lenght];

        for (int i=0; i<lenght; i++){
            System.out.print("Fila "+(i+1)+": ");
            dna[i] = sc.next();

            while(dna[i].length() != lenght){
                System.out.println("Error, la secuencia debe tener "+ lenght +" caracteres. Vuelva a intentarlo.");
                System.out.println("Fila "+(i+1)+": ");
                dna[i] = sc.next();
            }
        }

        return dna;
    }

}