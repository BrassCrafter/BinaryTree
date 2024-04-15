public class MorseDecoder {
    BinaryTree <String> morseTree;
    BinaryTree <String> currentTree;
    String morseCode;
    public MorseDecoder() {
        morseTree = new BinaryTree<>("/", createLeftMorseTree(), createRightMorseTree());
        currentTree = morseTree;
        morseCode = "";
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
    public String decode(String morseCode){
        String decodedCharacter;
        this.morseCode = morseCode;
        System.out.println("MorseCode before cuttingFirst" + this.morseCode);
        char firstCharacter = cutFirstCharacter();
        System.out.println("MorseCode after cuttingFirst" + this.morseCode);
        if('#' == firstCharacter)
            return "";
        if('/' == firstCharacter){
            if("/".equals(currentTree.getContent())){
                decodedCharacter = " ";
            }else{
                decodedCharacter = currentTree.getContent();
            }
            currentTree = morseTree;
            return decodedCharacter + decode(this.morseCode);
        }else if ('.' == firstCharacter){
            currentTree = currentTree.getLeftTree();
        }else if ('-' == firstCharacter)
            currentTree = currentTree.getRightTree();
        return decode(this.morseCode);
    }
    private char cutFirstCharacter(){
        if(!this.morseCode.isEmpty()) {
            char firstCharacter = this.morseCode.charAt(0);
            this.morseCode = this.morseCode.substring(1);
            return firstCharacter;
        }
        return '#';
    }
    public static void main(String[] args) {
        MorseDecoder morseDecoder = new MorseDecoder();
        String morseCode = "...././.-../.-../---//.--/---/.-./.-../-../";
        String decodedMsg = morseDecoder.decode(morseCode);
        System.out.println(morseCode + " = " + decodedMsg);
    }
}