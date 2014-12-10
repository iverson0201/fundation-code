package algorithms.ds.rbt;
/*
 * 红黑树的结点数据
 * */
public class RBTNode<E> {
	private E val;
	private RBTNode<E> left,right,parent;
	public RBTNode(E val){
		this.val=val;
		this.left=null;
		this.right=null;
		this.parent=null;
	}
	
	public E getVal() {
		return val;
	}
	
	public void setVal(E val) {
		this.val = val;
	}
	
	public RBTNode<E> getLeft() {
		return left;
	}
	public void setLeft(RBTNode<E> left) {
		this.left = left;
	}
	public RBTNode<E> getRight() {
		return right;
	}
	public void setRight(RBTNode<E> right) {
		this.right = right;
	}
	public RBTNode<E> getParent() {
		return parent;
	}
	public void setParent(RBTNode<E> parent) {
		this.parent = parent;
	}
	
	
}
