package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        System.out.println("save memberDTO = " + memberDTO);

        // Member.save, Mapper파일의 namespace=Member, id=save 호출
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO){
        System.out.println("login memberDTO = " + memberDTO);

        // Member.login, Mapper파일의 namespace=Member, id=login 호출
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll() {
//        System.out.println("list memberDTO= ");
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        System.out.println("Repository findById id = " + id);
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        System.out.println("Repository delete id = " + id);
        sql.delete("Member.delete", id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        System.out.println("Repository findByMemberEmail email = " + loginEmail);
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        System.out.println("Repository update  memberDTO = " + memberDTO);
        return sql.update("Member.update", memberDTO);
    }
}
