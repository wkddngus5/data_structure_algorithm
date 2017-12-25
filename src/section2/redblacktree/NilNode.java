package section2.redblacktree;

/**
 * Created by Woohyeon on 2017. 12. 24..
 */
public class NilNode extends Node {

    private static NilNode nilNode = new NilNode();

    public static NilNode getNilNode() {
        if(nilNode == null) {
            nilNode = new NilNode();
        }
        return nilNode;
    }

    private NilNode() {
        this.color = Color.BLACK;
    };
}
