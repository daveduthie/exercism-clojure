public class RnaTranscription {
    public String ofDna(String dnaString) {
        String result = "";
        for (char s:dnaString.toCharArray()) {
            result += complementaryNucleotide(s);
        }
        return result;
    }

    private String complementaryNucleotide(char dna) {
        switch (dna) {
            case 'C': { return "G"; }
            case 'G': { return "C"; }
            case 'A': { return "U"; }
            case 'T': { return "A"; }
            default:  { throw new IllegalArgumentException("That's not DNA!"); }
        }
    }
}
