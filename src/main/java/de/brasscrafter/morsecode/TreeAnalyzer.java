package de.brasscrafter.morsecode;
public class TreeAnalyzer {
    public TreeAnalyzer(){

    }
    public <T> int gibTiefe(BinaryTree<T> binaryTree){
        if(null == binaryTree || binaryTree.isEmpty())
            return -1;
        else{
            int links = gibTiefe(binaryTree.getLeftTree());
            int rechts = gibTiefe(binaryTree.getRightTree());
            if(links >= rechts) {
                System.out.println("links");
                return links + 1;
            }
            System.out.println("rechts");
            return rechts + 1;

        }
    }
    public <T> int gibGesamtKnotenAnzahl(BinaryTree<T> binaryTree){
        if(null == binaryTree || binaryTree.isEmpty())
            return 0;
        return 1 + gibGesamtKnotenAnzahl(binaryTree.getLeftTree()) + gibGesamtKnotenAnzahl(binaryTree.getRightTree());
    }
    public <T> int gibAnzahlDerBlätter(BinaryTree<T> binaryTree){
        if((null == binaryTree.getLeftTree() && null == binaryTree.getRightTree()) || (binaryTree.getLeftTree().isEmpty() && binaryTree.getRightTree().isEmpty()))
            return 1;
        return gibAnzahlDerBlätter(binaryTree.getLeftTree()) + gibAnzahlDerBlätter(binaryTree.getRightTree());
    }
    public int gibMaximumDesBaumes(BinaryTree<Integer> binaryTree){
        if(null == binaryTree || binaryTree.isEmpty())
            return 0;
        int links = gibMaximumDesBaumes(binaryTree.getLeftTree());
        int rechts = gibMaximumDesBaumes(binaryTree.getRightTree());
        if(binaryTree.getContent() > links || binaryTree.getContent() > rechts)
            return binaryTree.getContent();
        else{
            if(links > rechts)
                return links;
            return rechts;
        }
    }
    public int gibSummeAllerKnoten(BinaryTree<Integer> binaryTree){
        if(null == binaryTree || binaryTree.isEmpty())
            return 0;
        return binaryTree.getContent() + gibSummeAllerKnoten(binaryTree.getLeftTree()) + gibSummeAllerKnoten(binaryTree.getRightTree());
    }
    public static void main(String[] args) {
        TreeAnalyzer treeAnalyzer = new TreeAnalyzer();
        BinaryTree <Integer> binaryTree = new BinaryTree<Integer>(0, new BinaryTree<Integer>(1, new BinaryTree<Integer>(3), new BinaryTree<Integer>(5)), new BinaryTree<Integer>(2, new BinaryTree<Integer>(4), new BinaryTree<Integer>(6)));
        System.out.println("Tiefe => " + treeAnalyzer.gibTiefe(binaryTree));
        System.out.println(treeAnalyzer.gibGesamtKnotenAnzahl(binaryTree));
        System.out.println(treeAnalyzer.gibAnzahlDerBlätter(binaryTree));
        System.out.println(treeAnalyzer.gibSummeAllerKnoten(binaryTree));
        System.out.println(treeAnalyzer.gibMaximumDesBaumes(binaryTree));
    }
}
