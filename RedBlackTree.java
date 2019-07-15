/**
Name: Michael Garrison
Date: 11/10/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class RedBlackTree extends RedBlackNode implements TreeInterface{
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;
    private RedBlackNode nullNode;
    private static final int BLACK = 1;
    private static final int RED = 0;

    public RedBlackTree(){
        nullNode = new RedBlackNode(null);
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode(null);
        header.left = header.right = nullNode;
    }
    
    public String find(int key){
        nullNode.element.key = key;
        current = header.right;
        for( ; ; ){
        if (key < current.element.key)
            current = current.left;
        else if (key > current.element.key)
            current = current.right;
        else if (current != nullNode)
            return current.element.getValue();
        else
            return null;
        }       
    }
    
    public void insert (int key, String value){
        current = parent = grand = header;
        nullNode.element.key = key;
        nullNode.element.value= value;
        
        while(compare(nullNode, current) != 0){
            great = grand; grand = parent; parent = current;
            current = compare(nullNode, current) < 0 ?
                    current.left : current.right;
            
            //Checks for two red children and will rotate
            if(current.left.color == RED && current.right.color == RED)
                handleReorient(nullNode);
        }
        //Insertion fails if the node is already present
        if(current != nullNode)
            return;
        current = new RedBlackNode (nullNode.element, nullNode, nullNode);
        //Attach node to parent
        if(compare(nullNode, parent) < 0)
            parent.left = current;
        else
            parent.right = current;
        handleReorient(nullNode); 
    }
    
    public void delete (int key){
        if(find(key) != null){
            if(header.left.color == BLACK && header.right.color == BLACK)
                header.color = RED;
            header = delete(header, key);
        }
        else{
        }
    }
    
        @Override
    public String remove(int key) {
        if(find(key) == null){
            return null;
        }
        current = findNode(key);
        String data = current.element.value;
        current = null;
        return data;
    }
     
   
    public String toString(){
        current = header;
        String prefix = "root";
        String firstCase = "";
        String secondCase = "";
        String thirdCase = "";
        String fourthCase = "";
        if (current == null)
            return "This tree is empty.";
        if(current != null){
            if(current.color == 1)       
    firstCase = prefix + ":" + "BLACK" + "(" + current.element.key + "," + 
                    current.element.value + ")\n";
            else
    firstCase = prefix + ":" + "RED" + "(" + current.element.key + "," + 
                    current.element.value + ")\n";
        }
        while (current.left != null){
            if(current.left.color == 1)
    secondCase = prefix + "-left:" + "BLACK" + "(" + current.left.element.key
                        + "," + current.element.value + ")\n" + secondCase;
            else
    secondCase = prefix + "-left:" + "RED" + "(" + current.left.element.key
                        + "," + current.element.value + ")\n" + secondCase;
        }
        while (parent.right != null){
            if(parent.right.color == 1)
    thirdCase = prefix + "-right" + "BLACK" + "(" + parent.right.element.key
                        + "," + current.element.value + ")\n" + thirdCase;
            else
    thirdCase = prefix + "-right" + "RED" + "(" + parent.right.element.key
                        + "," + current.element.value + ")\n" + thirdCase;
        }
         current = header.right;
        while (current.left != null){
            if(current.left.color == 1)
    fourthCase = prefix + "-left:" + "BLACK" + "(" + current.left.element.key
                        + "," + current.element.value + ")\n" + fourthCase;
            else
    fourthCase = prefix + "-left:" + "RED" + "(" + current.left.element.key
                        + "," + current.element.value + ")\n" + fourthCase;
    }
        return firstCase + secondCase + thirdCase + fourthCase;
    }
    
        public RedBlackNode delete (RedBlackNode item, int key){
        if(key != item.element.key){
            if(item.left.color != RED  && item.left.left.color != RED){
                item = rotate (item, parent);
                
            }
        }
        else{
            item.right = delete(item.right,key);
        }
        return rotate(item, current);
    }
    
    private final int compare(RedBlackNode item, RedBlackNode t){
       if(t == header)
           return 1;
       else
           return item.element.value.compareTo(t.element.value);
    }
    
    private RedBlackNode rotate(RedBlackNode item, RedBlackNode parent){
        if(compare(item, parent) < 0){
            return parent.left = compare(item, parent.left) < 0 ?
                    rotateWithLeftChild(parent.left): // left left
                    rotateWithRightChild(parent.left); //left right
        }
        else{
            return parent.right = compare(item, parent.right) < 0 ?
                    rotateWithLeftChild(parent.right) : // right left
                    rotateWithRightChild(parent.right); //right right
        }
    }
    
    private RedBlackNode rotateWithLeftChild(RedBlackNode c2){
        RedBlackNode c1 = c2.left;
        c2.left = c1.right;
        c1.right = c2;
        return c1;
    }
    
    private RedBlackNode rotateWithRightChild(RedBlackNode c1){
        RedBlackNode c2 = c1.right;
        c1.right = c2.left;
        c2.left = c1;
        return c2;
    }
    
    private void handleReorient(RedBlackNode item){
        //Executes color flipping
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        
        if(parent.color == RED){ //Executes rotation
            grand.color = RED;
            if((compare(item, grand) < 0) != (compare(item, parent) < 0))
                parent = rotate(item, grand); //Start double rotation
            current = rotate(item, great);
            
            current.color = BLACK;
        }
        header.right.color = BLACK; //colors the root black
    }
    
    public RedBlackNode findNode(int key){
        nullNode.element.key = key;
        current = header.right;
        for( ; ; ){
        if (key < current.element.key)
            current = current.left;
        else if (key > current.element.key)
            current = current.right;
        else if (current != nullNode)
            return current;
        else
            return null;
        }       
    }

}