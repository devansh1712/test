//<06 jan>
package com.BlogApp_With_Mircroservices.service;

import com.BlogApp_With_Mircroservices.payload.ListPostDto;
import com.BlogApp_With_Mircroservices.payload.PostDto;

public interface PostService {

    public PostDto createPost(PostDto postDto);//this method will return back PostDto object.What service layer returning PostDto.

   // <08 jan>
    void deletePost(long id);


    // </08 jan>
    //<21 feb>


    ListPostDto fetchAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    //<04 mar>
    public  PostDto getPosyById(long id);


}

