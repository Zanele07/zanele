/** @autor Zanele Ndlovu
 * 18 April 2023
 * A user class which contains username, description and list of posts
 *   **/

import java.util.ArrayList;

class User implements Comparable<User>{
    private String username;
    private String description;
    private ArrayList<Post> posts;
//    ArrayList<String> posts = new ArrayList<String>();
    /**
     * This is the constructor method that initialises the instances of the object
     * @param username
     * @param description
     * @param posts
     */
    public User(String username, String description, ArrayList<Post> posts) {
        this.username = username;
        this.description = description;
        posts = new ArrayList<Post>();
    }

    /**
     * This is to acquire the acounts username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method is to obtain the description of an account
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method is to set the description of an account
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method is to obtain the list of posts of a given account
     * @return posts
     */
    public ArrayList<Post> getPosts() {
         return posts;

    }

    /**
     * This method set the list of posts
     * @param posts
     */
    public void setPost(ArrayList<Post> posts) {
       this.posts = posts;
    }

    /**
     * This is a method to compare a user to another user in a binary search tree
     * @param another the object to be compared.
     * @return posts
     */
     public int compareTo (User another)

    {
        return this.username.compareTo(another.username);
//        if(res == 0){
//            this.description.compareTo(another.description);
//        }
//        if (res == 0) {
//            for (int i = 0; i < posts.length; i++) {
//                this.posts[i].compareTo(another.posts[i]);
//            }
//        }

    }


    /**
     * This method returns the string form of the class  object
     * @return object string
     */
    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", posts=" + posts +
                '}';
    }
}

