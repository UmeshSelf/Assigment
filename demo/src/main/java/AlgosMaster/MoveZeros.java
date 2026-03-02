package AlgosMaster;

public class MoveZeros {
    static int [] numbers = {1,0,5,12,0,13} ;

    public static void main(String [] args)
    {
        MoveZeros mv = new MoveZeros();
        mv.moveZeroes(numbers);

        for (int num :numbers)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
        public void moveZeroes(int[] nums) {
            int writePos = 0; // next slot for a non-zero
            for (int readPos = 0; readPos < nums.length; readPos++) {
                if (nums[readPos] != 0) {
                    if (readPos != writePos) {
                        int tmp = nums[readPos];
                        nums[readPos] = nums[writePos];
                        nums[writePos] = tmp;
                    }
                    writePos++;
                }
            }
        }
    }

