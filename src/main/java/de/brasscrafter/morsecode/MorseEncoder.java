package de.brasscrafter.morsecode;

public class MorseEncoder {
    String[] morseAlphabet;
    String msg, morse;
    public MorseEncoder() {
        morseAlphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "/"};

        this.msg = "";
        this.morse = "";
    }
    public String encode(String msg) {
        this.msg = msg.toUpperCase();
        char firstCharacter = cutFirst();
        if(firstCharacter == '#') {
            return "";
        }
        if(firstCharacter - 'B' <= 'Z' - 'B' && firstCharacter - 'B' >= 1) {
            return morseAlphabet[firstCharacter - 'A'] + morseAlphabet[26] + encode(this.msg);
        }
        if(firstCharacter == ' ')
            return morseAlphabet[26] + encode(this.msg);
        return "{Zeichen nicht gefunden}";
    }
    private char cutFirst(){
        if(!this.msg.isEmpty()){
            char first = this.msg.charAt(0);
            this.msg = this.msg.substring(1);
            return first;
        }
        return '#';
    }
    public static void main(String[] args) {
        MorseEncoder morseEncoder = new MorseEncoder();
        String msg = "Hello World";
        System.out.println(msg + " = " + morseEncoder.encode(msg));
    }
}