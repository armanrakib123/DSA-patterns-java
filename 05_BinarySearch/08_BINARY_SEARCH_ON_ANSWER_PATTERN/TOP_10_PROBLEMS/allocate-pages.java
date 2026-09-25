package 08_BINARY_SEARCH_ON_ANSWER_PATTERN.TOP_10_PROBLEMS;

/**
 * GeeksForGeeks: Allocate Minimum Number of Pages
 * Category: Hard (Classic FAANG problem)
 * 
 * Problem: You have N books, each with arr[i] number of pages. M students need to be allocated contiguous books,
 * with each student getting at least one book. 
 * Out of all the permutations, the goal is to find the permutation where the student with the most pages allocated to him 
 * gets the MINIMUM number of pages, out of all possible allocations.
 */
public class allocate_pages {

    /**
     * Approach: Binary Search on Answer
     * Once again, identical to Split Array Largest Sum and Painter's Partition.
     * We want to minimize the maximum pages assigned to a student.
     * 
     * Time Complexity: O(N log(Sum - Max))
     * Space Complexity: O(1)
     */
    public int findPages(int[] A, int N, int M) {
        // If students are more than books, allocation is impossible
        if (M > N) return -1;
        
        long low = 0;
        long high = 0;
        
        for (int pages : A) {
            low = Math.max(low, pages); // Minimum possible max pages is the book with most pages
            high += pages; // Maximum possible is all books to one student
        }
        
        long ans = -1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isValid(A, M, mid)) {
                ans = mid; // Possible. Try to minimize.
                high = mid - 1;
            } else {
                low = mid + 1; // Not possible. Need more max pages per student.
            }
        }
        
        return (int) ans;
    }
    
    private boolean isValid(int[] books, int studentsAllowed, long maxPagesAllowed) {
        int studentsUsed = 1;
        long currentPages = 0;
        
        for (int pages : books) {
            if (currentPages + pages > maxPagesAllowed) {
                studentsUsed++;
                currentPages = pages;
            } else {
                currentPages += pages;
            }
            
            if (studentsUsed > studentsAllowed) {
                return false;
            }
        }
        
        return true;
    }

    /*
     * FAANG Interview Note:
     * Why are we writing the same code 3 times? (Split Array, Painter, Allocate Books).
     * Because interviewers love to re-skin problems! 
     * Recognizing that a problem is a re-skin of an existing pattern is the 
     * fastest way to solve a "new" hard problem in 10 minutes.
     */
}
