import java.util.Random;

public class CharBag {
    private Random rand = new Random(System.currentTimeMillis());
    private int[] freq;
    public CharBag(){
        this.freq = new int[27];
    }

    public void add(char toAdd){
        if (!Character.isAlphabetic(toAdd)){
            freq[26] ++;
        }else{
            toAdd = Character.toLowerCase(toAdd);
            freq[toAdd - 97] ++;
        }
    }

    public void remove(char toRemove){
        if (!Character.isAlphabetic(toRemove)){
            if (freq[26] == 0){
                return;
            }
            freq[26] --;
        }else{
            toRemove = Character.toLowerCase(toRemove);
            if (freq[toRemove - 97] == 0){
                return;
            }
            freq[toRemove - 97] --;
        }
    }

    public int getCount(char count){
        if (!Character.isAlphabetic(count)){
            return freq[26];
        }else{
            count = Character.toLowerCase(count);
            return freq[count - 97];
        }
    }

    public int getSize(){
        int sum = 0;

        for (int i = 0; i < freq.length; i++){
                sum += freq[i];
        }
        return sum;
    }

    @Override
    public String toString() {
        String temp = "CharBag{";
        for (int i=0; i < this.freq.length; i++){
            if (i == 26){
                temp += ".:" + this.freq[i] + "}";
            }else{
                temp += Character.toString((char)('a' + i)) + ":" + this.freq[i] + ", ";
            }
        }

        return temp;
    }

    public char getRandomChar(){
        int size = getSize();
        if (size == 0){
            return '.';
        }
        int randomInt = rand.nextInt(size);
        for (int i=0; i < this.freq.length - 1; i++){
            randomInt -= getCount((char)('a' + i));
            if (randomInt < 0){
                return (char) ('a' + i);
            }
        }
        return '.';
    }
}
