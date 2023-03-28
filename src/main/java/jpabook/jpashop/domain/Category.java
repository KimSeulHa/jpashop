package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name; //카테고리명
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent; //상위 카테고리 (셀프 매핑)
    @OneToMany(mappedBy = "parent")
    private List<Category> chlid = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"), //내가 조인하는거
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID") //반대쪽에서 조인하는거
    )// 다대다의 ERD상 하나의 테이블을 만들때와 동일
    private List<Item> items = new ArrayList<>();
}
