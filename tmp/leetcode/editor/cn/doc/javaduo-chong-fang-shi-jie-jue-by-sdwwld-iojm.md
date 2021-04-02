
### 1，两次遍历

第一遍先统计每个字符出现的次数，第二遍再次从前往后遍历字符串s中的每个字符，如果某个字符出现一次直接返回，原来比较简单，看下代码

```
    public int firstUniqChar(String s) {
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        //先统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++)
            count[chars[i] - 'a']++;
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++)
            if (count[chars[i] - 'a'] == 1)
                return i;
        return -1;
    }
```

<br>

### 2，使用HashMap解决
也是换汤不换药，原来和上面的一样，先统计每个字符的数量，然后在查找
```
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        //先统计每个字符的数量
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
```

<br>



### 3，使用Java的api
一个从前查找，一个从后查找，如果下标相等，说明只出现了一次

```
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }
```



<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**

