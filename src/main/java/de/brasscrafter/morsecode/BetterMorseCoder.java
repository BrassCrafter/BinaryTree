package de.brasscrafter.morsecode;
public class BetterMorseCoder {
    BinaryTree <Character> morseTree;
    public BetterMorseCoder(){
        morseTree = new BinaryTree<>(' ', createLeftMorseTree(), createRightMorseTree());
    }
    private BinaryTree<Character> createLeftMorseTree(){
        BinaryTree<Character> bS = new BinaryTree<>('S', new BinaryTree<Character>('H'), new BinaryTree<Character>('V'));
        BinaryTree<Character> bU = new BinaryTree<>('U', new BinaryTree<Character>('F'), new BinaryTree<Character>('Ü'));
        BinaryTree<Character> bI = new BinaryTree<>('I', bS, bU);
        BinaryTree<Character> bR = new BinaryTree<>('R', new BinaryTree<Character>('L'), new BinaryTree<Character>('Ä'));
        BinaryTree<Character> bW = new BinaryTree<>('W', new BinaryTree<Character>('P'), new BinaryTree<Character>('J'));
        BinaryTree<Character> bA = new BinaryTree<>('A', bR, bW);
        return new BinaryTree<>('E', bI, bA);
    }
    private BinaryTree<Character> createRightMorseTree(){
        BinaryTree<Character> bD = new BinaryTree<>('D', new BinaryTree<Character>('B'), new BinaryTree<Character>('X'));
        BinaryTree<Character> bK = new BinaryTree<>('K', new BinaryTree<Character>('C'), new BinaryTree<Character>('Y'));
        BinaryTree<Character> bN = new BinaryTree<>('N', bD, bK);
        BinaryTree<Character> bG = new BinaryTree<>('G', new BinaryTree<Character>('Z'), new BinaryTree<Character>('Q'));
        BinaryTree<Character> bO = new BinaryTree<>('O', new BinaryTree<Character>('Y'), new BinaryTree<Character>());
        BinaryTree<Character> bM = new BinaryTree<>('M', bG, bO);
        return new BinaryTree<>('T', bN, bM);
    }
    public String generateMorseCode(String msg){
        msg = msg.toUpperCase();
        String msgInMorse = "";
        for(int i = 0; i < msg.length(); i++){
            msgInMorse += getMorsePath(msg.charAt(i), "", morseTree) + "/";
        }
        return msgInMorse;
    }
    private String getMorsePath(char character, String path, BinaryTree<Character> tree){
        if(tree.isEmpty())
            return "";
        else {
            if(tree.getContent() == character)
                return path;
            else{
                String left = getMorsePath(character, path + ".", tree.getLeftTree());
                if(!left.isEmpty())
                    return left;
                return getMorsePath(character, path + "-", tree.getRightTree());
            }
        }
    }

    public static void main(String[] args) {
        BetterMorseCoder morseCoder = new BetterMorseCoder();
        String msg = "Hello World";
        System.out.println("Message: " + msg + " ==TO==MORSE==CODE==> " + morseCoder.generateMorseCode(msg));
    }
}
