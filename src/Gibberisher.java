public class Gibberisher {
    private Trie<CharBag> letters;
    private int segmentSize;
    private int numLetters;

    public Gibberisher(int segmentSize){
        this.segmentSize = segmentSize;
        this.letters = new Trie<CharBag>();
        letters.put("", new CharBag());
        this.numLetters = 0;
    }

    public void train(LetterSample letter){
        char temp = letter.getNextLetter();
        if (letters.get(letter.getSegment()) == null){
            CharBag temper = new CharBag();
            temper.add(temp);
            letters.getRoot().setData(temper);
        }else {
            CharBag temping = letters.getRoot().getData();
            TrieNode<CharBag> tempering = letters.getRoot();
            for (int i = 0; i < letter.getSegment().length(); i++){
                tempering = tempering.getChild(letter.getSegment().charAt(i));
            }
            temping = tempering.getData();
            temping.add(temp);
            letters.put(Character.toString(temp), temping);
        }

    }

    public void train(String toTrain){
        LetterSample[] temp = LetterSample.toSamples(toTrain, this.segmentSize);
        for (int i = 0; i < temp.length; i++){
            this.train(temp[i]);
        }
    }

    public void train(String[] toTrain){
        for (int i = 0; i < toTrain.length; i++){
            this.train(toTrain[i]);
        }
    }

    public int getSampleCount(){
        return numLetters;
    }

    public String generate(){
        String word = "";
        do {
            String temper = "";
            for (int i=0; i < word.length(); i++){
                temper += Character.toString(word.charAt(i));
                if (temper.length() > this.segmentSize){
                    temper = temper.substring(1);
                }
            }
            word += Character.toString(letters.get(temper).getRandomChar());
        }while ( word.charAt(word.length() - 1) != '.');

        return word;
    }

}
