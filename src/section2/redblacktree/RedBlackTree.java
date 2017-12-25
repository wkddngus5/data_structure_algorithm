package section2.redblacktree;

import java.util.*;

/**
 * Created by Woohyeon on 2017. 12. 24..
 */
public class RedBlackTree {
    public RealNode root;

    public void insert(RealNode node) {
        node.color = Color.RED;

        Node parentNode = null;
        Node currentNode = root;
        boolean childIsLeft = false;

        while(!currentNode.isNilNode()) {
            parentNode = currentNode;
            if(currentNode.isBiggerThanIntput(node)) {
                currentNode = currentNode.leftChild;
                childIsLeft = true;
            }  else {
                currentNode = currentNode.rightChild;
                childIsLeft = false;
            }
        }
        node.parent = parentNode;
        if(childIsLeft) {
            parentNode.leftChild = node;
        } else {
            parentNode.rightChild = node;
        }
        insertFixup(node);
    }

    public void insertFixup(Node fixupNode) {
        Node uncleNode;
        while (fixupNode.parent.color == Color.RED) {
            if(fixupNode.parent == fixupNode.parent.parent.leftChild) {
                uncleNode = fixupNode.parent.parent.rightChild;
                if(uncleNode.color == Color.RED) {
                    fixupNode.parent.color = Color.BLACK;
                    uncleNode.color = Color.BLACK;
                    fixupNode.parent.parent.color = Color.RED;
                    fixupNode = fixupNode.parent.parent;
                } else {
                    if(fixupNode.equals(fixupNode.parent.rightChild)) {
                        fixupNode = fixupNode.parent;
                        leftRotate(fixupNode);
                    }
                    fixupNode.parent.color = Color.BLACK;
                    fixupNode.parent.parent.color = Color.RED;
                    rightRotate(fixupNode.parent.parent);
                }
            } else {
                uncleNode = fixupNode.parent.parent.leftChild;
                if(uncleNode.color == Color.RED) {
                    fixupNode.parent.color = Color.BLACK;
                    uncleNode.color = Color.BLACK;
                    fixupNode.parent.parent.color = Color.RED;
                    fixupNode = fixupNode.parent.parent;
                } else {
                    if(fixupNode.equals(fixupNode.parent.leftChild)) {
                        fixupNode = fixupNode.parent;
                        rightRotate(fixupNode.parent.parent);
                    }
                    fixupNode.parent.color = Color.BLACK;
                    fixupNode.parent.parent.color = Color.RED;
                    leftRotate(fixupNode.parent.parent);
                }
            }
            root.color = Color.BLACK;
        }
    }

    public void transplant(Node oldNode, Node plantNode) {
        if(oldNode.parent.isNilNode()) {
            root = (RealNode)plantNode;
        }

        if(oldNode.equals(oldNode.parent.leftChild)) {
            oldNode.parent.leftChild = plantNode;
        } else {
            oldNode.parent.rightChild = plantNode;
        }
        plantNode.parent = oldNode;
    }

    public Node getMinimumNode(Node node) {
        Node currentMinimumNode = node;
        while(!currentMinimumNode.leftChild.isNilNode()) {
            currentMinimumNode = currentMinimumNode.leftChild;
        }
        return currentMinimumNode;
    }

    public void delete(Node node) {
        Node fixupNode;
        Node successor;
        Color erasedColor = node.color;

        if(node.leftChild.isNilNode()) {
            fixupNode = node.rightChild;
            transplant(node, node.rightChild);
        } else if(node.rightChild.isNilNode()) {
            fixupNode = node.leftChild;
            transplant(node, node.leftChild);
        } else {
            successor = getMinimumNode(node.rightChild);
            erasedColor = successor.color;
            fixupNode = successor.rightChild;
            if(successor.parent == node) {
                fixupNode.parent = successor;
            } else {
                transplant(successor, successor.rightChild);
                successor.rightChild = node.rightChild;
                successor.rightChild.parent = successor;
            }
            transplant(node, successor);
            successor.leftChild = node.leftChild;
            successor.color = node.color;
        }
        if(erasedColor == Color.BLACK) {
            deleteFixup(fixupNode);
        }
    }

    public void deleteFixup(Node fixupNode) {
        Node sibling;
        while(!fixupNode.equals(root) && fixupNode.color == Color.BLACK) {
            if(fixupNode.equals(fixupNode.parent.leftChild)) {
                sibling = fixupNode.parent.rightChild;
                if(sibling.color == Color.RED) {
                    sibling.color = Color.BLACK;
                    fixupNode.parent.color = Color.RED;
                    leftRotate(fixupNode.parent);
                    sibling = fixupNode.parent.rightChild;
                }
                if(sibling.leftChild.color == Color.BLACK && sibling.rightChild.color == Color.BLACK) {
                    sibling.color = Color.RED;
                    fixupNode = fixupNode.parent;
                } else {
                    if(sibling.rightChild.color == Color.BLACK) {
                        sibling.leftChild.color = Color.BLACK;
                        sibling.color = Color.RED;
                        rightRotate(sibling);
                        sibling = fixupNode.parent.rightChild;
                    }
                    sibling.color = fixupNode.parent.color;
                    fixupNode.parent.color = Color.BLACK;
                    sibling.rightChild.color = Color.BLACK;
                    leftRotate(fixupNode.parent);
                    fixupNode = root;
                }
            } else {
                sibling = fixupNode.parent.leftChild;
                if(sibling.color == Color.RED) {
                    sibling.color = Color.BLACK;
                    fixupNode.parent.color = Color.RED;
                    rightRotate(fixupNode.parent);
                    sibling = fixupNode.parent.leftChild;
                }
                if(sibling.rightChild.color == Color.BLACK && sibling.leftChild.color == Color.BLACK) {
                    sibling.color = Color.RED;
                    fixupNode = fixupNode.parent;
                } else {
                    if(sibling.leftChild.color == Color.BLACK) {
                        sibling.rightChild.color = Color.BLACK;
                        sibling.color = Color.RED;
                        leftRotate(sibling);
                        sibling = fixupNode.parent.leftChild;
                    }
                    sibling.color = fixupNode.parent.color;
                    fixupNode.parent.color = Color.BLACK;
                    sibling.leftChild.color = Color.BLACK;
                    rightRotate(fixupNode.parent);
                    fixupNode = root;
                }
            }
            fixupNode.color = Color.BLACK;
        }
    }

    public boolean isRedBlackTree() {
        boolean parentIsRed = false;

        Queue<Node> queue = new LinkedList<>();

        if(root == null) {
            return true;
        }

        //ROOT는 black이다.
        if(root.color != Color.BLACK) {
            return false;
        }

        queue.add(root);
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            //각 노드는 red 혹은 black이다
            if(currentNode.color != Color.RED && currentNode.color != Color.BLACK) {
                System.err.println("This node isn't RED OR BLACK");
                return false;
            }

            //각 노드가 red라면 두 개의 children은 모두 black이다
            if(currentNode.color == Color.RED) {
                if(currentNode.leftChild.color == Color.RED || currentNode.rightChild.color == Color.RED) {
                    System.err.println("Both parent and child are red");
                    return false;
                }
            }

            if(!currentNode.leftChild.isNilNode()) {
                queue.add((RealNode)currentNode.leftChild);
            }

            if(!currentNode.rightChild.isNilNode()) {
                queue.add((RealNode)currentNode.rightChild);
            }

            if(getBlackHeight(currentNode.leftChild) != getBlackHeight(currentNode.rightChild)) {
                return false;
            }
//            System.out.println(queue);
        }

        return true;
    }

    public int getBlackHeight(Node node) {
        if(node == null) {
            return 0;
        }

        if(node.isNilNode()) {
            return 1;
        }

        int leftBlackHeight = getBlackHeight(node.leftChild);
        int rightBlackHeight = getBlackHeight(node.leftChild);
        int result = leftBlackHeight > rightBlackHeight ? leftBlackHeight : rightBlackHeight;
        if(node.color == Color.BLACK) {
            result++;
        }

        return result;
    }

    public void leftRotate(Node node) {
        Node y = node.rightChild;
        node.rightChild = y.leftChild;

        if(!y.leftChild.isNilNode()) {
            y.leftChild.parent = node;
        }

        y.parent = node.parent;

        if(node.parent.isNilNode()) {
            root = (RealNode)y;
        } else if(node.equals(node.parent.leftChild)) {
            node.parent.leftChild = y;
        } else {
            node.parent.rightChild = y;
        }
        y.leftChild = node;
        node.parent = y;
    }

    public void rightRotate(Node node) {
        Node x = node.leftChild;
        node.leftChild = x.rightChild;

        if(!x.rightChild.isNilNode()) {
            x.rightChild.parent = node;
        }

        x.parent = node.parent;

        if(node.parent.isNilNode()) {
            root = (RealNode)x;
        } else if(node.equals(node.parent.leftChild)) {
            node.parent.leftChild = x;
        } else {
            node.parent.rightChild = x;
        }

        x.rightChild = node;
        node.parent = x;
    }

    public void printTree() {
        Queue<Node> queue = new LinkedList<>();
        Node currentNode;

        if(root == null) {
            return;
        }

        queue.add(root);
        while(!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.print(currentNode + "   |   ");
            if(!currentNode.leftChild.isNilNode()) {
                queue.add(currentNode.leftChild);
            }
            if(!currentNode.rightChild.isNilNode()) {
                queue.add(currentNode.rightChild);
            }
        }
        System.out.println();
    }
}
