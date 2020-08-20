/*Problem 1: 
An online news organization wants to transform the top three longest words from a newspaper headline into hashtags.
Task: Write a Java program to accomplish this task.
Examples:
getHashTags("How the Avocado Became the Fruit of the Global Trade")
➞ ["#avocado", "#became", "#global"]
getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")
➞ ["#christmas", "#probably", "#will"]
getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")
➞ ["#surprise", "#parents", "#fruit"]
getHashTags("Visualizing Science")
➞ ["#visualizing", "#science"]

Notes:
1.	If the title is less than three words, just order the words in the title by length in descending order (see example #4).
2.	Punctuation does not count towards a word's length.
3.	If multiple words tie for the same length, retrieve the word that occurs first.
*/
package com.nit.hk;

public class StringP1 {

	public static void getHashTags(String heading) {
		String[] headingArr = heading.split(" ");
		
		System.out.print("[");
			for (int j = 0; j < 3; j++) {
			String string = headingArr[0];
			int count=1;
			for (int i = 1; i < headingArr.length; i++) {
				if (string.length() < headingArr[i].length()) {
					string = headingArr[i];
					count=i;
				}
			}
			headingArr[count]="a";
			String str =string.replaceAll("[,!?.|]", "");			
			System.out.print(" \"#"+str+"\",");
			
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
	//	getHashTags("How the Avocado Became the Fruit of the Global Trade");
	//	getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year");
	//	getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit");
	//	getHashTags("Visualizing Science");
		
	}
}
