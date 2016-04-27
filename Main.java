/**
 * Created by VannessTan on 26/04/2016.
 */

public class Main {

    public static void main(String[] args){

        long time = System.currentTimeMillis();
        double[][] array = new double[200][100];
        Thread[] threads = new Thread[200];
        myTask[] tasks = new myTask[200];

        double min = 999999.99;

        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 100; j++){
                array[i][j] = Math.random() * 10.24 + - 5.12;
            }
        }

        for(int i = 0; i < 200; i++){
            tasks[i] = new myTask(array[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        try{
            for(int i = 0; i < 200; i++){
                threads[i].join();
            }

            for(int i = 0; i < 200; i++){
                min = min > tasks[i].getMin() ? tasks[i].getMin() : min;
            }

            System.out.printf("Minimum value of summation of rows: %.2f\n", min);
            System.out.println("Execution Time: " + (System.currentTimeMillis() - time));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

