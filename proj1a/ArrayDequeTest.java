public class ArrayDequeTest {

    public static void testArray(){
       // String[] input={"I ","have ","an ","egg "};
        String[] expected={"3","4","1","2"};

        ArrayDeque L= new ArrayDeque();
        L.addFirst("4");
        L.addFirst("3");
        L.addFirst("2");
        L.addFirst("1");

        L.removeLast();
        L.removeLast();
        L.addFirst("4");
        L.addFirst("3");

        ArrayDeque LL=new ArrayDeque(L.size);
        if(L.nextLast>L.nextFirst){
            for(int i=L.nextFirst-1;i<L.nextLast;i++){
                LL.items[i]=L.items[i];
            }
        }
        else {
            for(int i=L.nextFirst-1;i<L.size;i++) {
                System.out.println(L.items[i]);
            }
            for(int i=0;i<L.nextLast;i++) {
                System.out.println(L.items[i]);
            }
        }


        if(L.items!=expected){
            System.out.println("Error");
        }

    }
    public static void main(String[] args){
        testArray();
    }
}
