public class RnaTranscription {
    public String ofDna(String dnaString) {
        String result = "";
        for (char s:dnaString.toCharArray()) {
            switch (s) {
                case 'C': { result += "G"; break; }
                case 'G': { result += "C"; break; }
                case 'A': { result += "U"; break; }
                case 'T': { result += "A"; break; }
            }
        }
        return result;
    }
}
