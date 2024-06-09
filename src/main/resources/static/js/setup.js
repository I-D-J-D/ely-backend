var mapContainer = document.getElementById("map"); // 지도를 표시할 div
var mapOption = {
  center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
  level: 3, // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

function moveToCurrentLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      function (position) {
        var lat = position.coords.latitude; // 위도
        var lon = position.coords.longitude; // 경도

        console.log(lat + "/" + lon);

        var locPosition = new kakao.maps.LatLng(lat, lon); // 위도 경도를 통해 LatLng 객체 생성

        // 지도 중심을 현재 위치로 이동
        map.setCenter(locPosition);

        // 현재 위치에 마커를 표시
        var marker = new kakao.maps.Marker({
          map: map,
          position: locPosition,
        });

        // 현재 위치 정보 창 표시
        // var infowindow = new kakao.maps.InfoWindow({
        //   content: '<div style="padding:20px; border:radious;">현재 위치</div>',
        //   removable: true,
        // });
        // infowindow.open(map, marker);
      },
      function (error) {
        console.error("Error occurred. Error code: " + error.code);
      }
    );
  } else {
    // 브라우저가 Geolocation을 지원하지 않는 경우
    alert("Geolocation을 지원하지 않습니다.");
  }
}

// 페이지 로드 시 현재 위치로 이동
moveToCurrentLocation();
