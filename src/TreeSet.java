public class TreeSet<V> {
    private int size = 0;
    private Node root = null;
    private class Node {
        public V value;
        public Node left = null;
        public Node right = null;
        public Node ( V value) {
            this.value = value;
        }
    }

    public V put( V value) {
        if (root == null) {
            root = new Node(value);
            size++;
            return null;
        }
        return putHelper(root,value);
    }
    public V getRoot(){
        return root.value;
    }
    private V putHelper(Node node, V value) {
        Comparable<? super V> k = (Comparable<? super V>)value;
        int cmp = k.compareTo(node.value);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(value);
                size++;
                return null;
            }
            return putHelper(node.left,value);
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node( value);
                size++;
                return null;
            }
            return putHelper(node.right,value);
        }
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }
    public V get(Object value) {
        Node node = findNode(value);
        if (node == null) return null;
        return node.value;
    }
    private Node findNode(Object target) {
        Comparable<? super V> k = (Comparable<? super V>) target;
        Node node = root;
        while (node != null) {
            int cmp = k.compareTo(node.value);
            if (cmp < 0) {
                node = node.left;
            }
            if (cmp > 0) {
                node = node.right;
            }
            if (cmp == 0) return node;
        }
        return null;
    }
    private Node findParent(Object target) {
        Comparable<? super V> k = (Comparable<? super V>) target;
        Node node = root;
        Node parent = root;
        while (node != null) {
            int cmp = k.compareTo(node.value);
            if (cmp < 0) {
                parent = node;
                node = node.left;
            }
            if (cmp > 0) {
                parent = node;
                node = node.right;
            }
            if (cmp == 0) return parent;
        }
        return null;
    }
    public V remove(Object value) {
        V oldValue = get(value);
        if (value == root.value) {
            Node tempNode = findSmallest(root.right);
            delRecursive(tempNode.value);
            root.value = tempNode.value;
        }
        else {
            delRecursive(value);
        }
        return oldValue;
    }
    private Node delRecursive(Object value) {
        Node node = findNode(value);
        Node parent = findParent(value);
        if (node.left == null && node.right == null) {
            if (node == parent.left) parent.left = null;
            if (node == parent.right) parent.right = null;
            size--;
            return parent;
        }
        if (node.right == null) {
            if (node == parent.left) parent.left = node.left;
            if (node == parent.right) parent.right = node.left;
            size--;
            return parent;
        }
        if (node.left == null) {
            if (node == parent.left) parent.left = node.right;
            if (node == parent.right) parent.right = node.right;
            size--;
            return parent;
        }
        Node tempNode = findSmallest(node.right);
        delRecursive(tempNode.value);
        node.value = tempNode.value;
        return parent;
    }
    private Node findSmallest(Node node) {
        if (node.left == null) return node;
        else {
            return findSmallest(node.left);
        }
    }
    public void printTree() {
        LER(root);
        System.out.println("____");
    }
    private void LER(Node node) {
        if (node.left != null) LER(node.left);
        System.out.println(node.value);
        if (node.right != null) LER(node.right);
    }
}