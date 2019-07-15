/**
Name: Michael Garrison
Date: 11/10/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class RedBlackNode{
    Element element;
    RedBlackNode left;
    RedBlackNode right;
    int color;
    
    public RedBlackNode(){
        this(null,null,null);
    }
    
    public RedBlackNode(Element e){
        this(e, null, null);
    }
    
    public RedBlackNode(Element e, RedBlackNode l, RedBlackNode r){
                     element = e;
                    left = l;
                    right = r;
                    color = 1;
                }
    public Element getElement(){
        return element;
    }
    public int getColor(){
        return color;
    }
    public RedBlackNode getLeftChild(){
        return left;
    }
    public RedBlackNode getRightChild(){
        return right;
    }
}