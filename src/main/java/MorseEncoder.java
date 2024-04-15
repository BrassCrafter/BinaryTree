import java.util.Objects;

public class MorseEncoder {
    BinaryTree <String> morseTree;
    BinaryTree <String> currentTree;
    String plainMsg, morseCode, searchingFor;
    public MorseEncoder() {
        morseTree = new BinaryTree<>("/", createLeftMorseTree(), createRightMorseTree());
        currentTree = morseTree;
        plainMsg = "";
        morseCode = "";
        searchingFor = "";
    }
    private BinaryTree<String> createLeftMorseTree(){
        BinaryTree <String> bS = new BinaryTree<>("S", new BinaryTree<String>("H"), new BinaryTree<String>("V"));
        BinaryTree <String> bU = new BinaryTree<>("U", new BinaryTree<String>("F"), new BinaryTree<String>("Ü"));
        BinaryTree <String> bI = new BinaryTree<>("I", bS, bU);
        BinaryTree <String> bR = new BinaryTree<>("R", new BinaryTree<String>("L"), new BinaryTree<String>("Ä"));
        BinaryTree <String> bW = new BinaryTree<>("W", new BinaryTree<String>("P"), new BinaryTree<String>("J"));
        BinaryTree <String> bA = new BinaryTree<>("A", bR, bW);
        return new BinaryTree<>("E", bI, bA);
    }
    private BinaryTree<String> createRightMorseTree(){
        BinaryTree <String> bD = new BinaryTree<>("D", new BinaryTree<String>("B"), new BinaryTree<String>("X"));
        BinaryTree <String> bK = new BinaryTree<>("K", new BinaryTree<String>("C"), new BinaryTree<String>("Y"));
        BinaryTree <String> bN = new BinaryTree<>("N", bD, bK);
        BinaryTree <String> bG = new BinaryTree<>("G", new BinaryTree<String>("Z"), new BinaryTree<String>("Q"));
        BinaryTree <String> bO = new BinaryTree<>("O", new BinaryTree<String>("Y"), new BinaryTree<String>("CH"));
        BinaryTree <String> bM = new BinaryTree<>("M", bG, bO);
        return new BinaryTree<>("T", bN, bM);
    }
    public String encode(String plainMsg){
        this.plainMsg = plainMsg;
        System.out.println("plainMsg before cuttingFirst: " + this.plainMsg);
        char firstCharacter = cutFirstCharacter();
        System.out.println("plainMsg after cuttingFirst: " + this.plainMsg);
        this.searchingFor = "" + firstCharacter;
        if('C' == firstCharacter){
            System.out.println("plainMsg before cuttingSecond: " + this.plainMsg);
            char secondCharacter = cutFirstCharacter();
            if('H' == secondCharacter) {
                this.searchingFor = "" + firstCharacter + secondCharacter;
            }else{
                String scndChar = "" + secondCharacter;
                this.plainMsg = scndChar.concat(this.plainMsg);
                System.out.println("plainMsg after concat: " + this.plainMsg);
            }
        }
        String character = encodeCharacter(morseTree);
        System.out.println("Character in morse: " + character);
        if(!character.isEmpty())
            return character + encode(this.plainMsg);

        return "The sequence: " + searchingFor + " contains unsupported symbols.";
    }
    private String encodeCharacter(BinaryTree<String> currentTree) {
        if (currentTree.getContent().equals(this.searchingFor)) {
            System.out.println("Character: " + this.searchingFor + " found.");
            return "/";
        }
        if (null == currentTree.getLeftTree()) {
            String left = encodeCharacter(currentTree.getLeftTree());
            if (left.charAt(left.length() - 1) == '/') {
                return "." + left;
            }
        }
        if (null == currentTree.getRightTree()) {
            String right = encodeCharacter(currentTree.getLeftTree());
            if (right.charAt(right.length() - 1) == '/') {
                return "-" + right;
            }
        }
        return "";
    }
    private char cutFirstCharacter(){
        if(!this.plainMsg.isEmpty()) {
            char firstCharacter = this.plainMsg.charAt(0);
            this.plainMsg = this.plainMsg.substring(1);
            return firstCharacter;
        }
        return '#';
    }
    public static void main(String[] args) {
        MorseEncoder morseEncoder = new MorseEncoder();
        String plainMsg = "CJ";
        String morseMsg = morseEncoder.encode(plainMsg);

    }
}