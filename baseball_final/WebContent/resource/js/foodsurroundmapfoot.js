$(function() {
		initMap();
	});
	
	function initMap() { 
		
		//document.querySelector("#lat").textContent, document.querySelector("#lng").textContent
		var area = document.querySelectorAll("#areadb");
		
		var areaArr = new Array();  // 지역을 담는 배열 ( 지역명/위도경도 )
		for(var i = 0; i < area.length; i++) {
			var a = document.querySelector("#name"+i).textContent;
			var b = document.querySelector("#lat"+i).textContent;
			var c = document.querySelector("#lng"+i).textContent;
			var d = document.querySelector("#add"+i).textContent;
			var e = document.querySelector("#cat"+i).textContent;
			areaArr.push(
					{location : ''+a+'', lat : ''+b+'', lng : ''+c+'', add : ''+d+'', cat : ''+e+''} );
		}
		
		let markers = new Array(); // 마커 정보를 담는 배열
		let infoWindows = new Array(); // 정보창을 담는 배열
		
		var map = new naver.maps.Map('map', {
	        center: new naver.maps.LatLng(document.querySelector("#homelat").textContent, document.querySelector("#homelng").textContent), //지도 시작 지점
	        zoom: 15
	    });
		
		for (var i = 0; i < areaArr.length; i++) { // 지역을 담은 배열의 길이만큼 for문으로 마커와 정보창을 채워주자 !
			
		    var marker = new naver.maps.Marker({
		        map: map,
		        title: areaArr[i].location, // 지역구 이름 
		        position: new naver.maps.LatLng(areaArr[i].lat , areaArr[i].lng) // 지역구의 위도 경도 넣기 
		    });
		    
		    /* 정보창 */
			 var infoWindow = new naver.maps.InfoWindow({
			     content: '<div style="width:200px;text-align:center;padding:10px;"><p><b>['+ areaArr[i].cat +'] ' + areaArr[i].location + '</b></p>' + areaArr[i].add + '</div>;'
			 }); // 클릭했을 때 띄워줄 정보 HTML 작성
		    
			 markers.push(marker); // 생성한 마커를 배열에 담는다.
			 infoWindows.push(infoWindow); // 생성한 정보창을 배열에 담는다.
		}
	    
		 
	    function getClickHandler(seq) {
	            return function(e) {  // 마커를 클릭하는 부분
	                var marker = markers[seq], // 클릭한 마커의 시퀀스로 찾는다.
	                    infoWindow = infoWindows[seq]; // 클릭한 마커의 시퀀스로 찾는다
	
	                if (infoWindow.getMap()) {
	                    infoWindow.close();
	                } else {
	                    infoWindow.open(map, marker); // 표출
	                }
	    		}
	    	}
	    
	    for (var i=0, ii=markers.length; i<ii; i++) {
	    	console.log(markers[i] , getClickHandler(i));
	        naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i)); // 클릭한 마커 핸들러
	    }
	}