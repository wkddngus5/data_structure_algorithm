package section2.redblacktree;

/**
 * Created by Woohyeon on 2017. 12. 24..
 */

enum Color {
    RED, BLACK
}

public abstract class Node {
    public Node parent;

    public Node leftChild;

    public Node rightChild;

    public Color color;

    public boolean isNilNode() {
        return this.equals(NilNode.getNilNode());
    }

    public boolean isBiggerThanIntput(Node inputNode) {
        if(isNilNode() || inputNode.isNilNode()) {
            System.err.println("NIL node can't compare");
            return false;
        }
        return ((RealNode)this).value > ((RealNode)inputNode).value;
    }

    @Override
    public String toString() {
        if(isNilNode()) {
            return "NIL Node";
        }
        return "Node{" +
                "value=" + ((RealNode)this).value +
                ", color=" + color +
                '}';
    }
}
