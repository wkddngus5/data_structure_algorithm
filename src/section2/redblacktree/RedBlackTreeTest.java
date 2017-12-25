package section2.redblacktree;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Created by Woohyeon on 2017. 12. 25..
 */

public class RedBlackTreeTest {
    RedBlackTree redBlackTree;

    @Before
    public void init() {
        redBlackTree = new RedBlackTree();
        RealNode node1 = new RealNode(11);
        node1.color = Color.BLACK;
        RealNode node2 = new RealNode(2);
        node2.color = Color.RED;
        RealNode node3 = new RealNode(14);
        node3.color = Color.BLACK;
        RealNode node4 = new RealNode(1);
        node4.color = Color.BLACK;
        RealNode node5 = new RealNode(7);
        node5.color = Color.BLACK;
        RealNode node6 = new RealNode(15);
        node6.color = Color.RED;
        RealNode node7 = new RealNode(5);
        node7.color = Color.RED;
        RealNode node8 = new RealNode(8);
        node8.color = Color.RED;

        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.parent = node1;
        node2.leftChild = node4;
        node2.rightChild = node5;
        node3.parent = node1;
        node3.rightChild = node6;
        node4.parent = node2;
        node5.parent = node2;
        node5.leftChild = node7;
        node5.rightChild = node8;
        node6.parent = node3;
        node7.parent = node5;
        node8.parent = node5;

        redBlackTree.root = node1;
    }

    @Test
    public void isNilNode() {
        Node node1 = NilNode.getNilNode();
        assertTrue(node1.isNilNode());
    }

    @Test
    public void isRedBlackTree() {
        assertTrue(redBlackTree.isRedBlackTree());
    }

    @Test
    public void isRedBlackTree2() {
        redBlackTree.root.rightChild.rightChild.color = Color.BLACK;
        assertTrue(!redBlackTree.isRedBlackTree());
    }

    @Test
    public void getBlackHeight() {
        System.out.println(redBlackTree.getBlackHeight(redBlackTree.root));
    }

    @Test
    public void insert() {
        assertTrue(redBlackTree.isRedBlackTree());
        redBlackTree.insert(new RealNode(13));
        assertTrue(redBlackTree.isRedBlackTree());
    }

    @Test
    public void deleteNode() {
        RealNode testNode = new RealNode(3);
        assertTrue(redBlackTree.isRedBlackTree());
        redBlackTree.insert(testNode);
        assertTrue(redBlackTree.isRedBlackTree());
        redBlackTree.delete(testNode);
        assertTrue(redBlackTree.isRedBlackTree());
    }
}
