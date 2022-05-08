public class Driver {
    public static void main(String[] args) {


    MyBinaryTree tree = new MyBinaryTree();

        for (int i =0;i<args.length;i++) {
            try {
                tree.add(Integer.parseInt(args[i]));
            } catch(Exception e) {
                // attemping to remove non integer values + e.getMessage()
            }
        }




System.out.println(tree.contains(10));



    }
}
