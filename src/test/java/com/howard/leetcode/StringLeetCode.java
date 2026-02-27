package com.howard.leetcode;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class StringLeetCode {
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
