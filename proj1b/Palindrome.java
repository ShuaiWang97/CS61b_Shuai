public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        Deque<Character> wordInDeque = new ArrayDeque();
        for (int i = 0; i < word.length(); i++) {
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }


    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        if(d.size()%2==0){
            int num=d.size();
            for(int i=0;i<num/2;i++) {
                //OffByOne obo = new OffByOne();
                Character a = d.removeFirst();
                Character b = d.removeLast();
                if (a != b)
                //if(!obo.equalChars(a,b))
                    return false;
            }
        }
        else if(d.size()%2!=0){
            int num=d.size();
            for(int i=0;i<(num-1)/2;i++) {
                //OffByOne obo = new OffByOne();
                Character a = d.removeFirst();
                Character b = d.removeLast();
                if (a != b)
             //   if(!obo.equalChars(a,b))
                    return false;
            }
        }
        return true;
    }

    //overload method//
    public boolean isPalindrome(String word, CharacterComparator cc){

        return true;
    }
}
