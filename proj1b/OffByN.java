public class OffByN implements CharacterComparator{
   private int Offnumber;

    public OffByN (int N) {
        Offnumber=N;
   }

    @Override
    public boolean equalChars(char x, char y){
        int diff = x - y;
        if (diff == Offnumber || diff == -Offnumber)
            return true;
        else
            return false;
    }
}
