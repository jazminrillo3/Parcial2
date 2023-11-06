import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mutante {

    private String[] matriz = new String[6];
    private String[] matrizTraspuesta = new String[6];
    private ArrayList<String> matrizDiagonales = new ArrayList<>();
    private ArrayList<String> secuencias = new ArrayList<>();
    private String[] mutantSequences = {"AAAA", "TTTT", "CCCC", "GGGG"};
    private int counter = 0;

    public boolean isMutant(String[] dna){
        findCombinations(dna);

        secuencias.addAll(List.of(matriz));
        secuencias.addAll(List.of(matrizTraspuesta));
        secuencias.addAll(matrizDiagonales);

        System.out.println("Secuencias formadas:");
        showSequence(secuencias);

        secuencias.stream().forEach(s -> {
            if (Arrays.stream(mutantSequences)
                    .anyMatch(c -> s.toUpperCase().contains(c))) { counter++; }
        });

        if (counter>=2)
            return true;
        else
            return false;
}

    public void findCombinations(String[] dna){
        Arrays.fill(matriz,0,6,"");
        Arrays.fill(matrizTraspuesta,0,6,"");

        int filas = dna.length;
        int columnas = dna[0].length();

        for (int i = 0; i < filas; i++){
            for (int j= 0; j < columnas; j++) {
                char caracter = dna[i].charAt(j);
                matriz[i] += caracter;                                  //matriz
                matrizTraspuesta[j] += caracter;                        //matriz traspuesta
            }
        }

        for (int i = 0; i < filas; i++) {
            String diagonal1 = "";
            String contradiagonal1 = "";
            String diagonal2 = "";
            String contradiagonal2 = "";

            for (int j= 0; j < columnas; j++) {
                if (i+j < dna.length) {
                    diagonal1 += matriz[i + j].charAt(j);                                   // Diagonales hacia la derecha
                    diagonal2 += matrizTraspuesta[i + j].charAt(j);                         // Diagonales hacia la derecha
                    contradiagonal1 += matriz[i + j].charAt(columnas - j - 1);              // Diagonales hacia la izquierda
                    contradiagonal2 += matrizTraspuesta[i + j].charAt(columnas - j - 1);    // Diagonales hacia la izquierda
                }
            }
            if (diagonal1.length()>=4) matrizDiagonales.add(diagonal1);
            if (diagonal2.length()>=4) matrizDiagonales.add(diagonal2);
            if (contradiagonal1.length()>=4) matrizDiagonales.add(contradiagonal1);
            if (contradiagonal2.length()>=4) matrizDiagonales.add(contradiagonal2);
        }

    }

    public void showSequence(ArrayList<String> dna){
        for (String cadena : dna) {
            System.out.println(cadena);
        }

    }

}
