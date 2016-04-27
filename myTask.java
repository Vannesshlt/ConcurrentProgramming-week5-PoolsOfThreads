/**
 * Created by VannessTan on 26/04/2016.
 */

public class myTask implements Runnable{

    private double[] array;
    private double min;

    public myTask(double[] array){

        this.array = array;
    }

    public void run(){

        int counter = 0;
        double min = 999999.99;

        do{
            double temp = summationOfRow(0, 0.0);
            min = min > temp ? temp : min;
            modifyNumber();
            counter++;

        } while(counter <= 200);

        this.min = min;
    }

    public double summationOfRow(int pointer, double value){

        if(pointer >= array.length){
            return value;
        }
        return summationOfRow(pointer+1, value + (pointer * (array[pointer] * array[pointer])));
    }

    public void modifyNumber(){

        double randomNumber = 0;

        for(int i = 0; i < array.length; i++){

            do{
                randomNumber = Math.random() * 10.24 - 5.12;

            } while (array[i] + randomNumber >= 5.12 && array[i] + randomNumber <= -5.12);

            array[i]+= randomNumber;
        }
    }


    public double getMin(){

        return min;
    }
}
