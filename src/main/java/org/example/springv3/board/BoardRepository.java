package org.example.springv3.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    //@Query(value = "select * from board_tb bt inner join user_tb ut on bt.user_id = ut.id where bt.id=?", nativeQuery = true)
    @Query("select b from Board b join fetch b.user u where b.id=:id")
    Optional<Board> mFindById(@Param("id") int id);

    @Query("select b from Board b order by b.id desc") // JPQL, 이렇게 하면 Sort 안해도 됨
    List<Board> mFindAll(); // 이건 팀 컨벤션, ex. 내가 만든 거 m 붙이기
}

