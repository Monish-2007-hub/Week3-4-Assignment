import java.util.*;

public class WeekAssignment {

    // 🔍 Linear Search (First Occurrence)
    static int linearSearchFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Not found (Linear)");
        return -1;
    }

    // 🔍 Linear Search (Last Occurrence)
    static int linearSearchLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last Found at index: " + index);
        System.out.println("Comparisons: " + comparisons);
        return index;
    }

    // 🔍 Binary Search (Any Match)
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found at index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found (Binary)");
        return -1;
    }

    // 🔁 Count Occurrences (Binary expansion)
    static int countOccurrences(String[] arr, String target, int index) {
        if (index == -1) return 0;

        int count = 1;

        int left = index - 1;
        while (left >= 0 && arr[left].equals(target)) {
            count++;
            left--;
        }

        int right = index + 1;
        while (right < arr.length && arr[right].equals(target)) {
            count++;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search
        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // Binary Search
        int index = binarySearch(logs, "accB");

        // Count duplicates
        int count = countOccurrences(logs, "accB", index);
        System.out.println("Total occurrences: " + count);
    }
}