import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dataset.txt");
        Scanner line = new Scanner(file);
//        String[] ls = line.nextLine().split( " ");
//        String username = ls[1];
//
//        StringBuilder des = new StringBuilder();
//        for (int i = 2; i < ls.length; i++) {
//            des.append(ls[i]);
        // }
        String[] ls;
        String username;
        String lines;
        BinarySearchTree<User> bt = new BinarySearchTree<User>();
        String videoClip;
        String likes;
        ArrayList<Post> arr = new ArrayList<>();
        int num = 0;
        while (line.hasNext()) {

            lines = line.nextLine();
            ls = line.nextLine().split(" ");

            if (ls[0].equalsIgnoreCase("create")) {
                username = ls[1];

                StringBuilder des = new StringBuilder();
                for (int i = 2; i < ls.length; i++) {
                    des.append(ls[i]);

                }

                User user = new User(username, des.toString(), null);

                bt.insert(user);
                //bt.inOrder();
            }

            else{
                    //Add ZamWesell9 video6304.mpg 9219 Sadie's vigil defiance picturesque sterling

                        StringBuilder title = new StringBuilder();
                        for (int i = 5; i < ls.length; i++) {
                            title.append(ls[i]);
                        }
                    videoClip = ls[2];
                    likes= ls[3];
                    username= ls[1];

                    User user = new User(username, null, null);
//                if (bt.find(user) != null) {
//
//                    System.out.println(bt.find(user).data);
//                }

                    Post post = new Post(title.toString(), videoClip,likes);
                    arr.add(post);

                    BinaryTreeNode<User> userBinaryTreeNode ;
                    BinaryTreeNode<User> testing = new BinaryTreeNode<User>(
                            new User("Vusani", null, null), null, null
                );
                    if (bt.find(user) != null) {
                        userBinaryTreeNode = bt.find(user);
                        User userr = userBinaryTreeNode.getData();
                        userr.setPost(arr);
                        String name = "V";
                        if (name.equalsIgnoreCase("v")) System.out.println("");

//                        user2.setPost(arr);
//                        System.out.println(user2);
                    }

//                    bt.insert(post);
                   //bt.inOrder();
                        }

                }

                }
            }
