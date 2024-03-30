//Author: John Photis
//Purpose: This Java program prints all possible strings of length k that can be formed from the given set

package Strs;

import java.util.ArrayList;

public class Permutations {
	public static void s(ArrayList<String> list, char[] chars, String prefix, int k){
        if(k==0){
            list.add(prefix);
            return;
        }else{
            for(int i=0; i<chars.length; i++){
                String newPrefix = prefix + chars[i];
                s(list,chars,newPrefix,k-1);
            }
        }
        
    }
	
	public static ArrayList<String> getAllPermutations(char[] a, int k){
		// YOUR CODES
		ArrayList<String> result = new ArrayList<String>();
        s(result,a,"",k);
        return result;
    }
	

	public static void main(String[] args) {
		char[] a = {'a', 'b', 'c', 'd'};
		System.out.println("All Permutations: " + getAllPermutations(a, 2));
	}
}