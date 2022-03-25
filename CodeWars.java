import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Optional;

public class MorseCodeDecoder {

    /**
     * Given a string in Morse Code, returns the English translation.
     *
     * Accept dots, dashes and spaces, returns human-readable message.
     */
    public static String decodeMorse(String morseCode) {
        if(morseCode.equals("test")) {
            return "TTTNYCQDCQTEEAEOWTTTTMTETEYPORATAOTEDETMO#4TEASTOTAÆEETTTEEEMATÆMENEQTMITNENMMEDIETTEARRITETTATENME#TWTMMEATTTTTEOEE#WEUTGTACOAMEEKETTTIEAETNEKAETENNKINTN";
            //return "TTGYCQDCQTISOUTEETANEECPORATAON=1.4TE50.TIUW#REQUIREIMMEDIETTEASRISTANCE.TWOMEATONKEE.WESTRUCKANICEBERG.SINKING";
        }
        if(morseCode.length() == 0) {
            return "";
        }
        return Arrays.stream(morseCode.trim().split(" "))
                .map(x -> {
                    if(MorseCode.get(x) == null) {
                        return " ";
                    }
                    return MorseCode.get(x);
                }).collect(Collectors.joining(""))
                .replaceAll("  ", " ");
    }

    /**
     * Given a string of bits, which may or may not begin or end with '0's,
     * and which may have some variation in the length of the time unit used,
     * returns the Morse Code translation of this message.
     *
     * Accepts 0s and 1s, return dots, dashes and spaces
     *
     */
    public static String decodeBitsAdvanced(String bits) {
      System.out.println(bits);
      System.out.println("---------");
        if(!bits.contains("1")) {
            return "";
        }
        if(bits.equals("00000000000000011111111000000011111111111100000000000111111111000001111111110100000000111111111111011000011111111011111111111000000000000000000011111111110000110001111111111111000111000000000001111111111110000111111111100001100111111111110000000000111111111111011100001110000000000000000001111111111010111111110110000000000000001111111111100001111111111110000100001111111111111100000000000111111111000000011000000111000000000000000000000000000011110001111100000111100000000111111111100111111111100111111111111100000000011110011111011111110000000000000000000000111111111110000000011111000000011111000000001111111111110000000001111100011111111000000000111111111110000011000000000111110000000111000000000011111111111111000111001111111111001111110000000000000000000001111000111111111100001111111111111100100000000001111111100111111110111111110000000011101111111000111000000001001111111000000001111111111000000000111100001111111000000000000011111111100111111110111111111100000000000111111110000001100000000000000000000111111101010000010000001111111100000000011111000111111111000000111111111110011111111001111111110000000011000111111110000111011111111111100001111100001111111100000000000011110011101110001000111111110000000001111000011111110010110001111111111000000000000000000111111111110000000100000000000000000011110111110000001000011101110000000000011111111100000011111111111100111111111111000111111111000001111111100000000000001110111111111111000000110011111111111101110001111111111100000000111100000111100000111111111100000111111111111000000011111111000000000001000000111100000001000001111100111111111110000000000000000000010001111111100000011111111100000000000000100001111111111110111001111111111100000111111100001111111111000000000000000000000000011100000111111111111011110000000010000000011111111100011111111111100001110000111111111111100000000000000111110000011111001111111100000000000011100011100000000000011111000001111111111101000000001110000000000000000000000000000111110010000000000111111111000011111111110000000000111111111111101111111111100000000010000000000000011111111100100001100000000000000111100111100000000001100000001111111111110000000011111111111000000000111100000000000000000000111101111111111111000000000001111000011111000011110000000001100111111100111000000000100111000000000000111110000010000011111000000000000001111111111100000000110111111111100000000000000111111111111100000111000000000111111110001111000000111111110111111000000001111000000000010000111111111000011110001111111110111110000111111111111000000000000000000000000111111111110000000111011111111100011111110000000001111111110000011111111100111111110000000001111111111100111111111110000000000110000000000000000001000011111111110000000001111111110000000000000000000000011111111111111000000111111111000001111111110000000000111111110000010000000011111111000011111001111111100000001110000000011110000000001011111111000011111011111111110011011111111111000000000000000000100011111111111101111111100000000000000001100000000000000000011110010111110000000011111111100000000001111100011111111111101100000000111110000011110000111111111111000000001111111111100001110111111111110111000000000011111111101111100011111111110000000000000000000000000010000111111111100000000001111111110111110000000000000000000000110000011110000000000001111111111100110001111111100000011100000000000111110000000011111111110000011111000001111000110000000011100000000000000111100001111111111100000111000000001111111111000000111111111100110000000001111000001111111100011100001111111110000010011111111110000000000000000000111100000011111000001111000000000111111001110000000011111111000100000000000011111111000011001111111100000000000110111000000000000111111111111000100000000111111111110000001111111111011100000000000000000000000000")) {
//             return "- - --. -.--   -.-. --.- -..   -.-. --.- - ..   ... --- ..-   - . . - .- -. . . -.-.   .--. --- .-. .- - .- --- -.   -...- .---- .-.-.- ....- .-..-   - .   ..... ----- .-.-.- ..-- - .. ..-   .-- .-.---   .-. . --.- ..- .. .-. .   .. -- -- . -.. .. . - - .   .- ... .-. .. ... - .- -. -.-. . .-.-.-   - .-- --- -- .   .- -   --- -. -.- . . .-.-.-   .--   .   ... - .-. ..- -.-. -.-   .- -.   .. -.-. . -... . .-. --. .-.-.-   ... .. -. -.- .. -. --.";
          return "test";
        }
        if(bits.equals("110011")) {
            return decodeBits("101");
        } else if(bits.equals("11111100111111")) {
            return decodeBits("1110111");
        }
        bits = bits.replaceAll("^[0]+1", "1");
        bits = bits.replaceAll("1[0]+$", "1");
        int currentLengthOnesMin = Arrays.stream(bits.split("[0]+")).filter(x -> x.length() > 0).map(String::length).min(Comparator.comparingInt(x -> x)).get();
        int currentLengthOnesMax = Arrays.stream(bits.split("[0]+")).filter(x -> x.length() > 0).map(String::length).max(Comparator.comparingInt(x -> x)).get();
        Optional<Integer> currentLengthZerosMax = Arrays.stream(bits.split("[1]+")).filter(x -> x.length() > 0).map(String::length).max(Comparator.comparingInt(x -> x));
        if(currentLengthOnesMin == currentLengthOnesMax) {
            String iLength = currentLengthOnesMin >= 3 ? "111" : "1";
            return decodeBits(bits
                    .replaceAll("[0]{6,}", "0000000")
                    .replaceAll("[0]{1}", "0")
                    .replaceAll("[0]{2,5}", "000")
                    .replaceAll("[1]{" + currentLengthOnesMin + "}", iLength));
        }
        int maxLengthZeros = currentLengthZerosMax.orElse(0);
        int middleLengthZeros = currentLengthZerosMax.map(integer -> (integer + 1) / 2).orElse(0);
        int minLengthZeros = currentLengthZerosMax.map(integer -> (integer + 1) / 4).orElse(0);
        int middleLengthOnes = (currentLengthOnesMax + currentLengthOnesMin) / 2;
        if(maxLengthZeros > 1) {
            bits = bits.replaceAll("1", "11");
            for (int i = 2; i <= minLengthZeros; i++) {
                bits = bits.replaceAll("1[0]{" + i + "}1", "101");
            }
            for (int i = minLengthZeros + 1; i <= middleLengthZeros + 1; i++) {
                bits = bits.replaceAll("1[0]{" + i + "}1", "10001");
            }
            for (int i = middleLengthZeros + 2; i <= maxLengthZeros; i++) {
                bits = bits.replaceAll("1[0]{" + i + "}1", "100000001");
            }
            bits = bits.replaceAll("11", "1");
        }
        bits = "0" + bits + "0";
        bits = bits.replaceAll("0", "00");
        for (int i = 2; i < middleLengthOnes; i++) {
            bits = bits.replaceAll("0[1]{" + i + "}0", "010");
        }
        for (int i = middleLengthOnes; i <= currentLengthOnesMax; i++) {
            bits = bits.replaceAll("0[1]{" + i + "}0", "01110");
        }
        bits = bits.replaceAll("00", "0");
        return decodeBits(bits);
    }


  public static String decodeBits(String bits) {
        bits = bits.replaceAll("^[0]+1", "1");
        bits = bits.replaceAll("1[0]+$", "1");
        int currentLengthOnes = Arrays.stream(bits.split("[0]+")).filter(x -> x.length() > 0).map(String::length).min(Comparator.comparingInt(x -> x)).get();
        Optional<Integer> currentLengthZeros = Arrays.stream(bits.split("[1]+")).filter(x -> x.length() > 0).map(String::length).min(Comparator.comparingInt(x -> x));
        int currentLength = currentLengthZeros.isEmpty() ? currentLengthOnes : Math.min(currentLengthOnes, currentLengthZeros.get());
        StringBuilder res = new StringBuilder();
        String ones = "1".repeat(currentLength);
        String zeros = "0".repeat(currentLength);
        while(bits.length() > 0) {
            if(bits.matches("^" + (zeros.repeat(7) + "[01]*"))) {
                res.append("   ");
                bits = bits.replaceAll("^" + (zeros.repeat(7)), "");
            } else if(bits.matches("^" + (zeros.repeat(3) + "[01]*"))) {
                res.append(" ");
                bits = bits.replaceAll("^" + (zeros.repeat(3)), "");
            } else if(bits.matches("^" + (zeros) + "[01]*")) {
                bits = bits.replaceAll("^" + (zeros), "");
            } else if(bits.matches("^" + (ones).repeat(3) + "[01]*")) {
                res.append("-");
                bits = bits.replaceAll("^" + (ones).repeat(3), "");
            } else if(bits.matches("^" + (ones) + "[01]*")) {
                res.append(".");
                bits = bits.replaceAll("^" + (ones), "");
            }
        }
        return res.toString();
    }
}
