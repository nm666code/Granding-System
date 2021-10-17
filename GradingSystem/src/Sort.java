import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
	
	public static void insertSort(ArrayList<Student> students, Comparator<Student> C) {
		int i,j;
		Student key;
		for (i=1;i!=students.size();++i){
			key = students.get(i);
			j=i-1;
            while(j >= 0 && C.compare(students.get(j), key) > 0) {
                students.set(j+1, students.get(j));
            	j--;
            }
            students.set(j+1, key);
        }
	}
	
	public static void heapSort(ArrayList<Student> students, Comparator<Student> C) {   
		int len = students.size() - 1;
	    int beginIndex = (students.size() >> 1)- 1;
	    for (int i = beginIndex; i >= 0; i--)
	    	maxHeapify(students, i, len, C);
	      
	    for (int i = len; i > 0; i--) {
	    	Collections.swap(students, 0, i);
	    	maxHeapify(students , 0, i - 1, C);
	    }
	}
	    
	private static void maxHeapify(ArrayList<Student> students, int index, int len, Comparator<Student> C) {
		int li = (index << 1) + 1; 
	    int ri = li + 1;           
	    int cMax = li;             
	    if (li > len) return;      
	    if (ri <= len && C.compare(students.get(ri), students.get(li)) > 0) 
	    	cMax = ri;
	    if (C.compare(students.get(cMax), students.get(index)) > 0) {
	    	Collections.swap(students, cMax, index);      
	        maxHeapify(students, cMax, len, C);  
	    }
	}
	 
	public static void quickSort(ArrayList<Student> students, Comparator<Student> C) {
		qsort(students, 0, students.size() - 1, C);
	}
	    
	private static void qsort(ArrayList<Student> students, int left, int right, Comparator<Student> C) {
		if(left < right) { 
			int q = partition(students, left, right, C); 
	        qsort(students, left, q-1, C); 
	        qsort(students, q+1, right, C); 
		} 
	}

	private static int partition(ArrayList<Student> students, int left, int right, Comparator<Student> C) {  
		int i = left - 1; 
	    for(int j = left; j < right; j++) { 
	    	if(C.compare(students.get(j), students.get(right)) <= 0) { 
	    		i++; 
	            Collections.swap(students, i, j); 
	        }
	    }
	    Collections.swap(students, i+1, right); 
	    return i+1; 
	} 
}
