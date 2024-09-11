package org.example.springv3.board;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest // JPARepository 상속하면 import 안해도 된다. QueryRepository 는 import 해야 됨!
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void mFindAll_test(){
        // given
        String title = "제";

        // when
        List<Board> boardList = boardRepository.mFindAll(title);

        // eye
        System.out.println(boardList.size());
        System.out.println(boardList.get(0).getTitle());
    }

    @Test
    public void mFindByIdwithReply_test(){
        Board board = boardRepository.mFindByIdWithReply(5).get();
        System.out.println(board.getReplies().get(0).getComment());
    }

}
