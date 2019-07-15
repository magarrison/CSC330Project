/**
Name: Michael Garrison
Date: 11/13/2014
I have abided by the UNCG Academic Honor Code on this assignment.
*/
-----------------------------------------------------------------
Readme.txt
-----------------------------------------------------------------
Here I will discuss the method layout of my java classes that will talk about some of the additions and changes that I made to the original specification.

Element.java
-----------------------------------------------------------------
This class contains the int:key and String:value variables along with a public default constructor as well as int:getKey() and String:getValue() methods.
Although these int:getKey() and String:getValue() methods exist, I chose to implement public variables for these to match similar specifications of the textbook.
-----------------------------------------------------------------

RedBlackNode.java
-----------------------------------------------------------------
I made a couple of changes and additions to the original specification. The changes include making all variables public to match similar specifications of the textbook.
The methods Element:getElement(), int:getColor(), RedBlackNode:getLeftChild(), and RedBlackNode:getRightChild() are still implemented and functional.
I made two additional constructors that aided in the creation of my RedBlackTree.java class. These were also implemented to match similar specifications of the textbook.
-----------------------------------------------------------------

TreeInterfacte.java
-----------------------------------------------------------------
This is an exact copy of the TreeInterface.java you provided in the project specification. Additional methods implemented in RedBlackTree.java were not added to the interface.
-----------------------------------------------------------------

RedBlackTree.java
-----------------------------------------------------------------
This class contains the following private variables: RedBlackNode:current, RedBlackNode:parent, RedBlackNode:grand, RedBlackNode:great, RedBlackNode:header,
RedBlackNode:nullNode, int:BLACK, and int:RED. 
The public default constructor is present as well as the specified String:find(int key), void:insert(int key, String value), void:delete(int key), String:remove(int key). 
and String:toString() methods.

The following helper methods were added to assist with the above methods: RedBlackNode:delete (RedBlackNode item, int key), int:compare(RedBlackNode item, RedBlackNode t), 
RedBlackNode:rotate(RedBlackNode item, RedBlackNode parent), RedBlackNode:rotateWithLeftChild(RedBlackNode c2), RedBlackNode:rotateWithRightChild(RedBlackNode c1),
void:handleReorient(RedBlackNode item), and RedBlackNode findNode(int key).

Some of these methods have close specification to that of the textbook but have been modified and adapted to match the differences in implementation.
I am not 100% sure if my implementation of the String:toString() method is printing all of the nodes it should be (namely the nodes to the right of parents on the left subtree)
and it may fail to print some nodes if the parent node has no right child, but I wanted to be cautious of calling to grandparent nodes and printing out duplications.
-----------------------------------------------------------------

RBTValidator.java
-----------------------------------------------------------------
This class contains a public default constructor and the single method boolean:validate(String RBTree) that assumes the RBTree string provided is a BST and that
the tree has a size of 1 as indicated in the last two examples of the TipsAndHints.pdf that was provided on Canvas. This method checks to see if the string starts at the root
and begins with the color BLACK. If this is the case then the first node is BLACK and the boolean is true. If this does not match than the boolean is false. This is because
all RBTrees must start with a black node as the root.