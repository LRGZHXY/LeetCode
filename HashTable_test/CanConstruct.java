package HashTable_test;
//赎金信

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] record = new int[26];//

        for(char c : magazine.toCharArray()){//toCharArray：将字符串转化为字符数组
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){//在增强型 for 循环中，i 是数组中的元素值，而不是索引,所以不是record[i]<0
                return false;
            }
        }

        return true;
    }
}