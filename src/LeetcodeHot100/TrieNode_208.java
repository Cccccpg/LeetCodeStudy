package LeetcodeHot100;

class TrieNode{
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
 *
 */
public class TrieNode_208 {
    TrieNode root;

    public TrieNode_208() {
        root = new TrieNode();
    }

    /**
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就new出新节点；
     * 如果节点已经存在，cur顺着往下走就可以
     * @param word
     */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index]  == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        //表示一个字符已经插入完毕
        cur.isWord = true;
    }

    /**
     * 思路：cur从根节点开始，按照word的字符一直尝试向下走：
     * 如果走到了null，说明这个word不是前缀树的任何一条路径，返回false;
     * 如果按照word顺利的走完，就要判断此时cur是否为单词尾端：如果是，返回true；如果不是，说明word仅仅是一个前缀，并不完整，返回false
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] != null){
                cur = cur.children[index];
            }else{
                return false;
            }
        }
        return cur.isWord;
    }

    /**
     * 思路：和sesrch方法一样，根据word从根节点开始一直尝试向下走：
     * 如果遇到null了，说明这个word不是前缀树的任何一条路径，返回false;
     * 如果安全走完了，直接返回true就行了———我们并不关心此事cur是不是末尾(isWord)
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] != null){
                cur = cur.children[index];
            }else{
                return false;
            }
        }
        return true;
    }
}
