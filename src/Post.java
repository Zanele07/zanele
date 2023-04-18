
/** @autor Zanele Ndlovu
 * 18 April 2023
 * A post class which contains title
 * videoClip and likes  **/
class Post implements Comparable<Post> {
    private String title;
    private String videoClip;
    private String likes;

    /**
     * This is the constructor method that initialises the instances of the object
     * @param title
     * @param videoClip
     * @param likes
     */
    public Post(String title, String videoClip, String likes) {
        this.title = title;
        this.videoClip = videoClip;
        this.likes = likes;
    }


    /**
     * To obtain the title of the video fro the user of a given account
     * @return
     */
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This is to obtain the accounts video clip
     * @return
     */
    public String getVideoClip() {
        return videoClip;
    }

    /**
     * This method is to set the video clip
     * @param videoClip
     */
    public void setVideoClip(String videoClip)
    {
        this.videoClip = videoClip;
    }

    /**
     * This method returns the likes of a video clip
     * @return likes
     */
    public String getLikes(){
        return likes;
    }
/* This is to save the likes obtained
*/

    /**
     * This method returns sets/updates the likes of the video clip
     * @param likes
     */

    public void setLikes(String likes)
    {
        this.likes = likes;
    }

    /* The compareTo() method is implemented to provide a natural ordering for
     User and Post objects . The method compares two Post
     objects and two user object based on their titles, video clips, and likes in that order*/

    /**
     * This method takes in the object of type post and compare it to the other the current post object running in this class
     * @param another the object to be compared.
     * @return integer
     */
     public int compareTo (Post another) {
        int res = this.title.compareTo(another.title);
        if (res == 0) {
            this.videoClip.compareTo(another.videoClip);
        }if (res == 0) {
            this.likes.compareTo(another.likes);
        }
        return res;
    }

    /**
     * This method returns the string form of the class  object
     * @return object string
     */

    @Override
    public String toString() {
        return "User{" +
                "title='" + title + '\'' +
                ", des='" + videoClip + '\'' +
                '}';
    }
}


