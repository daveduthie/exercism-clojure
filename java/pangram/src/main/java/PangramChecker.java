public class PangramChecker {

    public boolean isPangram(String input) {
        boolean[] alphabet = new boolean[26];

        for (char c : input.toUpperCase().toCharArray()) {
            if (65 <= c && c <= 90) alphabet[c - 65] = true;
        }

        for (boolean b : alphabet) {
          if (!b) return false;
        }

        return true;
    }
}
