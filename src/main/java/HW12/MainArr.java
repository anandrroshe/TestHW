package HW12;

public class MainArr {
    public static void main(String[] args) {
        NewArr arrList = new NewArr();
        for (int i = 0; i <10; i++) {
            arrList.add(i + " ");
        }
        System.out.println(arrList.toString());
        System.out.println("Size of collection is: "+ arrList.size());
        System.out.println("Adding Neon element to the list:......."+ "\n -----|OPERATION COMPLETE|----- \n Is Neon added to the list? - "
                +arrList.add("Neon"));
        System.out.println("List contents: \n" +arrList.toString());
        System.out.println("Adding Argon on second place element to the list:......."+ "\n -----|OPERATION COMPLETE|----- " +
                "\n Is Argon added to the second place in the list? - "+ arrList.add(1,"Argon"));
        System.out.println("List contents: \n" + arrList.toString());
        System.out.println("Deleting Neon element from the list:......."+ "\n -----|OPERATION COMPLETE|-----" +
                " \n Is Neon deleted from the list? - " + arrList.delete("Neon"));
        System.out.println("List contents: \n" + arrList.toString());
        System.out.println("Getting second place element from list - " + arrList.get(1));
        System.out.println("Does list contents Argon ?"+ arrList.contain("Argon"));
        System.out.println("Deleting list information......."+ "\n -----|OPERATION COMPLETE|-----\n Is all information deleted? "
                + arrList.clear());
        System.out.println("How much is elements left in list? " + arrList.size()+ " elements in the list.");
        NewArr testArr = new NewArr();
        System.out.println("Creating  new empty collection. How much elements in this list? " + arrList.size()+ " elements in the list.");
        System.out.println("Are collection same? It's " + arrList.equals(testArr));

    }
}
