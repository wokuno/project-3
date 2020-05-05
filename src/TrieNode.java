public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] array;

    public TrieNode(){
        this.array = new TrieNode[26];
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public TrieNode<T> getChild(char letter){
        if ('a' > letter || 'z' < letter){
            return null;
        }
        if (array[letter - 'a'] == null){
            TrieNode<T> temp = new TrieNode<T>();
            array[letter - 'a'] = temp;
            return temp;
        }
        return array[letter - 'a'];

    }

    public int getTreeSize(){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
                sum ++;
            }
        }
        sum++;
        return sum;
    }


}
