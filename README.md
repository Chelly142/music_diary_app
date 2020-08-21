# Music diary
안드로이드 스튜디오를 사용해 음악 일기장 앱을 작성

# 진행 상황
- 2020/08/11 tabLayout itemTab tab텍스트의 커스텀 디자인 및 생성 완료 
- 2020/08/12 tabLayout, viewPager와 fragment 등의 연결 완료, tab click시 색 변경 적용
- 2020/08/13 onCreat시 색이 선택 색이 나타나도록 했고 곡목록 fragment에 recyclerview구현(adapter) room을 이용한 music 데이터베이스 생성
- 2020/08/18 곡 추가시 검색을 위한 asynctask를 구현 jsoup을 이용해 멜론에서 필요한 정보를 가지고옴
# 다음에 해야할것
- serchFragment의 recyclerView 구현해야함 
- room 데이터베이스
- 웹 크롤링
- 검색 환경
- 위 3개를 모두 합쳐 완성 시킬것
# 해결되지 않은 문제
- 리사이클러뷰를 위한 어레이리스트를 엑티비티 클래스 단위에서 정의해줬는데 객체를 추가하는 단계에서 오류가나고 doinBackgorund에서 한번더 정의해주니 해결이 됨
