/*** 온라인 베이커리 *********************/
/*** 회원 정보 테이블 ***/
create table b_member (
    id varchar2(30) primary key,
    pw  varchar2(30),
    name varchar2(30),
    grade number(2)
);
desc b_member;

/* 관리자 : 1 / VIP : 2 / 일반회원 : 3 */
insert into b_member values ('aaa', '111', '홍길동', 1);
insert into b_member values ('bbb', '222', '황진이', 1);
insert into b_member values ('ccc', '333', '고길동', 3);
commit;

select * from b_member;


/*** 제품 정보 테이블 ***/
create table b_product (
    pcode varchar2(10),
    pname varchar2(30) not null,
    price number(6),
    storage varchar2(30),
    expiration varchar2(30),
    description varchar2(100),
    img varchar2(30),
    constraint pk_code primary key(pcode)
);
desc b_product;

insert into b_product values ('br001', '티라미슈', 7000, '냉장보관', '구매 후 5일', '촉촉해요', 'bread_01.jpg');
insert into b_product values('br002', '크림빵', 2500, '냉장보관', '구매 후 5일', '크림듬뿍', 'bread_02.jpg');
insert into b_product values('br003', '댕댕토스트', 3000, '실온보관', '구매 후 5일', '바삭바삭', 'bread_03.jpg');
insert into b_product values('br004', '마늘빵', 3800, '실온보관', '구매 후 5일', '마늘향듬뿍', 'bread_04.jpg');
commit;

select * from b_product;
