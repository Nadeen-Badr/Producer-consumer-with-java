public class Producer implements Runnable {
    Buffer buff;
    int n;

    public Producer(Buffer buff, int n) {
        this.buff = buff;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j <= (i/2)/*Math.pow(i, 0.5)*/; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                buff.produce(Integer.toString(i));
                Main.c++;
                Main.mv = i;
            }
           /* buff.done();*/
        }
         buff.done();
    }
}