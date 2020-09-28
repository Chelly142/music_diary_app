# 무기한 연기
설계한 앱을 작성하기에는 아직 실력이 너무 부족하다 판단 무기한 연기합니다.
# Music diary
안드로이드 스튜디오를 사용해 음악 일기장 앱을 작성

# 진행 상황
- 2020/08/11 tabLayout itemTab tab텍스트의 커스텀 디자인 및 생성 완료 
- 2020/08/12 tabLayout, viewPager와 fragment 등의 연결 완료, tab click시 색 변경 적용
- 2020/08/13 onCreat시 색이 선택 색이 나타나도록 했고 곡목록 fragment에 recyclerview구현(adapter) room을 이용한 music 데이터베이스 생성
- 2020/08/18 곡 추가시 검색을 위한 asynctask를 구현 jsoup을 이용해 멜론에서 필요한 정보를 가지고옴
- 2020/08/21 searchFragment를 새로만드는것을 포기하고(해결되지 않은 문제2) musicFragment에 여러 뷰를 넣고 버튼 이벤트시 원하는 UI만 보이도록 해결, musicFragment 구현을 거의 마쳤으며 이미지 크롤링시 멜론 url이 규칙성이 이해해 몇몇 이미지가 로딩되지않음
- 2020/08/24 room database를 작성 하는 와중에 mainActivity에서 생성한 room을 fragment에서 부르는데서 오류가 생기는 것 같다. 아직 해결이 안되었고 사실 이게 정확한 원인인지도 잘 모르겠다. 너무 어렵다.(아ㅏㅇㅁ낭ㄴ마아ㅏㅣㅁ나아ㅏㅇ)
- 2020/08/27 구글링의 끝을 달린 후 ViewModel을 사용해 해결이 가능한것을 알게되었다. 하지만 역시나 하나 해결 = 새로운 문제는 틀리질 않는다. 안드로이드 개발자 페이지에서는 ViewModelProvider의 매개변수로 생명주기를 결정해줄 객체만 사용해 ViewModel을 선언했지만, 현실은 ViewModelFactory를 인자로 넣으라고 한다. 구글링해봐도 정보가 부족해 일단 후퇴해 다른 방식을 강구해봐야겠다.
# 다음에 해야할것
- room 데이터베이스 프레그먼트와 엑티비티에서의 생성과 호출 문제 해결할것
- fragment에 대해 정확히 알아볼것
- musicFragment 의 데이터베이스를 이용한 메인recyclerView 완성
# 해결되지 않은 문제
- 1 searchFragemnt를 하나더 생성해 musicFragment에서 버튼 이벤트로 이동해야하는데 문제는 viewpager에 layout을 넣는거라 표현이 안된다.
- 2 room을 actrivity에서 생성해서 fragment에서 도 불러올수있는 방법?
 - 2-1 ViewModel을 사용해 해결할 수 있지만 viewModelProvider의 인자에 대한 이해가 너무 어려움(기본이 부족하다고 생각되어짐) 

