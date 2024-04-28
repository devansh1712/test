package com.BlogApp_With_Mircroservices.repository;

import com.BlogApp_With_Mircroservices.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//<06 jan>
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
//</06 jan>