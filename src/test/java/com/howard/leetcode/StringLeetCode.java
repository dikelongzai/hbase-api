package com.howard.leetcode;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class StringLeetCode {
    private static final Logger logger = LoggerFactory.getLogger(StringLeetCode.class);
    public static final String BLANK_STRING = " ";
    public static final char STAR_CHAR = '*';
    public static final char QUESTION_CHAR = '?';

    public static final int BLANK_STRING_SIZE = 1;

    private StringLeetCode() {
    }

    /**
     * @param entirePatternStr
     * @param pattern
     * @return
     * @see <a href="https://leetcode.com/problems/wildcard-matching/description/">leetCodeLink</a>xxxx
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
     * <p>
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "aa", p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     * <p>
     * Input: s = "aa", p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     * Example 3:
     * <p>
     * Input: s = "cb", p = "?a"
     * Output: false
     * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= s.length, p.length <= 2000
     * s contains only lowercase English letters.
     * p contains only lowercase English letters, '?' or '*'.
     */
    public boolean isMatch(String entirePatternStr, String pattern) {
        Preconditions.checkNotNull(entirePatternStr, "entirePatternStr can not be null");
        Preconditions.checkNotNull(pattern, "pattern can not be null");
        boolean[][] matchArr = new boolean[entirePatternStr.length() + 1][pattern.length() + 1];
        matchArr[entirePatternStr.length()][pattern.length()] = true;
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) != STAR_CHAR) {
                break;
            } else {
                matchArr[entirePatternStr.length()][i] = true;
            }

        }
        for (int i = entirePatternStr.length() - 1; i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if (entirePatternStr.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == QUESTION_CHAR) {
                    matchArr[i][j] = matchArr[i + 1][j + 1];
                } else if (pattern.charAt(j) == STAR_CHAR) {
                    matchArr[i][j] = matchArr[i][j + 1] || matchArr[i + 1][j];
                } else {
                    matchArr[i][j] = false;
                }
            }

        }

        return matchArr[0][0];
    }

    /**
     * 76 {@code https://leetcode.com/problems/minimum-window-substring/description/}
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     * <p>
     * The testcases will be generated such that the answer is unique.
     * Example 1:
     * <p>
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     * <p>
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * <p>
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     * <p>
     * <p>
     * Follow up: Could you find an algorithm that runs in O(m + n) time?
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string ""
     *
     * @param strSource
     * @param windowStr
     * @return
     */
    public String minWindowSubstr(String strSource, String windowStr) {

        char[] chars = windowStr.toCharArray();

        LinkedList<KV> indexSourceList = new LinkedList<>();
        LinkedList<HashSet<Integer>> listSequence = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            Collection<Integer> indexList = searchAllIndex(chars[i], strSource);
            if (CollectionUtils.isEmpty(indexList)) {
                return "";
            } else {
                if (i == 0) {
                    for (Integer integer : indexList) {
                        HashSet<Integer> integersHashset = new HashSet<>();
                        integersHashset.add(integer);
                        listSequence.add(integersHashset);
                    }
                } else {
                    Queue<Integer> queue = new LinkedList<>();
                    for (HashSet<Integer> integerHashSet : listSequence) {
                        for (Integer integer : indexList) {
                            if (!queue.contains(integer)) integerHashSet.add(integer);
                        }
                    }
                }

            }
        }
        int minLength = strSource.length();
        String subStr = "";
        for (HashSet<Integer> integerHashSet : listSequence) {
//            int max=0,min=0;integerHashSet
            Integer[] integers = new Integer[integerHashSet.size()];

            // toArray() method converts the set to array
            integerHashSet.toArray(integers);
            if (integers.length == minLength) {
                int substractSequenceIndex = integers[integers.length - 1] - integers[0];
                if (substractSequenceIndex >= windowStr.length() && substractSequenceIndex < minLength) {
                    minLength = substractSequenceIndex;
                    subStr = strSource.substring(integers[0], integers[integers.length - 1]);
                }
            }
        }
        if (indexSourceList.size() < chars.length) return "";
        return subStr;

    }

    /**
     * {@code https://leetcode.com/problems/text-justification/description/}
     * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
     * <p>
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
     * <p>
     * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
     * <p>
     * For the last line of text, it should be left-justified, and no extra space is inserted between words.
     * <p>
     * Note:
     * <p>
     * A word is defined as a character sequence consisting of non-space characters only.
     * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
     * The input array words contains at least one word.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
     * Output:
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     * Example 2:
     * <p>
     * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
     * Output:
     * [
     * "What   must   be",
     * "acknowledgment  ",
     * "shall be        "
     * ]
     * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
     * Note that the second line is also left-justified because it contains only one word.
     * Example 3:
     * <p>
     * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
     * Output:
     * [
     * "Science  is  what we",
     * "understand      well",
     * "enough to explain to",
     * "a  computer.  Art is",
     * "everything  else  we",
     * "do                  "
     * ]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= words.length <= 300
     * 1 <= words[i].length <= 20
     * words[i] consists of only English letters and symbols.
     * 1 <= maxWidth <= 100
     * words[i].length <= maxWidth
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        Preconditions.checkArrayNotEmpty("words array can not be null", words);
        //actually the maxWidth should greater than the longest length of word in the words
        Preconditions.checkState(maxWidth > 0);
        int startIndex = 0, currentMinLineLength = 0;
        List<String> fullJustifyList = new LinkedList<>();
        LinkedList<String> lineWordsList = new LinkedList<>();
        while (startIndex < words.length) {
            String strWords = words[startIndex++];
            int nextLength = currentMinLineLength + strWords.length();
            if (nextLength >= maxWidth) {
                //if nextLength=maxWidth indicate that the current strWord is this line's word
                if (nextLength == maxWidth) {
                    if (!strWords.trim().isEmpty()) {
                        lineWordsList.add(strWords);
                    }

                } else {
                    startIndex--;
                }
                if (!lineWordsList.isEmpty() && lineWordsList.size() > 0) {
                    String stringFillBlank = fillBlank(lineWordsList, maxWidth, false);
                    if (!stringFillBlank.isEmpty() && stringFillBlank.trim().length() > 0) {
                        fullJustifyList.add(stringFillBlank);
                    }
                }


                lineWordsList.clear();
                //rollback a index
                currentMinLineLength = 0;//reset the currentLineLength to 0
                //when nextLength==maxWidth the currentWords should be include to the current line


            } else {
                lineWordsList.add(strWords);

                currentMinLineLength = currentMinLineLength + strWords.length();
                currentMinLineLength++;//add one blank size

            }

        }
        if (!lineWordsList.isEmpty()) {
            //add the last line
            fullJustifyList.add(fillBlank(lineWordsList, maxWidth, true));
        }


        return fullJustifyList;
    }

    private String fillBlank(LinkedList<String> list, int maxWidth, boolean lastLine) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!list.isEmpty()) {
            if (lastLine) {
                endLineBuilder(list, maxWidth, stringBuilder);
            } else {
                int listSize = list.size();
                int count = getCharCountByList(list);
                int countBlank = maxWidth - count;
                int countMinBlink = listSize - 1;
                int waitingFillBlank = countBlank - countMinBlink;
                int everyWordsEndBlank = listSize > 1 ? waitingFillBlank / (listSize - 1) : waitingFillBlank - 1;
                int mod = listSize > 1 ? Math.floorMod(waitingFillBlank, listSize - 1) : 0;
                List<Integer> listModIndex = getListLessThanGivenNum(mod);
                int beginIndex = 0;
                while (!list.isEmpty()) {
                    String currentStr = list.pollFirst();

                    if (beginIndex == 0) {
                        stringBuilder.append(currentStr);
                        if (stringBuilder.length() < maxWidth) {
                            stringBuilder.append(BLANK_STRING);
                            fillBlankByCount(stringBuilder, everyWordsEndBlank);
                        }


                    } else if (beginIndex == listSize - 1) {
                        stringBuilder.append(currentStr);
                    } else {
                        stringBuilder.append(currentStr);
                        if (stringBuilder.length() < maxWidth) {
                            stringBuilder.append(BLANK_STRING);
                            fillBlankByCount(stringBuilder, everyWordsEndBlank);
                        }

                    }
                    if (listModIndex.contains(beginIndex)) {
                        stringBuilder.append(BLANK_STRING);
                    }
                    beginIndex++;
                }
            }

        }


        return stringBuilder.toString();

    }

    private List<Integer> getListLessThanGivenNum(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        return list;

    }

    private int getCharCountByList(LinkedList<String> list) {
        int count = list.stream().mapToInt(String::length).sum();
        return count;
    }

    private void endLineBuilder(LinkedList<String> list, int maxWidth, StringBuilder stringBuilder) {
        for (String str : list) {
            stringBuilder.append(str).append(BLANK_STRING);
        }
        if (stringBuilder.length() > maxWidth) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            fillBlankByCount(stringBuilder, maxWidth - stringBuilder.length());
        }
    }

    private void fillBlankByCount(StringBuilder stringBuilder, int countBlank) {
        for (int i = 0; i < countBlank; i++) {
            stringBuilder.append(BLANK_STRING);

        }
    }

    public String bestSolutionWindowSubstr(String beSubstring, String windowStr) {
        Preconditions.checkNotNull(beSubstring);
        Preconditions.checkNotNull(windowStr);
        Preconditions.checkState(beSubstring.length() > 0);
        Preconditions.checkState(windowStr.length() > 0);
        int[] map = new int[128];
        int windowStrLength = windowStr.length();
        int start = 0, end = 0, minLength = Integer.MAX_VALUE, startIndex = 0;
        for (char charTmp : windowStr.toCharArray()) {
            map[charTmp]++;
        }
        /**
         * if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
         *                 s.length() < t.length()) {
         *             return new String();
         *         }
         *         int[] map = new int[128];
         *         int count = t.length();
         *         int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
         *         /// UPVOTE !
         *         for (char c : t.toCharArray()) {
         *             map[c]++;
         *         }
         *
         *         char[] chS = s.toCharArray();
         *
         *         while (end < chS.length) {
         *             if (map[chS[end++]]-- > 0) {
         *                 count--;
         *             }
         *             while (count == 0) {
         *                 if (end - start < minLen) {
         *                     startIndex = start;
         *                     minLen = end - start;
         *                 }
         *                 if (map[chS[start++]]++ == 0) {
         *                     count++;
         *                 }
         *             }
         *         }
         *
         *         return minLen == Integer.MAX_VALUE ? new String() :
         *                 new String(chS, startIndex, minLen);
         *     }
         */
        char[] beSubstringCharArr = beSubstring.toCharArray();
        while (end < beSubstringCharArr.length) {
            //if the current character of the beSubstringCharArr in map,the count of waiting match character substract one ,
            // move the index end to the next one, the character of t
            if (map[beSubstringCharArr[end++]]-- > 0) {
                windowStrLength--;
            }
            while (windowStrLength == 0) {
                //if current substring length is the minimum length of  substring,record the start index and minimum length
                if (end - start < minLength) {
                    startIndex = start;
                    minLength = end - start;

                }
                if (map[beSubstringCharArr[start++]]++ == 0) {
                    windowStrLength++;

                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : new String(beSubstringCharArr, startIndex, minLength);

    }

    public String getMinWindowBasedIndex(Collection<KV> collection) {
        List<Integer> listReturn = new LinkedList<>();
        collection.forEach(KV -> {
            char key = (char) KV.getKey();
            LinkedList<Integer> list = (LinkedList) KV.getValue();
            listReturn.add(list.pollFirst());

        });
        return "";


    }

    /**
     * <p>https://leetcode.com/problems/longest-substring-without-repeating-characters/</p>
     * <p>
     * abcbcabc
     *
     * @param inputStr
     * @return
     */
    public int lengthOfLongestSubstringV1(String inputStr) {
        int longestSub = 0, startIndex = 0;
        String lastLongestStr = "";
        while (startIndex < inputStr.length()) {
            List<Character> list = new LinkedList<>();
//            sb.append(inputStr.charAt(startIndex));
            int startWindowIndex = startIndex;
            while (startWindowIndex < inputStr.length()) {
                Character characterWindow = inputStr.charAt(startWindowIndex);
                if (!list.contains(characterWindow)) {
                    list.add(characterWindow);
                    startWindowIndex++;
                } else {

                    break;

                }

            }
            if (list.size() > longestSub) {
                longestSub = list.size();
                lastLongestStr = list.toString();
            }
            startIndex++;
        }
        return longestSub;
    }

    /**
     * 滑动窗口 找最长不重复字符串长度
     *
     * @param strInput
     * @return
     */
    public int lengthOfLongestSubstringV2SidingWindow(String strInput) {
        //leftIndex rightIndex
        int left = 0, right = 0, longestSubLength = 0, bestLeft = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (right < strInput.length()) {
            Character charCurr = strInput.charAt(right);
            if (map.containsKey(charCurr)) {
                left = Math.max(left, map.get(charCurr) + 1);
            }
            if (right - left + 1 > longestSubLength) {
                longestSubLength = right - left + 1;
                bestLeft = left;
                //longestStr=strInput.substring(left,right+1);
            }
            longestSubLength = Math.max(longestSubLength, right - left + 1);
            map.put(charCurr, right);
            right++;
        }
        String longestStr = strInput.substring(bestLeft, bestLeft + longestSubLength);
        logger.info("longestStr:" + longestStr);

        return longestSubLength;
    }

    /**
     * 76 {@code https://leetcode.com/problems/minimum-window-substring/description/}
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     * <p>
     * The testcases will be generated such that the answer is unique.
     * Example 1:
     * <p>
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     * <p>
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * <p>
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     * <p>
     * <p>
     * Follow up: Could you find an algorithm that runs in O(m + n) time?
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string ""
     *
     * @param strSource
     * @param windowStr
     * @return
     */
    public String minWindowSubstrV2SlidingWindow(String strSource, String windowStr) {
        //s = "ADOBECODEBANC", t = "ABC"
        String minStr = "";
        int left = 0, right = 0, minStrLength = Integer.MAX_VALUE, bestLeft = 0, leftNext = 0, valid = 0;
        ;
        Map<Character, Integer> windowMap = new HashMap<>();
        for (Character character : windowStr.toCharArray()) {
            windowMap.put(character, windowMap.getOrDefault(character, 0) + 1);
        }
        Map<Character, Integer> sourceMap = new HashMap<>();
        while (right < strSource.length()) {
            Character charCurr = strSource.charAt(right);
            if (windowMap.containsKey(charCurr)) {
//                if (leftNext == 0 && valid == 2) {
//                    leftNext = right;
//                }
                sourceMap.put(charCurr, sourceMap.getOrDefault(charCurr, 0) + 1);
                if (windowMap.get(charCurr).equals(sourceMap.get(charCurr))) valid++;
            }
            while (valid == windowMap.size()) {
                if (right - left + 1 < minStrLength) {
                    bestLeft = left;
                    minStrLength = right - left + 1;
                }
//                minStrLength = Math.min(minStrLength, right - left + 1);

                char lastLeft = strSource.charAt(left);
                if (windowMap.containsKey(lastLeft)) {
                    sourceMap.put(lastLeft, sourceMap.get(lastLeft) - 1);
                    if (sourceMap.get(lastLeft) < windowMap.get(lastLeft)) {
                        valid--;
                    }
                }

                left++;//left置位下一含windowMap位置index
//                leftNext = 0;
            }


            right++;
        }
//        if (minStrLength > 0) {
//            minStr = strSource.substring(bestLeft, bestLeft + minStrLength);
//        }
        return minStrLength == Integer.MAX_VALUE ? "" : strSource.substring(bestLeft, bestLeft + minStrLength);

    }

    /**
     * 固定窗口长度起始索引
     * <p>https://leetcode.com/problems/find-all-anagrams-in-a-string/description/</p>
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
     * Example 1:
     * <p>
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     * <p>
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s and p consist of lowercase English letters.
     *
     * @param strSource
     * @param windowStr
     * @return
     */
    public List<Integer> findAnagramsV1SlidingWindow(String strSource, String windowStr) {
        List<Integer> fixedIndexList = new ArrayList<>();
        int left = 0, right = 0, valid = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        for (Character character : windowStr.toCharArray()) {
            windowMap.put(character, windowMap.getOrDefault(character, 0) + 1);
        }
        Map<Character, Integer> sourceMap = new HashMap<>();
        while (right < strSource.length()) {
            Character charCurr = strSource.charAt(right);
            if (windowMap.containsKey(charCurr)) {
                sourceMap.put(charCurr, sourceMap.getOrDefault(charCurr, 0) + 1);
                if (windowMap.get(charCurr).equals(sourceMap.get(charCurr))) valid++;
                // 2. 修正：控制窗口长度。如果窗口太长了（比如 target 是 "abc", 窗口里成了 "abac"）
                // 我们必须踢出左边的一个字符，保证长度始终 <= windowStr.length()
                if (right - left + 1 > windowMap.size()) {
                    char lastLeft = strSource.charAt(left);
                    // 只有当减少这个字符会破坏平衡时，valid 才减
                    if (sourceMap.get(lastLeft).equals(windowMap.get(lastLeft))) {
                        valid--;
                    }
                    sourceMap.put(lastLeft, sourceMap.get(lastLeft) - 1);

                    left++;
                }
                if (valid == windowMap.size()) {


                    fixedIndexList.add(left);

                }
            } else {
                left = right + 1;
                sourceMap.clear();
                valid = 0;
            }


            right++;
        }
        return fixedIndexList;


    }

    /**
     * AI 版本
     *
     * @param strSource
     * @param patternStr
     * @return
     */
    public List<Integer> findAnagramsV2SlidingWindowRelease(String strSource, String patternStr) {
        List<Integer> startPatternIndexs = new ArrayList<>();
        if (strSource.length() < patternStr.length()) return startPatternIndexs;
        Map<Character, Integer> needs = new HashMap<>();
        for (char needChar : patternStr.toCharArray()) {
            needs.put(needChar, needs.getOrDefault(needChar, 0) + 1);
        }
        Map<Character, Integer> slidingWondows = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        while (right < strSource.length()) {
            Character charCurr = strSource.charAt(right);
            // 1. 右边进：更新数据 (Right in: Update data)
            if (needs.containsKey(charCurr)) {
                slidingWondows.put(charCurr, slidingWondows.getOrDefault(charCurr, 0) + 1);
                if (slidingWondows.get(charCurr).equals(needs.get(charCurr))) valid++;
            }
            // 2. 核心：判断窗口长度是否达标 (Core: Check if window length is reached)
            // 窗口长度达到 windowStr.length() 时，开始判断并收缩
            if (right - left + 1 == needs.size()) {
                if (valid == needs.size()) {
                    startPatternIndexs.add(left);
                }
                Character lastLeft = strSource.charAt(left);
                // 只有当减少这个字符会破坏平衡时，valid 才减
                if (slidingWondows.get(lastLeft).equals(needs.get(lastLeft))) {
                    valid--;
                }
                slidingWondows.put(lastLeft, slidingWondows.getOrDefault(charCurr, 0) - 1);
                left++;
            }


            right++;
        }
        return startPatternIndexs;

    }


    public void combinationHelper(List result, List current, Number[] arr, int index) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            combinationHelper(result, current, arr, i + 1);
            current.remove(current.size() - 1);
        }
    }


    private Collection<Integer> searchAllIndex(char key, String str) {
        LinkedList<Integer> list = new LinkedList<>();
        int index = str.indexOf(key);//*第一个出现的索引位置
        while (index != -1) {
            list.add(index);
            index = str.indexOf(key, index + 1);//*从这个索引往后开始第一个出现的位置
        }
        return list;
    }


    public static class StringLeetCodeInstance {
        private static final StringLeetCode stringLeetCode = new StringLeetCode();

        public static StringLeetCode getStringLeetCodeInstance() {
            return stringLeetCode;
        }
    }
}
