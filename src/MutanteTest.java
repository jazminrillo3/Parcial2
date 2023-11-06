import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MutanteTest {

    Mutante mutanteTest = new Mutante();
    Boolean result;

    @Test
    public void isMutant() {
        String[] test1 =
                {"ATGCAA",
                 "TTATAT",
                 "AGAACG",
                 "GTCCCC",
                 "GTCCCC",
                 "TCACGT"};
        result = mutanteTest.isMutant(test1);
        assertTrue(result);

        mutanteTest = new Mutante();
        String[] test2 =
                {"AAAAAA",
                 "CAGTGC",
                 "TCATAT",
                 "AGCACG",
                 "gtcccc",
                 "TCACGT"};
        result = mutanteTest.isMutant(test2);
        assertTrue(result);

        mutanteTest = new Mutante();
        String[] test3 =
                {"gtgcaa",
                 "cggtgc",
                 "ttgtat",
                 "agagcg",
                 "gtaagt",
                 "tcccct"};
        result = mutanteTest.isMutant(test3);
        assertTrue(result);

        mutanteTest = new Mutante();
        String[] test4 =
                {"1AGC",
                 "4TGA",
                 "4676",
                 "32tg"};
        result = mutanteTest.isMutant(test4);
        assertFalse(result);

        mutanteTest = new Mutante();
        String[] test5 =
                {"CGGTGC",
                "ATGCAC",
                "TTATAT",
                "AGAGCG",
                "GCCAAC",
                "TCACGT"};
        result = mutanteTest.isMutant(test5);
        assertFalse(result);
    }
}