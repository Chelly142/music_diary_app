# Music diary
안드로이드 스튜디오를 사용해 음악 일기장 앱을 작성

# 진행 상황
- 2020/08/11 tabLayout itemTab tab텍스트의 커스텀 디자인 및 생성 완료 
- 2020/08/12 tabLayout, viewPager와 fragment 등의 연결 완료, tab click시 색 변경 적용
- 2020/08/13 onCreat시 색이 선택 색이 나타나도록 했고 곡목록 fragment에 recyclerview구현(adapter) room을 이용한 music 데이터베이스 생성
- 2020/08/18 곡 추가시 검색을 위한 asynctask를 구현 jsoup을 이용해 멜론에서 필요한 정보를 가지고옴
- 2020/08/21 searchFragment를 새로만드는것을 포기하고(해결되지 않은 문제2) musicFragment에 여러 뷰를 넣고 버튼 이벤트시 원하는 UI만 보이도록 해결, musicFragment 구현을 거의 마쳤으며 이미지 크롤링시 멜론 url이 규칙성이 이해해 몇몇 이미지가 로딩되지않음
# 다음에 해야할것
- room 데이터베이스
- 검색 환경
- musicFragment 의 데이터베이스를 이용한 메인recyclerView 완성
# 해결되지 않은 문제
- 1 리사이클러뷰를 위한 어레이리스트를 엑티비티 클래스 단위에서 정의해줬는데 객체를 추가하는 단계에서 오류가나고 doinBackgorund에서 한번더 정의해주니 해결이 됨
- 2 searchFragemnt를 하나더 생성해 musicFragment에서 버튼 이벤트로 이동해야하는데 문제는 viewpager에 layout을 넣는거라 표현이 안된다.
