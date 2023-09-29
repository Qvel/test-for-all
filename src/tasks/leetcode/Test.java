package tasks.leetcode;

import tasks.binary.BinarySearch;

import java.util.*;

public class Test {

    public static void main(String[] args) {

    }


    //LRU Cache
    private class LRUCache<K,V> {

        private final Map<K, V> map;
        private final Queue<K> queue;
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.queue = new LinkedList<>();
        }

        public V get(K key) {
            if(!map.containsKey(key)) return null;

            queue.remove(key);
            queue.offer(key);

            return map.get(key);
        }

        public void put(K key, V value){
            if(map.containsKey(key)){
                queue.remove(key);
            } else if (queue.size() == capacity) {
                K oldestKey = queue.poll();
                map.remove(oldestKey);
            }

            queue.offer(key);
            map.put(key,value);
        }
    }

    //K-closest Points
    private class KlosetPoints {


        public int [][] getClosest(int [] [] points, int k){

            PriorityQueue<int []> que = new PriorityQueue<>(k, new Comparator<int[]>() {
                @Override
                public int compare(int[] p1, int[] p2) {
                    return getDistanse(p2) - getDistanse(p1);
                }
            });

            for(int [] point : points){
                que.offer(point);
                if(que.size() > k){
                    que.poll();
                }
            }

            int [] [] result = new int [k][2];

            while (k >0) {
                result[k--] = que.poll();
            }

            return result;
        }

        private int getDistanse(int [] point){
            return point[0] * point[0] + point[1]*point[1];
        }

    }

    //isValidBST
    private static boolean isValidBST(TreeNode root){
        if(root == null) return false;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long lowLimit, long highLimit) {
        if(node == null) return true;

        if(node.val <= lowLimit || node.val >= highLimit){
            return false;
        }

        return isValidBST(node.left,lowLimit, node.val) && isValidBST(node.right, node.val, highLimit);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //anagram finder
    private static List<Integer> findAnagram(String s, String p){

        List<Integer> result = new ArrayList<>();


        //s=abssabbca   p=abs

        //two arrays with 26 size, add all count of p chars
        int [] pCount = new int[26];
        int [] sCount = new int[26];
        for(char sym : p.toCharArray()){
            pCount[sym - 'a']++;
        }

        //create cycle with String widow
        for(int i = 0; i<s.length();i++){
            //move widow when p.capacity the same as iteration
            if(i>=p.length()){
              sCount[s.charAt(i) - p.length() -'a']--;
            }
            sCount[s.charAt(i) - 'a']++;
            //check arrays if the same add to result
            if(Arrays.equals(sCount,pCount)){
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    //mising numbers
    private static int getMissingNumber(){
        int[] arr = new int[999]; // Ідеально тут повинні бути ваші числа.
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i != 123) {
                arr[index++] = i;
            }
        }

        //sum(1000) - sum(arr)
        //add to Map (1000)
        //xor ^=
        return 1;
    }
}
