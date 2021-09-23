package Day1;

public class OddNumbers {
        public void printodd()
        {
            for(int i=1;i<20;i=i+2)
                System.out.println(i);
        }
        public static void main(String[] args)
        {
            new OddNumbers().printodd();
        }

}
