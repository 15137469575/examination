 var oSpan = document.getElementsByTagName('span')[0];
 
  function tow(n) {
 
    return n >= 0 && n < 10 ? '0' + n : '' + n;
 
  }
 
  function getDate(time) {
 
    var oDate = new Date();//获取日期对象
 
    var oldTime = oDate.getTime();//现在距离1970年的毫秒数
 
    var newDate = new Date(time);
	
	console.log(newDate);
 
    var newTime = newDate.getTime();//2019年距离1970年的毫秒数
 
    var second = Math.floor((newTime - oldTime) / 1000);//未来时间距离现在的秒数
 
    // var day = Math.floor(second / 86400);//整数部分代表的是天；一天有24*60*60=86400秒 ；
 
    second = second % 86400;//余数代表剩下的秒数；
 
    var hour = Math.floor(second / 3600);//整数部分代表小时；
 
    second %= 3600; //余数代表 剩下的秒数；
 
    var minute = Math.floor(second / 60);
 
    second %= 60;
	
 
    var str =  tow(hour) + '<span class="time">小时</span>'
 
        + tow(minute) + '<span class="time">分钟</span>'
 
        + tow(second) + '<span class="time">秒</span>';
 
    oSpan.innerHTML = str;
 
  }
 
  // getDate('2022/04/21 00:00:00');
  
  // console.log(getDate);
 
  setInterval(function(){
	  getDate('2022/04/21 00:00:00');
  }, 1000);