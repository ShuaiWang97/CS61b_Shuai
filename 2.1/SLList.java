public class SLList{
    
    private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	} 

	private int size;
    private IntNode sentinel;

	public SLList(int x){
		sentinel= new IntNode(66,null);
        sentinel= new IntNode(x,sentinel);
        size=1;
	}

	public SLList(){
		sentinel= new IntNode(66,null);
        size=0;
	}	
	
    /*Adds x to the front list(do not change sentinel!!)*/
	public void addFirst(int x){
		sentinel.next = new IntNode(x,sentinel.next);
		size=size+1;
	}

	/*return the first item in the first*/
	public int getFirst(){
		return sentinel.next.item;
	}
	
	/*adds an item to the end of the list*/
	public void addLast(int x){
		IntNode p=sentinel;
		while(p.next!=null){
			p=p.next;
		}
		p.next= new IntNode(x,null);
		size=size+1;
	}
    


/*    private static int Size(IntNode p){
    	
    	if(p.next==null){
    		return 1;
    	}
    	return 1+Size(p.next);
    }

    public int Size(){
    	return Size(first);
    }*/

    public int Size (){
    	return size;
    }



	public static void main(String[] args){
		SLList L = new SLList();
		L.addLast(20);
	    L.addFirst(10);
		L.addFirst(5);
		System.out.println(L.getFirst());
		System.out.println(L.Size());
	}
	
}
