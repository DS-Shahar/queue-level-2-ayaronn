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
    	public static int MaxQ( Queue <Integer> q) {
		Queue<Integer> copy = new Queue<>();
		int max=copy.remove();
		while(!copy.isEmpty()) {
			if(copy.remove()>max) {
				max=copy.remove();
			}
			else {
				copy.remove();
			}
			return max;
		}
		
	}
	public static int digitCount(Queue<integer>q) {
		Queue<Integer> copy2 = new Queue<>();
		int count=copy2.remove();
		while(!copy2.isEmpty()) {
			copy2.remove();
			count++;
			
		}
		return count;
	}
	public static int digit(int num,int index)
	{
		Queue<Integer> copy2 = new Queue<>();
		if(digitCount(num)<index) {
			return 0;
		}
		for(int i=0;i<(index-1);i++) {
			num=num/10
		}
		num=num%10;
		return num;

		
	}
	public static Queue<Integer>bulidQueue(int[]arr){
		Queue<Integer>q=new Queue<>
		for(int i=0;i<arr.length;i++) {
			q.insert(arr[i]):
		}
		return q;
	}
	
	public static Queue<Integer> sort(Queue<Integer>q){
		for(int i=0;i<10;i++) {
			a[i]=new Queue<Integer>();
			
		}
		int x=digit(max(q));
		int num;
		for (int i = 0; i < x i++) {
			while(!q.isEmpty()) {
				num=q.remove();
				a[digitCount(num,i)].insert(num);
				
			}
		for (int j = 0; j < 10 j++) {
			while(!a[j].isEmpty()) {
				q.insert(a[j].remove());
			}
			
		}
		return q;
		    public static int max(Queue<Integer> q) {
        if (q.isEmpty() || q.head() == 0) {
            return 0;
        }

        int max = q.remove();  

        while (!q.isEmpty()) {
            int current = q.remove();

            if (current == 0) {
                return max;
            }

            if (current > max) {
                max = current;
            }
        }

        return 0;
    }
    public static Node<Integer> listmax(Queue<Integer> q) {
        Node<Integer> maxList = new Node<>(-1); 
        Node<Integer> currentNode = maxList;     

        Queue<Integer> qCopy =copy(q) ;

        while (!q.isEmpty()) {

            int currentMax = max(qCopy);

            if (currentMax != 0) {
                currentNode.setNext(new Node<>(currentMax)); 
                currentNode = currentNode.getNext();  
            }
        }

        return maxList.getNext();  
    }
			public static void tree11a (BinNode<Integer> t) 
	{
        if (t == null) 
            return;
        
        if (t.getValue() % 2 == 0) 
        {
            boolean hasEvenChild = false;

            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (t.hasRight() && t.getRight().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (!hasEvenChild) 
                System.out.println(t.getValue());
        }
        tree11a(t.getLeft());
        tree11a(t.getRight());
	}
	
	
	
	
	
	
	public static int tree11b (BinNode<Integer> t) 
	{
        if (t == null) 
            return 0;
        
        int count=0;
        
        if (t.getValue() % 2 == 0) 
        {
            boolean hasEvenChild = false;

            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (t.hasRight() && t.getRight().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (!hasEvenChild) 
                count=1;
        }
        return count + tree11b(t.getLeft()) + tree11b(t.getRight());
	}
	
	
	
	
    public static boolean tree11c(BinNode<Integer> t)
    {
        if (t == null)
            return false;
    
        boolean bool = false;
    
        if (t.getValue() % 2 == 0)
        {
            boolean hasOddChild = false;
    
            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1)
                hasOddChild = true;
    
            if (t.hasRight() && t.getRight().getValue() % 2 == 1)
                hasOddChild = true;
    
            if (!hasOddChild)
                bool = true;
        }
        return bool || tree11c(t.getLeft()) || tree11c(t.getRight());
    }
    
    
   
    
    public static boolean tree11d(BinNode<Integer> t)
    {
        if (t == null)
            return false;   
    
        boolean bool = true;
    
        if (t.getValue() % 2 == 0)
        {
            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1)
                bool = false;
    
            if (t.hasRight() && t.getRight().getValue() % 2 == 1)
                bool = false;
        }
        return bool && tree11d(t.getLeft()) && tree11d(t.getRight());
    }

	public class Main {

    public static int ex12(BinNode<Integer> t) {
        if (t == null)
            return 0;

        if (t.getValue() >= 10 && t.getValue() < 100)
            return 1 + ex12(t.getLeft()) + ex12(t.getRight());

        return ex12(t.getLeft()) + ex12(t.getRight());
    }

    public static int ex14(BinNode<Integer> t) {
        if (t == null)
            return 0;

        if (!t.hasLeft() && !t.hasRight())
            return 1;

        return ex14(t.getLeft()) + ex14(t.getRight());
    }

    public static int ex16(BinNode<Integer> t) {
        if (t == null)
            return 0;

        if (t.hasLeft() && t.hasRight())
            return t.getValue() + ex16(t.getLeft()) + ex16(t.getRight());

        return ex16(t.getLeft()) + ex16(t.getRight());
    }

    public static int ex17(BinNode<Integer> t) {
        if (t == null)
            return 0;

        if (t.hasLeft() && t.hasRight() &&
            t.getLeft().hasLeft() && t.getLeft().hasRight() &&
            t.getRight().hasLeft() && t.getRight().hasRight())
            return 1 + ex17(t.getLeft()) + ex17(t.getRight());

        return ex17(t.getLeft()) + ex17(t.getRight());
    }
	    public static boolean allevenleaves(BinNode<Integer> t){
        if (t == null) {
            return true;
        }

        if (!t.hasLeft() && !t.hasRight()) {
            return t.getValue() % 2 == 0;
        }

        return allevenleaves(t.getLeft()) && allevenleaves(t.getRight());
    }
	   public static boolean rightleftree(BinNode<Integer> t) {
        if (t == null) {
            return true;
        }

        if (t.hasRight() && t.getRight().hasLeft()) {
            return true;
        }

        return rightleftree(t.getLeft()) && rightleftree(t.getRight());
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
		 int[] a = {2, 3, 2, 5,0, 60, 48, 63, 4};
        int[] b = {2, 2, 5,0, 60, 4, 63, 4};
        Queue<Integer> q = buildQueue(a);
        Queue<Integer> q1 = buildQueue(b);
        System.out.println(max(q));
        System.out.println(listmax(q1));
 

    }
}
