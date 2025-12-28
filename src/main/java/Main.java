public class Main {
    public static Queue<Integer> copy(Queue<Integer> q) {
        Queue<Integer> newQ = new Queue<>();
        Queue<Integer> tempQ = new Queue<>();

        while (!q.isEmpty()) {
            int element = q.remove();
            tempQ.insert(element);
            newQ.insert(element);
        }

        while (!tempQ.isEmpty()) {
            q.insert(tempQ.remove());
        }

        return newQ;
    }


    public static boolean isIn(int x, Queue<Integer> q) {
        Queue<Integer> temp = new Queue<>();
        boolean found = false;

        while (!q.isEmpty()) {
            int y = q.remove();
            if (y == x) found = true;
            temp.insert(y);
        }

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }

        return found;
    }


    public static Queue<Integer> runLengths(Queue<Character> q) {
        Queue<Integer> result = new Queue<>();
        Queue<Character> temp = new Queue<>();

        if (q.isEmpty()) return result;

        char prev = q.remove();
        temp.insert(prev);
        int count = 1;

        while (!q.isEmpty()) {
            char curr = q.remove();
            temp.insert(curr);

            if (curr == prev) {
                count++;
            } else {
                result.insert(count);
                count = 1;
                prev = curr;
            }
        }

        result.insert(count);

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }

        return result;
    }


    public static void removeDuplicates(Queue<Integer> q) {
        Queue<Integer> qCopy = copy(q);
        Queue<Integer> unique = new Queue<>();

        while (!qCopy.isEmpty()) {
            int x = qCopy.remove();
            if (!isIn(x, unique)) {
                unique.insert(x);
            }
        }

        while (!unique.isEmpty()) {
            q.insert(unique.remove());
        }
    }


    public static void sortQueue(Queue<Integer> q) {
        Queue<Integer> sorted = new Queue<>();

        while (!q.isEmpty()) {
            int min = q.remove();
            Queue<Integer> temp = new Queue<>();
            temp.insert(min);

            while (!q.isEmpty()) {
                int x = q.remove();
                temp.insert(x);
                if (x < min) min = x;
            }

            boolean removed = false;
            while (!temp.isEmpty()) {
                int x = temp.remove();
                if (x == min && !removed) {
                    removed = true;
                } else {
                    q.insert(x);
                }
            }

            sorted.insert(min);
        }

        while (!sorted.isEmpty()) {
            q.insert(sorted.remove());
        }
    }


    public static void main(String[] args) {

        Queue<Character> chars = new Queue<>();
        chars.insert('c');
        chars.insert('c');
        chars.insert('a');
        chars.insert('c');

        System.out.println(runLengths(chars));

        Queue<Integer> nums = new Queue<>();
        nums.insert(3);
        nums.insert(5);
        nums.insert(3);
        nums.insert(2);
        nums.insert(5);

        System.out.println(removeDuplicates(nums));
       
        Queue<Integer> q = new Queue<>();
        q.insert(4);
        q.insert(1);
        q.insert(3);
        q.insert(2);

        System.out.println(sortQueue(q));

    }
}
