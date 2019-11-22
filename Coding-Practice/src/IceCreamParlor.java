import java.util.Arrays;

public class IceCreamParlor {

    public static int[] findChoices(int[] menu, int money) {
        int[] sortedArray = menu.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < sortedArray.length; i++){
            int complement = Math.abs(sortedArray[i] - money);

            int location = Arrays.binarySearch(sortedArray, i+1, sortedArray.length, complement);

            if (location >= 0 && location < sortedArray.length && sortedArray[location] == complement) {
                int [] indices = getIndicesFromValues(menu, sortedArray[i], complement);

                return indices;
            }

        }

        return null;
    }

    private static int[] getIndicesFromValues(final int[] menu, final int i, final int complement) {
        int index1 = indexOf(menu, i, -1);
        int index2 = indexOf(menu, complement, index1);

        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    private static int indexOf(final int[] menu, final int value, final int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != excludeThis) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] iceCreamMenu=  {2,7,13,5,4,13,5};
        for (int i :findChoices(iceCreamMenu, 10)){
            System.out.println(i);
        }
    }

}
