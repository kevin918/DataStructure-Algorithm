class Untitled {
	public static void main(String[] args) {
		System.out.println(4%2);
		System.out.println(2345/10);
	}
	public boolean palindromWord(String word){
		String reverse = "";
		for (int x=word.length()-1;x>=0;x--) {
			reverse += word.charAt(x);
		}
		if (!reverse.equals(word)) {
			return false;
		}
		return true;
	}
	//use StringbBuffer
	public String joinWord(String[] words){
		StringBuffer sentence = new StringBuffer();
		for (String w : words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
	//1.3 permutaion strings
	public String sort(String s){
		//perumation is anagram!!
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	public boolean permuation(String s, String t){
		if (s.length()!=t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	//1.4 replace all spaces in a string with '%20'
	public void replaceSpaces(char[] s,int length){
		int spacecount =0,newlength=length;
		for (int i=0;i<length;i++) {
			if (s[i]==' ') {
				spacecount++;
			} 
		}
		newlength += spacecount*2;
		for (int i=length-1;i>=0;i--) {
			if (s[i] ==' ') {
				s[newlength-1] = '0';
				s[newlength-2] = '2';
				s[newlength-3] = '%';
				newlength = newlength-3;
			}
			else {
				s[newlength-1] = s[i];
				newlength--;
			}
		}
	}
	
	//1.5 implement a method to perform basic string compression using the counts of repeated characters. for example, the string aabbcccccaaa would become a2b1c5a3.
	public String compress(String s){
		StringBuffer mys = new StringBuffer();
		char last = s.charAt(0);
		int count=1;
		for (int i=1; i<s.length();i++) {
			if (last == s.charAt(i)) {
				count++;
			}
			else {
				mys.append(last);
				mys.append(count);
				count=1;
				last = s.charAt(i);
			}
		}
		mys.append(last);
		mys.append(count);
		return mys.toString();
	}
	
}