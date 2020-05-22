package com.cntt.systemfailure.springboot.domain.user;

import com.cntt.systemfailure.domain.posts.Posts;
import com.cntt.systemfailure.domain.posts.PostsRepository;
import com.cntt.systemfailure.domain.user.User;
import com.cntt.systemfailure.domain.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@ActiveProfiles( "local" )
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        //postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기 () {


        String name = "lowell";

        userRepository.save( User.builder()
                .name( name)
                .build() );

        List<User> userList = userRepository.findAll();

        User user = userList.get( 0 );
        assertThat( user.getName()).isEqualTo( name );

    }
}
