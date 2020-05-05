public class Trie<T> {
    private TrieNode<T> root;

    public Trie(){
        this.root = new TrieNode<T>();
    }

    private TrieNode<T> getNode(String checker) {
        TrieNode<T> temp = this.getRoot();
        for (int i = 0; i < checker.length(); i++){
                temp = temp.getChild(checker.charAt(i));
        }
        return temp;
    }

    public T get(String checker){
        TrieNode<T> temp = getNode(checker);
        if (temp.getData() == null){
            return null;
        }
        return temp.getData();
    }

    public void put(String checker, T data){
        TrieNode<T> temp = getNode(checker);
        temp.setData(data);
        this.root = temp;
    }

    public TrieNode<T> getRoot(){
        return this.root;
    }
}
