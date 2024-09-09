package org.example.springv3.board;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // JPARepository 상속하면 import 안해도 된다. QueryRepository 는 import 해야 됨!
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void mFindByIdwithReply_test(){
        Board board = boardRepository.mFindByIdWithReply(5).get();
        System.out.println(board.getReplies().get(0).getComment());
    }

}
