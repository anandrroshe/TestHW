package HW12;

import java.util.Arrays;

public class NewArr implements CustomCollection {
    private Object [] arrList;
    private final int ARR_AMOUNT = 10;
    private int count = 0;

    public NewArr(){
        arrList = new Object[ARR_AMOUNT];
    }


    @Override
    public boolean add(Object o) {
        if(count==arrList.length) resize();
        arrList[count] = o;
        count++;
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        if(count==arrList.length) resize();
        count++;
        for (int i = arrList.length-2; i >= index; i--) {
            arrList[i + 1] = arrList[i];
        }

        arrList[index] = o;

        return true;
    }
    private  void removeIndex(int index) {
        for (int i = index; i < count; i++)
            arrList[i] = arrList[i + 1];
        arrList[index] = null;
        count--;
    }

    @Override
    public boolean delete(Object o) {
        count--;
        for (int i = 0; i < arrList.length; i++) {
            if (arrList[i].equals(o)) {
                removeIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return  arrList[index];
    }

    @Override
    public boolean contain(Object o) {
        for (int i = 0; i <count ; i++) {
            if (arrList[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(NewArr o) {
        if (this == o) return true;
        if (o ==null || (getClass() != o.getClass())) return false;
        NewArr that = (NewArr)o;
        if (count == that.count);{
            return equal(o);
        }
    }

    private boolean equal(NewArr o) {
        for (int i = 0; i < count; i++) {
            this.get(i);
            if (!arrList[i].equals(o.get(i))) return false;
        }
        return true;
    }

    @Override
    public boolean clear() {
        count = 0;
        Object [] arr = new Object[ARR_AMOUNT];
        arrList = arr;
        return true;
    }

    private void resize() {
        int newLength= arrList.length + 1;
        arrList= Arrays.copyOf(arrList, newLength);

    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(arrList);
    }
}





