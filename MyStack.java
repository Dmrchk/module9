import java.util.Arrays;

public class MyStack <T> {
    private Object[] array = new Object[0];

    Object returner;
    public void push(T info){
        array = Arrays.copyOf(array, array.length + 1 );
        array[array.length-1] = info;
    }

    public void remove(int index){
        if (index == array.length - 1){
            array = Arrays.copyOf(array, array.length - 1);
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (i < index){
                array[i] = array[i];
            }
            if (i >= index){
                array[i] = array[i+1];
            }
        }
        array = Arrays.copyOf(array, array.length - 1);
    }

    public void clear(){
        array = Arrays.copyOf(array, 0);
    }

    public int size(){
        return array.length;
    }


    public Object peek(){
        return array[array.length - 1];
    }

    public Object pop(){
        Object returner = array[array.length - 1];
        remove(array.length - 1);
        return returner;
    }

    @Override
    public String toString(){
        String str = "";
        if (array.length == 0){
            return "[]";
        }
        else{
            for (int i = 0; i < array.length - 1; i++) {
                str += array[i] + ", ";
            }
        }
        return "[" + str + array[array.length - 1 ] + "]";
    }
}
