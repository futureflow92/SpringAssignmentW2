# SpringAssignmentW2
항해99 주특기(Spring) 숙련주 과제
## JWT를 이용한 회원가입/로그인 기능 구현하기

1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 날짜를 조회하기
    - 작성 날짜 기준으로 내림차순 정렬하기
    - AccessToken이 없어도 조회 가능하게 하기
2. 게시글 작성 API
    - AccessToken이 있고, 유효한 Token일 때(== 로그인 상태일 때)만 작성 가능하게 하기
    - 제목 작성 내용을 입력하기
3. 게시글 조회 API
    - 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
    - AccessToken이 없어도 조회 가능하게 하기
4. 게시글 수정 API
    - AccessToken이 있고, 유효한 Token이면서 해당 게시글 작성자만 수정 가능하게 하기
    - 제목, 작성자명, 작성 내용을 수정되게 하기
5. 게시글 삭제 API
    - AccessToken이 있고, 유효한 Token이면서 해당 게시글 작성자만 삭제 가능하게 하기
    - 글과 댓글이 함께 삭제되게 하기

![그림1](https://user-images.githubusercontent.com/108922600/183005092-91bc1485-a4f9-48a5-8f83-ad498f894c5f.png)
