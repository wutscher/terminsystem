package com.eventplaner.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @Column(name="comment_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String  commentID;

    //@Column(name="author")
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private RegisteredUser author;

    @Column(name="date_time")
    private Date dateTime;

    @Column(name="comment")
    private String comment;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "sub_comment_system")
    private CommentSystem subCommentSystem;

    public Comment(RegisteredUser author, String comment) {
        this.author = author;
        this.comment = comment;
        this.subCommentSystem = new CommentSystem();

        this.dateTime = new Date();
    }

    public Comment() {
        this.subCommentSystem = new CommentSystem();
    }

    public RegisteredUser getAuthor() {
        return author;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        return formatter.format(dateTime);
    }

    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        return formatter.format(dateTime);
    }

    public Date getDateTime(){
        return dateTime;
    }

    public String getDateTimeString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        return formatter.format(dateTime);
    }

    public CommentSystem getSubComments() {
        return subCommentSystem;
    }

    public String getCommentID() {
        return commentID;
    }

    public String getComment() {
        return comment;
    }

    public CommentSystem getSubCommentSystem() {
        return subCommentSystem;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public void setAuthor(RegisteredUser author) {
        this.author = author;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSubCommentSystem(CommentSystem subCommentSystem) {
        this.subCommentSystem = subCommentSystem;
    }
}

