package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public static void main(String[] args) {
        new Solution().recurse(464);
    }

    public void recurse(int n) {
        if(n<=1) return;
        int i;
        for(i=2;i<n;i++){
            if(n%i==0) {
                System.out.print(Integer.toString(i) + " ");
                break;
            }
        }
        if(i==n) System.out.print(n);
        else recurse(n/i);
    }
}
