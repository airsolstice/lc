思路:

本题与[剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)相似。

用哈希表记录字符的个数。
在遍历字符串，找到第一个个数为1的字符的索引，即可。


```cpp
class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> hash(256);
        for(auto x : s){
            ++hash[x];
        }
        for(int i=0;i<s.size();++i){
            if(hash[s[i]] == 1){
                return i;
            }
        }
        return -1;
    }
};
```