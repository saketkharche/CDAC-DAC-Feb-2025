### Binary Tree Data Structure

A **binary tree** is a hierarchical data structure in which each node has at most two children, referred to as the **left child** and the **right child**.

### Properties of a Binary Tree

1. **Basic Structure**:
   - Each node contains three components:
     1. **Data** (value or key)
     2. **Left Child** (pointer/reference to the left child node)
     3. **Right Child** (pointer/reference to the right child node)

2. **Maximum Nodes**:
   - The maximum number of nodes at level `L` is `2^L`.
   - The maximum number of nodes in a binary tree of height `h` is `2^h - 1`.

3. **Height of the Tree**:
   - The height of a binary tree is the number of edges in the longest path from the root to a leaf node. Alternatively, the height of a tree with `n` nodes is at most `n-1` and at least `log2(n)`.

4. **Types of Binary Trees**:
   - **Full Binary Tree**: Every node has 0 or 2 children.
   - **Perfect Binary Tree**: All internal nodes have two children, and all leaves are at the same level.
   - **Complete Binary Tree**: All levels are completely filled except possibly the last, which is filled from left to right.
   - **Balanced Binary Tree**: The height difference between left and right subtrees of any node is not more than 1.
   - **Degenerate (Skewed) Tree**: Every parent node has only one child (left or right), making the tree behave like a linked list.

5. **Traversals in a Binary Tree**:
   - **Inorder Traversal (Left, Root, Right)**: Visits left subtree, root, then right subtree.
   - **Preorder Traversal (Root, Left, Right)**: Visits root first, then left subtree, and finally right subtree.
   - **Postorder Traversal (Left, Right, Root)**: Visits left subtree, then right subtree, and finally the root.

6. **Binary Tree Representation**:
   - **Linked Representation**: Each node contains a pointer to its left and right child.
   - **Array Representation**: Binary trees can be represented using arrays where for a node at index `i`:
     - Left child is at `2i + 1`
     - Right child is at `2i + 2`
     - Parent is at `(i - 1) / 2`

### Common Binary Tree Operations

1. **Insertion**:
   - Insertion is usually performed level-wise in the first available empty position.
   - In a balanced tree, this ensures that the tree remains as complete as possible.

2. **Deletion**:
   - The node to be deleted is replaced with the deepest rightmost node, followed by removing the deepest node.
   - Special cases involve deleting a node with one child or no children.

3. **Traversal**:
   - Inorder, Preorder, and Postorder are the most common traversal techniques for visiting all nodes in a binary tree.

4. **Searching**:
   - Searching for a particular element involves checking every node, potentially requiring traversal of the entire tree.
   - The time complexity of searching is generally O(n).

5. **Height of Tree**:
   - The height is the length of the path from the root node to the deepest leaf.
   - Can be calculated recursively by taking the maximum of the heights of the left and right subtrees.

### Example of Binary Tree:

```
       1
      / \
     2   3
    / \   \
   4   5   6
```

### Traversal of the Above Tree:

1. **Inorder**: 4, 2, 5, 1, 3, 6
2. **Preorder**: 1, 2, 4, 5, 3, 6
3. **Postorder**: 4, 5, 2, 6, 3, 1

---
### Types of Binary Trees

1. **Strict Binary Tree**:
   - A **strict binary tree** (or **proper** or **2-tree**) is a tree where every node has either **0** or **2** children.
   - In other words, no node can have only one child.
   
   **Example**:
   ```
       1
      / \
     2   3
    / \   \
   4   5   6
   ```
   - Node 1 has two children (2, 3), nodes 2 and 3 also follow the rule, and nodes 4, 5, and 6 have zero children.
   - Node 3 violates the strict property because it has only one child.

2. **Full Binary Tree**:
   - A **full binary tree** is a tree in which every node has either **0** or **2** children (similar to strict binary tree).
   - The key difference is the context and emphasis. A **full binary tree** is often used interchangeably with a **strict binary tree**, although "full" generally stresses the idea that the tree has no nodes with one child.

   **Example**:
   ```
       1
      / \
     2   3
    / \ / \
   4  5 6  7
   ```
   - Each node either has zero or exactly two children.
   - Node 4, 5, 6, and 7 are leaf nodes with no children.

3. **Complete Binary Tree**:
   - A **complete binary tree** is a binary tree in which **all levels**, except possibly the last, are completely filled, and all nodes are as far left as possible on the last level.
   
   **Example**:
   ```
       1
      / \
     2   3
    / \  /
   4   5 6
   ```
   - The nodes are filled from left to right. The last level is not completely filled, but all nodes are as far left as possible.

4. **Almost Complete Binary Tree (ACBT)**:
   - An **almost complete binary tree** is essentially the same as a **complete binary tree**, but emphasizes the fact that the nodes at the last level may not fill up the entire row but should still be positioned as left as possible.

   **Example**:
   ```
       1
      / \
     2   3
    / \  
   4   5
   ```
   - The last level is not filled completely (it lacks right children), but all nodes are pushed to the left.

5. **Perfect Binary Tree**:
   - A **perfect binary tree** is a binary tree in which **all internal nodes have two children** and **all leaf nodes are at the same level**.
   - This tree is perfectly balanced, with all leaves at the maximum depth.
   
   **Example**:
   ```
       1
      / \
     2   3
    / \ / \
   4  5 6  7
   ```
   - All internal nodes (1, 2, 3) have two children, and all leaves (4, 5, 6, 7) are on the same level.

6. **Incomplete Binary Tree**:
   - An **incomplete binary tree** is the opposite of a complete or perfect binary tree.
   - This tree doesn't fill up all levels completely or doesn’t push nodes to the left.
   
   **Example**:
   ```
       1
      /
     2
    / \
   4   5
   ```
   - The tree is missing several nodes, making it unbalanced or incomplete.

