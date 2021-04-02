### 解题思路
统计每个字母的次数，然后找到第一个次数为1的字母的索引即可

### 代码

```python3
class Solution:
    def firstUniqChar(self, s: str) -> int:
        m = {}
        l_s = list(s)
        for word in l_s:
            m[word] = 0
        for word in l_s:
            m[word] += 1
        for key,vaule in m.items():
            if vaule == 1:
                return l_s.index(key)
        return -1
```