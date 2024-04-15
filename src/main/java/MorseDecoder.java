public class MorseDecoder {
    BinaryTree <String> morseTree;
    public MorseDecoder() {
        morseTree = new BinaryTree<>("/");
        BinaryTree <String> bS = new BinaryTree<>("S", new BinaryTree<String>("H"), new BinaryTree<String>("V"));
        BinaryTree <String> bU = new BinaryTree<>("U", new BinaryTree<String>("F"), new BinaryTree<String>("Ü"));
        BinaryTree <String> bI = new BinaryTree<>("I", bS, bU);
        BinaryTree <String> bR = new BinaryTree<>("R", new BinaryTree<String>("L"), new BinaryTree<String>("Ä"));
        BinaryTree <String> bW = new BinaryTree<>("W", new BinaryTree<String>("P"), new BinaryTree<String>("J"));
        BinaryTree <String> bA = new BinaryTree<>("A", bR, bW);
        BinaryTree <String> bE = new BinaryTree<>("E", bI, bA);

        BinaryTree <String> bD = new BinaryTree<>("D", new BinaryTree<String>("B"), new BinaryTree<String>("X"));
        BinaryTree <String> bK = new BinaryTree<>("K", new BinaryTree<String>("C"), new BinaryTree<String>("Y"));
        BinaryTree <String> bN = new BinaryTree<>("N", bS, bU);
        BinaryTree <String> bG = new BinaryTree<>("G", new BinaryTree<String>("Z"), new BinaryTree<String>("Q"));
        BinaryTree <String> bO = new BinaryTree<>("O", new BinaryTree<String>("Y"), new BinaryTree<String>("CH"));
        BinaryTree <String> bM = new BinaryTree<>("M", bR, bW);
        BinaryTree <String> bT = new BinaryTree<>("T", bI, bA);
    }
}
