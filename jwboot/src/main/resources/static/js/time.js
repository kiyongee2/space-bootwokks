/**
 * 시계 구현
 */

/*setInterval(myWatch, 1000);

function myWatch(){
	const date = new Date();
	let now = date.toLocaleTimeString();
	document.getElementById("display").innerHTML = now;
}*/

//실행 함수(익명 함수)
setInterval(() => {
	const date = new Date();
	let now = date.toLocaleTimeString();
	document.getElementById("display").innerHTML = now;
}, 1000);