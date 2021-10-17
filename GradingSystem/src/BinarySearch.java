import java.util.ArrayList;

public class BinarySearch {
	/*student name & ID binary Search remember sort first*/
	public static int binarySearchID(ArrayList<Student> students, int start, int end, int ID){
	    if (start > end)
	        return -1;

	    int mid = start + (end - start)/2;    //¨¾¤î·¸¦ì
	    if (students.get(mid).getId() > ID)
	        return binarySearchID(students, start, mid - 1, ID);
	    if (students.get(mid).getId() < ID)
	        return binarySearchID(students, mid + 1, end, ID);
	    return mid;  

	}
	
	public static int binarySearchName(ArrayList<Student> students, int start, int end, String name){
	    if (start > end)
	        return -1;

	    int mid = start + (end - start)/2;    //¨¾¤î·¸¦ì
	    if (students.get(mid).getName().compareTo(name) > 0)
	        return binarySearchName(students, start, mid - 1, name);
	    if (students.get(mid).getName().compareTo(name) < 0)
	        return binarySearchName(students, mid + 1, end, name);
	    return mid;  

	}
}
