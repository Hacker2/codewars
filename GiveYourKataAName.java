package com.comdewars;


import java.util.*;
import java.util.stream.IntStream;

public class Kata {

    public static void main(String[] args) {
        String[] s = {"co","de","w","ar","s"};
        String[] s2 = {"k","a","t","a"};
        String[] s3 = {"give","your","kata","a","name"};
        String[] s4 = {"mo","re","twi","zzl","ers"};
        String[] s5 = {"srfcn","mmeisvnm","gwkqcpnm","gfwksynddy","ghor","dxyw","roafpth","nrthpgoi","steagb","bdgvn","fzjloi","bidxnt"};
        String[] s6 = {"sw","hm","dcti","va","ot","atgollimdk","o","ydlylbi","exn","dt"};
        String[] s7 = {"mwjfcocwhj","qnfvb","en","zqousguxmh","oo","yx","kvkcj","gwjeaca","jf"};
        String[] s8 = {"utaydoybo","qe","miiamtrgez","djwmpizt","ugdwdwym","oe","bcb","ndy","rs"};
        String[] s9 = {"ahkbl","hpc","mxtg","ar","qqhdcdrhug","nyqvsmtr","apwkisfnxg","tkpjb","sv","okwumzc","ciqg","qauxokxa","bvgo","fydjjpia","blg","qkmshqdqr"};
        String[] s10 = {"uswfjd","hqd","hzirec","hbrxccqbmcd","hqisvp"};
        String[] s11 = {"rzurjy","umbuwogw","mgooxbssu","ebgqb","qrfwwld","uricn","bcjrzgu"};
        String[] s12 = {"t"," xysg","ugik","rnnkcxyoh","u","ful","voaibie","kftmgitxfe","hcwlixacxj","wubg","rs","ccbr","nubcgckdfg","tqbtjtfk"};
        String[] s13 = {"nkkfboro","lm","yswsbmcwy","zeoce","ib","epxdvg","ymqggyr"};
        String[] s14 = {"rconarj","hcp","jp","kbygkfb","tc","jvvr","u","pwk","qizqyswttj"};
        String[] s15 = {"ynathtj","an","kvjicqo","nyqel","cdxnjhh","bcapu","tvax","jvtqin","lpd","dhvptgrz","jjxj","jakhtbmyl","d","uohpiejhf"};
//        String[] s10 = {"xdbejsyb", "ofgyyh"};
//        String[] s10 = {"bkvayktl", "emxfvayle", "fosq"};
//        System.out.println(name(s));
//        System.out.println(name(s2));
//        System.out.println(name(s3));
//        System.out.println(name(s4));
//        System.out.println(name(s5));
//        System.out.println(name(s6));
//        System.out.println(name(s7));//26,18
//        System.out.println(name(s8));//17, 10
//        System.out.println(name(s9));//44, 26
//        System.out.println(name(s10));//15, 12
//        System.out.println(name(s11));//12, 10
//        System.out.println(name(s12));
//        System.out.println(name(s13));//9> but was: <2
//        System.out.println(name(s14));//17> but was: <12
        System.out.println(name(s15));//27> but was: <22
//        System.out.println(name(new String[] {"abcd"}));
//        System.out.println(name(new String[] {"az"}));

//        int[] ar = new int[] {1,2,3,4};
//        for (int i = ar.length - 1; i >= 0; i--) {
//            for (int j = 0; j < ar.length; j++) {
//                if(i != j) {
//                    System.out.println(ar[j]);
//                }
//            }
//            System.out.println(ar[i]);
//            System.out.println("--------");
//        }

//        int input[] = { 1, 2, 3 };
//        possibleNumbers(input, 0);
    }

//    public static void possibleNumbers(int[] x, int index) {
//        if (index == x.length) {
//            for (int i = 0; i < x.length; i++) {
//                System.out.print(x[i] + " ");
//            }
//            System.out.println();
//        }
//        for (int i = index; i < x.length; i++) {
//            int temp = x[index];
//            x[index] = x[i];
//            x[i] = temp;
//            possibleNumbers(x, index + 1);
//
//            temp = x[index];
//            x[index] = x[i];
//            x[i] = temp;
//        }
//    }

    public static int name(String[] s) {
        System.out.println(Arrays.toString(s));
        map = new HashMap<>();
        sum = 0;
        List<int[]> list = new ArrayList<>();
        IntStream.range(0, s.length).forEach(i -> {
            list.add(new int[] {Arrays.stream(s[i].split("")).mapToInt(x -> x.charAt(0) % 96).sum(),
            s[i].length()});
            System.out.println(s[i] + " " + list.get(i)[0] + " " + s[i].length() + ", " + list.get(i)[0] + "-" + (s[i].length() * 10) + "=" + (list.get(i)[0] - (s[i].length() * 10)));
        });
        list.sort(Comparator.comparingInt(x -> x[0] - (x[1] * 10)));
        int minusSum = 0;
        int minusLength = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)[0] - (list.get(i)[1] * 10) <= 0) {
                minusSum += list.get(i)[0] - (list.get(i)[1] * 10);
                minusLength += list.get(i)[1];
                list.remove(i--);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] - (list.get(i)[1] * 10) > Math.abs(minusSum)) {
                list.remove(i--);
            }
        }
        int length = minusLength;
        sum = minusSum;
        possibleNumbers(list, 0);
//        Optional<Map.Entry<List<int[]>, Integer>> max = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
//        Optional<Map.Entry<List<int[]>, Integer>> max = map.entrySet().stream().max(Comparator.comparingInt(x -> x.getKey().stream().mapToInt(y -> y[1]).sum()));
        Optional<Map.Entry<List<int[]>, Integer>> max = map.entrySet().stream().max(Comparator.comparingInt(x -> {
            int sm = 0;
            int maxLength = sum;
            for (int i = 0; i < x.getKey().size(); i++) {
                sm += x.getKey().get(i)[1];
                maxLength += x.getKey().get(i)[0];
                if(maxLength > 0) {
                    break;
                }
            }
            return sm;
        }));
        if(max.isPresent()) {
            List<int[]> maxArr = max.get().getKey();
            for (int i = 0; i < maxArr.size(); i++) {
                sum += maxArr.get(i)[0] - maxArr.get(i)[1] * 10;
                length += maxArr.get(i)[1];
                if(sum >= 0) {
                    if(sum == 0) return length;
                    return length - maxArr.get(i)[1];
                }
            }
        }
        return length;
    }

    static int sum = 0;
    static Map<List<int[]>, Integer> map = new HashMap<>();

    public static void possibleNumbers(List<int[]> x, int index) {
        if (index == x.size()) {
            int innerSum = sum;
            for (int i = 0; i < x.size(); i++) {
                innerSum += x.get(i)[0] - (x.get(i)[1] * 10);
                if(innerSum >= 0) {
                    innerSum -= x.get(i)[0] - (x.get(i)[1] * 10);
                    map.put(new ArrayList<>(x), Math.abs(innerSum));
                    break;
                }
            }
//            if(innerSum < 0) {
//                map.put(new ArrayList<>(x), Math.abs(innerSum));
//            }
        }
        for (int i = index; i < x.size(); i++) {
            int[] temp = x.get(index);
            x.set(index, x.get(i));
            x.set(i, temp);
            possibleNumbers(x, index + 1);

//            temp = x.get(index);
//            x.set(index, x.get(i));
//            x.set(i, temp);
        }
    }
}


