package com.example.geeks.repos;

import com.example.geeks.entity.Comment;
import com.example.geeks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, List<Comment>> {

    public List<Comment> getCommentsByCommentGiver_IdAndIsDeleted(Long u, boolean d);



    public List<Comment> getCommentsByCommentReceiver_IdAndIsDeleted(Long u, boolean d);


    public List<Comment> getCommentsByCommentGiver_IdAndCommentReceiver_IdAndIsDeleted(Long staffId, Long studentId, boolean d);

    @Modifying
    @Query(value = "UPDATE `alumni_db`.`comment` SET `is_deleted` = true WHERE (`comment_giver_id` = ?1) AND (`comment_receiver_id` = ?2);\n",
            nativeQuery = true)
    public void updateCommentByIdIs(Long commenterId, Long receiverId);
}
