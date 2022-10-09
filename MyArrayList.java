import java.util.Arrays;

public class MyArrayList <T>  {
    private Object[] array = new Object[0];

    public void add(T info){
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


    public Object get(int index){
        if (index >= array.length){
            return "index is too big for";
        }
        return array[index];
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
        return "[" + str + array[array.length - 1] +"]";
    }
}
