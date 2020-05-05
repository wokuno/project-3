public class LetterSample {
    private String segment;
    private char nextLetter;
    public static final char STOP = '.';


    public LetterSample(String segment, char nextLetter){
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    public String getSegment(){
        return this.segment;
    }

    public char getNextLetter(){
        return this.nextLetter;
    }

    @Override
    public String toString() {
        String temp = "";
        temp += '"' + this.segment + '"' + " -> " + Character.toString(this.nextLetter);
        return temp;
    }

    public static LetterSample[] toSamples(String input, int segmentSize){
        input = input.toLowerCase();
        String temp = "";
        for (int i = 0; i < input.length(); i++){
            char temporary = input.charAt(i);
            if (Character.isAlphabetic(temporary)){
                temp += Character.toString(temporary);
            }
        }
        temp += Character.toString(STOP);
        LetterSample[] toReturn = new LetterSample[temp.length()];
        String temper = "";
        for (int i=0; i < temp.length(); i++){

            toReturn[i] = new LetterSample(temper, temp.charAt(i));
            temper += Character.toString(temp.charAt(i));

            if (temper.length() > segmentSize){
                temper = temper.substring(1);
            }
        }

        return toReturn;
    }
}
