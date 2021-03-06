public class BinaryTreeNode<T> {
    //fields
    protected T data;
    protected BinaryTreeNode<T> left;
    protected BinaryTreeNode<T> right;

    //constructors
    public BinaryTreeNode(T data) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        this.data = data;
        left = null;
        right = null;
    }

    //methods
    public T getData(){
        return data;
    }

    public BinaryTreeNode<T> getLeft(){
        return left;
    }

    public BinaryTreeNode<T> getRight(){
        return right;
    }

    public void setData(T data){
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        this.data = data;
    }

    public void setLeft(BinaryTreeNode<T> left){
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right){
        this.right = right;
    }

    public void insert(T element) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        if (Math.random() < 0.5)
            if (left == null)
                left = new BinaryTreeNode<T>(element);
            else
                left.insert(element);
        else
            if (right == null)
                right = new BinaryTreeNode<T>(element);
            else
                right.insert(element);
    }

    public BinaryTreeNode<T> remove(T toRemove) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        BinaryTreeNode<T> returnData = null;
        if (data.equals(toRemove)) {
            if (left != null) {
                data = left.data;
                left = left.remove(data);
            }
            else if (right != null) {
                data = right.data;
                right = right.remove(data);
            }
            else {
                return null;
            }
        }
        else if (left != null && left.contains(toRemove)) {
            left = left.remove(toRemove);
        }
        else if (right != null && right.contains(toRemove)) {
            right = right.remove(toRemove);
        }
        return this;
    }

    public boolean contains(T element) {
        if (data == null)
            throw new IllegalArgumentException("Null argument");
        if (data.equals(element))
            return true;
        return left != null && left.contains(element) || right != null && right.contains(element);
    }

    public int height() {
        int heightR = -1, heightL = -1;
        if (left != null)
            heightL = left.height();
        if (right != null)
            heightR = right.height();
        return Math.max(heightL, heightR) + 1;
    }

    public int size() {
        int sizeR = 0, sizeL = 0;
        if (left != null)
            sizeL = left.size();
        if (right != null)
            sizeR = right.size();
        return sizeL + sizeR + 1;
    }

    public boolean equals(Object other){
        if (!(other instanceof BinaryTreeNode<?>))
            return false;
        if (!data.equals(((BinaryTreeNode<?>) other).data))
            return false;
        boolean result = true;
        if (left != null)
            result = left.equals(((BinaryTreeNode<?>) other).left);
        else
            result = ((BinaryTreeNode<?>) other).left == null;
        if (result) //checking if right = other.right
            if (right != null)
                result = right.equals(((BinaryTreeNode<?>) other).right);
            else
                result = ((BinaryTreeNode<?>) other).right == null;
        return result;
    }

    public String toString() {
        return toString("") + "\n";
    }

    private String toString(String depth) {
        String ans = "";
        if (right != null)
            ans = ans + right.toString(depth + "  ") + "\n";
        ans = ans + depth + data;
        if (left != null)
            ans = ans + "\n" + left.toString(depth + "  ");
        return ans;
    }
}