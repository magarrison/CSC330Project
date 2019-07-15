/**
Name: Michael Garrison
Date: 11/11/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
public class RBTValidator extends RedBlackTree{
    
    public RBTValidator(){
    
}
  
    //Assuming RBTree is a BST and has a size equal to 1.
    public boolean validate(String RBTree){
        if(RBTree.startsWith("root:BLACK")){
            return true;
        }
        else
            return false;
    }
    
}