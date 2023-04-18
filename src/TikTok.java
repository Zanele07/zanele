/** @autor Zanele Ndlovu
 * 18 April 2023
 * This a TikTok Class to produce a simple proof-of-concept
 * replica of some functionality of a social media system like TIktok,
 * using Binary Search Trees as the main underlying data structure**/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TikTok {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BinarySearchTree<User> bst = new BinarySearchTree<User>();


    /**
     * This method reads loads all the data from the dataset and add them to binary search tree
     * @throws FileNotFoundException
     */
    public static void loadActionsFromFile() throws FileNotFoundException {
        System.out.print("Load a file of actions from disk and process: ");
        String filename = scanner.nextLine();                           /*To read a file*/

        File file = new File(filename);
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
        String videoClip;
        String likes;
        ArrayList<Post> arr = new ArrayList<>();

        int num = 0;
        //This is to read each and every line of the file
        while (line.hasNext())
        {

            lines = line.nextLine();
            ls = line.nextLine().split(" ");
// the word is "create" it should return the lines where there is create as the first word
            if (ls[0].equalsIgnoreCase("create")) {
                username = ls[1];

                StringBuilder des = new StringBuilder();
                for (int i = 2; i < ls.length; i++) {
                    des.append(ls[i]);

                }

                User user = new User(username, des.toString(), null);

                bst.insert(user);
                //bst.inOrder();
            }

            else{
                //Add ZamWesell9 video6304.mpg 9219 Sadie's vigil defiance picturesque sterling
                //When the first word is "add" it should add the lines where the first word is add ***/

                StringBuilder title = new StringBuilder();
                for (int i = 5; i < ls.length; i++) {
                    title.append(ls[i]);
                }
                videoClip = ls[2];
                likes= ls[3];
                username= ls[1];

                User user = new User(username, null, null);
//                if (bst.find(user) != null) {
//
//                    System.out.println(bst.find(user).data);
//                }

                Post post = new Post(title.toString(), videoClip,likes);
                arr.add(post);

                BinaryTreeNode<User> userBinaryTreeNode ;
                BinaryTreeNode<User> testing = new BinaryTreeNode<User>(
                        new User("Vusani", null, null), null, null
                );
                if (bst.find(user) != null)
                {
                    userBinaryTreeNode = bst.find(user);
                    User userr = userBinaryTreeNode.getData();
                    userr.setPost(arr);

//                System.out.println("You've successfully loaded the file");
//                        user2.setPost(arr);
//                        System.out.println(user2);
                }

//                    bst.insert(post);
                //bst.inOrder();
            }

        }




    }

    /**
     * This method handles all the input and outputs of the user
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //loadAccounts();
//        Scanner line = new Scanner(System.in);



        //
        int choice = 0;
        do {
            System.out.println("\nChoose an action from the menu:");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit");

            System.out.print("Enter your choice: ");
            try{
            choice = scanner.nextInt();

            scanner.nextLine();}
            catch(InputMismatchException e){
                System.out.println("Please enter a number in the provided options");
                scanner.nextLine();
                continue;
            }

            // Consume newline character
            //The user choices if the user enters the first option it should
            //return the method "find the profile description and if the user enters option 2
            //it should return the list all accounts method, so forth and forth until the user
            // enters option 8 where it will quit the program
            switch (choice) {
                case 1:
                    findProfileDescription();
                    break;
                case 2:
                    listAllAccounts();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    deleteAccount();
                 case 5:
                    displayAllPosts();
                    break;
              case 6:
                   addNewPost();
                  break;
               case 7:
                  loadActionsFromFile();
                   break;
                case 8:
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    /**
     * This method will require the user to enter the account name and will further go to the binary search tree to obtain a corresponding account description
     */

    private static void findProfileDescription()
    {
        System.out.print("Enter the account name: ");
       String accountName = scanner.nextLine();

        User user = new User (accountName, null,null);
        BinaryTreeNode<User> username  = bst.find(user);
//        User user = new User(String username, );
        if (username != null) {
            System.out.println("The profile description is: " + username.data.getDescription());
        } else {
            System.out.println("Account not found.");
       }
    }

    /**
     * This method is when the user enters the second option. It will order the list in the binary search tree and print the list of accounts
     */
    private static void listAllAccounts()
    {
        System.out.println("List of all accounts:");

       bst.inOrder();
    }


    /**
     * This method is when the user enters option 3, it will ask the user for the account name and if the account does not already exist it will create that account with profile description
     */
    private static void createAccount()
    {
        System.out.print("Enter the account name: ");
        String accountName = scanner.nextLine();

     User user = new User (accountName, null,null);
        if (bst.find(user) != null) {
            System.out.println("Account already exists.");
            return ;
        }

        System.out.print("Enter the profile description: ");
        String description = scanner.nextLine();

//        System.out.print("Enter posts: ");
//        String posts = scanner.nextLine();

        User user2 = new User(accountName,description,null);
        bst.insert(user2);

       System.out.println("Account created successfully.");
    }


    /**
     * If the user enters option 4, they will be required to  provide the account name which they'd like to delete. It will go to the binary search tree and look for the account that needs to be deleted
     */
    private static void deleteAccount()
    {
        System.out.print("Enter the account name: ");
        String accountName = scanner.nextLine();
        User user3 = new User(accountName,null,null);
        BinaryTreeNode<User> username = bst.find(user3);
        if (username != null)
        {
            bst.delete(user3);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * when the user enters option 5, it will display all post of the given account name
     */
    private static void displayAllPosts()
    {
        System.out.print("Enter the account name: ");
        String accountName = scanner.nextLine();
        User user3 = new User(accountName,null,null);
        BinaryTreeNode<User> username = bst.find(user3);
        System.out.println(username.data.getPosts());
    }

    /**
     * When the user enters option 6,it will require the user to enter the user, title and video then go on to add the post
     */
    private static void addNewPost()
   {
       System.out.print("Account name: ");
       String user = scanner.nextLine();
       System.out.print("Title: ");
       String title = scanner.nextLine();
       System.out.print("Video: ");
       String videoClip = scanner.nextLine();
       System.out.print("Likes: ");
       String likes = scanner.nextLine();
       User user3 = new User(user,null,null);
       BinaryTreeNode<User> username = bst.find(user3);
       Post post = new Post(title, videoClip, likes);
       username.data.getPosts().add(post);
   }
}
