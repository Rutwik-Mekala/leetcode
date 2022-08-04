import java.lang.reflect.Array;
import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static Node insert(Node root, int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(val<root.data){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
            return search(root.left, key);
        }else if(root.data==key){
            return true;
        }else{
            return search(root.right,key);
        }
    }
    public static Node delete(Node root, int val){
        if(root.data>val){
            return delete(root.left,val);
        }else if(root.data<val){
            return delete(root.right,val);
        }else{
            //case 1
            //when its a leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //when there's only one child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            //when there's two children
            Node IS = inorderNext(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    public static Node inorderNext(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root, int X, int Y){
        if(root==null) return;
        if(root.data>=X && root.data<=Y){
            printInRange(root.left,X,Y);
            System.out.print(root.data+" ");
            printInRange(root.right,X,Y);
        }else if(root.data>=Y){
            printInRange(root.left,X,Y); // the range lies only in left subtree
        }else{
            printInRange(root.right,X,Y);
        }
    }
    public static void printArray(ArrayList<Integer> arr){
        for(int i: arr){
            System.out.print(i+"->");
        }
        System.out.println();
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.data);
        if(root.left==null && root.right==null){
            printArray(arr);
        }
        else{
            printRoot2Leaf(root.left, arr);
            printRoot2Leaf(root.right, arr);
        }
        arr.remove(arr.size()-1);
    }
    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();
        if(search(root,6)){
            System.out.println("found");
        }else{
            System.out.println("Not found");
        }
        delete(root,5);
        inorder(root);
        System.out.println();
        printInRange(root,3,7);
        System.out.println();
        printRoot2Leaf(root,new ArrayList<>());
    }
}
