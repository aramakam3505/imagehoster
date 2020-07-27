package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'comments'.
// Hence the table named 'comments' will be created in the database with all the columns mapped to all the attributes in 'comments' class
@Table(name = "comments")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;


    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    // this is a base64 encoded version of the image
    @Column(name ="text",columnDefinition = "TEXT")
    private String text;

    //Datatype should be LocalDate.
    @Column(name = "createdDate")
    private LocalDate createdDate;

    //The 'comments' table is mapped to 'users' table with Many:One mapping
    //One comments can have only one user but one user can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'comments' table referring the primary key in 'user' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    //The 'comments' table is mapped to 'images' table with Many:One mapping
    //One comments can have only one images but one image can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'comments' table referring the primary key in 'images' table will be 'image_id'
    @JoinColumn(name = "image_id")
    private Image image;

    public Comment() {
    }

    //GetterSetter for ID
    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    //GetterSetter for Text
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    //GetterSetter for CreatedDate
    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(LocalDate description) {
        this.createdDate = createdDate;
    }

    //GetterSetter for User
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //GetterSetter for Image
    public User getImage() { return user; }
    public void setImage(Image image) {
        this.image = image;
    }
}
