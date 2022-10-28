//지도를 그려주는 함수 실행
selectMapList();

//검색한 주소의 정보를 insertAddress 함수로 넘겨준다.
function searchAddressToCoordinate(address) {
    naver.maps.Service.geocode({
        query: address
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }
        if (response.v2.meta.totalCount === 0) {
            return alert('올바른 주소를 입력해주세요.');
        }
        var htmlAddresses = [],
            item = response.v2.addresses[0],
            point = new naver.maps.Point(item.y, item.x);
        if (item.roadAddress) {
            htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
        }
        if (item.jibunAddress) {
            htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
        }
        if (item.englishAddress) {
            htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
        }
        
        insertAddress(item.roadAddress, item.y, item.x);
        
    });
}

// 주소 검색의 이벤트
$('#inputaddress').on('keydown', function(e) {
    var keyCode = e.which;
    if (keyCode === 13) { // Enter Key
        searchAddressToCoordinate($('#inputaddress').val());
    }
});
$('#submit').on('click', function(e) {
    e.preventDefault();
    searchAddressToCoordinate($('#inputaddress').val());
});
naver.maps.Event.once(map, 'init_stylemap', initGeocoder);

//검색정보를 inputbox내에 작성해주고, 지도에 마커를 찍어준다.
function insertAddress(address, latitude, longitude) {
	
	document.querySelector("#address").value = address;
	document.querySelector("#lat").value = latitude;
	document.querySelector("#lng").value = longitude;

	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(latitude, longitude),
	    zoom: 14
	});
    var marker = new naver.maps.Marker({
        map: map,
        position: new naver.maps.LatLng(latitude, longitude),
    });
}

//지도를 그려주는 함수
function selectMapList() {
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng( $('#teamlat').val(), $('#teamlng').val()),
	    zoom: 15
	});
}

// 지도를 이동하게 해주는 함수
function moveMap(lat, lng) {
	var mapOptions = {
		    center: new naver.maps.LatLng(lat, lng),
		    zoom: 15,
		    mapTypeControl: true
		};
    var map = new naver.maps.Map('map', mapOptions);
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(lat, lng),
        map: map
    });
}