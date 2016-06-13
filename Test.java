import java.util.Random;
import java.util.Arrays;

public class Test{

	public static void main(String[] args)
	{
	    Test t = new Test();

	    Random rand = new Random();
	    int[] tester = new int[10];
	    for(int i=0; i<10; i++) {
		tester[i] = rand.nextInt(25);
		System.out.print(tester[i] + " ");
	    }

	    System.out.println(t.sum42(tester));
	}

	public Test() {}

	public boolean sum42(int[] ary) {
	    Arrays.sort(ary);

	    int i = 0;
	    int j = ary.length - 1;
	    int sum;

	    while(i < j) {
		sum = ary[i] + ary[j];
		if(sum == 42) {
		    return true;
		} else if(sum < 42) {
		    i++;
		} else {
		    j--;
		}
	    }

	    return false;
	}

}
