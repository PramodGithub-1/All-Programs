package Practice;

import java.util.ArrayList;

public class J {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<>();

        al.add("Varm@");
        al.add("hello");
        al.add("manual");
        al.add("#hostel");
        al.add("softw@re");
        al.add("@#$%");

        for (Object abc : al) {
            if (abc instanceof String) {
                String as = (String) abc;
                if (!(as.charAt(0) >= 'a' && as.charAt(0) <= 'z')) {
                    System.out.println(as);
                }
            }
        }
    

	}

}
