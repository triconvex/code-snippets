//package ps.kakao.blind20;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class 가사검색 {
//
//    public int[] solution(String[] words, String[] queries) {
//        int[] answer = new int[queries.length];
//
//        List<Query> queryObjects = new ArrayList<>();
//        for(String query : queries) {
//            queryObjects.add(new Query(query));
//        }
//
//        Trie prefix = new Trie();
//        Trie suffix = new Trie();
//
//        for(String word : words) {
//            if(word.endsWith("\\?")) {
//                prefix.insert(word);
//            } else {
//                suffix.insert(word);
//            }
//        }
//
//        for(String query : queries) {
//            if(query.endsWith("\\?")) {
//                prefix.
//            } else {
//
//            }
//
//
//
//        }
//
//        for(String word : words) {
//            for(int i = 0; i < queryObjects.size(); i++) {
//                if(queryObjects.get(i).matches(word)) {
//                    answer[i]++;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    class Query {
//
//        boolean direction;
//        String key;
//        int length;
//
//        Query(String word) {
//            this.direction = !word.startsWith("?");
//            this.length = word.length();
//            this.key = word.replaceAll("\\?", "");
//        }
//
//        public int getLength() {
//            return length;
//        }
//
//        boolean matches(String target) {
//            if(target.length() != length) {
//                return false;
//            }
//
//            if(direction) {
//                return target.startsWith(key);
//            } else {
//                return target.endsWith(key);
//            }
//        }
//
//    }
//
//
//
//
//
//
//
//
//
//
//    class TrieNode {
//        private final Map<Character, TrieNode> children = new HashMap<>();
//        private boolean endOfWord;
//
//        Map<Character, TrieNode> getChildren() {
//            return children;
//        }
//
//        boolean isEndOfWord() {
//            return endOfWord;
//        }
//
//        void setEndOfWord(boolean endOfWord) {
//            this.endOfWord = endOfWord;
//        }
//    }
//
//    class Trie {
//        private TrieNode root;
//
//        Trie() {
//            root = new TrieNode();
//        }
//
//        void insert(String word) {
//            TrieNode current = root;
//
//            for (int i = 0; i < word.length(); i++) {
//                current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
//            }
//            current.setEndOfWord(true);
//        }
//
//        boolean delete(String word) {
//            return delete(root, word, 0);
//        }
//
//        boolean containsNode(String word) {
//            TrieNode current = root;
//
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                TrieNode node = current.getChildren().get(ch);
//                if (node == null) {
//                    return false;
//                }
//                current = node;
//            }
//            return current.isEndOfWord();
//        }
//
//        boolean isEmpty() {
//            return root == null;
//        }
//
//        private boolean delete(TrieNode current, String word, int index) {
//            if (index == word.length()) {
//                if (!current.isEndOfWord()) {
//                    return false;
//                }
//                current.setEndOfWord(false);
//                return current.getChildren().isEmpty();
//            }
//            char ch = word.charAt(index);
//            TrieNode node = current.getChildren().get(ch);
//            if (node == null) {
//                return false;
//            }
//            boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();
//
//            if (shouldDeleteCurrentNode) {
//                current.getChildren().remove(ch);
//                return current.getChildren().isEmpty();
//            }
//            return false;
//        }
//    }
//
//}
