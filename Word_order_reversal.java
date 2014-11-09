class Untitled {
	  public static void main(String[] args) {
		        // TODO code application logic here
		        System.out.println(reverseByWord("I am going there"));
		    }
		
	    public static String reversePart (String in){
	        // Reverses the complete string
	        StringBuffer reversed = new StringBuffer();
	        for (int i= in.length()-1; i>=0; i--){
	            reversed.append(in.charAt(i));
	        }
	        return reversed.toString();
	    }

	    public static String reverseByWord (String in){
	        // First reverses the complete string
	        // "I am going there" becomes "ereht gniog ma I"
	        // After that we just need to reverse each word.
	        String reversed = reversePart(in);
	        StringBuffer word_reversal=new StringBuffer();
	        int last_space=-1;
	        int j=0;
	        while (j<in.length()){
	            if (reversed.charAt(j)==' '){
	                word_reversal.append(reversePart(reversed.substring(last_space+1, j)));
	                word_reversal.append(" ");
	                last_space=j;
	            }
	            j++;
	        }
	        word_reversal.append(reversePart(reversed.substring(last_space+1, in.length())));
	        return word_reversal.toString();
	    }
}