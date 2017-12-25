package section2.redblacktree;

/**
 * Created by Woohyeon on 2017. 12. 24..
 */
public class RealNode extends Node {

    public int value;

    public RealNode(int value) {
        this.value = value;
        this.parent = NilNode.getNilNode();
        this.leftChild = NilNode.getNilNode();
        this.rightChild = NilNode.getNilNode();
    }
}
